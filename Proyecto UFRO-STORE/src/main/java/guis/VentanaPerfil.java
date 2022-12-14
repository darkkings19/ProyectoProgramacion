package guis;

import modelo.Producto;
import modelo.Store;
import modelo.Usuario;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaPerfil extends Ventana implements ActionListener {
    Store store;
    JPanel panel = new  FondoVentana("ImagenesFondo/FondoPerfil.jpg");
    JButton volverMenu;
    JButton salir;
    JButton editarPerfil;
    JButton[] articulo;
    String correo;

    public VentanaPerfil(String correo, Store store){
        this.setTitle("Perfil");
        this.setSize(1200,700);
        this.setContentPane(panel);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.correo=correo;
        this.store=store;
        compVentanaPerfil();
        mostrarArticulo(datos(correo)[0], this);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== volverMenu){
            new MenuPrincipal(correo, this.store);
            this.dispose();
        }
        if(e.getSource()==salir){
            new VentanaInicial(this.store);
            this.dispose();
        }
        if(e.getSource()==editarPerfil){
            JOptionPane.showMessageDialog(this, "Esta funcion no esta disponible");
        }
        try{
            for (int i = 0; i < articulo.length; i++) {
                if(e.getSource()==articulo[i]){
                    new InfoProducto(store, articulo[i].getName());
                }
            }
        }catch (Exception ex){
        }
    }

    private void compVentanaPerfil(){
        generarEtiqueta("Productos subidos",Color.black,23,700, 110, 400, 25);
        generarEtiqueta("Datos del perfil",Color.black,23,140, 110, 400, 25);
        etiquetaDatos("Correo UFRO: ",Color.black,20,50,160,300,25);
        etiquetaDatos(datos(correo)[0],Color.black,20,50, 190, 500, 30);
        etiquetaDatos("Contraseña: "+datos(correo)[1],Color.black,20,50, 240, 500, 25);
        etiquetaDatos("Nombre de perfil: "+datos(correo)[2],Color.black,20,50, 290, 500, 25);
        etiquetaDatos("Numero celular: "+datos(correo)[3],Color.black,20,50, 340, 500, 25);
        editarPerfil=this.generarBoton("Editar Datos",180,390,150,25);
        volverMenu = this.generarBoton("Volver menu",180,20,150,25);
        salir = this.generarBoton("Cerrar sesion", 180,60,150,25);
        editarPerfil.addActionListener(this);
        volverMenu.addActionListener(this);
        salir.addActionListener(this);
    }

    private String[] datos(String correo){
        String[] d= new String[4];
        for (Usuario u: store.getUsuarios()) {
            if(u.getCorreo().equals(correo)) {
                d[0]= u.getCorreo();
                d[1]= u.getContrasena();
                d[2]= u.getNombre();
                d[3]= u.getnCelular();
            }
        }
        return d;
    }

    protected void mostrarArticulo(String correo, JFrame v){
        ArrayList<Producto> p = datosProducto(correo);
        articulo=new JButton[p.size()];
        int x=500;
        int y= 160;
        for (int i = 0; i < p.size(); i++) {
            v.add(articulo[i] = this.btnImagen(p.get(i).getRutaImagen(), x, y, 130, 130));
            articulo[i].setName(p.get(i).getCodigo());
            v.add(generarEtiqueta(p.get(i).getNombre(),Color.black,12,x,y+130,150,25));
            x= x+160;
            if(x==1140){
                x=500;
                y=y+160;
            }
            articulo[i].addActionListener(this);
        }
    }

    private ArrayList<Producto> datosProducto(String correo){
        ArrayList<Producto> productos = new ArrayList<>();
        Producto p;
        for (int i = 0; i < store.getProductos().size(); i++) {
            p= store.getProductos().get(i);
            if(p.getCorreo().equals(correo)) {
                productos.add(p);
            }
        }
        return productos;
    }
}