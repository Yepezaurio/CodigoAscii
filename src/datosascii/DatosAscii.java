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
    // Vamos a pintar "10110010" como ejemplo
    String sNumero = "10110010";
    String sChar;
    //Generamos una variable booleana para tener un interruptor
    boolean bEstado = false;
    //Iniciamos variables X y Y para tener control de las posiciones a pintar
    int X = 200;
    int Y = 400;
    
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
       
        int option = 4;
        //Vamos a crear un switch para tener diferentes gráficados
        switch(option){
            case 1:
                nrzUnipolar(g);
                break;
            case 2:
                nrzBipolar(g);
                break;
            case 3:
                rzUnipolar(g);
                break;
            case 4:
                Manchester(g);
                break;
        }
        
        
    }
    
    public static void main(String[] args) {
        DatosAscii ascii = new DatosAscii();
        ascii.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    // nrz = no retorna zero
    // rz = retorna zero
    //Este metodo grafica lo anterior hecho es de 1 a 0
    
    //Metodos con diferentes graficaciones.
    public void nrzUnipolar(Graphics g){
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
    
    //Aqui graficamos donde el 0 pasa al voltaje de los negativos.
    public void nrzBipolar(Graphics g)
    {
        Y=500;
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
                    g.drawLine(X+1, Y, X+1,Y-200);
                    g.drawLine(X-1, Y, X-1,Y-200);
                    g.drawLine(X, Y, X,Y-200);
                    Y-=200; //Guardamos el valor de Y en 300 para pintar lineas verticales
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
                   g.drawLine(X+1,Y,X+1,Y+200);
                   g.drawLine(X-1,Y,X-1,Y+200);
                   g.drawLine(X,Y,X,Y+200);
                   Y+=200;
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

    public void rzUnipolar(Graphics g)
    {
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
            if ( sChar.compareTo("1") == 0 ) {
                
              // Aqui empezamos en X=200 y Y=400
              g.drawLine(X, Y, X, Y-100);
              g.drawLine(X-1, Y, X-1, Y-100);
              g.drawLine(X+1, Y, X+1, Y-100);
              
              g.drawLine(X,Y-100,X+50,Y-100);
              g.drawLine(X,Y-101,X+50,Y-101);
              g.drawLine(X,Y-99,X+50,Y-99);
              
              g.drawLine(X+50, Y-100, X+50, Y);
              g.drawLine(X+51, Y-100, X+51, Y);
              g.drawLine(X+49, Y-100, X+49, Y);
              
              g.drawLine(X+50, Y+1, X+100, Y+1);
              g.drawLine(X+50, Y-1, X+100, Y-1);
              g.drawLine(X+50, Y, X+100, Y);
              X+=100;
            }
            else
            {
              g.drawLine(X,Y+1,X+100,Y+1);
              g.drawLine(X,Y-1,X+100,Y-1);
              g.drawLine(X,Y,X+100,Y);
              X+=100;
               
            }
           
            
            //Pintamos la linea de transición
            
        }
    }
    
    
    public void Manchester(Graphics g)
    {
        
        
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
                    //Pintamos las lineas Verticales en este codigo
                
                if(bEstado)
                {
                    g.drawLine(X, Y, X, Y+200);
                }
                if(!bEstado)
                {
                  Y-=100;
                  bEstado=true;
                }
                
                g.drawLine(X, Y+200, X+50, Y+200);
                g.drawLine(X+50,Y+200, X+50, Y);
                g.drawLine(X+50,Y, X+100, Y);
                X+=100;
              
                
            }
            else
            {   
                if(!bEstado)
                {
                     g.drawLine(X, Y+100, X, Y-100);
                }
                if(bEstado)
                {
                   Y+=100;
                   bEstado=false;
                }
                g.drawLine(X,Y-100,X+50,Y-100);
                g.drawLine(X+50,Y-100,X+50, Y+100);
                g.drawLine(X+50,Y+100, X+100, Y+100);
                X+=100;
            }
          
        }
    }
}

