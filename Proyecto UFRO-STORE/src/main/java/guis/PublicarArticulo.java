package guis;

import datos.GestorDatos;
import modelo.Producto;
import modelo.Store;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.ThreadLocalRandom;

public class PublicarArticulo extends Ventana implements ActionListener {
    Store store;
    String correo;
    private JTextField nombre;
    private JTextField precio;
    private JTextArea descripcion;
    private JButton guardar;
    private JButton cancelar;
    private JButton subirimagen;
    private JComboBox categoria;
    protected String[] datosImg;
    JPanel panel = new FondoVentana("ImagenesFondo/Publicar Producto.jpg");

    public PublicarArticulo(String correo, Store store){
        this.setTitle("Publicar Producto");
        this.setSize(600,600);
        this.setContentPane(panel);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.correo=correo;
        this.store=store;
        elementosVentana();
        datosImg=new String[2];
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource()== subirimagen){
            selecImagen();
         }else if(e.getSource()== guardar){
            if(camposVacios()){
                mensajeError(this, "Rellene todos los datos requeridos");
            }else if (datosImg[0] ==null || datosImg[1]==null){
                this.mensajeError(this, "Debe seleccionar una Imagen");
            }else{
                guardarImagen(datosImg[0], datosImg[1]);
                agregarProducto();
                Store storeNew = new Store();
                GestorDatos.leerArchivoProductos(storeNew,"BaseDatos/productos.txt");
                GestorDatos.leerArchivoUsuarios(storeNew,"BaseDatos/cuentas.txt");
                new MenuPrincipal(correo, storeNew);
                this.dispose();
            }
         }
         if (e.getSource()==cancelar){
             new MenuPrincipal(correo,store);
             this.dispose();
         }
    }

    private void elementosVentana(){
        this.generarEtiqueta("Nombre del Articulo: ", Color.WHITE,12,55, 190, 200, 25);
        this.generarEtiqueta("Precio: ", Color.WHITE,12,55, 230, 200, 25);
        this.generarEtiqueta("Descripcion: ",Color.WHITE,12,55, 270, 210, 25);
        this.generarEtiqueta("Categoría",Color.WHITE,12,250,390,200,25);
        this.etiquetaDatos("Recuerda no publicar articulos ilegales, UFRO-STORE no se responsabiliza de cualquier ilegalidad",
                Color.WHITE,10,5,540,600,25);
        nombre = this.generarCampoDeTexto(240,190, 170, 25);
        precio = this.generarCampoDeTexto(240,230, 170, 25);
        descripcion = this.generarTextArea(240,270,270,100);
        subirimagen = this.generarBoton("Subir Imagen",55,320,150,25);
        categoria = this.generarLista(opcionesCat(), 240,415,270,30);
        guardar = this.generarBoton("Guardar", 110,510,115,25);
        cancelar=this.generarBoton("Cancelar", 380,510,115,25);
        subirimagen.addActionListener(this);
        guardar.addActionListener(this);
        cancelar.addActionListener(this);
    }

    public void selecImagen(){
        JFileChooser fc= new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.jpg, PNG", "jpg","PNG");
        fc.setFileFilter(filtro);
        File archivo;
        int seleccion = fc.showOpenDialog(this);
        if(seleccion == JFileChooser.APPROVE_OPTION){
            archivo = fc.getSelectedFile();
            String rutaOrigen = archivo.getAbsolutePath();
            datosImg[0]=rutaOrigen;
            datosImg[1]="BaseDatos/ImagenesProductos/"+archivo.getName();
            ImageIcon imagen = new ImageIcon(rutaOrigen);
            JLabel img = etiquetaImagen(imagen, 55, 350, 150, 150);
            img.repaint();
        }
    }

    public void guardarImagen(String rutaOrigen,String rutaDestino){
        try {
            Path destino = FileSystems.getDefault().getPath(rutaDestino);
            Path origen = Paths.get(rutaOrigen);
            Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e){
            this.mensajeError(this, "Error al guardar la Imagen");
            System.out.println(e);
        }
    }

    public boolean camposVacios(){
        return nombre.getText().equals("") || precio.getText().equals("") ||
                descripcion.getText().equals("") || categoria.getSelectedItem().equals("");
    }

    public void agregarProducto(){
        Producto producto = new Producto(nombre.getText(),precio.getText(),descripcion.getText(), datosImg[1], categoria.getSelectedItem().toString(), generarCodigo(),correo);
        GestorDatos.guardarDatos(producto, "BaseDatos/productos.txt");
        JOptionPane.showMessageDialog(this, "Producto publicado");
    }

    private String[] opcionesCat(){
        String[] opciones= new String[7];
        opciones[0]="";
        opciones[1]= "Artistico";
        opciones[2]="Accesorios";
        opciones[3]="Comida";
        opciones[4]="Material Academico";
        opciones[5]="Moda y estilo";
        opciones[6]="Utiles";
        return opciones;
    }

    private String generarCodigo(){
        String alfabeto= "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String codigo = "";
        for (int i = 0; i < 12; i++) {
            int indice = ThreadLocalRandom.current().nextInt(0, alfabeto.length());
            char caracter= alfabeto.charAt(indice);
            codigo +=caracter;
        }
        return codigo;
    }
}
