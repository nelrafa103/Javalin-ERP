import jwtDecode from 'https://cdn.jsdelivr.net/npm/jwt-decode@3.1.2/+esm'

async function autenticar() {
    const request = await fetch("http://localhost:7001/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            username: document.getElementById("username_input").value,
            password: document.getElementById("password_input").value
        })
    })

    const response = await request;
    if (response.ok) {
      console.log(response.json());
    }
}


function saveOnIndexedDb() {
    const dbName = "db";

    const request = indexedDB.open(dbName, 2);


    request.onerror = (event) => {
    };

    request.onupgradeneeded = (event) => {
        const db = event.target.result;

        const objectStore = db.createObjectStore("credenciales", { keyPath: "fecha" });


        objectStore.createIndex("email", "email", { unique: false });

        objectStore.createIndex("password", "password", { unique: true });


        objectStore.transaction.oncomplete = (event) => {
            const customerObjectStore = db
                .transaction("credenciales", "readwrite")
                .objectStore("credenciales");
            customerObjectStore.add({ fecha: new Date().getTime(), email: "admin", password: "admin" });
        };
    };

}