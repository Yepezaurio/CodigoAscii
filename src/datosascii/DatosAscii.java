/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosascii;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author we_ro
 */
public class DatosAscii extends JFrame {
    
    public DatosAscii()
    {
        super("Gráfica de linea");
        setSize(1200 , 800);
        setVisible(true);
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        g.drawLine(200, 400, 1000, 400);
        g.drawLine(200, 200, 200, 600);
        for (int i = 0; i <=8 ; i++) {
            g.drawLine((200+i*100),200, (200+i*100), 600);
        }
        // Vamos a pintar "10110010" como ejemplo
        String sNumero = "10110010";
        String sChar;
        //Generamos una variable booleana para tener un interruptor
        boolean bEstado = false;
        //Iniciamos variables X y Y para tener control de las posiciones a pintar
        int X = 200;
        int Y = 400;
        for (int i = 0; i < sNumero.length(); i++) {
            //Aquí Pusimos un Sleep nos sirve para pintar las lineas de forma lenta ( 1 seg).
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(DatosAscii.class.getName()).log(Level.SEVERE, null, ex);
            }
            g.setColor(Color.BLUE);
            g.drawString(sNumero.charAt(i) + "", (250+i*100),200); //Aquí pintamos el Array o sNumero
            g.setColor(Color.red);
            //Pusimos el sChar para pasar letra x letra en el if
            sChar = sNumero.charAt(i) + "";
            /*
            Comparamos el primer caracter de nuestro arreglo si es 1 o 0.
            Entra a nuestro IF y hace una transicion si estaba en 0 para ello
            anteriormente.
            */
            
            if ( sChar.compareTo("1") == 0 ) {
                if (!bEstado){ //Variable interruptor
                    //Pintamos las lineas Verticales en este codigo
                    g.drawLine(X+1, Y, X+1,Y-100);
                    g.drawLine(X-1, Y, X-1,Y-100);
                    g.drawLine(X, Y, X,Y-100);
                    Y-=100; //Guardamos el valor de Y en 300 para pintar lineas verticales
                    bEstado = true;//Cambiamos el interruptor a veradero.
                }
            }
            else
            {
               /*
                Entra a nuestro interruptor pero ahora en Verdadero
                para pintar la transicion de 1 a 0. Mismo codigo de arriba pero para 0
               */
                if(bEstado){  
                   g.drawLine(X+1,Y,X+1,Y+100);
                   g.drawLine(X-1,Y,X-1,Y+100);
                   g.drawLine(X,Y,X,Y+100);
                   Y+=100;
                   bEstado = false;
               }
               
            }
            //Pintamos la linea de transición
            g.drawLine(X,Y+1,X+100,Y+1);
            g.drawLine(X,Y-1,X+100,Y-1);
            g.drawLine(X,Y,X+100,Y);
            X+=100;
        }
    }
    
    public static void main(String[] args) {
        DatosAscii ascii = new DatosAscii();
        ascii.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
