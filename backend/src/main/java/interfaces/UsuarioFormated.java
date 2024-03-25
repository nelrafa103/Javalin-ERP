package interfaces;

import com.google.api.Usage;

import java.util.List;

public class UsuarioFormated {
     public List<UsuarioInterface> usuarios;

     public void setUsuarios(List<UsuarioInterface> usuarios) {
         this.usuarios = usuarios;
     }

     public List<UsuarioInterface> getUsuarios() {
         return usuarios;
     }
}
