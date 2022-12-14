package modelo;

public class Producto {
    private String nombre;
    private String precio;
    private String descripcion;
    private String rutaImagen;
    private String categoria;
    private String codigo;
    private String correo;

    public Producto(String nombre, String precio, String descripcion, String rutaImagen,String categoria, String codigo,String correo){
        this.nombre=nombre;
        this.precio= precio;
        this.descripcion=descripcion;
        this.rutaImagen= rutaImagen;
        this.categoria=categoria;
        this.codigo=codigo;
        this.correo=correo;
    }

    public String getNombre(){
        return nombre;
    }

    public String getPrecio(){
        return precio;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public String getRutaImagen(){
        return rutaImagen;
    }

    public String getCategoria(){
        return categoria;
    }

    public String getCodigo(){
        return codigo;
    }

    public String getCorreo(){
        return correo;
    }

    public String toString() {
        return (this.nombre + ";" + this.precio + ";" + this.descripcion+ ";"+ this.rutaImagen+";"+this.categoria+";"+this.codigo+";"+this.correo);
    }
}
