package guis;

import modelo.Producto;
import modelo.Store;
import modelo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoProducto extends Ventana implements ActionListener {

    Store store;
    JPanel panel = new  FondoVentana("ImagenesFondo/FondoPerfil.jpg");
    JButton atras;
    String codigo;

    public InfoProducto( Store store, String codigo){
        this.setTitle("Informacion del producto");
        this.setSize(1200,700);
        this.setContentPane(panel);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.store=store;
        this.codigo=codigo;
        this.generarEtiqueta("Producto", Color.black,23,720, 110, 400, 25);
        this.generarEtiqueta("Datos del Vendedor",Color.black,23,115, 110, 400, 25);
        datosVendedor();
        datosProducto();
        atras = this.generarBoton("Atras",180,20,150,25);
        this.setVisible(true);
        atras.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==atras){
            this.dispose();
        }
    }

    private void datosVendedor(){
        String correo= datosP(codigo)[4];
        this.etiquetaDatos("Correo UFRO: ",Color.black,20,50,160,300,25);
        this.etiquetaDatos(datos(correo)[0],Color.black,20,50, 190, 500, 30);
        this.etiquetaDatos("Nombre: "+datos(correo)[1],Color.black,20,50, 240, 500, 25);
        this.etiquetaDatos("Numero celular: "+datos(correo)[2],Color.black,20,50, 290, 500, 25);
    }

    private String[] datos(String correo){
        String[] d= new String[3];
        for (Usuario u: store.getUsuarios()) {
            if(u.getCorreo().equals(correo)) {
                d[0]= u.getCorreo();
                d[1]= u.getNombre();
                d[2]= u.getnCelular();
            }
        }
        return d;
    }

    private void datosProducto(){
        ImageIcon imagen = new ImageIcon(datosP(codigo)[0]);
        this.etiquetaDatos("Imagen de referencia",Color.black,18,510,160,300,25);
        this.etiquetaImagen(imagen,510, 190, 280, 280);
        this.etiquetaDatos("Nombre: "+datosP(codigo)[1],Color.black,20,810, 190, 500, 25);
        this.etiquetaDatos("Precio: "+datosP(codigo)[2],Color.black,20,810, 260, 500, 25);
        this.etiquetaDatos("Descripcion: ",Color.black,20,810, 330, 500, 25);
        this.areaTexto(datosP(codigo)[3],810,360,330,400);
    }

    private String[] datosP(String codigo){
        String[] d= new String[5];
        for (Producto p: store.getProductos()) {
            if(p.getCodigo().equals(codigo)) {
                d[0]= p.getRutaImagen();
                d[1]= p.getNombre();
                d[2]= p.getPrecio();
                d[3]= p.getDescripcion();
                d[4]= p.getCorreo();
            }
        }
        return d;
    }
}
