/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

import Backend.Clases.Jugador;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author astridmc
 */
public class ResumenJuego extends javax.swing.JDialog {

    ArrayList<Jugador> jugadores = new ArrayList();

    /**
     * Creates new form ResumenJuego
     * @param parent
     * @param modal
     * @param jugadores
     */
    public ResumenJuego(java.awt.Frame parent, boolean modal, ArrayList<Jugador> jugadores) {
        super(parent, modal);
        this.jugadores = jugadores;
        initComponents();
        llenarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableResumenJuegadores = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tableResumenJuegadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableResumenJuegadores);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void llenarTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("jugador");
        modelo.addColumn("Planetas \nConquistados");
        modelo.addColumn("Flotas Lanzadas");
        modelo.addColumn("Produccion Actual");
        modelo.addColumn("Tamaño Flota");
        tableResumenJuegadores.setModel(modelo);
        tableResumenJuegadores.setRowHeight(25);
        for (int i = 0; i < jugadores.size(); i++) {
            modelo.addRow(generarArregloDatos(jugadores.get(i)));
        }
    }

    private String[] generarArregloDatos(Jugador jugador) {
        String[] infoJugador = new String[5];
        infoJugador[0] = jugador.getNombre();
        infoJugador[1] = String.valueOf(jugador.getPlanetasConquistados().size());
        infoJugador[2] = String.valueOf(jugador.getNavesEnviadas());
        if (jugador.getPlanetasConquistados().size() > 0) {
            infoJugador[3] = String.valueOf(jugador.getPlanetasConquistados().get(0));
        }else{
            infoJugador[3] = String.valueOf(0);
        }
        infoJugador[4] = String.valueOf(jugador.obtenerTamFlota());
        
        return infoJugador;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableResumenJuegadores;
    // End of variables declaration//GEN-END:variables
}
