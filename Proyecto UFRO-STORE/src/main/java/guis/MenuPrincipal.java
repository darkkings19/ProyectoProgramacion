package guis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends Ventana implements ActionListener {
    JButton artistico;
    JButton accesorios;
    JButton comida;
    JButton material;
    JButton modaa;
    JButton utiles;
    JButton salir;
    JButton verPerfil;
    JLabel titulo;
    JPanel panel = new FondoVentana("ImagenesFondo/FondoPrincipal.jpg");
    String correo;
    public MenuPrincipal(String correo){
        this.setTitle("UFRO - STORE");
        this.setSize(1200,700);
        this.setContentPane(panel);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.correo=correo;
        titulo = this.generarEtiqueta("Categorias", Color.black,24,500, 130, 200, 25);
        verPerfil = this.generarBoton("Mi perfil",180,20,150,25);

        artistico = this.btnImagen("ImagenesCategorias/Artistico.png",200,200,150,160);
        accesorios = this.btnImagen("ImagenesCategorias/Accesorios.png",525,200,150,150);
        comida = this.btnImagen("ImagenesCategorias/Comida.png",850,200,150,160);
        material = this.btnImagen("ImagenesCategorias/MaterialAcademico.png",200,400,160,160);
        modaa = this.btnImagen("ImagenesCategorias/ModaEstilo.png",525,400,150,160);
        utiles = this.btnImagen("ImagenesCategorias/Utiles.png",850,400,150,160);

        this.generarEtiqueta("Artistico",Color.black,12,245, 335, 200, 25);
        this.generarEtiqueta("Accesorios",Color.black,12,560, 330, 200, 25);
        this.generarEtiqueta("Comida",Color.black,12,900, 335, 200, 25);
        this.generarEtiqueta("Material Academico",Color.black,12,205, 540, 200, 25);
        this.generarEtiqueta("Moda y estilo",Color.black,12,550, 540, 200, 25);
        this.generarEtiqueta("Utiles",Color.black,12,900, 540, 200, 25);

        salir = this.generarBoton("Cerrar sesion", 180,60,150,25);
        verPerfil.addActionListener(this);
        salir.addActionListener(this);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == salir) {
            new VentanaInicial();
            this.dispose();
        }
        if(e.getSource()== verPerfil){
            new Perfil(correo);
            this.dispose();
        }
        //Ejecucion de las ventanas de cada categoria
        //
        //

    }
}
