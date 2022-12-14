package datos;

import modelo.Producto;
import modelo.Store;
import modelo.Usuario;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GestorDatos {

    public static boolean guardarDatos(Object objeto, String ruta) {
        boolean lineaVacia= false;
        try {
            File file = new File(ruta);
            if (!file.exists()) {
                file.createNewFile();
                lineaVacia=true;
            }
            FileWriter archivo =new FileWriter(ruta, true);
            BufferedWriter bw = new BufferedWriter(archivo);

            if (!lineaVacia){
                bw.newLine();
            }
            bw.write(objeto.toString());
            bw.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void leerArchivoUsuarios(Store store, String ruta) {
        String textoArchivo = "";
        try {
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);
            while ((textoArchivo = br.readLine()) != null) {
                String[] data = textoArchivo.split(";");
                store.getUsuarios().add(new Usuario(data[0], data[1],data[2],data[3]));
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Documento no disponible(usu)");
        }
    }

    public static void leerArchivoProductos(Store store, String ruta) {
        String textoArchivo = "";
        try {
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);
            while ((textoArchivo = br.readLine()) != null) {
                String[] data = textoArchivo.split(";");
                store.getProductos().add(new Producto(data[0], data[1],data[2],data[3],data[4],data[5],data[6]));
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Documento no disponible(prod)");
        }
    }

    public static ArrayList<String> correosUfro(){
        String textoArchivo = "";
        ArrayList<String> data= new ArrayList<>();
        try {
            FileReader fr = new FileReader("BaseDatos/CorreosUfro.txt");
            BufferedReader br = new BufferedReader(fr);
            while ((textoArchivo = br.readLine()) != null) {
                data.add(textoArchivo);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return data;
    }


}
