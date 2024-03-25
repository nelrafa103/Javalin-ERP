let page = 10

//import {nombres} from "./regex.js"

const dbName = "db";

async function cargarUsuarios() {
    if (navigator.onLine) {
        try {
            const request = await fetch("https://localhost:7001/users", {
                method: "GET",
                headers: {
                    "Content-Type": "application/json",
                },
            });

            const usuarios = await request.json();

            document.getElementById("usuarios").innerHTML = usuarios.usuarios.map((usuario, index) => {
                return (`<tr id="usuario${index}">
      <td id="id${index}">${usuario.idUsuario}</td>          
      <td>${usuario.nombre}</td>
      <td>${usuario.apellido}</td>
      <td>${usuario.direccion}</td>
      <td>${new Date(usuario.fechaNacimiento)}</td>
      <td>${usuario.correo}<br></td>
      <td>${usuario.cedula}</td>
      <td><button
      class="btn btn-primary btn-sm d-none d-sm-inline-block" role="button" href="#"
      onclick="borrar('${usuario.idUsuario}',${index})"><i
          class="fas fa-download fa-sm text-white-50"></i>&nbsp;Borrar usuario</button></td>
    
      <td><button
      class="btn btn-primary btn-sm d-none d-sm-inline-block" role="button" href="#"
      onclick="editorModal('${usuario.nombre}', '${usuario.apellido}','${usuario.direccion}','${usuario.correo}','${usuario.cedula}','${usuario.idUsuario}')"><i
          class="fas fa-download fa-sm text-white-50"></i>&nbsp;Editar
      usuario</button></td>
      </tr>`);
            });

            const version = parseInt(localStorage.getItem("version")) + 1;
            const versionNueva = localStorage.setItem("version", version);
            localStorage.setItem("version", version)
            const basededatos = indexedDB.open(dbName, versionNueva);


            basededatos.onsuccess = (event) => {
                const db = event.target.result;

                const transaction = db.transaction(["usuarios"], "readwrite");

                const objectStore = transaction.objectStore("usuarios");

                usuarios.users.map((usuario) => {
                    console.log()
                    objectStore.add(usuario)
                })


            }
        } catch {

        }
    } else {


        const version = parseInt(localStorage.getItem("version")) + 1;
        const versionNueva = localStorage.setItem("version", version);
        localStorage.setItem("version", version)
        const request = indexedDB.open(dbName, versionNueva);


        request.onsuccess = (event) => {
            const db = event.target.result;

            const transaction = db.transaction(["usuarios"], "readonly");

            const objectStore = transaction.objectStore("usuarios");

            const resultado = objectStore.getAll();

            const lista = document.getElementById('usuarios');


            resultado.onsuccess = (event) => {
                const data = event.target.result;
                data.forEach((usuario, index) => {
                    lista.innerHTML += `<tr id="usuario${index}">
                    <td>${usuario.idUsuario}</td>
                    <td>${usuario.nombre}</td>
                    <td>${usuario.apellido}</td>
                    <td>${usuario.direccion}</td>
                    <td>${new Date(usuario.fechaNacimiento)}</td>
                    <td>${usuario.correo}<br></td>
                    <td>${usuario.cedula}</td>
                    
                    <td><button
                    class="btn btn-primary btn-sm d-none d-sm-inline-block" role="button" href="#"
                    onclick="borrar('${usuario.idUsuario}',${index})"><i
                        class="fas fa-download fa-sm text-white-50"></i>&nbsp;Borrar usuario</button></td>
                  
                    <td><button
                    class="btn btn-primary btn-sm d-none d-sm-inline-block" role="button" href="#"
                    onclick="editorModal('${usuario.nombre}', '${usuario.apellido}','${usuario.direccion}','${usuario.correo}','${usuario.cedula}','${usuario.idUsuario}')"><i
                        class="fas fa-download fa-sm text-white-50"></i>&nbsp;Editar
                    usuario</button></td>
                    </tr>`
                });
            }


            transaction.oncomplete = (event) => {
                db.close();
            };
        };

    }


}

cargarUsuarios();


