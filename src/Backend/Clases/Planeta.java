package Backend.Clases;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author astridmc
 */
public class Planeta {

    String nombre;
    int naves;
    int produccion;
    float porcentajeMuertes;
    boolean neutral;
    String imagenPath;
    Jugador dueño;
    int[] posicion;
    Color colorFondo;
    int i = 0;

    public Planeta() {
    }

    public Planeta(String nombre, int naves, int produccion, float porcentajeMuertes, boolean neutral) {
        this.nombre = nombre;
        this.naves = naves;
        this.produccion = produccion;
        this.porcentajeMuertes = porcentajeMuertes;
        this.neutral = neutral;

    }

    public Planeta(boolean neutral) {
        this.neutral = neutral;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int[] getPosicion() {
        return posicion;
    }

    public void setPosicion(int[] posicion) {
        this.posicion = posicion;
    }

    public int getNaves() {
        return naves;
    }

    public void setNaves(int naves) {
        this.naves = naves;
    }

    public int getProduccion() {
        return produccion;
    }

    public void setProduccion(int produccion) {
        this.produccion = produccion;
    }

    public float getPorcentajeMuertes() {
        return porcentajeMuertes;
    }

    public void setPorcentajeMuertes(float porcentajeMuertes) {
        this.porcentajeMuertes = porcentajeMuertes;
    }

    public String getImagenPath() {
        return imagenPath;
    }

    public void setImagenPath(String imagenPath) {
        this.imagenPath = imagenPath;
    }

    public boolean isNeutral() {
        return neutral;
    }

    public void setNeutral(boolean neutral) {
        this.neutral = neutral;
    }

    public Color getColorFondo() {
        return colorFondo;
    }

    public void setColorFondo(Color colorFondo) {
        this.colorFondo = colorFondo;
    }

    public Jugador getDueño() {
        return dueño;
    }

    public void setDueño(Jugador dueño) {
        this.dueño = dueño;
    }

    ArrayList<Integer> filasNR = new ArrayList();

    public int GenerarFilas(int maximo) {

        int aleatorio = (int) (Math.random() * maximo);
        if (filasNR.contains(aleatorio)) {
            return GenerarFilas(maximo);
        } else {
            return aleatorio;
        }
    }
    ArrayList<Integer> columnasNR = new ArrayList();

    public int GenerarColumnas(int maximo) {

        int aleatorio = (int) (Math.random() * maximo);
        if (columnasNR.contains(aleatorio)) {
            return GenerarColumnas(maximo);
        } else {
            return aleatorio;
        }
    }
    
    public Color generarColorAleatorio(){
        Random Rand = new Random();
        float r = Rand.nextFloat();
        float g = Rand.nextFloat();
        float b = Rand.nextFloat();
        Color randomColor = new Color(r, g, b);
        return randomColor;
    }

    public ArrayList<Planeta> AsignarEspacios(ArrayList<Planeta> planetas, int filas, int columnas) {
        for (int j = 0; j < planetas.size(); j++) {
            int posicionPlaneta[] = new int[2];
            posicionPlaneta[0] = GenerarFilas(filas);
            posicionPlaneta[1] = GenerarColumnas(columnas);

            planetas.get(j).setPosicion(posicionPlaneta);
        }
        return planetas;
    }

    public ArrayList<PlanetaNeutral> AsignarEspaciosNeutrales(ArrayList<PlanetaNeutral> planetas, int filas, int columnas) {
        for (int j = 0; j < planetas.size(); j++) {
            int posicionPlaneta[] = new int[2];
            posicionPlaneta[0] = GenerarFilas(filas);
            posicionPlaneta[1] = GenerarColumnas(columnas);

            planetas.get(j).setPosicion(posicionPlaneta);
        }
        return planetas;
    }

    public int[] AsignarEspacioPlanetas(int filas, int columnas) {

        int posicionPlaneta[] = new int[2];
        posicionPlaneta[0] = GenerarFilas(filas);
        posicionPlaneta[1] = GenerarColumnas(columnas);
        return posicionPlaneta;
    }

    public Planeta BuscarPlaneta(ArrayList<Planeta> planetas, String nombre) {
        Planeta planeta = null;
        for (int j = 0; j < planetas.size(); j++) {
            if (planetas.get(j).getNombre().equals(nombre)) {
                planeta = planetas.get(j);
                return planeta;
            }
        }
        return planeta;
    }
    
    

    public int BuscarIndicePlaneta(ArrayList<Planeta> planetas, String nombre) {
        Planeta planeta = null;
        int j = 0;
        for (j = 0; j < planetas.size(); j++) {
            if (planetas.get(j).getNombre().equals(nombre)) {
                planeta = planetas.get(j);
                return j;
            }
        }
        return j;
    }

    public String generarNombreAleatorio() {
        String[] elementos = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n ", "ñ", "o", "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "fF", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"};
        int tam = (int) (Math.random() * 2) + 1;
        int el = (int) (Math.random() * elementos.length);
        ArrayList conjunto = new ArrayList();
        String nombrep;
        nombrep = elementos[el];
        for (int i = 0; i < tam; i++) {

            int el2 = (int) (Math.random() * elementos.length);

            nombrep = nombrep + elementos[el2];
        }
        return nombrep;
    }

    public float generarPorcentajeMuertes() {
        Random rnd = new Random();
        return rnd.nextFloat();
    }

    public String elegirImagen() {
        Random r = new Random();
        int num = r.nextInt(12);
        return "planetas/planeta" + num + ".png";
    }
    
    //verificar si todos los planetas tienen sus caracteristicas completas ingresarColor al Jugador antes 
    public ArrayList<Planeta> VerificarPlanetas(ArrayList<Planeta> planetas, int filas, int columnas, int produccion){
        Tablero tab = new Tablero();
        
        for (int j = 0;  j< planetas.size(); j++) {
            Planeta planeta =planetas.get(j);
            if(planeta.getNombre()==null){
                planeta.setNombre(generarNombreAleatorio());
            }
            try {
                 System.out.println("planeta no Neutro"+ planeta.getNombre());
                planeta.setColorFondo(planeta.getDueño().getColorJugador());
            } catch (Exception e) {
                System.out.println("no se asigno nombre planeta Planeta verificar Planetas");
            }
           
            planeta.setImagenPath(elegirImagen());
            
            if(planeta.getPorcentajeMuertes()<=0){
                planeta.setPorcentajeMuertes(generarPorcentajeMuertes());
            }
            planeta.setPosicion(AsignarEspacioPlanetas(filas, columnas));
            if(planeta.getProduccion()<=0){
                planeta.setProduccion(produccion);
            }
        }
        return planetas;
    }
    
    public ArrayList<Planeta> GenerarPlanetasAlazar(ArrayList<Jugador> jugadores, int produccion, int filas, int planetas){
        ArrayList<Planeta> misPlanetas = new ArrayList();
        ArrayList<Planeta> planetasJugador = new ArrayList();
        for (int j = 0; j < jugadores.size(); j++) {
            for (int k = 0; k < jugadores.get(j).getPlanetasConquistados().size(); k++) {
                Planeta planeta = new Planeta( generarNombreAleatorio(),10, produccion, generarPorcentajeMuertes(), false);
                planeta.setDueño(jugadores.get(j));
                planeta.setNombre(jugadores.get(j).getPlanetasConquistados().get(k).getNombre());
                planeta.setPorcentajeMuertes(generarPorcentajeMuertes());
                planeta.setProduccion(produccion);
                planeta.setNaves(10);
                planeta.setColorFondo(jugadores.get(j).getColorJugador());
                planeta.setNeutral(false);
                planeta.setPosicion(AsignarEspacioPlanetas(filas, planetas));
                planeta.setImagenPath(elegirImagen());
                misPlanetas.add(planeta);
                planetasJugador.add(planeta);
            }
            jugadores.get(j).setPlanetasConquistados(planetasJugador);
        }
        return misPlanetas;
        
    }
    
    public ArrayList<Planeta> asignarPlanetasArreglos(ArrayList<Planeta> uno , ArrayList<Planeta> dos){
        for (int j = 0; j < uno.size(); j++) {
            dos.add(uno.get(i));
        }
        return dos;
    }
}
