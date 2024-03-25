package interfaces;

import java.util.Date;
import java.util.Base64;

public class FormInterfaceFrontend {
    String IdUsuario;
    String IdForm;
    String Nombre;
    String Apellido;
    String Telefono;
    Date Fecha;
    String NivelAcademico;
    Double Latitud;
    Double Longitud;
     
    byte[] Foto;

    public String getApellido() {
        return Apellido;
    }

    public Date getFecha() {
        return Fecha;
    }

    public String getIdForm() {
        return IdForm;
    }

    public String getIdUsuario() {
        return IdUsuario;
    }

    public Double getLatitud() {
        return Latitud;
    }

    public Double getLongitud() {
        return Longitud;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public String getNivelAcademico() {
        return NivelAcademico;
    }

    public void setNivelAcademico(String nivelAcademico) {
        NivelAcademico = nivelAcademico;
    }

    public void setIdForm(String idForm) {
        IdForm = idForm;
    }

    public void setLatitud(Double latitud) {
        Latitud = latitud;
    }

    public void setLongitud(Double longitud) {
        Longitud = longitud;
    }

    public void setIdUsuario(String idUsuario) {
        IdUsuario = idUsuario;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public byte[] getFoto() {
        return Foto;
    }

    public void setFoto(byte[] foto) {
        Foto = foto;
    }
}
