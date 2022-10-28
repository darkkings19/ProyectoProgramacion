public class Menus {

    public static void menuInicial(){
        System.out.println("--------------- U F R O    S T O R E ---------------");
        System.out.println("Seleccione una opcion");
        System.out.println(" 1. Registrar como comprador");
        System.out.println(" 2. Registrar como vendedor");
        System.out.println(" 3. Iniciar Sesion como Comprador");
        System.out.println(" 4. Iniciar Sesion como Vendedor");
        System.out.println(" 5. Salir");
    }

    public static void menuVendedor(){
        System.out.println("Seleccione la opcion que desea realizar");
        System.out.println(" 1. Publicar producto");
        System.out.println(" 2. Ver todos los productos");
        System.out.println(" 3. Ver perfiles de Vendedores");
        System.out.println(" 4. Editar producto");
        System.out.println(" 5. Eliminar un producto");
        System.out.println(" 6. Ver mi perfil");
        System.out.println(" 7. Cerrar Sesion");
    }

    public static void menuComprador(){
        System.out.println("Seleccione la opcion que desea realizar");
        System.out.println(" 1. Ver todos los productos");
        System.out.println(" 2. Ver perfiles de Vendedores");
        System.out.println(" 3. Cerrar sesion");
    }

    public static void publicarProducto(){
        System.out.println("Ingrese la categoria de su producto");
        System.out.println(" | Moda y estilo | Utiles | Accesorios | ");
        System.out.println(" | Comida | Artistico | Material Academico");

    }

}
