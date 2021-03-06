/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

import Backend.Clases.Accion;
import Backend.Clases.Jugador;
import Backend.Clases.ManejadorAtaque;
import Backend.Clases.Mapa;
import Backend.Clases.Planeta;
import Backend.Clases.PlanetaNeutral;
import Backend.Clases.Tablero;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTextPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 *
 * @author astridmc
 */
public class PanelJuego extends javax.swing.JPanel {

    ArrayList<Planeta> planetas = new ArrayList();
    ArrayList<Jugador> jugadores = new ArrayList();
    ArrayList<PlanetaNeutral> planetasNeutrales = new ArrayList();
    public static ArrayList<Planeta> planetasEscogidos = new ArrayList();
    public static Jugador jugadorEnTurno = new Jugador();
    ArrayList<ArrayList> accionesJugadores = new ArrayList();
    ManejadorAtaque atacar = new ManejadorAtaque();
    ArrayList<Accion> acciones = new ArrayList();
    PlanetaNeutral planetaNeutro = new PlanetaNeutral();
    public static Planeta planetaElegido;
    Planeta planeta = new Planeta();
    Accion accion;
    Mapa mapa = new Mapa();
    String fondo = "fondoSol.jpg";
    Propiedades propiedades;
    Tablero tablero = new Tablero(true);
    int turno = 0;
    int numJugador = 0;

    /**
     * Creates new form PanelJuego
     *
     * @param planetas
     * @param jugadores
     * @param planetasNeutrales
     * @param mapa
     */
    public PanelJuego(ArrayList<Planeta> planetas, ArrayList<Jugador> jugadores, ArrayList<PlanetaNeutral> planetasNeutrales, Mapa mapa) {
        initComponents();
        this.planetas = planetas;
        this.jugadores = jugadores;
        this.planetasNeutrales = planetasNeutrales;
        this.mapa = mapa;
        System.out.println(mapa.getTamaño()[0]+"tama;o mapa "+mapa.getTamaño()[1]);
        crearArreglosAcciones();
        jugadorEnTurno = jugadores.get(numJugador);
        tablero.setJugador(jugadorEnTurno);
        panelEnviarNaves.setVisible(false);
        accionJugador.setForeground(jugadorEnTurno.getColorJugador());
        accionJugador.setText(jugadorEnTurno.getNombre() + "    escoja un Planeta");

        generarTablero();
    }

    public PanelJuego(String path) {
        initComponents();
        
    }
    
    

    public ArrayList<Planeta> getPlanetasEscogidos() {
        return planetasEscogidos;
    }

