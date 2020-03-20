
package Backend.Clases;

import java.util.ArrayList;

/**
 *
 * @author astridmc
 */
public class Jugador {
    
    String nombre;
    int numeroNaves;
    int punteo;
    ArrayList<Planeta> planetasConquistados;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroNaves() {
        return numeroNaves;
    }

    public void setNumeroNaves(int numeroNaves) {
        this.numeroNaves = numeroNaves;
    }

    public int getPunteo() {
        return punteo;
    }

    public void setPunteo(int punteo) {
        this.punteo = punteo;
    }

    public ArrayList<Planeta> getPlanetasConquistados() {
        return planetasConquistados;
    }

    public void setPlanetasConquistados(ArrayList<Planeta> planetasConquistados) {
        this.planetasConquistados = planetasConquistados;
    }
    
    public void agregarPlanetaConquistado(Planeta planeta){
        planetasConquistados.add(planeta);
    }
    
    
}
