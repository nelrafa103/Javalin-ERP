let page = 10
async function cargarUsuarios() {
    const request = await fetch("http://localhost:7001/users", {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        },
    });
    const usuarios = await request.json();

    document.getElementById("usuarios").innerHTML = usuarios.users.map((usuario) => {
        return (`<tr><td><img class="rounded-circle me-2" width="30" height="30" src="assets/img/avatars/avatar5.jpeg">${usuario.nombre}</td>
  <td>${usuario.apellido}</td>
  <td>${usuario.direccion}</td>
  <td>${new Date().getFullYear() - usuario.fechaNacimiento}</td>
  <td>${usuario.correo}<br></td>
  <td>${usuario.cedula}</td>
  <td><button
  class="btn btn-primary btn-sm d-none d-sm-inline-block" role="button" href="#"
  onclick="abrirModal()"><i
      class="fas fa-download fa-sm text-white-50"></i>&nbsp;Borrar usuario</button></td>

  <td><button
  class="btn btn-primary btn-sm d-none d-sm-inline-block" role="button" href="#"
  onclick="abrirModal()"><i
      class="fas fa-download fa-sm text-white-50"></i>&nbsp;Editar
  usuario</button></td>
  </tr>`);
    });

 }

cargarUsuarios();