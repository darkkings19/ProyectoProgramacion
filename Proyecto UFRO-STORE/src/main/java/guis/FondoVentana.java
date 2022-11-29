package guis;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FondoVentana extends JPanel {
    private final Image imagen;

    public FondoVentana(String nombreImagen) {
        File file = new File(nombreImagen);
        imagen = new ImageIcon(file.toString()).getImage();
    }
    @Override
    public void paint(Graphics g) {
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
        setOpaque(false);
        super.paint(g);
    }
}
