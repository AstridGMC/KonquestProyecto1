/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Clases;

import java.util.ArrayList;

/**
 *
 * @author astridmc
 */
public class PlanetaNeutral extends Planeta {
    
    private boolean mostrarNaves;
    private boolean mostrarEstadisticas;

    public PlanetaNeutral() {
        this.neutral = true;
        this.imagenPath = "planetas/neutral.png";
    }

    public PlanetaNeutral(String nombre, int naves, int produccion, float porcentajeMuertes, boolean neutral) {
        super(nombre, naves, produccion, porcentajeMuertes, neutral);
    }
    
    
    
    public boolean isMostrarNaves() {
        return mostrarNaves;
    }

    public void setMostrarNaves(boolean mostrarNaves) {
        this.mostrarNaves = mostrarNaves;
    }

    public boolean isMostrarEstadisticas() {
        return mostrarEstadisticas;
    }

    public void setMostrarEstadisticas(boolean mostrarEstadisticas) {
        this.mostrarEstadisticas = mostrarEstadisticas;
    }
    
    public int BuscarIndicePlanetaNeutral(ArrayList<PlanetaNeutral> planetas, String nombre) {
        Planeta planeta = null;
        int j=0 ;
        for (j = 0; j < planetas.size(); j++) {
            if (planetas.get(j).getNombre().equals(nombre)) {
                planeta = planetas.get(j);
                return j;
            }
        }
        return j;
    }
    
      public ArrayList<PlanetaNeutral> VerificarPlanetasNeutrales(ArrayList<PlanetaNeutral> planetas, int filas, int columnas, int produccion){
        Tablero tab = new Tablero();
        for (int j = 0;  j< planetas.size(); j++) {
            System.out.println(".............." + planetas.get(j).getNombre());
            Planeta planeta =planetas.get(j);
            if(planeta.getNombre()==null){
                planeta.setNombre(generarNombreAleatorio());
            }
            planeta.setImagenPath("planetas/neutral.png");
            if(planeta.getPorcentajeMuertes()<=0){
                planeta.setPorcentajeMuertes(generarPorcentajeMuertes());
            }
            if(planeta.getPosicion()==null){
                planeta.setPosicion(AsignarEspacioPlanetas(filas, columnas));
            }
            if(planeta.getProduccion()<=0){
                planeta.setProduccion(produccion);
            }
            planeta.setNeutral(true);
        }
        return planetas;
    }
    
    public ArrayList<PlanetaNeutral> GenerarPlanetasAlazarNeutrales(int numeronNeutrales, int produccion, int filas, int planetas){
        ArrayList<PlanetaNeutral> misPlanetas = new ArrayList();
        for (int j = 0; j < numeronNeutrales; j++) {
                PlanetaNeutral planeta = new PlanetaNeutral( generarNombreAleatorio(),10, produccion, generarPorcentajeMuertes(), true);
                planeta.setNombre(generarNombreAleatorio());
                planeta.setPorcentajeMuertes(generarPorcentajeMuertes());
                planeta.setProduccion(produccion);
                planeta.setNaves(10);
                planeta.setPosicion(AsignarEspacioPlanetas(filas, planetas));
                planeta.setImagenPath("planetas/neutral.png");
                misPlanetas.add(planeta);
            
        }
        return misPlanetas;
        
    }
}
