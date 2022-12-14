package modelo;

import java.util.ArrayList;
import java.util.List;

public class Store {
    List <Usuario> usuarios;
    List <Producto> productos;

    public Store(){
        this.usuarios= new ArrayList<>();
        this.productos = new ArrayList<>();
    }

    public List<Usuario> getUsuarios(){
        return usuarios;
    }

    public List<Producto> getProductos(){
        return productos;
    }

    public boolean validarRegistro(){
        return false;
    }

    public boolean correoExiste(String correo){
        for(Usuario e: this.usuarios){
            if(e.getCorreo().equals(correo)){
                return true;
            }
        }
        return false;
    }

    public boolean agregarUsuario(Usuario usuario, String correo){
        if(!correoExiste(correo)){
            usuarios.add(usuario);
            return true;
        }
        return false;
    }

    public boolean validarDatos(String correo, String contrasena){
        for (Usuario u: this.usuarios){
            if(u.getCorreo().equals(correo) && u.getContrasena().equals(contrasena)){
                return true;
            }
        }
        return false;
    }

}
