package interfaces;

public class MensajeInterface {
    private String Tipo;
    private Object mensaje;

    public Object getMensaje() {
        return mensaje;
    }


    public String getTipo() {
        return Tipo;
    }

    public void setMensaje(Object mensaje) {
        this.mensaje = mensaje;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }
}
