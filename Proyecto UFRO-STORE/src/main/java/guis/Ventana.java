package guis;

import javax.swing.*;
import java.awt.*;

public abstract class Ventana extends JFrame{

    public Ventana(){
        this.setResizable(false);
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

    protected JLabel etiquetaDatos (String texto, Color c, int tamano, int x, int y, int ancho, int largo) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setBounds(x, y, ancho, largo);
        etiqueta.setForeground(c);
        etiqueta.setFont(new Font("Lucida Console",Font.PLAIN,tamano));
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

    protected JTextArea generarTextArea(int x, int y, int ancho, int alto){
        JTextArea textArea= new JTextArea();
        textArea.setBounds(x, y, ancho, alto);
        this.add(textArea);
        return textArea;
    }

    protected JLabel etiquetaImagen(ImageIcon imagen, int x, int y, int ancho, int alto){
        JLabel etiqueta = new JLabel();
        //ImageIcon imagen1 = new ImageIcon(ruta);
        etiqueta.setBounds(x,y,ancho,alto);
        etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta.getWidth(), etiqueta.getHeight(), Image.SCALE_SMOOTH)));
        //etiqueta.repaint();
        this.add(etiqueta);
        etiqueta.setOpaque(true);
        return etiqueta;
    }

    protected JPanel crearPanel(String categoria, Boolean estado){
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setBounds(0,0,1200,700);
        panel.setLayout(null);
        panel.setVisible(estado);
        JLabel titulo = generarEtiqueta(categoria,Color.black,24,500, 110, 400, 25);
        panel.add(titulo);
        this.add(panel);
        return panel;
    }

    protected JTextArea areaTexto(String texto, int x, int y, int ancho, int alto){
        JTextArea textArea= new JTextArea();
        textArea.setText(texto);
        textArea.setLineWrap(true);
        textArea.setBounds(x, y, ancho, alto);
        textArea.setFont(new Font("Lucida Console",Font.PLAIN,15));
        textArea.setForeground(Color.black);
        textArea.setOpaque(false);
        //textArea.setBorder(null);
        this.add(textArea);
        return textArea;
    }

    protected void mensajeError(JFrame v, String texto){
        JOptionPane.showMessageDialog(v,texto, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
}