async function borrar(id, index) {

    console.log("Borrando usuario");
    const request = await fetch(`https://localhost:7001/user=${id}`, {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json",
            "Authorization": `Bearer ${sessionStorage.getItem("token")}`
            //    "Autherization": `Bearer ${sessionStorage.getItem("token")}`
        },

    })


    const response = await request;
    if (response.status == 200) {
        document.getElementById(`usuario${index}`).remove()
    }
}

async function editar(id) {
    // Va a tomar los valores de los inputs en el modal y los va a mandar al servidor



    //if (nombres(document.getElementById("nombre").value) == true) {
    // Mostrar mensaje de error debido a que el nombre de usuario no es valido
    //} else {


    fetch(`https://localhost:7001/user=${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json",
            "Autherization": `Bearer ${sessionStorage.getItem("token")}`
        },
        body: JSON.stringify({
            idUsuario: document.getElementById("").value,
            telefono: "",
            longitud: document.getElementById("").value,
            latitud: document.getElementById("").value,
            fecha: new Date(),
            apellido:  document.getElementById("").value,
            idForm: "",
            foto: null,
            nivelAcademico: document.getElementById("").value,
            nombre: document.getElementById("").value
        })
    }).then((res) => {
        if (res.status == 200) {
            /*
            * Aqui se va a cambiar el valor de las columnas en la tabla
            */
        }
        console.log(res)
    })
    //}
}

function editorModal(nombre, apellidos, direccion, correo, cedula, id) {

    /*
    * Hay que hacer que segun si editas o creas un usuario el titulo cambie
    */

    console.log(arguments)
    document.getElementById("nombre").value = nombre
    document.getElementById("apellido").value = apellidos
    document.getElementById("cedula").value = cedula
    document.getElementById("contrasena").value = contrasena
    document.getElementById("direccion").value = direccion
    document.getElementById("email").value = correo

    console.log(id)
    document.getElementById("modal-2-button").onclick = () => {
        editar(id)
    }

    abrirModal()

}


function abrirModal() {
    //console.log("Hello world")
    document.getElementById("modal-2").style.display = "block"
    document.getElementById('modal-2').classList.add('show')
}

function insertar() {
    if (nombres(document.getElementById("nombre").value) && nombres(document.getElementById("apellido").value)) {
        fetch("https://localhost:7001/new", {
            method: 'POST',
            body: JSON.stringify({
                cedula: document.getElementById("cedula").value,
                contrasena: document.getElementById("contrasena").value,
                direccion: document.getElementById("direccion").value,
                correo: document.getElementById("email").value,
                activo: true,
                fechaNacimiento: Date.now(),
                idRole: document.getElementById("rol").value,
                idUsuario: 0,
                nombre: document.getElementById("nombre").value,
                apellido: document.getElementById("apellido").value
            })
        }).then(response => {
            const inputs = ["cedula", "contrasena", "direccion", "email", "nombre", "apellido"]
            inputs.forEach((item) => {
                document.getElementById(item).value = ""
            })
            // console.log(data)
        })
    } else {
        /* Codigo para mostrar un dialogo donde mencione que no se puede agregar un nombres personales
        *  con numeros, caractereres especiales, etc.. 
        */
    }
}

function insertarModal() {
    abrirModal()
    document.getElementById("modal-2-button").onclick = () => {
        insertar()
    }
}

function cerrarModal() {
    //console.log("Hello world")
    document.getElementById("modal-2").style.display = "none"
    document.getElementById('modal-2').classList.remove("show")
    document.getElementById("nombre").value = ""
    document.getElementById("apellido").value = ""
    document.getElementById("cedula").value = ""
    document.getElementById("contrasena").value = ""
    document.getElementById("direccion").value = ""
    document.getElementById("email").value = ""
}

function nombres(valor) {
    //console.log(document.getElementById("nombre").value)
    const evaluador = RegExp(/^[a-zA-Z]+$/);
    return evaluador.test(valor)

    //return evaluador.test(valor);
}

function alerta() {
    document.getElementById("alerta").style.display = "block"
    document.getElementById('alerta').classList.add('show')
}



