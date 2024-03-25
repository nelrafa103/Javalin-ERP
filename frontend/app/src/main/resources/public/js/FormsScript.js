async function getForms() {
   const peticion = await fetch("https://localhost:7001/form/all", {
      headers: {
         "Access-Control-Allow-Origin": "*",
      },
      method: 'GET'
   })
   const formularios = await peticion.json()



   console.log(formularios)

   document.getElementById("formularios").innerHTML = formularios.forms.map((form, index) => {
      return (`<tr id="usuario${index}">
          <td>${form.nombre}</td>
          <td>${form.apellido}</td>
          <td>${form.nivelAcademico}</td>
 </tr>`);
   });

   // Hay que utilizar esta api para obtener la direccion exacta en vez de longitud y latitud
   // https://maps.googleapis.com/maps/api/geocode/json?latlng=19.4900957,-70.7417021&key=AIzaSyARGxyXTVxGZkS7QzQ3Cg3DnPmIyNfTjzc"

}

async function busquedadeUsuario(id) {
   const peticion = await fetch(`https://localhost:7001/form/user=${id}`, {
      headers: {
         "Access-Control-Allow-Origin": "*",
      },
      method: 'GET'
   })
   const formularios = await peticion.json()



   console.log(formularios)

   document.getElementById("formularios").innerHTML = formularios.forms.map((form, index) => {
      return (`<tr id="usuario${index}">
          <td>${form.nombre}</td>
          <td>${form.apellido}</td>
          <td>${form.nivelAcademico}</td>
 </tr>`);
   });

}
getForms() 