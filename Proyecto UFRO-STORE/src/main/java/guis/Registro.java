package guis;

import datos.GestorDatos;
import modelo.Store;
import modelo.Usuario;
import utils.ValidarIngresoDatos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Registro extends Ventana implements ActionListener {
    Store store;
    JTextField correo;
    JTextField contrasena;
    JTextField nombre;
    JTextField numero;
    JButton aceptar;
    JButton volver;
    JPanel panel = new FondoVentana("ImagenesFondo/Registro.jpg");

    public Registro(Store store) {
        this.setTitle("Registrar datos");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setContentPane(panel);
        this.setLayout(null);
        this.store=store;
        this.generarEtiqueta("Ufro-mail: ", Color.WHITE,12, 70, 170, 200, 25);
        this.generarEtiqueta("Cree su contraseña: ", Color.WHITE,12, 70, 220, 200, 25);
        this.generarEtiqueta("Nombre de usuario", Color.WHITE,12, 70, 270, 200, 25);
        this.generarEtiqueta("Numero celular", Color.WHITE,12, 70, 320, 200, 25);
        correo = this.generarCampoDeTexto(250, 170, 170, 22);
        contrasena = this.generarCampoDeTexto(250, 220, 170, 22);
        nombre = this.generarCampoDeTexto(250, 270, 170, 22);
        numero = this.generarCampoDeTexto(250, 320, 170, 22);
        ValidarIngresoDatos.numero(numero);
        aceptar = this.generarBoton("Registrar", 165, 370, 150, 25);
        aceptar.addActionListener(this);
        volver = this.generarBoton("Atras", 10, 20, 100, 25);
        volver.addActionListener(this);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String correo = this.correo.getText();
        String contrasena = this.contrasena.getText();
        String nombre = this.nombre.getText();
        String numero = this.numero.getText();
        if (e.getSource() == volver) {
            this.dispose();
            new VentanaInicial(this.store);
        } else if (e.getSource() == aceptar) {
            if(camposVacios()){
                mensajeError(this, "Rellene todos los campos solitados");
            }else if (!ValidarIngresoDatos.validarContrasena(contrasena)) {
                mensajeError(this, "Contraseña de minimo 8 caracteres requerida");
            }else if(!ValidarIngresoDatos.validarNombre(nombre)){
                mensajeError(this, "Nombre invalido (maximo 25 caracteres)");
            }else if(!ValidarIngresoDatos.validarNumero(numero)){
                mensajeError(this, "Ingrese un numero de 9 digitos (primero digito 9)");
            }else if(!correoUfro()) {
                mensajeError(this, "El correo ingresado no pertenece a la Universidad");
            }else {
                agregarUsuario();
                new VentanaInicial(this.store);
                this.dispose();
            }
        }
    }

    public boolean camposVacios(){
        return correo.getText().equals("") || contrasena.getText().equals("") ||
                nombre.getText().equals("") || numero.getText().equals("");
    }

    public void agregarUsuario(){
        Usuario usuario = new Usuario(correo.getText(),contrasena.getText(), nombre.getText(), numero.getText());
        if(!store.agregarUsuario(usuario, correo.getText())){
            mensajeError(this,"El correo ingresado ya tiene una cuenta registrada");
        }else{
            GestorDatos.guardarDatos(usuario, "BaseDatos/cuentas.txt");
            JOptionPane.showMessageDialog(this, "Datos registrados");
        }
    }

    public boolean correoUfro(){
        ArrayList<String> correos= GestorDatos.correosUfro();
        for (int i = 0; i < correos.size(); i++) {
            if(correos.get(i).equals(this.correo.getText())){
                return true;
            }
        }
        return false;
    }
}