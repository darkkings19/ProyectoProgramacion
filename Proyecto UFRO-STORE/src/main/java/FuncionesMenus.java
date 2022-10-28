public class FuncionesMenus {

    public static String rutaCom = "cuentas/cuentasCompradores.txt";
    public static String rutaVen = "cuentas/cuentasVendedores.txt";
    public static String rutaP = "productos/productos.txt";

    public static void ejecucionMenuInicial(){

        int opcion=-1;
        do {
            Menus.menuInicial();
            opcion=IngresoDatos.opcionMenu1();
            switch (opcion) {
                case 1:
                    //registrar comprador
                    Usuario.registrarComprador();
                    menuComprador();
                    break;
                case 2:
                    //registrar vendedor
                    Usuario.registrarVendedor();
                    menuVendedor();
                    break;
                case 3:
                    //iniciar sesion como comprador
                    Usuario.validarUsuario(opcion);
                    break;
                case 4:
                    //iniciar sesion como vendedor
                    Usuario.validarUsuario(opcion);
                    break;
                case 5:
                    System.out.println("Terminando ejecucion...");
                    break;
            }
        }while (opcion!=5);
    }

    public static void menuComprador(){
        int opcion;
        do {
            Menus.menuComprador();
            opcion=IngresoDatos.opcionMenuCom();
            switch (opcion) {
                case 1:
                    //ver todos los productos
                    GestorDatos.mostrarProductos(rutaP);
                    break;
                case 2:
                    GestorDatos.mostrarVendedores(rutaVen);
                    break;
                case 3:
                    //cerrar sesion
                    break;
            }
        }while(opcion!=3);
    }

    public static void menuVendedor() {
        int opcion;
        do {
            Menus.menuVendedor();
            opcion=IngresoDatos.opcionMenuVen();
            switch (opcion) {
                case 1:
                    //publicar Producto
                    Menus.publicarProducto();
                    Producto.agregarProducto();
                    System.out.println("Producto publicado");
                    break;
                case 2:
                    //ver todos los productos
                    GestorDatos.mostrarProductos(rutaP);
                    break;
                case 3:
                    //ver todos los perfiles
                    GestorDatos.mostrarVendedores(rutaVen);
                case 4:
                    //editar producto
                    break;
                case 5:
                    //eliminar producto
                    break;
                case 6:
                    //Editar perfil
                    break;
                case 7:
                    //cerrar sesion
                    break;
            }
        }while(opcion!=7);
    }
}
