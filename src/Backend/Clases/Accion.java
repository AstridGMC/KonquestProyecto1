
package Backend.Clases;

import java.util.ArrayList;

/**
 *
 * @author astridmc
 */
public class Accion {
    
    Planeta[] planetasUsados;
    Jugador jugador;
    int navesEnviadas;
    int turnoAllegar;
    boolean realizado;
    int numeroFlota =0 ;

    public Planeta[] getPlanetasUsados() {
        return planetasUsados;
    }

    public void setPlanetasUsados(Planeta[] planetasUsados) {
        this.planetasUsados = planetasUsados;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public int getNavesEnviadas() {
        return navesEnviadas;
    }

    public void setNavesEnviadas(int navesEnviadas) {
        this.navesEnviadas = navesEnviadas;
    }

    public int getTurnoAllegar() {
        return turnoAllegar;
    }

    public void setTurnoAllegar(int turnoAllegar) {
        this.turnoAllegar = turnoAllegar;
    }

    public boolean isRealizado() {
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }

    public int getNumeroFlota() {
        return numeroFlota;
    }

    public void setNumeroFlota(int numeroFlota) {
        this.numeroFlota = numeroFlota;
    }
    
    
    
    public String[] combertirArreglo(Accion juego){
        String[] infoJuego = new String[7];
        
        if(juego.isRealizado()){
           infoJuego[0] = "si"; 
        }else{
            infoJuego[0] = "no"; 
        }
        infoJuego[1] = String.valueOf(juego.getNumeroFlota());
        infoJuego[2] = String.valueOf(juego.getPlanetasUsados()[0].getNombre());
        infoJuego[3] = String.valueOf(juego.getPlanetasUsados()[1].getNombre());
        infoJuego[4] = String.valueOf(juego.getNavesEnviadas());
        infoJuego[5] = String.valueOf(juego.getPlanetasUsados()[0].getPorcentajeMuertes());
        infoJuego[6] = String.valueOf(juego.getTurnoAllegar());
        return infoJuego;
    }
    
}
