export default async function getView() {
   const peticion = await  fetch("http://localhost:7001/panel", {
        method: 'GET'
     })

     return await peticion.json()
}

