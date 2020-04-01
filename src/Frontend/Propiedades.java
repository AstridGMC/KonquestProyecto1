/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

import Backend.Clases.EscritorJson;
import Backend.Clases.Jugador;
import Backend.Clases.Mapa;
import Backend.Clases.Planeta;
import Backend.Clases.PlanetaNeutral;
import Backend.Clases.Tablero;
import Backend.FlexYCup.AnalizadorLexico;
import Backend.FlexYCup.Parser;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.json.JSONObject;

/**
 *
 * @author astridmc
 */
public class Propiedades extends javax.swing.JDialog {
    boolean creado= false;
    String path1;
    DefaultTableModel modelo;
    ComboBoxModel<String> modeloCombo;
    Jugador jugador = new Jugador();
    int produccion = 10;
    int naves = 12;
    int planetasNeutrales;
    int numeroJugador = 1;
    Planeta planetaJugador;
    Tablero tablero = new Tablero();
    public ArrayList<Jugador> jugadores = new ArrayList();
    public ArrayList<Planeta> planetas = new ArrayList();
    public ArrayList<PlanetaNeutral> planetasNeutrales1 = new ArrayList();
    EscritorJson creadorJson = new EscritorJson();
    Boolean archivo;
    Mapa mapa = new Mapa();

    /**
     * Creates new form Propiedades
     *
     * @param path
     */

    /**
     * Creates new form Propiedades
     *
     * @param path
     * @param parent
     */
    public Propiedades(String path, java.awt.Frame parent) {
        super(parent, true);
        path1 = path;
        archivo = true;
        initComponents();
        enableComponents(jPanel1, false);
        modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Tipo");
        this.jugadoresTable.setModel(modelo);
        jugadoresTable.removeAll();
        setLocation(200, 100);
        try {
            AnalizadorLexico lexico = new AnalizadorLexico(new BufferedReader(new StringReader(creadorJson.leerArchivo(path))));
            Parser parser1 = new Parser(lexico);
            parser1.parse();
        } catch (Exception ex) {
            System.out.println("error ..." + ex);
        }
            mapa = Parser.mapa;
        planetas = Parser.planetas;
        if(mapa.isAlAzar()){
            PlanetaNeutral planNeutro = new PlanetaNeutral();
            planNeutro.GenerarPlanetasAlazarNeutrales(mapa.getNumeroPlanetasNeutrales(), mapa.getPlanetasNeutrales().getProduccion(), mapa.getTamaño()[0], mapa.getTamaño()[1]);
        }else{
             planetasNeutrales1 = Parser.planetasNeutrales;
        }
        planetas = Parser.planetas;
        jugadores = Parser.jugadores;
        System.out.println(jugadores.size() + " planetas " + planetas.size() + " neutrales " + planetasNeutrales1.size());
        llenarDatos(mapa);
        panelMapaCreado.setVisible(false);
        planetas = plan.AsignarEspacios(planetas, (Integer) Altura.getValue(), (Integer) Anchura.getValue());
        planetasNeutrales1 = plan.AsignarEspaciosNeutrales(planetasNeutrales1, (Integer) Altura.getValue(), (Integer) Anchura.getValue());
        generarTablero();
        //llenarDatos(Parser.mapa);
    }

