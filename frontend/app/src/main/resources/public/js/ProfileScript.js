
function probando() {
    console.log("Probando")
}

function insertarEnInputs(data) {
    const inputs = ["nombre", "apellido", "cedula", "correo"]
    // Esta parte hay que arreglarla
    localStorage.setItem("contrasena", data.contrasena)
    localStorage.setItem("direccion", data.direccion)
    localStorage.setItem("fechaNacimiento", data.fechaNacimiento)
    localStorage.setItem("idUsuario", data.idUsuario)
    localStorage.setItem("idRole", data.idRole)
    inputs.forEach((item) => {
        console.log(data[item])
        document.getElementById(item).value = data[item]
    })
}

/*

    "foto": null,
    "nombre": "Miguel",
    "idUsuario": "64e8eb6cbefc4b6c0eeb6c9f",
    "apellido": "Noboa",
    "cedula": "123456",
    "contrasena": "miguel",
    "direccion": "direccion",
    "correo": "migueljnoboa@gmail.com",
    "activo": true,
    "fechaNacimiento": 1692986220064,
    "idRole": 1
    
    */
async function editar(id) {
    const request = await fetch(`https://localhost:7001/user=${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json",
            "Autherization": `Bearer ${sessionStorage.getItem("token")}`
        },
        body: JSON.stringify({
            cedula: document.getElementById("cedula").value,
            contrasena: localStorage.getItem("contrasena"),
            direccion:  localStorage.getItem("direccion"),
            correo: document.getElementById("correo").value,
            activo: true,
            fechaNacimiento: localStorage.getItem("fechaNacimiento"),
            idRole: localStorage.getItem("idRole"),
            idUsuario: localStorage.getItem("idUsuario"),
            nombre: document.getElementById("nombre").value,
            apellido: document.getElementById("apellido").value
        })
    }).then((res) => {
        if (res.status == 200) {

            insertarEnInputs(res)
            /*
            * Aqui se va a cambiar el valor de las columnas en la tabla
            */
        }
        console.log(res)
    })

}

probando()