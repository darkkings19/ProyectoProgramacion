package modelo;

public class Usuario {
    private String correo;
    private String contrasena;
    private String nombre;
    private String nCelular;

    public Usuario(String correo, String contrasena, String nombre, String nCelular){
        this.correo=correo;
        this.contrasena=contrasena;
        this.nombre=nombre;
        this.nCelular=nCelular;
    }

    public String getCorreo(){
        return correo;
    }

    public String getContrasena(){
        return contrasena;
    }

    public String getNombre(){
        return nombre;
    }

    public String getnCelular(){
        return nCelular;
    }

    public String toString() {
        return (this.correo + ";" + this.contrasena + ";" + this.nombre + ";" + this.nCelular);
    }
}
