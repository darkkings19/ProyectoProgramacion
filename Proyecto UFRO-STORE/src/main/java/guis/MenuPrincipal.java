package guis;

import modelo.Producto;
import modelo.Store;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MenuPrincipal extends Ventana implements ActionListener {
    Store store;
    JButton artistico,accesorios,comida,material,moda,utiles;
    JButton salir, verPerfil, volverMenu;
    JButton[] articulo;
    JButton publicar;
    JPanel fondo = new FondoVentana("ImagenesFondo/FondoPrincipal.jpg");
    JPanel panelMenu, panelArt, panelAcc, panelCom, panelMat, panelModa, panelUti;
    String correo;

    public MenuPrincipal(String correo, Store store){
        this.setTitle("UFRO - STORE");
        this.setSize(1200,700);
        this.setContentPane(fondo);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.correo=correo;
        this.store=store;
        panelMenu = this.crearPanel("",true);
        panelArt = this.crearPanel("Artisticos",false);
        panelAcc = this.crearPanel("Accesorios",false);
        panelCom = this.crearPanel("Comida",false);
        panelMat = this.crearPanel("Material Academico",false);
        panelModa = this.crearPanel("Moda y Estilo",false);
        panelUti = this.crearPanel("Utiles",false);
        compVentana();
        comPanelMenu();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if(evt.getSource() == salir) {
            new VentanaInicial(this.store);
            this.dispose();
        }
        if(evt.getSource()== verPerfil){
            new VentanaPerfil(correo,this.store);
            this.dispose();
        }
        if (evt.getSource()== artistico){
            panelMenu.setVisible(false);
            panelArt.setVisible(true);
            comArtisticos();
        }
        if (evt.getSource()== accesorios){
            panelMenu.setVisible(false);
            panelAcc.setVisible(true);
            comAccesorios();
        }
        if (evt.getSource()== comida){
            panelMenu.setVisible(false);
            panelCom.setVisible(true);
            comComida();
        }
        if (evt.getSource()== material){
            panelMenu.setVisible(false);
            panelMat.setVisible(true);
            comMaterial();
        }
        if (evt.getSource()== moda){
            panelMenu.setVisible(false);
            panelModa.setVisible(true);
            comModa();
        }
        if (evt.getSource()== utiles){
            panelMenu.setVisible(false);
            panelUti.setVisible(true);
            comUtiles();
        }
        if (evt.getSource()== volverMenu){
            new MenuPrincipal(correo,store);
            this.dispose();
        }
        if (evt.getSource()== publicar){
            this.dispose();
            new PublicarArticulo(correo,store);
        }
        try{
        for (int i = 0; i < articulo.length; i++) {
            if(evt.getSource()==articulo[i]){
                new InfoProducto(store, articulo[i].getName());
            }
        }
        }catch (Exception e){
        }
    }

    private void compVentana(){
        verPerfil = this.generarBoton("Mi perfil",180,20,150,25);
        publicar = this.generarBoton("Publicar articulo",340,20,200,25);
        salir = this.generarBoton("Cerrar sesion", 180,60,150,25);

        publicar.addActionListener(this);
        verPerfil.addActionListener(this);
        salir.addActionListener(this);
    }

    private void comPanelMenu(){
        panelMenu.add(generarEtiqueta("Artistico",Color.black,12,245, 335, 200, 25));
        panelMenu.add(generarEtiqueta("Accesorios",Color.black,12,560, 330, 200, 25));
        panelMenu.add(generarEtiqueta("Comida",Color.black,12,900, 335, 200, 25));
        panelMenu.add(generarEtiqueta("Material Academico",Color.black,12,205, 540, 200, 25));
        panelMenu.add(generarEtiqueta("Moda y estilo",Color.black,12,550, 540, 200, 25));
        panelMenu.add(generarEtiqueta("Utiles",Color.black,12,900, 540, 200, 25));
        panelMenu.add(generarEtiqueta("Categorias", Color.black,24,500, 130, 200, 25));

        panelMenu.add(artistico = this.btnImagen("ImagenesCategorias/Artistico.png",200,200,150,160));
        panelMenu.add(accesorios = this.btnImagen("ImagenesCategorias/Accesorios.png",525,200,150,150));
        panelMenu.add(comida = this.btnImagen("ImagenesCategorias/Comida.png",850,200,150,160));
        panelMenu.add(material = this.btnImagen("ImagenesCategorias/MaterialAcademico.png",200,400,160,160));
        panelMenu.add(moda = this.btnImagen("ImagenesCategorias/ModaEstilo.png",525,400,150,160));
        panelMenu.add(utiles = this.btnImagen("ImagenesCategorias/Utiles.png",850,400,150,160));

        artistico.addActionListener(this);
        accesorios.addActionListener(this);
        comida.addActionListener(this);
        material.addActionListener(this);
        moda.addActionListener(this);
        utiles.addActionListener(this);
    }

    private void comArtisticos(){
        panelArt.add(volverMenu = this.generarBoton("Volver menu",340,60,200,25));
        volverMenu.addActionListener(this);
        mostrarArticulo("Artistico", panelArt);
    }

    private void comAccesorios(){
        panelAcc.add(volverMenu = this.generarBoton("Volver menu",340,60,200,25));
        volverMenu.addActionListener(this);
        mostrarArticulo("Accesorios", panelAcc);
    }

    private void comComida(){
        panelCom.add(volverMenu = this.generarBoton("Volver menu",340,60,200,25));
        volverMenu.addActionListener(this);
        mostrarArticulo("Comida", panelCom);
    }

    private void comMaterial(){
        panelMat.add(volverMenu = this.generarBoton("Volver menu",340,60,200,25));
        volverMenu.addActionListener(this);
        mostrarArticulo("Material Academico", panelMat);
    }

    private void comModa(){
        panelModa.add(volverMenu = this.generarBoton("Volver menu",340,60,200,25));
        volverMenu.addActionListener(this);
        mostrarArticulo("Moda y estilo", panelModa);
    }

    private void comUtiles(){
        panelUti.add(volverMenu = this.generarBoton("Volver menu",340,60,200,25));
        volverMenu.addActionListener(this);
        mostrarArticulo("Utiles",panelUti);
    }

    protected void mostrarArticulo(String categoria, JPanel panel){
        ArrayList<Producto> p = datosProducto(categoria);
        articulo=new JButton[p.size()];
        int x=70;
        int y= 160;
        for (int i = 0; i < p.size(); i++) {
            panel.add(articulo[i] = this.btnImagen(p.get(i).getRutaImagen(), x, y, 130, 130));
            articulo[i].setName(p.get(i).getCodigo());
            panel.add(generarEtiqueta(p.get(i).getNombre(),Color.black,12,x,y+130,150,25));
            x= x+180;
            if(x==1150){
                x=70;
                y=y+160;
            }
            articulo[i].addActionListener(this);
        }
    }

    private ArrayList<Producto> datosProducto(String categoria){
        ArrayList<Producto> productos = new ArrayList<>();
        Producto p;
        for (int i = 0; i < store.getProductos().size(); i++) {
            p= store.getProductos().get(i);
            if(p.getCategoria().equals(categoria)) {
                productos.add(p);
            }
        }
        return productos;
    }
}
