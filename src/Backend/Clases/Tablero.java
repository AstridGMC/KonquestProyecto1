/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Clases;

import Frontend.PanelJuego;
import Frontend.Propiedades;
import java.awt.Color;
import java.awt.Dimension;
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

    static Planeta planeta;
    private String idMapa;
    public JLabel[][] casillas;
    int fila;
    int columna;
    static JLabel casilla;
    boolean tipoJuego = false;

    public Tablero(boolean tipoJuego) {
        this.tipoJuego = tipoJuego;
    }

    public Tablero() {
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public boolean isTipoJuego() {
        return tipoJuego;
    }

    public void setTipoJuego(boolean tipoJuego) {
        this.tipoJuego = tipoJuego;
    }

    ArrayList<Planeta> planetas;
    ArrayList<PlanetaNeutral> planetasNeutros;

    public JPanel llenarTablero(ArrayList<Planeta> planetas, ArrayList<PlanetaNeutral> planetasNeutrales, int alto, int ancho) {
        this.planetas = planetas;
        planetasNeutros = planetasNeutrales;
        System.out.println(".............................");
        int k = 0;
        int imagenAlto = alto / fila;
        int imagenAncho = ancho / columna;
        JPanel tablero = new JPanel();
        tablero.setOpaque(false);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        casillas = new JLabel[fila][columna];
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                planeta = buscarLugarPlaneta(planetas, planetasNeutrales, i, j);

                if (planeta != null) {
                    
                    System.out.println(planeta.isNeutral());
                    casilla = new JLabel();
                    casilla.setBorder(border);
                    k = k + 1;
                    System.out.println(k);
                    if (!planeta.isNeutral()) {
                        System.out.println("...........imprimoPlaneta "+planeta.getNombre());
                        ImageIcon planetaImg = new ImageIcon(planeta.getImagenPath());
                        casilla.setIcon(new ImageIcon(planetaImg.getImage().getScaledInstance(imagenAncho, imagenAlto, Image.SCALE_SMOOTH)));
                        casilla.setBackground(planeta.getColorFondo());
                        casilla.setOpaque(true);
                    } else {
                        casilla.setOpaque(false);
                        ImageIcon planetaNeutralImg = new ImageIcon("planetas/neutral.png");
                        casilla.setIcon(new ImageIcon(planetaNeutralImg.getImage().getScaledInstance(imagenAncho, imagenAlto, Image.SCALE_SMOOTH)));
                        
                    }
                    tablero.add(casilla);
                    listenerCasilla(casilla, i, j);
                    casillas[i][j] = casilla;

                } else {
                    casilla = new JLabel();
                    casilla.setBorder(border);
                    casilla.setOpaque(false);
                    tablero.add(casilla);
                    casillas[i][j] = casilla;
                }

            }

        }

        tablero.setLayout(new GridLayout(fila, columna));
        return tablero;
    }

    public void obtenerCasilla(int i, int j) {
        fila = i;
        columna = j;
    }
    Planeta planeta1;
    Planeta planeta2;

    public Planeta getPlaneta1() {
        return planeta1;
    }

    public void setPlaneta1(Planeta planeta1) {
        this.planeta1 = planeta1;
    }

    public Planeta getPlaneta2() {
        return planeta2;
    }

    public void setPlaneta2(Planeta planeta2) {
        this.planeta2 = planeta2;
    }

    ArrayList<Planeta> planetasEscogidos = new ArrayList();
    Jugador jugador;

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public void listenerCasilla(JLabel casilla, int i, int j) {
        MouseListener oyenteDeRaton = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                obtenerCasilla(i, j);
                Planeta planeta = buscarLugarPlaneta(planetas, planetasNeutros, fila, columna);
                if (tipoJuego == true) {
                    System.out.println("ingresando Tipo Juego  " + planetasEscogidos.size() + ""+jugador.getPlanetasConquistados().size());
                    if (planetasEscogidos.size() == 2) {
                        planetasEscogidos.clear();
                    }
                    if (planetasEscogidos.size() <= 2) {
                        if (planetasEscogidos.isEmpty()) {
                            if (jugador.verificarPropiedad(planeta) != null) {
                                planetasEscogidos.add(planeta);
                                System.out.println(" agregando Planeta " + planeta.getNombre());
                                PanelJuego.planetasEscogidos = planetasEscogidos;
                            }
                        } else {
                            if (!planeta.getNombre().equals(planetasEscogidos.get(0).getNombre())) {
                                planetasEscogidos.add(planeta);
                                System.out.println(" agregando Planeta 2" + planeta.getNombre());
                                PanelJuego.planetasEscogidos = planetasEscogidos;
                                // planetasEscogidos.clear();
                            }

                        }

                    } /*else {
                        planetasEscogidos.clear();
                        PanelJuego.planetasEscogidos.clear();
                        if (planetasEscogidos.size() <= 2) {
                            if (planetasEscogidos.isEmpty()) {
                                planetasEscogidos.add(planeta);
                                PanelJuego.planetasEscogidos = planetasEscogidos;
                            }
                        }
                    }*/

                } else {
                        Propiedades.enableComponents(Propiedades.jPanel1, true);
                        Propiedades.llenarDatosPlaneta(planeta);
                }

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
                obtenerCasilla(i, j);
                if (tipoJuego) {
                    Planeta planeta = buscarLugarPlaneta(planetas, planetasNeutros, fila, columna);
                    if (planeta != null) {
                        if (!planeta.isNeutral()) {
                            casilla.setToolTipText(""
                                    + "<html>" + ""
                                    + "<head>"
                                    + "</head>"
                                    + "<body>"
                                    + "<h4>" + "Nombre: " + planeta.getNombre() + "</h4>"
                                    + "<h4>" + "Deño: " + planeta.getDueño().getNombre() + "</h4>"
                                    + "<h4>" + "Naves: " + planeta.getNaves() + "</h4>"
                                    + "<h4>" + "Produccion: " + planeta.getProduccion() + "</h4>"
                                    + "<h4>" + "Porcentaje De Muertes: " + planeta.getPorcentajeMuertes() + "</h5>"
                                    + "</body>"
                                    + "</html>");
                        } else {
                            casilla.setToolTipText(""
                                    + "<html>" + ""
                                    + "<head>"
                                    + "</head>"
                                    + "<body>"
                                    + "<h4>" + "Nombre: " + planeta.getNombre() + "</h4>"
                                    + "<h4>" + "Deño: " + "</h4>"
                                    + "<h4>" + "Naves: " + planeta.getNaves() + "</h4>"
                                    + "<h4>" + "Produccion: " + planeta.getProduccion() + "</h4>"
                                    + "<h4>" + "Porcentaje De Muertes: " + planeta.getPorcentajeMuertes() + "</h5>"
                                    + "</body>"
                                    + "</html>");
                        }
                    }

                }
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
        casilla.addMouseListener(oyenteDeRaton);
    }

    //asigna la fila y columna a cada planeta segun tablero
    public Planeta buscarLugarPlaneta(ArrayList<Planeta> planetas, ArrayList<PlanetaNeutral> planetaNeutral, int fila, int columna) {
        for (int i = 0; i < planetas.size(); i++) {
            if (planetas.get(i).getPosicion()[0] == fila && planetas.get(i).getPosicion()[1] == columna) {
                System.out.println("planeta" + planetas.get(i).getNombre());
                return planetas.get(i);
            }
        }
        for (int i = 0; i < planetaNeutral.size(); i++) {
            if (planetaNeutral.get(i).getPosicion()[0] == fila && planetaNeutral.get(i).getPosicion()[1] == columna) {
                System.out.println("No Neutral" + planetaNeutral.get(i).getNombre());
                return planetaNeutral.get(i);
            }
        }
        return null;
    }
}
