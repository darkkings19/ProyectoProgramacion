package datos;

import java.util.ArrayList;
import java.util.Objects;

public class BuscarDatos {
    public static String rutaCuentas = "BaseDatos/cuentas.txt";
    public static String rutaUfro= "BaseDatos/CorreosUfro.txt";

    public static boolean validarDatos(String correo, String contrasena){
        ArrayList<ArrayList<String>>usuarios;
        usuarios = GestorDatos.leerArchivo(rutaCuentas);
        ArrayList <String> datos;
        boolean valido = false;
        for (int i = 0; i < usuarios.size(); i++) {
            datos= usuarios.get(i);
            if((Objects.equals(datos.get(0), correo)) && (Objects.equals(datos.get(1), contrasena))) {
                valido = true;
                break;
            }
        }
        return valido;
    }

    public static boolean buscarCorreo(String correo, String ruta) {
        ArrayList<ArrayList<String>> usuarios;
        usuarios = GestorDatos.leerArchivo(ruta);
        ArrayList<String> datos;
        boolean valido = false;
        for (int i = 0; i < usuarios.size(); i++) {
            datos = usuarios.get(i);
            if ((Objects.equals(datos.get(0), correo))) {
                valido = true;
                break;
            }
        }
        return valido;
    }

    public static ArrayList<String> arrayDatos(String correo, String ruta){
        ArrayList<ArrayList<String>> usuarios;
        usuarios = GestorDatos.leerArchivo(ruta);
        ArrayList<String> datos= new ArrayList<>();
        for (int i = 0; i < usuarios.size(); i++) {
            datos = usuarios.get(i);
            if ((Objects.equals(datos.get(0), correo))) {
                datos = usuarios.get(i);
                break;
            }
        }
        return datos;
    }

    public static String getDatos(String correo, int dato, String ruta){
        return arrayDatos(correo,ruta).get(dato);
    }
}
