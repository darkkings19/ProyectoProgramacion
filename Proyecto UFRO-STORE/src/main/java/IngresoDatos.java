import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IngresoDatos {

    public static String[] ingresarDatosVendedor() {
        String[] datos=new String[5];
        System.out.println("Ingresa tu direccion de Correo UFRO");
        datos[0] = ingresoCorreo();
        System.out.println("Crea tu contraseña");
        datos[1] = ingresoContrasena();
        System.out.println("A continuacion incorpora tus datos de contacto");
        System.out.println("Ingresa tu nombre (apellidos opcional)");
        datos[2] = ingresoPalabra();
        System.out.println("Ingresa tu número de celular");
        datos[3] = String.valueOf(ingresoNum());
        System.out.println("Ingresa tu matricula");
        datos[4] = String.valueOf(ingresoRut());

        return datos;
    }

    public static String [] ingresarDatosComprador() {
        String[] datos=new String[3];
        System.out.println("Ingresa tu direccion de Correo UFRO");
        datos[0] = ingresoCorreo();
        System.out.println("Crea tu contraseña");
        datos[1] = ingresoContrasena();
        System.out.println("Ingresa tu nombre (apellidos opcional)");
        datos[2] = ingresoPalabra();

        return datos;
    }

    public static String ingresoPalabra(){
        String palabra;
        do {
            palabra= teclado().nextLine();
            boolean valido=esValida(palabra);
            if (!valido){
                System.out.println("Error, Ingrese nombre valido (max. 15 caracteres)");
            }else{
                break;
            }
        } while (palabra.length()>0);
        return palabra;
    }

    public static boolean esValida(String palabra){
        boolean valida=true;
        palabra.replace(" ","");
        if (palabra.length()>15 || palabra.length()<2) {
            valida = false;
        }else if(!palabra.matches("[A-Za-z0-9]*")){
            valida = false;
        }
        return valida;
    }

    public static int ingresoRut(){
        int rut=0;
        do {
            try {
                rut = teclado().nextInt();
                if((int)(Math.log10(rut)+1)>7 && (int)(Math.log10(rut)+1)<10){
                    break;
                }else{
                    System.out.println("Ingrese un Rut valido");
                }
            } catch (Exception e) {
                System.out.println("Ingrese un Rut valido");
            }
        } while ((int)(Math.log10(rut)+1)<8 || (int)(Math.log10(rut)+1)>9);
        return rut;
    }

    public static int ingresoNum(){
        int numeroTel=0;
        do {
            try {
                numeroTel = teclado().nextInt();
                if((int)(Math.log10(numeroTel)+1)==8){
                    break;
                }else{
                    System.out.println("Ingrese un numero valido(sin el digito 9 inicial)");
                }
            } catch (Exception e) {
                System.out.println("Ingrese un numero valido");
            }
        } while ((int)(Math.log10(numeroTel)+1)!=8);
        return numeroTel;
    }

    public static String ingresoCorreo(){
        String correo;
        Pattern pattern= Pattern.compile("(\\W|^)[\\w.\\-]{2,25}@" +
                "(ufromail|ufrontera)\\.cl$");
        do {
            correo= teclado().next();
            Matcher matcher = pattern.matcher(correo);
            if (matcher.find()){
                break;
            }else{
                System.out.println("Direccion de correo invalida");
            }
        } while (correo.length()>0);
        return correo;
    }

    public static int opcionMenu1() {
        int opcion = -1;
        do {
            try {
                opcion = teclado().nextInt();
                if(opcion>5 || opcion<1){
                    mostrarError();
                }
            } catch (Exception e) {
                mostrarError();
            }
        } while (opcion > 5 || opcion < 1);
        return opcion;
    }

    public static void mostrarError() {
        System.err.println("Opción inválida");
        System.err.println("Ingrese un número válido");
    }

    public static int opcionMenuVen() {
        int opcion = -1;
        do {
            try {
                opcion = teclado().nextInt();
                if(opcion > 7 || opcion < 1){
                    mostrarError();
                }
            } catch (Exception e) {
                mostrarError();
            }
        } while (opcion > 7 || opcion < 1);
        return opcion;
    }

    public static int opcionMenuCom() {
        int opcion = -1;
        do {
            try {
                opcion = teclado().nextInt();
                if(opcion > 3 || opcion < 1){
                    mostrarError();
                }
            } catch (Exception e) {
                mostrarError();
            }
        } while (opcion > 3 || opcion < 1);
        return opcion;
    }

    public static String[] infoProducto(){
        String[] info=new String [3];
        System.out.println("Ingrese la categoria de su producto");
        info[0]=ingresarCategoria();
        System.out.println("Ingrese una breve descripcion del Producto");
        info[1]=teclado().nextLine();
        System.out.println("Ingrese el precio del Producto");
        info[2]= String.valueOf(ingresarPrecio());

        return info;
    }

    public static String ingresarCategoria(){
        String categoria;
        Pattern pattern= Pattern.compile("(Moda y estilo|Utiles|Accesorios|Artistico|Comida|Material Academico)$");
        do {
            categoria= teclado().nextLine();
            Matcher matcher = pattern.matcher(categoria);
            if (matcher.find()){
                break;
            }else{
                System.out.println("Ingrese una categoria mencionada");
            }
        } while (categoria.length()>0);
        return categoria;
    }

    public static int ingresarPrecio(){
        int precio=0;
        do {
            try {
                precio = teclado().nextInt();
            } catch (Exception e) {
                System.out.println("Ingrese un precio valido");
            }
        } while (precio<1);
        return precio;
    }

    public static String correoInicioSes(){
        System.out.println("Ingresa tu direccion de correo UFRO");
        String correo = ingresoCorreo();
        return correo;
    }

    public static String ingresoContrasena(){
        String c=teclado().next();
        do {
            try {
                if(c.length()<6){
                    System.out.println("Ingrese una contraseña de min. 6 digitos");
                    c=teclado().next();
                }else if(c.matches("[A-Za-z]*")){
                    System.out.println("Ingrese una contraseña con letras y numeros");
                    c=teclado().next();
                }else if(c.matches("[A-Za-z0-9]*")){
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ingrese un numero valido");
            }
        } while (c.length()>0);
        return c;
    }

    public static String contrasenaIS(){
        System.out.println("Ingresa tu contraseña");
        return ingresoContrasena();
    }

    public static Scanner teclado(){
        return new Scanner(System.in);
    }
}

