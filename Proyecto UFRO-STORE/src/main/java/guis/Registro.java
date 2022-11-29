package guis;

import datos.BuscarDatos;
import datos.GestorDatos;
import utils.ValidarIngresoDatos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registro extends Ventana implements ActionListener {
    JTextField correo;
    JTextField contrasena;
    JTextField nombre;
    JTextField celular;
    JButton aceptar;
    JButton volver;
    JPanel panel = new FondoVentana("ImagenesFondo/Registro.jpg");

    public Registro() {
        this.setTitle("Registrar datos");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setContentPane(panel);
        this.setLayout(null);
        this.generarEtiqueta("Ufro-mail: ", Color.WHITE,12, 70, 170, 200, 25);
        this.generarEtiqueta("Cree su contraseña: ", Color.WHITE,12, 70, 220, 200, 25);
        this.generarEtiqueta("Nombre de usuario", Color.WHITE,12, 70, 270, 200, 25);
        this.generarEtiqueta("Numero celular", Color.WHITE,12, 70, 320, 200, 25);
        correo = this.generarCampoDeTexto(250, 170, 170, 22);
        contrasena = this.generarCampoDeTexto(250, 220, 170, 22);
        nombre = this.generarCampoDeTexto(250, 270, 170, 22);
        celular = this.generarCampoDeTexto(250, 320, 170, 22);
        ValidarIngresoDatos.numero(celular);
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
        String numero = this.celular.getText();
        String[] datos= new String[]{correo, contrasena, nombre, numero};
        if (e.getSource() == volver) {
            this.dispose();
            new VentanaInicial();
        } else if (e.getSource() == aceptar) {
            if (correo.isEmpty()|| contrasena.isEmpty() || nombre.isEmpty() || numero.isEmpty()){
                mensajeError(this, "Rellene todos los campos solitados");
            }else if (!ValidarIngresoDatos.validarCorreo(correo)) {
                mensajeError(this, "Ingrese un Correo Ufro Valido");
            }else if (!ValidarIngresoDatos.validarContrasena(contrasena)) {
                mensajeError(this, "Contraseña de minimo 8 caracteres requerida");
            }else if(!ValidarIngresoDatos.validarNombre(nombre)){
                mensajeError(this, "Nombre invalido (maximo 25 caracteres)");
            }else if(!ValidarIngresoDatos.validarNumero(numero)){
                mensajeError(this, "Ingrese un numero de 9 digitos (primero digito 9)");
            }else if(!BuscarDatos.buscarCorreo(correo, "BaseDatos/CorreosUfro.txt")) {
                mensajeError(this, "El correo ingresado no pertenece a la Universidad");
            }else if(BuscarDatos.buscarCorreo(correo, "BaseDatos/cuentas.txt")){
                mensajeError(this,"El correo ingresado ya tiene una cuenta registrada");
            }else {
                GestorDatos.guardarCuenta("BaseDatos/cuentas.txt", datos);
                JOptionPane.showMessageDialog(null, "Datos registrados");
                new VentanaInicial();
                this.dispose();
            }
        }
    }
}