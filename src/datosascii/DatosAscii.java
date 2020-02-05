/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosascii;

import java.awt.Color;
import java.awt.Graphics;
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
        g.setColor(Color.red);
        for (int i = 0; i < sNumero.length(); i++) {
            if(sNumero.substring(i,1).compareTo("1") == 0)
            {
                System.out.println(sNumero.substring(i,1).compareTo("1"));
                System.out.println(i);
            }
           
        }
    }
    
    public static void main(String[] args) {
        DatosAscii ascii = new DatosAscii();
        ascii.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
