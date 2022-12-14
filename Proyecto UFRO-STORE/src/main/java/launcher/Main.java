package launcher;

import datos.GestorDatos;
import guis.InfoProducto;
import guis.PublicarArticulo;
import guis.VentanaInicial;
import modelo.Store;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        GestorDatos.leerArchivoUsuarios(store,"BaseDatos/cuentas.txt");
        GestorDatos.leerArchivoProductos(store,"BaseDatos/productos.txt");
        new VentanaInicial(store);
        //String correo= "hola";
        //new PublicarArticulo(correo,store);
        //new InfoProducto(correo, store);
    }
}