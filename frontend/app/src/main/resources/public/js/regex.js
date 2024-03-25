/*
* Este archivo va a contener funciones que comprueben la entrada de los inputs en la aplicacion de tal manera 
* que por ejemplo no se pueda introducir a un nombre numeros o caracteres especiales. 
*/

export function contrasena() {
    const evaluador = RegExp(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/);
    return evaluador.test(valor);
}

export function nombres(valor) {
    const evaluador = RegExp(/^[a-zA-Z]+$/);
    return evaluador.test(valor);
}

function direccion() {
    /*
     Comprobar si la direccion es correcta

    */
}


