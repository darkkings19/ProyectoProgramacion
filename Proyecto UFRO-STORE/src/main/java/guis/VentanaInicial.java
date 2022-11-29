package guis;

import datos.BuscarDatos;
import utils.ValidarIngresoDatos;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.EventListener;
import javax.swing.*;

public class VentanaInicial extends Ventana implements ActionListener{
    JTextField correo;
    JTextField contrasena;
    JButton ingresar;
    JButton salir;
    JButton registrar;
    JPanel panel = new FondoVentana("ImagenesFondo/VentanaInicial.jpg");

    public VentanaInicial(){
        this.setTitle("UFRO - STORE");
        this.setSize(500,500);
        this.setContentPane(panel);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.generarEtiqueta("B I E N V E N I D O", Color.WHITE,14, 170,190,200,25);
        this.generarEtiqueta("Ufro-mail: ", Color.WHITE,12,80, 220, 200, 25);
        this.generarEtiqueta("Contraseña: ", Color.WHITE,12,80, 260, 200, 25);
        this.generarEtiqueta("No tienes cuenta ",Color.WHITE,12, 180,350,250,25);
        correo = this.generarCampoDeTexto(230,220, 170, 25);
        contrasena = this.generarCampoDeTexto(230,260, 170, 25);
        ingresar = this.generarBoton("Ingresar", 185,310,115,25);
        ingresar.addActionListener(this);
        registrar = this.generarBoton("Registrar", 185,380,115,25);
        registrar.addActionListener(this);
        salir  = this.btnImagen("ImagenesFondo/IconSalir.png",400,400,25,30);
        salir.addActionListener(this);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String correo = this.correo.getText();
        String contraseña =this.contrasena.getText();
        if(e.getSource() == ingresar) {
            if(!ValidarIngresoDatos.validarCorreo(correo)){
                mensajeError(this, "Ingrese un Correo Ufro Valido");
            }else if(!ValidarIngresoDatos.validarContrasena(contraseña)){
                mensajeError(this,"Contraseña de minimo 8 caracteres requerida");
            }else if(!BuscarDatos.validarDatos(correo, contraseña)){
                mensajeError(this,"Usuario no encontrado o los datos ingresados no son correctos");
            }else {
                new MenuPrincipal(correo);
                this.dispose();
            }
        }else if(e.getSource() == registrar) {
            new Registro();
            this.dispose();
        }else if(e.getSource() == salir){
            this.dispose();
        }
        /*if(e.getSource()== ingresar){
            new MenuPrincipal(correo.getText());
            this.dispose();
        }if(e.getSource()==registrar){
            new Registro();

        }*/
    }
}
