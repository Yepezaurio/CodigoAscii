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
        boolean bEstado = false;
        int X = 200;
        int Y = 400;
        for (int i = 0; i < sNumero.length(); i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(DatosAscii.class.getName()).log(Level.SEVERE, null, ex);
            }
            g.setColor(Color.BLUE);
            g.drawString(sNumero.charAt(i) + "", (250+i*100),200);
            g.setColor(Color.red);
            //Pusimos el sChar para pasar letra x letra en el if
            sChar = sNumero.charAt(i) + "";
            if ( sChar.compareTo("1") == 0 ) {
                if (!bEstado){ 
                    g.drawLine(X+1, Y, X+1,Y-100);
                    g.drawLine(X-1, Y, X-1,Y-100);
                    g.drawLine(X, Y, X,Y-100);
                    Y-=100;
                    bEstado = true;
                }
            }
            else
            {
               if(bEstado){
                   g.drawLine(X+1,Y,X+1,Y+100);
                   g.drawLine(X-1,Y,X-1,Y+100);
                   g.drawLine(X,Y,X,Y+100);
                   Y+=100;
                   bEstado = false;
               }
               
            }
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
