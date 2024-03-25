async function obtenerPerfil(userId) {
    fetch(`http://localhost:7001/user=${userId}`, {
        method: "GET",
        body: JSON.stringify({
            // null 
        })
    })
}