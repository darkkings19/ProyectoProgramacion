package guis;

import javax.swing.*;
import java.awt.*;

public abstract class Ventana extends JFrame{

    public Ventana(){
        this.setResizable(false);
        //this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    protected JTextField generarCampoDeTexto(int x, int y, int ancho, int largo) {
        JTextField campoDeTexto = new JTextField();
        campoDeTexto.setBounds(x, y, ancho, largo);
        this.add(campoDeTexto);
        return campoDeTexto;
    }

    protected JButton generarBoton(String texto, int x, int y, int ancho, int largo) {
        JButton boton = new JButton(texto);
        boton.setBounds(x, y, ancho, largo);
        boton.setFont(new Font("Terminator Two",Font.PLAIN,11));
        this.add(boton);
        return boton;
    }

    protected JButton btnImagen(String ruta, int x, int y, int ancho, int largo) {
        JButton boton = new JButton();
        boton.setBounds(x, y, ancho, largo);
        ImageIcon img = new ImageIcon(ruta);
        boton.setIcon(new ImageIcon(img.getImage().getScaledInstance(boton.getWidth(), boton.getHeight(), Image.SCALE_SMOOTH)));
        boton.setBorderPainted(true);
        boton.setContentAreaFilled(false);
        this.add(boton);
        return boton;
    }

    protected JLabel generarEtiqueta (String texto, Color c, int tamano, int x, int y, int ancho, int largo) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setBounds(x, y, ancho, largo);
        etiqueta.setForeground(c);
        etiqueta.setFont(new Font("Terminator Two",Font.PLAIN,tamano));
        this.add(etiqueta);
        return etiqueta;
    }

    protected JComboBox generarLista (String []opciones, int x, int y, int ancho, int alto ){
        JComboBox lista = new JComboBox(opciones);
        lista.setBounds(x,y,ancho,alto);
        lista.setFont(new Font("Terminator Two",Font.PLAIN,11));
        this.add(lista);
        return lista;
    }

    /*protected JLabel etiquetaImagen(String ruta, int x, int y, int ancho, int alto){
        JLabel etiqueta = new JLabel();
        ImageIcon imagen1 = new ImageIcon(ruta);
        etiqueta.setBounds(x,y,ancho,alto);
        etiqueta.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(etiqueta.getWidth(), etiqueta.getHeight(), Image.SCALE_SMOOTH)));
        this.add(etiqueta);
        etiqueta.setOpaque(false);
        return etiqueta;
    }*/
    protected void mensajeError(JFrame v, String texto){
        JOptionPane.showMessageDialog(v,texto, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
}