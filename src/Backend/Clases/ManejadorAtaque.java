
package Backend.Clases;

/**
 *
 * @author astridmc
 */
public class ManejadorAtaque {
    Planeta origen;
    Planeta destino;
    int numeroNaves;
    
    public boolean verificadorAtaque(int numeroNaves){
        if(origen.getNaves()>= numeroNaves){
            return true;
        }else{
            return false;
        }
    }
    
    public void atacar(int numeroNaves ){
        int navesRestar = (int) origen.getPorcentajeMuertes()* origen.getNaves() * destino.getNaves();
        destino.setNaves(destino.getNaves()- navesRestar);
    }
    
    public int determinarTurno(int i, int j, int a, int b){
        int turno  = (Integer)(((Math.abs(i-a))-(Math.abs(j-b)))/2);
        return turno;
    }
    
    
}
