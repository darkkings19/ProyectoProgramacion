package utils;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarIngresoDatos {

    public static boolean validarCorreo(String correo){
        Pattern pattern= Pattern.compile("(\\W|^)[\\w.\\-]{2,25}@" +
                "(ufromail|ufrontera)\\.cl$");
        do {
            Matcher matcher = pattern.matcher(correo);
            if (matcher.find()){
                return true;
            }else{
                return false;
            }
        } while (correo.length()>0);
    }
    public static boolean validarContrasena(String contrasena){
        Pattern pattern= Pattern.compile("(\\W|^)[\\w.\\-]{8,25}");
        do {
            Matcher matcher = pattern.matcher(contrasena);
            if (matcher.find()){
                return true;
            }else{
                return false;
            }
        } while (contrasena.length()>0);
    }

    public static void numero(JTextField n){
        n.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(!Character.isDigit(c)){
                    e.consume();
                }
            }
        });
    }

    public static boolean validarNumero(String n){
        if(n.length()!=9 || n.charAt(0)!='9'){
            return false;
        }else {
            return true;
        }
    }

    public static boolean validarNombre(String n){
        if(n.length()<26&& n.length()>0){
            return true;
        }else{
            return false;
        }
    }
}