    public Propiedades(java.awt.Frame parent) {
        super(parent, true);
        archivo = false;
        initComponents();
        generarPlanetasNeutrales();
        enableComponents(jPanel1, false);
        modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Tipo");
        setLocation(200, 100);
        this.jugadoresTable.setModel(modelo);
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public ArrayList<Planeta> getPlanetas() {
        return planetas;
    }

    public void setPlanetas(ArrayList<Planeta> planetas) {
        this.planetas = planetas;
    }

    public ArrayList<PlanetaNeutral> getPlanetasNeutrales1() {
        return planetasNeutrales1;
    }

    public void setPlanetasNeutrales1(ArrayList<PlanetaNeutral> planetasNeutrales1) {
        this.planetasNeutrales1 = planetasNeutrales1;
    }

    public Mapa getMapa() {
        return mapa;
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }

    public boolean isCreado() {
        return creado;
    }

    public void setCreado(boolean creado) {
        this.creado = creado;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        PanelJugadores = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jugadoresTable = new javax.swing.JTable();
        Eliminar = new javax.swing.JButton();
        comboTipoJugador = new javax.swing.JComboBox<>();
        btnAgregarJugador = new javax.swing.JButton();
        PanelMapa = new javax.swing.JPanel();
        panelMapaCreado = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        spinnerNumeroPlanetasNeutrales = new javax.swing.JSpinner();
        Anchura = new javax.swing.JSpinner();
        Altura = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        numeroPorcentajeMuertes = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        alAzarBtn = new javax.swing.JButton();
        numeroProduccion = new javax.swing.JSpinner();
        comboPlanetas = new javax.swing.JComboBox<>();
        txtNombre = new javax.swing.JTextField();
        nombrePlaneta = new javax.swing.JLabel();
        navesPlanetaTxt = new javax.swing.JLabel();
        navesPlaneta = new javax.swing.JSpinner();
        jPanel4 = new javax.swing.JPanel();
        checkProdAcum = new javax.swing.JCheckBox();
        checkMapaCiego = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        mostrarEstadisticas = new javax.swing.JCheckBox();
        mostrarNaves = new javax.swing.JCheckBox();
        finalizacionTxt = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        produccionTxt = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        idMapaTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setBackground(new java.awt.Color(1, 37, 66));
        setResizable(false);

        panelFondo.setBackground(new java.awt.Color(39, 69, 86));

        PanelJugadores.setBackground(new java.awt.Color(254, 254, 254));

        jugadoresTable.setFont(new java.awt.Font("Umpush", 0, 18)); // NOI18N
        jugadoresTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jugadoresTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jugadoresTableFocusGained(evt);
            }
        });
        jScrollPane2.setViewportView(jugadoresTable);

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        comboTipoJugador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HUMANO", "COMPUTADORA FACIL ", "COMPUTADORA DIFICIL" }));

        btnAgregarJugador.setText("Agregar");
        btnAgregarJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarJugadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelJugadoresLayout = new javax.swing.GroupLayout(PanelJugadores);
        PanelJugadores.setLayout(PanelJugadoresLayout);
        PanelJugadoresLayout.setHorizontalGroup(
            PanelJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelJugadoresLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(PanelJugadoresLayout.createSequentialGroup()
                .addComponent(btnAgregarJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(PanelJugadoresLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboTipoJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        PanelJugadoresLayout.setVerticalGroup(
            PanelJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelJugadoresLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboTipoJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Eliminar)
                    .addComponent(btnAgregarJugador))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        PanelMapa.setBackground(new java.awt.Color(236, 236, 236));
        PanelMapa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PanelMapa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelMapaMouseClicked(evt);
            }
        });

        panelMapaCreado.setBackground(new java.awt.Color(1, 28, 37));

        javax.swing.GroupLayout panelMapaCreadoLayout = new javax.swing.GroupLayout(panelMapaCreado);
        panelMapaCreado.setLayout(panelMapaCreadoLayout);
        panelMapaCreadoLayout.setHorizontalGroup(
            panelMapaCreadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        panelMapaCreadoLayout.setVerticalGroup(
            panelMapaCreadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 162, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Umpush", 1, 18)); // NOI18N
        jLabel4.setText("Anchura:");

        jLabel5.setFont(new java.awt.Font("Umpush", 1, 16)); // NOI18N
        jLabel5.setText("Planetas Neutrales:");

        jLabel6.setFont(new java.awt.Font("Umpush", 1, 18)); // NOI18N
        jLabel6.setText("Altura:");

        spinnerNumeroPlanetasNeutrales.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        spinnerNumeroPlanetasNeutrales.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spinnerNumeroPlanetasNeutrales.setValue(8);
        spinnerNumeroPlanetasNeutrales.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerNumeroPlanetasNeutralesStateChanged(evt);
            }
        });

        Anchura.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        Anchura.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        Anchura.setValue(8);
        Anchura.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                AnchuraStateChanged(evt);
            }
        });

        Altura.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        Altura.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        Altura.setValue(6);
        Altura.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                AlturaStateChanged(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        numeroPorcentajeMuertes.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(1.0f), Float.valueOf(1.0f)));

        jLabel7.setFont(new java.awt.Font("Umpush", 1, 16)); // NOI18N
        jLabel7.setText("Porcentaje de Muertes");

        jLabel8.setFont(new java.awt.Font("Umpush", 1, 16)); // NOI18N
        jLabel8.setText("Produccion:");

        alAzarBtn.setText("Alazar");
        alAzarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alAzarBtnActionPerformed(evt);
            }
        });

        numeroProduccion.setModel(new javax.swing.SpinnerNumberModel(5, 0, null, 1));

        comboPlanetas.setModel(new javax.swing.DefaultComboBoxModel<>(listarPropPlanetas()));

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
        });

        nombrePlaneta.setFont(new java.awt.Font("Umpush", 1, 16)); // NOI18N
        nombrePlaneta.setText("Nombre Planeta:");

        navesPlanetaTxt.setFont(new java.awt.Font("Umpush", 1, 16)); // NOI18N
        navesPlanetaTxt.setText("Numero De Naves");

        navesPlaneta.setModel(new javax.swing.SpinnerNumberModel(5, 0, null, 1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(95, 95, 95)
                                .addComponent(numeroProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(nombrePlaneta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(navesPlanetaTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(numeroPorcentajeMuertes, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(navesPlaneta, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(comboPlanetas, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(alAzarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(comboPlanetas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(numeroPorcentajeMuertes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(numeroProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombrePlaneta, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(navesPlanetaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(navesPlaneta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(alAzarBtn))
        );

        javax.swing.GroupLayout PanelMapaLayout = new javax.swing.GroupLayout(PanelMapa);
        PanelMapa.setLayout(PanelMapaLayout);
        PanelMapaLayout.setHorizontalGroup(
            PanelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelMapaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMapaLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Altura, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMapaLayout.createSequentialGroup()
                        .addGroup(PanelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(PanelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Anchura, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerNumeroPlanetasNeutrales, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMapaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelMapaCreado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        PanelMapaLayout.setVerticalGroup(
            PanelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMapaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(spinnerNumeroPlanetasNeutrales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Anchura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Altura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMapaCreado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        panelMapaCreado.getAccessibleContext().setAccessibleDescription("");

        jPanel4.setBackground(new java.awt.Color(236, 236, 236));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        checkProdAcum.setFont(new java.awt.Font("Umpush", 1, 18)); // NOI18N
        checkProdAcum.setText("Produccion Acumulativa");

        checkMapaCiego.setFont(new java.awt.Font("Umpush", 1, 18)); // NOI18N
        checkMapaCiego.setText(" Mapa Ciego ");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        mostrarEstadisticas.setFont(new java.awt.Font("Umpush", 1, 17)); // NOI18N
        mostrarEstadisticas.setText("Mostrar Estadisticas");
        mostrarEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarEstadisticasActionPerformed(evt);
            }
        });

        mostrarNaves.setFont(new java.awt.Font("Umpush", 1, 18)); // NOI18N
        mostrarNaves.setText("Mostrar Naves");
        mostrarNaves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarNavesActionPerformed(evt);
            }
        });

        finalizacionTxt.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        finalizacionTxt.setModel(new javax.swing.SpinnerNumberModel(50, 0, null, 1));

        jLabel11.setFont(new java.awt.Font("Umpush", 1, 18)); // NOI18N
        jLabel11.setText("Produccion:");

        produccionTxt.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        produccionTxt.setModel(new javax.swing.SpinnerNumberModel(10, 0, null, 1));

        jLabel12.setFont(new java.awt.Font("Umpush", 1, 18)); // NOI18N
        jLabel12.setText("Finalizacion:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mostrarEstadisticas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mostrarNaves, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(finalizacionTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(96, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(123, 123, 123)
                    .addComponent(produccionTxt)
                    .addGap(2, 2, 2)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(jLabel12)
                    .addContainerGap(96, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mostrarNaves)
                .addGap(18, 18, 18)
                .addComponent(mostrarEstadisticas)
                .addGap(18, 18, 18)
                .addComponent(finalizacionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(197, Short.MAX_VALUE)
                    .addComponent(jLabel11)
                    .addGap(14, 14, 14)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(197, Short.MAX_VALUE)
                    .addComponent(produccionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(14, 14, 14)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(139, Short.MAX_VALUE)
                    .addComponent(jLabel12)
                    .addGap(72, 72, 72)))
        );

        jLabel9.setFont(new java.awt.Font("Umpush", 1, 16)); // NOI18N
        jLabel9.setText("Neutrales:");

        jLabel10.setFont(new java.awt.Font("Umpush", 1, 18)); // NOI18N
        jLabel10.setText("Id Mapa:");

        idMapaTxt.setFont(new java.awt.Font("URW Bookman L", 0, 22)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(checkProdAcum)
                                .addComponent(checkMapaCiego, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(11, 11, 11)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(27, 27, 27)
                        .addComponent(idMapaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 16, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkMapaCiego)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkProdAcum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(idMapaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        jLabel2.setFont(new java.awt.Font("URW Bookman L", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setText("Jugadores:");

        jLabel3.setFont(new java.awt.Font("URW Bookman L", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setText("Mapa:");

        jLabel1.setFont(new java.awt.Font("URW Bookman L", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Propiedades:");

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frontend/Imagenes/checkmark.png"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frontend/Imagenes/stop.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFondoLayout = new javax.swing.GroupLayout(panelFondo);
        panelFondo.setLayout(panelFondoLayout);
        panelFondoLayout.setHorizontalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFondoLayout.createSequentialGroup()
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(28, 28, 28)
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelMapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addGap(33, 33, 33))
        );
        panelFondoLayout.setVerticalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(PanelMapa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelJugadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mostrarEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarEstadisticasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mostrarEstadisticasActionPerformed

    private void mostrarNavesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarNavesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mostrarNavesActionPerformed

    private void btnAgregarJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarJugadorActionPerformed
        String[] datoJugador = new String[2];
        ArrayList<Planeta> planJugador = new ArrayList();
        datoJugador[0] = "Jugador" + numeroJugador++;
        datoJugador[1] = comboTipoJugador.getSelectedItem().toString();
        planetaJugador = new Planeta(plan.generarNombreAleatorio(), 10, produccion, plan.generarPorcentajeMuertes(), false);
        Jugador jugador = new Jugador(datoJugador[0], 10, 0, planJugador, datoJugador[1]);
        planetaJugador.setDueño(jugador);
        jugador.setColorJugador(jugador.generarColor(numeroJugador));
        planetaJugador.setColorFondo(jugador.getColorJugador());
        planetaJugador.setPosicion(plan.AsignarEspacioPlanetas((Integer) Altura.getValue(), (Integer) Anchura.getValue()));
        planetaJugador.setImagenPath(plan.elegirImagen());
        planetaJugador.setNaves((Integer) navesPlaneta.getValue());
        planJugador.add(planetaJugador);
        jugador.setPlanetasConquistados(planJugador);
        planetas.add(planetaJugador);
        jugadores.add(jugador);
        generarTablero();
        modelo.addRow(datoJugador);
        comboPlanetas.removeAllItems();
        comboPlanetas.setModel(new javax.swing.DefaultComboBoxModel<>(listarPropPlanetas()));
    }//GEN-LAST:event_btnAgregarJugadorActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        int fila = jugadoresTable.getSelectedRow();
        if (fila >= 0) {
            panelMapaCreado.setVisible(false);
            modelo.removeRow(fila);
            planetas.remove(fila);
            jugadores.remove(fila);
            generarTablero();
        } else {
            JOptionPane.showMessageDialog(null, "Seleccionar Fila");
        }
    }//GEN-LAST:event_EliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Principal.creado = false;
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void PanelMapaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelMapaMouseClicked
        panelMapaCreado.setVisible(false);
        enableComponents(jPanel1, false);
        if (planeta2 != null) {
            
            guardarDatosPlaneta(planeta2);
            generarTablero();
            panelMapaCreado.setVisible(true);
        }

    }//GEN-LAST:event_PanelMapaMouseClicked

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        recopilarDatosPropiedades();
        System.out.println("crea Jason.........");
        JSONObject mapaJson = creadorJson.crearObjetoMapa(recopilarDatosPropiedades());
        JSONObject[] planetasJson = creadorJson.crearPlanetas(planetas);
        JSONObject[] jugadoresJson = creadorJson.crearJugadores(jugadores);
        JSONObject[] planetasNeutralesJson = creadorJson.crearPlanetasNeutrales(planetasNeutrales1);
        JSONObject objetoJuego = creadorJson.generarObjetoJuego(mapaJson, planetasJson, planetasNeutralesJson, jugadoresJson);
        if (archivo = true) {
            if(path1!=null)
            creadorJson.modificador(path1, objetoJuego.toString()); 
            creado = true;
            this.setVisible(false);
        } 
        if(path1==null) {
            System.out.println(" ingresandooooooooooo");
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int result = fileChooser.showOpenDialog(this);
            if (result != JFileChooser.CANCEL_OPTION) {

                File fileName = fileChooser.getSelectedFile();

                if ((fileName == null) || (fileName.getName().equals(""))) {
                    System.out.println("no se eligio direccion");
                    JOptionPane.showMessageDialog(null, "No se ha elegido Direccion");
                    //  txt.setText("...");
                } else {
                    PlanetaNeutral neutral = new PlanetaNeutral();
                    System.out.println(mapa.getTamaño()[0]+""+ mapa.getTamaño()[1]+""+  mapa.getPlanetasNeutrales().getProduccion());
                    planetasNeutrales1 = neutral.VerificarPlanetasNeutrales(planetasNeutrales1,(Integer) Altura.getValue(), (Integer) Anchura.getValue(), mapa.getPlanetasNeutrales().getProduccion());
                    planetas = plan.VerificarPlanetas(planetas,(Integer) Altura.getValue(), (Integer) Anchura.getValue(), mapa.getPlanetasNeutrales().getProduccion());
                    String path = fileName.getAbsolutePath();
                    System.out.print(objetoJuego);
                    System.out.println(idMapaTxt.getText());
                    creadorJson.creador(path, idMapaTxt.getText(), objetoJuego.toString());
                    System.out.println("creado..........");
                    creado = true;
                    this.setVisible(false);
                }
            }
        }

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void jugadoresTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jugadoresTableFocusGained
        System.out.println("cambiando texto ");
        try {
            jugadores.get(jugadoresTable.getSelectedRow()).setNombre(jugadoresTable.getValueAt(jugadoresTable.getSelectedRow(), 0).toString());
        } catch (Exception e) {
        }

    }//GEN-LAST:event_jugadoresTableFocusGained

    private void spinnerNumeroPlanetasNeutralesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerNumeroPlanetasNeutralesStateChanged
        int generarPlanetNeutros = planetasNeutrales - (Integer) spinnerNumeroPlanetasNeutrales.getValue();
        panelMapaCreado.setVisible(false);
        generarPlanetasNeutrales();
        if (generarPlanetNeutros > 0) {
            PlanetaNeutral planetaNeutral = new PlanetaNeutral();
            planetaNeutral.setNombre(plan.generarNombreAleatorio());
            planetaNeutral.setPosicion(plan.AsignarEspacioPlanetas((Integer) Altura.getValue(), (Integer) Anchura.getValue()));
            planetaNeutral.setProduccion((Integer) produccionTxt.getValue());
            planetaNeutral.setPorcentajeMuertes(plan.generarPorcentajeMuertes());
            planetaNeutral.setNaves(naves);
            planetasNeutrales1.add(planetaNeutral);
            planetasNeutrales = planetasNeutrales + 1;
        }
        Planeta plan= new Planeta();
        panelMapaCreado.setVisible(false);
        //planetas = plan.AsignarEspacios(planetas, (Integer) Altura.getValue(), (Integer) Anchura.getValue());
        //planetasNeutrales1 = plan.AsignarEspaciosNeutrales(planetasNeutrales1, (Integer) Altura.getValue(), (Integer) Anchura.getValue());
        generarTablero();
    }//GEN-LAST:event_spinnerNumeroPlanetasNeutralesStateChanged

    private void AnchuraStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_AnchuraStateChanged
        panelMapaCreado.setVisible(false);
        Planeta plan= new Planeta();
        planetas = plan.AsignarEspacios(planetas, (Integer) Altura.getValue(), (Integer) Anchura.getValue());
        planetasNeutrales1 = plan.AsignarEspaciosNeutrales(planetasNeutrales1, (Integer) Altura.getValue(), (Integer) Anchura.getValue());
        generarTablero();
    }//GEN-LAST:event_AnchuraStateChanged

    private void AlturaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_AlturaStateChanged
        panelMapaCreado.setVisible(false);
        Planeta plan= new Planeta();
        planetas = plan.AsignarEspacios(planetas, (Integer) Altura.getValue(), (Integer) Anchura.getValue());
        planetasNeutrales1= plan.AsignarEspaciosNeutrales(planetasNeutrales1, (Integer) Altura.getValue(), (Integer) Anchura.getValue());
        generarTablero();
    }//GEN-LAST:event_AlturaStateChanged

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        if (txtNombre.getText().length() == 3) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyPressed

    private void alAzarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alAzarBtnActionPerformed
        if (alAzar) {
            alAzar = false;
        } else {
            alAzar = true;
        }
        Planeta plan= new Planeta();
        planetas = plan.AsignarEspacios(planetas, (Integer) Altura.getValue(), (Integer) Anchura.getValue());
        planetasNeutrales1 = plan.AsignarEspaciosNeutrales(planetasNeutrales1, (Integer) Altura.getValue(), (Integer) Anchura.getValue());
        panelMapaCreado.setVisible(false);
        generarTablero();
    }//GEN-LAST:event_alAzarBtnActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        if (txtNombre.getText().length() == 3) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    public String[] listarPropPlanetas() {
        String[] tipoJugadores;
        if (modelo != null) {
            tipoJugadores = new String[modelo.getRowCount() + 2];
            tipoJugadores[0] = "Neutral";
            tipoJugadores[1] = "Desocupado";
            if (modelo.getColumnCount() > 0) {
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    int fila = i + 2;
                    tipoJugadores[fila] = modelo.getValueAt(i, 0).toString();

                }
            }
            return tipoJugadores;
        } else {
            tipoJugadores = new String[2];
            tipoJugadores[0] = "Neutral";
            tipoJugadores[1] = "Desocupado";
            return tipoJugadores;
        }
    }

    public void listarJugadoresTabla() {
        Jugador jugador;
        for (int i = 0; i < jugadoresTable.getRowCount(); i++) {
            if (modelo.getRowCount() > 0) {
                jugador = new Jugador(jugadoresTable.getValueAt(i, 0).toString(), jugadoresTable.getValueAt(i, 1).toString());
                jugadores.add(jugador);
            }
        }
    }

    public static int buscarIndiceJugadoresTabla(Planeta planeta) {
        int miIndice = 0;
        for (int i = 0; i < jugadoresTable.getRowCount(); i++) {
            if (planeta.getDueño() != null) {
                if (jugadoresTable.getValueAt(i, 0).toString().equals(planeta.getDueño().getNombre())) {
                    miIndice = i + 2;
                    return i + 2;
                }
            } else if (planeta.isNeutral()) {
                return 0;
            } else {
                return 1;
            }
        }
        return miIndice;
    }

    public static void enableComponents(Container container, boolean enable) {
        Component[] components = container.getComponents();
        for (Component component : components) {
            component.setEnabled(enable);
            if (component instanceof Container) {
                enableComponents((Container) component, enable);
            }
        }
    }
    Planeta plan = new Planeta();

    public void cambiarDatosJugador() {
        jugadores.get(jugadoresTable.getSelectedRow()).setNombre(jugadoresTable.getValueAt(jugadoresTable.getSelectedRow(), 0).toString());
    }

    public void generarPlanetasNeutrales() {
        PlanetaNeutral planetaNeutral;
        planetasNeutrales1.clear();
        planetasNeutrales = (Integer) spinnerNumeroPlanetasNeutrales.getValue();
        for (int i = 0; i < (Integer) spinnerNumeroPlanetasNeutrales.getValue(); i++) {
            planetaNeutral = new PlanetaNeutral();
            planetaNeutral.setNombre(plan.generarNombreAleatorio());
            planetaNeutral.setNaves((Integer) navesPlaneta.getValue());
            planetaNeutral.setPorcentajeMuertes(plan.generarPorcentajeMuertes());
            planetaNeutral.setProduccion((Integer) numeroProduccion.getValue());
            planetaNeutral.setPosicion(plan.AsignarEspacioPlanetas((Integer) Altura.getValue(), (Integer) Anchura.getValue()));
            planetasNeutrales1.add(planetaNeutral);
        }
    }

    public void generarTablero() {
        System.out.println(planetas.size()+"...........................................2222222222");
        System.out.println("removiendo");
        panelMapaCreado.removeAll();
        Tablero tablero1 = new Tablero();
        panelMapaCreado.setLayout(new GridLayout(1, 1));
        tablero1.setFila((Integer) Altura.getValue());
        tablero1.setColumna((Integer) Anchura.getValue());
        tablero1.setTipoJuego(false);
        panelMapaCreado.add(tablero1.llenarTablero(planetas, planetasNeutrales1, 180, 162));
        panelMapaCreado.setPreferredSize(new Dimension(180, 162));
        panelMapaCreado.setVisible(true);
    }
    static Planeta planeta2;

    public static void llenarDatosPlaneta(Planeta planeta) {
        planeta2 = planeta;
        int miIndice = buscarIndiceJugadoresTabla(planeta);
        comboPlanetas.setSelectedIndex(miIndice);
        txtNombre.setText(planeta.getNombre());
        numeroProduccion.setValue(planeta.getProduccion());
        numeroPorcentajeMuertes.setValue(planeta.getPorcentajeMuertes());
        navesPlaneta.setValue(planeta.getNaves());
    }

    public void guardarDatosPlaneta(Planeta planeta) {
        planeta.setNombre(txtNombre.getText());
        planeta.setProduccion((Integer) numeroProduccion.getValue());
        planeta.setNaves((Integer) navesPlaneta.getValue());
        planeta.setPorcentajeMuertes((float) numeroPorcentajeMuertes.getValue());
        if ((float) numeroPorcentajeMuertes.getValue() < 1) {
            planeta.setPorcentajeMuertes((float) numeroPorcentajeMuertes.getValue());
        }
        if (comboPlanetas.getSelectedItem().toString().equals("Neutral") || comboPlanetas.getSelectedItem().toString().equals("Desocupado")) {
            PlanetaNeutral neutral = new PlanetaNeutral();
            neutral.setColorFondo(null);
            neutral.setDueño(null);
            neutral.setNombre(planeta.getNombre());
            neutral.setProduccion(planeta.getProduccion());
            neutral.setNeutral(true);
            neutral.setPorcentajeMuertes(planeta.getPorcentajeMuertes());
            neutral.setPosicion(planeta.getPosicion());
            neutral.setNaves((Integer) navesPlaneta.getValue());
            neutral.setImagenPath("planetas/neutral.png");
            planeta.setDueño(null);
            if (!planeta.isNeutral()) {
                planetas.remove(planeta);
                planetasNeutrales1.add(neutral);
            }

        } else {
            Jugador jugadorP = new Jugador();
            ArrayList<Planeta> planetJugador = new ArrayList();
            planeta.setDueño(jugadores.get(jugadorP.BuscarIndiceJugador(jugadores, comboPlanetas.getSelectedItem().toString())));
            jugadorP = jugadores.get(jugadorP.BuscarIndiceJugador(jugadores, planeta.getDueño().getNombre()));

            if (planeta.isNeutral()) {
                planeta.setNeutral(false);
                planeta.setImagenPath(planeta.elegirImagen());
                planeta.setColorFondo(jugadorP.getColorJugador());
                System.out.println(jugadorP.getColorJugador());
                planetasNeutrales1.remove(planeta);
                planetas.add(planeta);
            }
            planetJugador.add(planeta);
            jugadorP.setPlanetasConquistados(planetJugador);
        }
    }

    boolean alAzar = false;

    public Mapa recopilarDatosPropiedades() {
        Mapa mapa = new Mapa();
        mapa.setAcumular(checkProdAcum.isSelected());
        mapa.setAlAzar(alAzar);
        mapa.setFinalizacion((Integer) finalizacionTxt.getValue());
        mapa.setIdMapa(idMapaTxt.getText());
        mapa.setMapaCiego(checkMapaCiego.isSelected());
        int[] tamMapa = {(Integer) Altura.getValue(), (Integer) Anchura.getValue()};
        mapa.setTamaño(tamMapa);
        PlanetaNeutral neutral = new PlanetaNeutral();
        neutral.setMostrarNaves(mostrarNaves.isSelected());
        neutral.setMostrarEstadisticas(mostrarEstadisticas.isSelected());
        neutral.setProduccion((Integer) produccionTxt.getValue());
        mapa.setPlanetasNeutrales(neutral);
        mapa.setNumeroPlanetasNeutrales((Integer) spinnerNumeroPlanetasNeutrales.getValue());
        return mapa;
    }

    //llenar Datos desde el archivo leido
    public void llenarDatos(Mapa mapa) {
        jugador.generarColor(jugadores);
        jugadores = jugador.planetaAsignarPropietario(jugadores, planetas);
        System.out.println(jugadores.get(0).getPlanetasConquistados().size() + " ........fffffffffff..");
        PlanetaNeutral neutral = new PlanetaNeutral();
        produccion = mapa.getPlanetasNeutrales().getProduccion();
        System.out.println("............." + planetas.size());
        planetasNeutrales1 = neutral.VerificarPlanetasNeutrales(planetasNeutrales1, mapa.getTamaño()[1], mapa.getTamaño()[0], mapa.getPlanetasNeutrales().getProduccion());
        planetas = plan.VerificarPlanetas(planetas, mapa.getTamaño()[1], mapa.getTamaño()[0], mapa.getPlanetasNeutrales().getProduccion());
        checkMapaCiego.setSelected(mapa.isMapaCiego());
        checkProdAcum.setSelected(mapa.isAcumular());
        alAzar = mapa.isAlAzar();
        idMapaTxt.setText(mapa.getIdMapa());
        mostrarNaves.setSelected(mapa.getPlanetasNeutrales().isMostrarEstadisticas());
        mostrarEstadisticas.setSelected(mapa.getPlanetasNeutrales().isMostrarEstadisticas());
        finalizacionTxt.setValue(mapa.getFinalizacion());
        Anchura.setValue(mapa.getTamaño()[0]);
        Altura.setValue(mapa.getTamaño()[1]);
        produccionTxt.setValue(mapa.getPlanetasNeutrales().getProduccion());
        String[] datoJugador = new String[2];
        for (int i = 0; i < jugadores.size(); i++) {
            datoJugador[0] = jugadores.get(i).getNombre();
            datoJugador[1] = jugadores.get(i).getTipo();
            modelo.addRow(datoJugador);
            comboPlanetas.removeAllItems();
            comboPlanetas.setModel(new javax.swing.DefaultComboBoxModel<>(listarPropPlanetas()));
        }
        if (alAzar == true) {
            planetas = plan.GenerarPlanetasAlazar(jugadores, produccion, mapa.getTamaño()[0], mapa.getTamaño()[1]);
            planetasNeutrales1 = neutral.GenerarPlanetasAlazarNeutrales(mapa.getNumeroPlanetasNeutrales(), produccion, mapa.getTamaño()[0], mapa.getTamaño()[1]);
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner Altura;
    private javax.swing.JSpinner Anchura;
    private javax.swing.JButton Eliminar;
    private javax.swing.JPanel PanelJugadores;
    private javax.swing.JPanel PanelMapa;
    private javax.swing.JButton alAzarBtn;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregarJugador;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JCheckBox checkMapaCiego;
    private javax.swing.JCheckBox checkProdAcum;
    private static javax.swing.JComboBox<String> comboPlanetas;
    private javax.swing.JComboBox<String> comboTipoJugador;
    private javax.swing.JSpinner finalizacionTxt;
    private javax.swing.JTextField idMapaTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JTable jugadoresTable;
    private javax.swing.JCheckBox mostrarEstadisticas;
    private javax.swing.JCheckBox mostrarNaves;
    public static javax.swing.JSpinner navesPlaneta;
    private javax.swing.JLabel navesPlanetaTxt;
    private javax.swing.JLabel nombrePlaneta;
    public static javax.swing.JSpinner numeroPorcentajeMuertes;
    public static javax.swing.JSpinner numeroProduccion;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JPanel panelMapaCreado;
    private javax.swing.JSpinner produccionTxt;
    private javax.swing.JSpinner spinnerNumeroPlanetasNeutrales;
    public static javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
