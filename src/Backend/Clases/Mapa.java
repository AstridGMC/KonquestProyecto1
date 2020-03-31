/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Clases;

/**
 *
 * @author astridmc
 */
public class Mapa {
    private String idMapa;
    private int[] tamaño;
    private boolean alAzar;
    int numeroPlanetasNeutrales;
    private PlanetaNeutral planetasNeutrales;
    private boolean mapaCiego;
    private boolean acumular;
    private int finalizacion;

    public String getIdMapa() {
        return idMapa;
    }

    public void setIdMapa(String idMapa) {
        this.idMapa = idMapa;
    }

    public int[] getTamaño() {
        return tamaño;
    }

    public void setTamaño(int[] tamaño) {
        this.tamaño = tamaño;
    }

    public boolean isAlAzar() {
        return alAzar;
    }

    public void setAlAzar(boolean alAzar) {
        this.alAzar = alAzar;
    }

    public PlanetaNeutral getPlanetasNeutrales() {
        return planetasNeutrales;
    }

    public void setPlanetasNeutrales(PlanetaNeutral planetasNeutrales) {
        this.planetasNeutrales = planetasNeutrales;
    }

    public boolean isMapaCiego() {
        return mapaCiego;
    }

    public void setMapaCiego(boolean mapaCiego) {
        this.mapaCiego = mapaCiego;
    }

    public boolean isAcumular() {
        return acumular;
    }

    public void setAcumular(boolean acumular) {
        this.acumular = acumular;
    }

    public int getFinalizacion() {
        return finalizacion;
    }

    public void setFinalizacion(int finalizacion) {
        this.finalizacion = finalizacion;
    }

    public int getNumeroPlanetasNeutrales() {
        return numeroPlanetasNeutrales;
    }

    public void setNumeroPlanetasNeutrales(int numeroPlanetasNeutrales) {
        this.numeroPlanetasNeutrales = numeroPlanetasNeutrales;
    }
    
    
}
