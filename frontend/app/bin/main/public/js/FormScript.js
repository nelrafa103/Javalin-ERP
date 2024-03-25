/*
* Es necesario que en la pagina principal se carguen todas la tablas, porque el indexedbd
* Hace complicado volver a crear las tablas, ademas con cada transaccion se debe abrir y cerrar la base de datos
*/

function crearTabla() {
    const dbName = "db";

    const request = indexedDB.open(dbName, 2);


    request.onerror = (event) => {
        console.log(event)
    };

    request.onupgradeneeded = (event) => {
        const db = event.target.result;

        const objectStore = db.createObjectStore("formularios", { keyPath: "nombres" });

        objectStore.createIndex("nombres", "nombres", { unique: false });
        objectStore.createIndex("apellidos", "apellidos", { unique: false });
        objectStore.createIndex("usuario", "user", { unique: true });
        objectStore.createIndex("sector", "sector", { unique: false });
        objectStore.createIndex("nivel", "nivel", { unique: false });


        db.close()
    };

}

crearTabla();

async function insertarFormulario(formulario) {

    /** 
     *  Hay que revisar si hay alguna forma para averiguar a donde hacer peticion
     */
    // Peticion para comprobar si el servicio de backend esta activo
    const peticion = await fetch("http://localhost:7001/", {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
          // "Autherization": `Bearer ${sessionStorage.getItem("token")}`
        },
    })


    const response = await peticion;

    if (response.status == 503) {
        obtenerLocalizacion()

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

        })
    } else {

        console.log(formulario)
        const dbName = "db";

        const request = indexedDB.open(dbName, 4);

        request.onsuccess = (event) => {
            const db = event.target.result;

            const transaction = db.transaction(["formularios"], "readwrite");

            const objectStore = transaction.objectStore("formularios");

            const request = objectStore.add(formulario);

            request.onsuccess = (event) => {
                console.log("Formulario agregado");
            };

            db.close();
        };
    }
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
    console.log(geo.latitude)
    console.log(geo.longitude)
}

function error() {

}

function obtenerLocalizacion() {
    navigator.geolocation.getCurrentPosition(exito, error, geoOpciones);
}

