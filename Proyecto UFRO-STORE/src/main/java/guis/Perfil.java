package guis;

import datos.BuscarDatos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Perfil extends Ventana implements ActionListener {

    JPanel panel = new  FondoVentana("ImagenesFondo/FondoPerfil.jpg");
    JLabel titulo;
    JLabel datos;
    JButton volverMenu;
    JButton salir;
    String correo;
    String ruta = "BB DD/cuentas.txt";

    public Perfil(String correo){
        this.setTitle("Perfil");
        this.setSize(1200,700);
        this.setContentPane(panel);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.correo=correo;
        titulo = this.generarEtiqueta("Productos subidos",Color.black,23,700, 110, 400, 25);
        datos = this.generarEtiqueta("Datos del perfil",Color.black,23,150, 110, 400, 25);
        this.generarEtiqueta("Correo UFRO",Color.black,20,50,160,300,25);
        this.generarEtiqueta(BuscarDatos.getDatos(correo, 0,ruta),Color.black,20,50, 180, 500, 30);
        this.generarEtiqueta("Contraseña: "+BuscarDatos.getDatos(correo, 1,ruta),Color.black,20,50, 230, 500, 25);
        this.generarEtiqueta("Nombre de perfil: "+BuscarDatos.getDatos(correo, 2,ruta),Color.black,20,50, 280, 500, 25);
        this.generarEtiqueta("Numero celular: "+BuscarDatos.getDatos(correo, 3,ruta),Color.black,20,50, 330, 500, 25);

        volverMenu = this.generarBoton("Volver menu",180,20,150,25);
        salir = this.generarBoton("Cerrar sesion", 180,60,150,25);
        volverMenu.addActionListener(this);
        salir.addActionListener(this);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== volverMenu){
            new MenuPrincipal(correo);
            this.dispose();
        }
        if(e.getSource()==salir){
            new VentanaInicial();
            this.dispose();
        }
        //Ejecucion de editar datos
        //
        //

    }
}
