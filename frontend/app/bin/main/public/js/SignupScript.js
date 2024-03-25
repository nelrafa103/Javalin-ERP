function crearCuenta() {
    // Obtener valores de los campos de texto
    fetch("http://localhost:7001/new", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "Autherization":  `Bearer ${sessionStorage.getItem("token")}` 
        },
        body: JSON.stringify({
          
           
        },
        )
    }).then((response) => {
        if (response.ok) {
            console.log("Cuenta creada");
        } else {
            console.log("Error al crear la cuenta");
        }
    })
}