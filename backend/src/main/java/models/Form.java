package models;

import java.util.Base64;
import java.util.Date;

public class Form {

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

    public Form(String idUsuario, String idForm, String nombre, String apellido, String telefono, Date fecha, String nivelAcademico, Double latitud, Double longitud, byte[] foto) {
        IdUsuario = idUsuario;
        IdForm = idForm;
        Nombre = nombre;
        Apellido = apellido;
        Telefono = telefono;
        Fecha = fecha;
        NivelAcademico = nivelAcademico;
        Latitud = latitud;
        Longitud = longitud;
        Foto = foto;
    }

    public String getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        IdUsuario = idUsuario;
    }

    public String getIdForm() {
        return IdForm;
    }

    public void setIdForm(String idForm) {
        IdForm = idForm;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public Date getFecha() {
        return Fecha;
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

    public Double getLatitud() {
        return Latitud;
    }

    public void setLatitud(Double latitud) {
        Latitud = latitud;
    }

    public Double getLongitud() {
        return Longitud;
    }

    public void setLongitud(Double longitud) {
        Longitud = longitud;
    }

    public byte[] getFoto() {
        return Foto;
    }

    public void setFoto(byte[] foto) {
        Foto = foto;
    }
}
