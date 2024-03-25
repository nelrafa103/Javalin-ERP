/*
* Es necesario que en la pagina principal se carguen todas la tablas, porque el indexedbd
* Hace complicado volver a crear las tablas, ademas con cada transaccion se debe abrir y cerrar la base de datos
*/


async function insertarFormulario(formulario) {
    obtenerLocalizacion()
    /** 
     *  Hay que revisar si hay alguna forma para averiguar a donde hacer peticion
     */
    // Peticion para comprobar si el servicio de backend esta activo
    /* const peticion = await fetch("http://localhost:7001/", {
          method: "GET",
          headers: {
              "Content-Type": "application/json",
            // "Autherization": `Bearer ${sessionStorage.getItem("token")}`
          },
      })
  
   */
    //const response = await peticion;

    // if (response.status == 503) {
    /*    obtenerLocalizacion()

        console.log("Error en el servidor, no se ha poidido guardar el formulario en servidor");

        const peticion = await fetch("http://localhost:7001/form/new", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Autherization": `Bearer ${sessionStorage.getItem("token")}`
            },

            body: JSON.stringify({
                "idUsuario": null,
                "idForm": null,
                "nombre": null,
                "apellido": null,
                "telefono": null,
                "fecha": new Date().getDate(),
                "nivelAcademico": null,
                "latitud": null,
                "longitud": null,
                "foto": null,
            })

        }) */
    // } else {

    console.log(formulario)
    const dbName = "db";



 

    const version = parseInt(localStorage.getItem("version")) + 1;
    const versionNueva = localStorage.setItem("version", version);
    localStorage.setItem("version", version)
    console.log("nueva version:" + version, "version:" + localStorage.getItem("version"))

    const request = indexedDB.open(dbName, versionNueva);


    
    request.onsuccess = (event) => {
        const db = event.target.result;


        console.log("hello")
        const transaction = db.transaction(["formularios"], "readwrite");

        const objectStore = transaction.objectStore("formularios");

        const request = objectStore.add(formulario);

        request.onsuccess = (event) => {
            console.log("Formulario agregado");

            const inputs = ["nombres", "apellidos", "sector"]

            inputs.forEach((input) => {
                document.getElementById(input).value = ""
            })
            //  db.close()
        };


        request.onerror = (event) => {
            console.log(event);
            //  db.close()
        };

        request.onblocked = (event) => {
            console.log(event);

        }

    };


    request.onerror = (event) => {
        console.log(event)
    }

    //}
}

function cargarFormularios() {
    const dbName = "db";

    const request = indexedDB.open(dbName, 2);

    request.onsuccess = (event) => {
        const db = event.target.result;

        const transaction = db.transaction(["formularios"], "readonly");

        const objectStore = transaction.objectStore("formularios");

        const request = objectStore.getAll();

        request.onsuccess = (event) => {
            console.log("Formulario agregado");
        };

        transaction.oncomplete = (event) => {
            db.close();
        };
    };
}


const geoOpciones = {
    enableHighAccuracy: true,
    maximumAge: 0,
    timeout: 5000
};


function exito(pos) {
    const geo = pos.coords

    localStorage.setItem("latitud", geo.latitude)
    localStorage.setItem("longitud", geo.longitude)
    console.log(geo.latitude)
    console.log(geo.longitude) 

    return geo;
}

function error() {
  console.log("Ha habido un error")
}

function obtenerLocalizacion() {
    navigator.geolocation.getCurrentPosition(exito, error, geoOpciones);
}


obtenerLocalizacion()