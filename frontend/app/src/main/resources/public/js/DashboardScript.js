export default async function getView() {
   const peticion = await fetch("https://localhost:7001/panel", {
      headers: {
         "Access-Control-Allow-Origin": "*",
      },
      method: 'GET'
   })

   console.log(peticion)
   return await peticion.json()
}

// Necesario implementar web sockets. de tal manera que por ejemplo cuando haya un cambio se mande una actualizacion a todos las personas conectadas a 
// ese punto de web sockets. 
// 

const socket = new WebSocket("wss://localhost:7001/sync");



socket.addEventListener("open", (event) => {
   console.log(event.data)
})

socket.addEventListener("message", (event) => {
   console.log(event.data)
   console.log(event.data)
   actualizarVista(JSON.parse(event.data))
   //console.log(event)
})


function actualizarVista(nuevo) {
   console.log(nuevo)

   switch (nuevo.tipo) {
      case "count_forms":
         document.getElementById("formulariso").innerHTML = nuevo.mensaje;
         break;
      case "count_users":
         document.getElementById("usuarios").innerHTML = nuevo.mensaje;
         break;
      case "count_adress":
         document.getElementById("sectores").innerHTML = nuevo.mensaje;
         break;
      case "new_form":
         // Some code here
         break;
      default:
         console.log("Operacion no registrada!")
         break;
   }
}
