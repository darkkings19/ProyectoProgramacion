import java.util.ArrayList;
import java.util.Objects;

public class Usuario {

    public static String rutaCom = "cuentas/cuentasCompradores.txt";
    public static String rutaVen = "cuentas/cuentasVendedores.txt";


    public static void registrarComprador(){
        ArrayList<ArrayList<String>>usuarios;
        usuarios = GestorDatos.leerArchivo(rutaCom);
        ArrayList <String> datos;
        String d[]=IngresoDatos.ingresarDatosComprador();
        boolean esRepetido=false;
        for (int i = 0; i < usuarios.size(); i++) {
            datos= usuarios.get(i);
            if(Objects.equals(datos.get(0), d[0])){
                esRepetido=true;
                break;
            }
        }
        if (esRepetido) {
            System.out.println("El correo ingresado ya se encuentra asociado a una cuenta");
        }else {
            GestorDatos.anadirUsuario(rutaCom, d);
        }
    }

    public static void registrarVendedor(){
        ArrayList<ArrayList<String>>usuarios;
        usuarios = GestorDatos.leerArchivo(rutaVen);
        ArrayList <String> datos;
        String d[]=IngresoDatos.ingresarDatosVendedor();
        boolean esRepetido=false;
        for (int i = 0; i < usuarios.size(); i++) {
            datos= usuarios.get(i);
            if(Objects.equals(datos.get(0), d[0])){
                esRepetido=true;
                break;
            }
        }
        if (esRepetido) {
            System.out.println("El correo ingresado ya se encuentra asociado a una cuenta");
        }else {
            GestorDatos.anadirUsuario(rutaVen, d);
        }
    }

    public static void validarUsuario(int usuario){
        ArrayList<ArrayList<String>>usuarios = new ArrayList<>();
        if(usuario==3){
            usuarios = GestorDatos.leerArchivo(rutaCom);
        }else if(usuario==4){
            usuarios = GestorDatos.leerArchivo(rutaVen);
        }
        ArrayList <String> datos;
        String correo= IngresoDatos.correoInicioSes();
        String contrasena=IngresoDatos.contrasenaIS();
        boolean esValido=false;
        for (int i = 0; i < usuarios.size(); i++) {
            datos= usuarios.get(i);
            if((Objects.equals(datos.get(0), correo)) && (Objects.equals(datos.get(1), contrasena))){
                esValido=true;
                break;
            }
        }
        if (esValido) {
            System.out.println("Usuario encontrado, bienvenido de nuevo!");
            if(usuario==3){
                FuncionesMenus.menuComprador();
            }else {
                FuncionesMenus.menuVendedor();
            }
        }else {
            System.out.println("Datos incorrecto o usuario no registrado");
        }
    }
}
