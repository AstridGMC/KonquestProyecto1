/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Clases;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author astridmc
 */
public class Tablero {
   Planeta planeta = new Planeta();
    public static JLabel[][] casillas;
    static int fila;
    static int columna;
    static JLabel casilla;  
    
    public JPanel llenarTablero(ArrayList<Planeta> planetas){
        JPanel tablero = new JPanel();
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        casillas = new JLabel[fila][columna];
        int k=0;
        for(int i=0; i<fila; i++){
            for(int j=0;j < columna ; j++){
                planetas.get(k);
                if(planeta.getPosicion()[0]==i && planeta.getPosicion()[1]==j){
                    casilla = new JLabel();
                    casilla.setBorder(border);
                    ImageIcon planetaImg = new ImageIcon(elegirImagen());
                    casilla.setIcon(new ImageIcon(planetaImg.getImage().getScaledInstance(casilla.getWidth(), casilla.getHeight(), Image.SCALE_SMOOTH)));                    
                    if(!planeta.isNeutral()){
                        casilla.setBackground(planeta.getColorFondo());
                        casilla.setOpaque(true);
                    }
                    casilla.setOpaque(false);
                    tablero.add(casilla);
                    listenerCasilla(casilla,i,j);
                    casillas[i][j]= casilla;
                    k=k+1;
                }else{
                    casilla = new JLabel();
                    casilla.setOpaque(false);
                    tablero.add(casilla);
                    listenerCasilla(casilla,i,j);
                    casillas[i][j]= casilla;
                }
            }
        }
        tablero.setLayout(new GridLayout(fila, columna));
        return tablero;
    }
    
      public static  void obtenerCasilla(int i, int j){
        fila = i;
        columna =j;
    }
      
    public void listenerCasilla(JLabel casilla,int i, int j){
        MouseListener oyenteDeRaton = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                obtenerCasilla( i, j);
                
               // pieza.setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                 //pieza.setVisible(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
 
            }

            @Override
            public void mouseExited(MouseEvent e) {
           
            }
        };
        casilla.addMouseListener(oyenteDeRaton);
        
        
    }
    
    public String elegirImagen(){
        Random r = new Random();
        int num = r.nextInt(12);
        return "planeta"+num+".jpg";
    }
    
}
