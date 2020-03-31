
package Backend.Clases;

/**
 *
 * @author astridmc
 */
public class ManejadorAtaque {
    Planeta origen;
    Planeta destino;
    int numeroNaves;
    int turno;
    
    public boolean verificadorAtaque(int numeroNaves){
        if(origen.getNaves()>= numeroNaves){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean atacar(int numeroNaves, Planeta origen, Planeta destino ){
        origen.setNaves(origen.getNaves()- numeroNaves);
        int navesRestar = (int) origen.getPorcentajeMuertes()* origen.getNaves() * destino.getNaves();
        destino.setNaves(destino.getNaves()- navesRestar);
        if(destino.getNaves()<=0){
            destino.setNaves(0);
            return true;
        }else{
            return false;
        }
    }
    
    public void darNaves(int numeroNaves, Planeta origen, Planeta destino ){
        origen.setNaves(origen.getNaves()- numeroNaves);
        int navesRestar = (int) origen.getPorcentajeMuertes()* origen.getNaves() * destino.getNaves();
        destino.setNaves(destino.getNaves()+ navesRestar);
    }
    
    public int determinarTurno(int i, int j, int a, int b){
        int turno  = (Integer)(((Math.abs(i-a))-(Math.abs(j-b)))/2);
        return turno;
    }
    
    public Planeta[] crearAPlanetas(Planeta origen, Planeta destino){
        Planeta[] planetas = new Planeta[2];
        planetas[0] = origen;
        planetas[1]=destino;
        return planetas;
    }
    
}
