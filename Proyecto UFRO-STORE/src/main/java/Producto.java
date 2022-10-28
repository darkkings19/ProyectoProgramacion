public class Producto {

    public static String rutaP = "productos/productos.txt";

    public static void agregarProducto(){
        GestorDatos.crearArchivoProductos(rutaP,IngresoDatos.infoProducto());
    }
}
