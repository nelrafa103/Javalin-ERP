/*
* Este archivo va a contener funciones que comprueben la entrada de los inputs en la aplicacion de tal manera 
* que por ejemplo no se pueda introducir a un nombre numeros o caracteres especiales. 
*/

function contrasena() {
    const evaluador = RegExp(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/);
    return evaluador.test(valor);
}

function nombres(valor) {
    const evaluador = RegExp(/^[a-zA-Z]+$/);
    return evaluador.test(valor);
}

function direccion() {
    /*
     Comprobar si la direccion es correcta

    */
}