    public void setPlanetasEscogidos(ArrayList<Planeta> planetasEscogidos) {
        this.planetasEscogidos = planetasEscogidos;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelJuego = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        consola = new javax.swing.JTextArea();
        panelOPcionesJuego = new javax.swing.JPanel();
        btnJuegoNuevo = new javax.swing.JButton();
        PanelBotones = new javax.swing.JPanel();
        btnMedirDistancia = new javax.swing.JButton();
        btnVistaGeneral = new javax.swing.JButton();
        btnFinPartida = new javax.swing.JButton();
        btnFinTurno = new javax.swing.JButton();
        panelTablero = new javax.swing.JPanel();
        panelTablero1 = new javax.swing.JPanel();
        panelOPcionesJuego1 = new javax.swing.JPanel();
        PanelBotones1 = new javax.swing.JPanel();
        btnMedirDistancia1 = new javax.swing.JButton();
        btnVistaGeneral1 = new javax.swing.JButton();
        btnFinPartida1 = new javax.swing.JButton();
        btnFinTurno1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        accionJugador = new javax.swing.JLabel();
        btnTerminar = new javax.swing.JButton();
        panelEnviarNaves = new javax.swing.JPanel();
        numNaves = new javax.swing.JSpinner();
        btnEnviarNaves = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        consola1 = new javax.swing.JTextPane();

        panelJuego.setOpaque(false);

        consola.setBackground(new java.awt.Color(1, 1, 1));
        consola.setColumns(20);
        consola.setRows(5);
        jScrollPane1.setViewportView(consola);

        btnJuegoNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frontend/Imagenes/5e72b43074a4d_1584575626_5e72b430749ed.png"))); // NOI18N
        btnJuegoNuevo.setText("Juego Nuevo");
        btnJuegoNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJuegoNuevoActionPerformed(evt);
            }
        });

        PanelBotones.setBackground(new java.awt.Color(1, 83, 78));

        btnMedirDistancia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frontend/Imagenes/distancia.png"))); // NOI18N
        btnMedirDistancia.setText("Medir Distancia");
        btnMedirDistancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedirDistanciaActionPerformed(evt);
            }
        });

        btnVistaGeneral.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frontend/Imagenes/naves.png"))); // NOI18N
        btnVistaGeneral.setText("Vista General de La Flota");

        javax.swing.GroupLayout PanelBotonesLayout = new javax.swing.GroupLayout(PanelBotones);
        PanelBotones.setLayout(PanelBotonesLayout);
        PanelBotonesLayout.setHorizontalGroup(
            PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBotonesLayout.createSequentialGroup()
                .addComponent(btnMedirDistancia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVistaGeneral)
                .addGap(0, 299, Short.MAX_VALUE))
        );
        PanelBotonesLayout.setVerticalGroup(
            PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnVistaGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnMedirDistancia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnFinPartida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frontend/Imagenes/stop.png"))); // NOI18N
        btnFinPartida.setText("Finalizar Partida");

        btnFinTurno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frontend/Imagenes/cambio.png"))); // NOI18N
        btnFinTurno.setText("Finalizar Turno");

        javax.swing.GroupLayout panelOPcionesJuegoLayout = new javax.swing.GroupLayout(panelOPcionesJuego);
        panelOPcionesJuego.setLayout(panelOPcionesJuegoLayout);
        panelOPcionesJuegoLayout.setHorizontalGroup(
            panelOPcionesJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOPcionesJuegoLayout.createSequentialGroup()
                .addComponent(btnJuegoNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFinPartida)
                .addGap(4, 4, 4)
                .addComponent(btnFinTurno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelOPcionesJuegoLayout.setVerticalGroup(
            panelOPcionesJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOPcionesJuegoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnJuegoNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(btnFinPartida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnFinTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelTablero.setOpaque(false);

        javax.swing.GroupLayout panelTableroLayout = new javax.swing.GroupLayout(panelTablero);
        panelTablero.setLayout(panelTableroLayout);
        panelTableroLayout.setHorizontalGroup(
            panelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 489, Short.MAX_VALUE)
        );
        panelTableroLayout.setVerticalGroup(
            panelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelJuegoLayout = new javax.swing.GroupLayout(panelJuego);
        panelJuego.setLayout(panelJuegoLayout);
        panelJuegoLayout.setHorizontalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(panelOPcionesJuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelJuegoLayout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(panelTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(406, Short.MAX_VALUE))
        );
        panelJuegoLayout.setVerticalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelJuegoLayout.createSequentialGroup()
                .addComponent(panelOPcionesJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setBackground(new java.awt.Color(21, 7, 45));
        setOpaque(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        panelTablero1.setOpaque(false);
        panelTablero1.setPreferredSize(new java.awt.Dimension(448, 448));
        panelTablero1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelTablero1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelTablero1MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout panelTablero1Layout = new javax.swing.GroupLayout(panelTablero1);
        panelTablero1.setLayout(panelTablero1Layout);
        panelTablero1Layout.setHorizontalGroup(
            panelTablero1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );
        panelTablero1Layout.setVerticalGroup(
            panelTablero1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        panelOPcionesJuego1.setBackground(new java.awt.Color(1, 57, 58));

        PanelBotones1.setBackground(new java.awt.Color(1, 83, 78));

        btnMedirDistancia1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frontend/Imagenes/distancia.png"))); // NOI18N
        btnMedirDistancia1.setText("Medir Distancia");
        btnMedirDistancia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedirDistancia1ActionPerformed(evt);
            }
        });

        btnVistaGeneral1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frontend/Imagenes/naves.png"))); // NOI18N
        btnVistaGeneral1.setText("Vista General de La Flota");
        btnVistaGeneral1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVistaGeneral1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelBotones1Layout = new javax.swing.GroupLayout(PanelBotones1);
        PanelBotones1.setLayout(PanelBotones1Layout);
        PanelBotones1Layout.setHorizontalGroup(
            PanelBotones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBotones1Layout.createSequentialGroup()
                .addComponent(btnMedirDistancia1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVistaGeneral1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelBotones1Layout.setVerticalGroup(
            PanelBotones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBotones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnVistaGeneral1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addComponent(btnMedirDistancia1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnFinPartida1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frontend/Imagenes/stop.png"))); // NOI18N
        btnFinPartida1.setText("Finalizar Partida");
        btnFinPartida1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinPartida1ActionPerformed(evt);
            }
        });

        btnFinTurno1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frontend/Imagenes/cambio.png"))); // NOI18N
        btnFinTurno1.setText("Finalizar Turno");
        btnFinTurno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinTurno1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelOPcionesJuego1Layout = new javax.swing.GroupLayout(panelOPcionesJuego1);
        panelOPcionesJuego1.setLayout(panelOPcionesJuego1Layout);
        panelOPcionesJuego1Layout.setHorizontalGroup(
            panelOPcionesJuego1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOPcionesJuego1Layout.createSequentialGroup()
                .addComponent(btnFinPartida1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFinTurno1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelBotones1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelOPcionesJuego1Layout.setVerticalGroup(
            panelOPcionesJuego1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelBotones1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelOPcionesJuego1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnFinTurno1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addComponent(btnFinPartida1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(1, 1, 1));

        jLabel2.setFont(new java.awt.Font("URW Bookman L", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setText("Orden de Posicion");

        accionJugador.setFont(new java.awt.Font("URW Bookman L", 0, 18)); // NOI18N
        accionJugador.setForeground(new java.awt.Color(254, 254, 254));
        accionJugador.setText("Acciones Jugadores");

        btnTerminar.setBackground(new java.awt.Color(254, 254, 254));
        btnTerminar.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnTerminar.setText("Terminar Turno");
        btnTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarActionPerformed(evt);
            }
        });

        panelEnviarNaves.setOpaque(false);

        numNaves.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                numNavesKeyPressed(evt);
            }
        });

        btnEnviarNaves.setText("Enviar");
        btnEnviarNaves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarNavesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelEnviarNavesLayout = new javax.swing.GroupLayout(panelEnviarNaves);
        panelEnviarNaves.setLayout(panelEnviarNavesLayout);
        panelEnviarNavesLayout.setHorizontalGroup(
            panelEnviarNavesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnviarNavesLayout.createSequentialGroup()
                .addComponent(numNaves, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEnviarNaves, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelEnviarNavesLayout.setVerticalGroup(
            panelEnviarNavesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEnviarNavesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelEnviarNavesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numNaves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviarNaves)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelEnviarNaves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTerminar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(accionJugador)
                    .addContainerGap(777, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTerminar)))
                    .addComponent(panelEnviarNaves, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(accionJugador, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        consola1.setBackground(new java.awt.Color(1, 1, 1));
        jScrollPane3.setViewportView(consola1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelOPcionesJuego1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(panelTablero1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addGap(240, 240, 240))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelOPcionesJuego1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTablero1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnJuegoNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJuegoNuevoActionPerformed
        propiedades = new Propiedades(null);
        propiedades.setVisible(true);

        if (!propiedades.isVisible()) {
        }
    }//GEN-LAST:event_btnJuegoNuevoActionPerformed

    private void btnMedirDistanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedirDistanciaActionPerformed
        generarTablero();
    }//GEN-LAST:event_btnMedirDistanciaActionPerformed

    private void btnMedirDistancia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedirDistancia1ActionPerformed
        
    }//GEN-LAST:event_btnMedirDistancia1ActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized

    }//GEN-LAST:event_formComponentResized

    private void panelTablero1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelTablero1MouseClicked
        //System.out.println(planetasEscogidos.size() + "........................tam planetasEscogidos");
        if (planetasEscogidos.size() == 2) {
            accionJugador.setText(jugadorEnTurno.getNombre() + "  ¿Cuantas naves desea enviar?");
            panelEnviarNaves.setVisible(true);
        }
    }//GEN-LAST:event_panelTablero1MouseClicked

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped

        if (evt.getKeyCode() == evt.VK_ESCAPE) {
            showMessageDialog(this, "Has pulsado Enter");
        }
    }//GEN-LAST:event_formKeyTyped

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed


    }//GEN-LAST:event_formKeyPressed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        generarTablero();
    }//GEN-LAST:event_formMouseClicked

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered

    }//GEN-LAST:event_formMouseEntered

    private void btnTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarActionPerformed
        panelEnviarNaves.setVisible(false);
        System.out.println("fiN TURNO");
        if (numJugador == (jugadores.size() - 1)) {
            numJugador = 0;
            jugadorEnTurno = jugadores.get(numJugador);
            tablero.setJugador(jugadorEnTurno);
            accionJugador.setForeground(jugadorEnTurno.getColorJugador());
            accionJugador.setText(jugadorEnTurno.getNombre() + "   escoja un Planeta");
            turno = turno + 1;
            finTurno();
            panelEnviarNaves.setVisible(false);
        } else {
            System.out.println("aumentando Turno" + numJugador);
            numJugador = numJugador + 1;
            jugadorEnTurno = jugadores.get(numJugador);
            tablero.setJugador(jugadorEnTurno);
            accionJugador.setForeground(jugadorEnTurno.getColorJugador());
            accionJugador.setText(jugadorEnTurno.getNombre() + "   escoja un Planeta");
            panelEnviarNaves.setVisible(false);
        }

    }//GEN-LAST:event_btnTerminarActionPerformed

    private void btnFinTurno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinTurno1ActionPerformed
        panelEnviarNaves.setVisible(false);
        if (numJugador == (jugadores.size() - 1)) {
            numJugador = 0;
            jugadorEnTurno = jugadores.get(numJugador);
            tablero.setJugador(jugadorEnTurno);
            accionJugador.setForeground(jugadorEnTurno.getColorJugador());
            accionJugador.setText(jugadorEnTurno.getNombre() + "   escoja un Planeta");
            turno = turno + 1;
            finTurno();
            panelEnviarNaves.setVisible(false);
        } else {
            System.out.println("aumentando Turno" + numJugador);
            numJugador = numJugador + 1;
            jugadorEnTurno = jugadores.get(numJugador);
            tablero.setJugador(jugadorEnTurno);
            accionJugador.setForeground(jugadorEnTurno.getColorJugador());
            accionJugador.setText(jugadorEnTurno.getNombre() + "   escoja un Planeta");

            panelEnviarNaves.setVisible(false);
        }
    }//GEN-LAST:event_btnFinTurno1ActionPerformed
    int numeroFlota = 0;
    private void btnEnviarNavesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarNavesActionPerformed
        numeroFlota = numeroFlota + 1;
        System.out.println(planetasEscogidos.size());
        System.out.println("enviando " + numNaves.getValue());
        accion = new Accion();
        accion.setJugador(jugadorEnTurno);
        accion.setNavesEnviadas(Integer.parseInt(numNaves.getValue().toString()));
        if (accionesJugadores.get(numJugador).isEmpty()) {
            accion.setNumeroFlota(1);
        } else {
            int tam = accionesJugadores.get(numJugador).size() - 1;
            ArrayList<Accion> action = accionesJugadores.get(numJugador);
            accion.setNumeroFlota(action.get(tam).getNumeroFlota() + 1);
        }
        try {
            accion.setPlanetasUsados(atacar.crearAPlanetas(planetasEscogidos.get(0), planetasEscogidos.get(1)));
            accion.setRealizado(false);
            accion.setTurnoAllegar(atacar.determinarTurno(planetasEscogidos.get(0).getPosicion()[0], planetasEscogidos.get(0).getPosicion()[1],
                    planetasEscogidos.get(1).getPosicion()[0], planetasEscogidos.get(1).getPosicion()[1]) + turno);
            accionesJugadores.get(numJugador).add(accion);
            System.out.println(accionesJugadores.get(numJugador).size());
            acciones.add(accion);
            System.out.println(acciones.size());

            planetasEscogidos.clear();
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnEnviarNavesActionPerformed

    private void numNavesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numNavesKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            showMessageDialog(this, "Has pulsado Enter");
        }
    }//GEN-LAST:event_numNavesKeyPressed

    private void panelTablero1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelTablero1MouseEntered
        if (planetasEscogidos.size() == 2) {
            accionJugador.setText(jugadorEnTurno.getNombre() + "     ¿Cuantas naves desea enviar?");
            SpinnerModel sm = new SpinnerNumberModel(1, 1, planetasEscogidos.get(0).getNaves(), 1);
            numNaves.setModel(sm);
            panelEnviarNaves.setVisible(true);
        }

    }//GEN-LAST:event_panelTablero1MouseEntered

    private void btnVistaGeneral1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVistaGeneral1ActionPerformed

        VerFlotas flotas = new VerFlotas(null,true,jugadorEnTurno, accionesJugadores.get(numJugador));
        flotas.setVisible(true);
        
        
    }//GEN-LAST:event_btnVistaGeneral1ActionPerformed

    private void btnFinPartida1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinPartida1ActionPerformed
        this.removeAll();
        this.setVisible(false);
    }//GEN-LAST:event_btnFinPartida1ActionPerformed

    public void generarTablero() {
        panelTablero1.setVisible(false);
        panelTablero1.removeAll();
        panelTablero1.setLayout(new GridLayout(1, 1));
        tablero.setFila(mapa.getTamaño()[1]);
        tablero.setColumna(mapa.getTamaño()[0]);
        System.out.println(planetasNeutrales.size()+".............tama;o ");
        panelTablero1.add(tablero.llenarTablero(planetas, planetasNeutrales, 448, 448));
        panelTablero1.setPreferredSize(new Dimension(448, 448));
        panelTablero1.setVisible(true);
    }

    void obtenerYEscribirConsola(String texto, Color color) {
        //consola.setText(consola.getText() + "\n" + texto);
        appendToPane(consola1, texto + "\n", color);
    }

    void finTurno() {
        Boolean isFall;
        Accion ataque = atacar.verificarTurno(acciones, turno);
        if (ataque != null) {
            Jugador jugador = ataque.getJugador();
            Planeta origen;
            Planeta destino;
            if (ataque != null) {
                System.out.println("atacandoo....");
                if (ataque.getPlanetasUsados()[1].isNeutral()) {
                    isFall = atacar.atacar(ataque.getNavesEnviadas(), ataque.getPlanetasUsados()[0], ataque.getPlanetasUsados()[1]);
                    origen = ataque.getPlanetasUsados()[0];
                    destino = ataque.getPlanetasUsados()[1];
                    System.out.println(jugador.BuscarIndiceJugador(jugadores, jugador.getNombre()));
                    jugadores.get(jugador.BuscarIndiceJugador(jugadores, jugador.getNombre())).getPlanetasConquistados().add(planeta.BuscarIndicePlaneta(planetas, origen.getNombre()), ataque.getPlanetasUsados()[0]);
                    planetas.set(planeta.BuscarIndicePlaneta(planetas, origen.getNombre()), ataque.getPlanetasUsados()[0]);
                    planetas.set(planeta.BuscarIndicePlaneta(planetas, destino.getNombre()), ataque.getPlanetasUsados()[1]);
                    if (isFall) {
                        destino.setColorFondo(jugador.getColorJugador());
                        planetasNeutrales.remove(planetaNeutro.BuscarIndicePlanetaNeutral(planetasNeutrales, destino.getNombre()));
                        planetas.add(destino);
                        jugador.getPlanetasConquistados().add(destino);
                        JOptionPane.showMessageDialog(null, "El planeta " + destino.getNombre() + " ha caido ante el jugador " + jugador.getNombre());
                        obtenerYEscribirConsola("El planeta " + destino.getNombre() + " ha caido ante el jugador " + jugador.getNombre(), jugador.getColorJugador());
                    } else {
                        JOptionPane.showMessageDialog(null, "El planeta " + destino.getNombre() + " se ha defendido de ataque del " + jugador.getNombre());
                        obtenerYEscribirConsola("El planeta " + destino.getNombre() + " ha caido ante el jugador " + jugador.getNombre(), jugador.getColorJugador());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El Turno" + turno + " Ha Finalizado");
                }
            } else {
                System.out.println("nada en el turno " + turno);
            }
        }

    }

    void crearArreglosAcciones() {
        ArrayList<Accion> misAcciones;
        for (int i = 0; i < jugadores.size(); i++) {
            System.out.println("agregando Acciones");
            misAcciones = new ArrayList();
            accionesJugadores.add(misAcciones);
        }
    }

    private void appendToPane(JTextPane tp, String msg, Color c) {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        int len = tp.getDocument().getLength();
        tp.setCaretPosition(len);
        tp.setCharacterAttributes(aset, false);
        tp.replaceSelection(msg);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelBotones;
    private javax.swing.JPanel PanelBotones1;
    private javax.swing.JLabel accionJugador;
    private javax.swing.JButton btnEnviarNaves;
    private javax.swing.JButton btnFinPartida;
    private javax.swing.JButton btnFinPartida1;
    private javax.swing.JButton btnFinTurno;
    private javax.swing.JButton btnFinTurno1;
    private javax.swing.JButton btnJuegoNuevo;
    private javax.swing.JButton btnMedirDistancia;
    private javax.swing.JButton btnMedirDistancia1;
    private javax.swing.JButton btnTerminar;
    private javax.swing.JButton btnVistaGeneral;
    private javax.swing.JButton btnVistaGeneral1;
    private javax.swing.JTextArea consola;
    private javax.swing.JTextPane consola1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner numNaves;
    private javax.swing.JPanel panelEnviarNaves;
    private javax.swing.JPanel panelJuego;
    private javax.swing.JPanel panelOPcionesJuego;
    private javax.swing.JPanel panelOPcionesJuego1;
    private static javax.swing.JPanel panelTablero;
    private static javax.swing.JPanel panelTablero1;
    // End of variables declaration//GEN-END:variables
}
