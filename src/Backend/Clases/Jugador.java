
package Backend.Clases;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author astridmc
 */
public class Jugador {
    
    String nombre;
    Color colorJugador;
    int numeroNaves;
    int punteo;
    ArrayList<Planeta> planetasConquistados;
    ArrayList<Accion> accionesJugador;
    int navesEnviadas;
    int navesConstruidas;
    String tipo;

    public Jugador(String nombre, int numeroNaves, int punteo, ArrayList<Planeta> planetasConquistados, String tipo) {
        this.nombre = nombre;
        this.numeroNaves = numeroNaves;
        this.punteo = punteo;
        this.planetasConquistados = planetasConquistados;
        this.tipo = tipo;
        
    }

    public Jugador(String nombre, ArrayList<Planeta> planetasConquistados, String tipo) {
        this.nombre = nombre;
        this.planetasConquistados = planetasConquistados;
        this.tipo = tipo;
        this.numeroNaves = planetasConquistados.size();
    }
    
    

    public Jugador(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo= tipo;
    }

    public Jugador() {
    }

    
    
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Color getColorJugador() {
        return colorJugador;
    }

    public void setColorJugador(Color colorJugador) {
        this.colorJugador = colorJugador;
    }
    public void generarColor(ArrayList<Jugador> jugadores){
        for (int i = 0; i < jugadores.size(); i++) {
            jugadores.get(i).setColorJugador(generarColor(i));
            System.out.println("............generando Color");
        }
    }

    public ArrayList<Accion> getAccionesJugador() {
        return accionesJugador;
    }

    public void setAccionesJugador(ArrayList<Accion> accionesJugador) {
        this.accionesJugador = accionesJugador;
    }

    public int getNavesEnviadas() {
        return navesEnviadas;
    }

    public void setNavesEnviadas(int navesEnviadas) {
        this.navesEnviadas = navesEnviadas;
    }

    public int getNavesConstruidas() {
        return navesConstruidas;
    }

    public void setNavesConstruidas(int navesConstruidas) {
        this.navesConstruidas = navesConstruidas;
    }
    
    
    public int BuscarIndiceJugador(ArrayList<Jugador> jugadores, String nombre) {
        Jugador jugador = null;
        int j=0 ;
        for (j = 0; j < jugadores.size(); j++) {
            if (jugadores.get(j).getNombre().equals(nombre)) {
                jugador = jugadores.get(j);
                return j;
            }
        }
        return j;
    }
    private static final Color[] colores = {Color.GREEN, Color.BLUE, Color.RED, Color.GRAY, Color.CYAN, Color.YELLOW, Color.BLUE, Color.MAGENTA, Color.ORANGE, Color.PINK};

    public Color generarColor(int i) {
        return colores[i];
    }
    
    public String[] combertirPLanetasArreglo(){
        String[] misPlanetas = new String[planetasConquistados.size()];
        System.out.println(planetasConquistados.size()+ " tam de  planetas jugador");
        for (int i = 0; i < planetasConquistados.size(); i++) {
            misPlanetas[i]= planetasConquistados.get(i).getNombre();
        }
        return misPlanetas;
    }
    
    public ArrayList<Jugador> planetaAsignarPropietario(ArrayList<Jugador> jugadores, ArrayList<Planeta> planetas){
        ArrayList<Planeta> planetasAsig;
        
        for (int i = 0; i < jugadores.size(); i++) {
            System.out.println(jugadores.get(i).getPlanetasConquistados().size());
             planetasAsig = new ArrayList();
            for (int j = 0; j < jugadores.get(i).getPlanetasConquistados().size(); j++) {
                System.out.println(jugadores.get(i).getPlanetasConquistados().get(j).getNombre());
                for (int k = 0; k < planetas.size(); k++) {
                    if(planetas.get(k).getNombre().equals(jugadores.get(i).getPlanetasConquistados().get(j).getNombre())){
                       planetasAsig.add(planetas.get(k));
                       System.out.println("ASIGNANDO PROPIETARIO "+ planetas.get(k).getNombre()+" Color " +  jugadores.get(i).getColorJugador()+" "+planetasAsig.size());
                       planetas.get(k).setDueño(jugadores.get(i));
                    }
                }
                
            }
            jugadores.get(i).setPlanetasConquistados(planetasAsig);
            System.out.println(jugadores.get(i).getPlanetasConquistados().size() +" tam planetas");
        }
        return jugadores;
    }
    
    public Planeta verificarPropiedad(Planeta planeta){
        Planeta planeta1= null;
        System.out.println(planetasConquistados.size());
        for (int i = 0; i < planetasConquistados.size(); i++) {
            System.out.println("sisisisisis");
            if(planeta.getNombre().equals(planetasConquistados.get(i).getNombre())){
                System.out.println("propietario........");
                planeta1 = planeta;
            }else{
               planeta1 = null;
            }
        }
        return planeta1;
    }
    
    public int obtenerTamFlota(){
        int tamFlota=0;
        for (int i = 0; i < planetasConquistados.size(); i++) {
            tamFlota = tamFlota + planetasConquistados.get(i).getNaves();
        }
        return tamFlota;
    }
    
    public int buscarIndiceJugador(ArrayList<Jugador> jugadores, String nombre){
        int indice=21;
        for (int i = 0; i < jugadores.size(); i++) {
            if(jugadores.get(i).getNombre().equals(nombre)){
                indice = i;
            }
        }
        return indice;
    }
}
