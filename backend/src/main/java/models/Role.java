package models;

import java.util.List;

public class Role {
    int IdRole;
    String Nombre;

    public Role(int idRole, String nombre) {
        IdRole = idRole;
        Nombre = nombre;
    }

    public int getIdRole() {
        return IdRole;
    }

    public void setIdRole(int idRole) {
        IdRole = idRole;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
