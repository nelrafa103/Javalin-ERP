package models;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public class Usuario {

    String IdUsuario;
    String Nombre;
    String Apellido;
    String Cedula;
    String Contrasena;
    String Direccion;
    String Correo;
    boolean Activo;
    Date FechaNacimiento;
    byte[] Foto;
    int IdRole;

    public Usuario(String idUsuario, String nombre, String apellido, String cedula, String contrasena, String direccion, String correo, Date fechaNacimiento, byte[] foto, int idRole) {
        IdUsuario = idUsuario;
        Nombre = nombre;
        Apellido = apellido;
        Cedula = cedula;
        Contrasena = contrasena;
        Direccion = direccion;
        Correo = correo;
        Activo = true;
        FechaNacimiento = fechaNacimiento;
        Foto = foto;
        IdRole = idRole;
    }

    public String getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        IdUsuario = idUsuario;
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

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public boolean isActivo() {
        return Activo;
    }

    public void setActivo(boolean activo) {
        Activo = activo;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String contrasena) {
        Contrasena = contrasena;
    }

    public byte[] getFoto() {
        return Foto;
    }

    public void setFoto(byte[] foto) {
        Foto = foto;
    }

    public int getIdRole() {
        return IdRole;
    }

    public void setIdRole(int idRole) {
        IdRole = idRole;
    }
}
