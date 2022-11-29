package datos;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GestorDatos {

    /*public static void crearDirectorio(String ruta) {

        Path directorio = Paths.get(ruta);
        if (Files.exists(directorio)) {
            System.out.println("El directorio ya existe");
        } else {
            try {
                Files.createDirectories(directorio);
                System.out.println("El directorio fue creado");
            } catch (IOException e) {
                System.out.println("El directorio no pudo ser creado");
            }
        }
    }*/
    public static void guardarCuenta(String ruta, String[] contenido) {
        try {
            FileWriter archivo =new FileWriter(ruta, true);
            for (int i = 0; i < contenido.length; i++) {
                archivo.write((contenido[i])+"/");
            }
            archivo.write("\n");
            archivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void guardarProducto(String ruta, String[] contenido){
        try {
            FileWriter archivo =new FileWriter(ruta, true);
            for (int i = 0; i < contenido.length; i++) {
                archivo.write((contenido[i])+"/");
            }
            archivo.write("\n");
            archivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<ArrayList<String>> leerArchivo(String ruta) {
        String textoArchivo = "";
        int lineas=1;
        ArrayList<ArrayList<String>> data= new ArrayList<>();
        try {
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);
            for (int i = 0; i < lineas; i++) {
                    if ((textoArchivo = br.readLine()) != null) {
                        lineas++;
                        ArrayList<String> contenido= new ArrayList<>(List.of(textoArchivo.split("/")));
                        data.add(contenido);
                    }
                }
            } catch (Exception e) {
            System.out.println(e);
            System.out.println("Documento no disponible, favor contactar con administrador");
        }
        return data;
    }

   /* public static void mostrarArrayProductos(ArrayList<ArrayList<String>>x){
        for (ArrayList<String> s:x){
            System.out.println(s+"\n");
        }
    }*/
}
