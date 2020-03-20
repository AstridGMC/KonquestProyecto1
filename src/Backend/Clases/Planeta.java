
package Backend.Clases;

import java.awt.Color;
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
    int[] posicion;
    Color colorFondo;
    int i=0;

    public Planeta() {
    }
    
    public Planeta(boolean neutral) {
        this.neutral = neutral;
        if(!neutral){
            colorFondo= generarColor(i);
            i++;
        }
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
    
    
    private static final Color[] colores = {Color.GREEN,Color.BLUE,Color.RED, Color.GRAY, Color.CYAN, Color.YELLOW};
    
    public Color generarColor(int i){
        return colores[i];
    }
}
