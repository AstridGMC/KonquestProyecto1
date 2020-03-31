package Backend.Clases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Format;
import java.util.ArrayList;
import org.json.*;

public class EscritorJson {

    /**
     * Generando un objeto JSON
     *
     * @param miPlaneta
     * @return
     */
    public JSONObject crearObjetoPlanetas(Planeta miPlaneta) {
        JSONObject planeta = new JSONObject();
        planeta.put("nombre", miPlaneta.getNombre());
        planeta.put("naves", miPlaneta.getNaves());
        planeta.put("porcentajeMuertes", miPlaneta.getPorcentajeMuertes());
        planeta.put("produccion", miPlaneta.getProduccion());
        return planeta;
    }

    public JSONObject crearObjetoPlanetasNeutrales(PlanetaNeutral miPlaneta) {
        System.out.println("neutrales");
        JSONObject planetaNeutral = new JSONObject();
        planetaNeutral.put("nombre", miPlaneta.getNombre());
        planetaNeutral.put("naves", miPlaneta.getNaves());
        planetaNeutral.put("porcentajeMuertes", miPlaneta.getPorcentajeMuertes());
        planetaNeutral.put("produccion", miPlaneta.getProduccion());
        return planetaNeutral;
    }

    public JSONObject crearObjetoMapa(Mapa miMapa) {
        System.out.println("creando Mapa");
        PlanetaNeutral planetaNeutro = miMapa.getPlanetasNeutrales();
        JSONObject mapa = new JSONObject();
        JSONObject tamaño = new JSONObject();
        JSONObject NEUTRALES = new JSONObject();
        mapa.put("id", miMapa.getIdMapa());
        tamaño.put("filas", miMapa.getTamaño()[0]);
        tamaño.put("columnas", miMapa.getTamaño()[1]);
        mapa.put("tamaño", tamaño);
        mapa.put("alAzar", miMapa.isAlAzar());
        mapa.put("planetasNeutrales", miMapa.getNumeroPlanetasNeutrales());
        mapa.put("mapaCiego", miMapa.isMapaCiego());
        mapa.put("acumular", miMapa.isAcumular());
        NEUTRALES.put("mostrarNaves", planetaNeutro.isMostrarNaves());
        NEUTRALES.put("mostrarEstadisticas", planetaNeutro.isMostrarEstadisticas());
        NEUTRALES.put("produccion", planetaNeutro.getProduccion());
        System.out.println("creando Mapa2");
        mapa.put("NEUTRALES", NEUTRALES);
        mapa.put("finalizacion", miMapa.getFinalizacion());
        System.out.println("creando Mapa3");
        return mapa;
    }

    public JSONObject crearObjetoJugador(Jugador miJugador) {
        JSONObject jugador = new JSONObject();
        jugador.put("nombre", miJugador.getNombre());
        jugador.put("planetas", miJugador.combertirPLanetasArreglo());
        jugador.put("tipo", miJugador.getTipo());
        System.out.println("jugadores creado");
        System.out.print(jugador);
        return jugador;
    }

    public JSONObject generarObjetoJuego(JSONObject mapa, JSONObject[] planetas, JSONObject neutrales[], JSONObject jugadores[]) {
        JSONObject juego = new JSONObject();
        juego.put("MAPA", mapa);
        juego.put("PLANETAS", planetas);
        juego.put("PLANETAS_NEUTRALES", neutrales);
        juego.put("JUGADORES", jugadores);
        System.out.println("objeto juego creado");
        System.out.print(juego);
        return juego;
    }

    public JSONObject[] crearJugadores(ArrayList<Jugador> jugadores) {
        JSONObject[] jugadoresJson = new JSONObject[jugadores.size()];
        for (int i = 0; i < jugadores.size(); i++) {
            jugadoresJson[i] = crearObjetoJugador(jugadores.get(i));
            System.out.println(jugadores.get(i).getPlanetasConquistados().size());
        }
        return jugadoresJson;
    }

    public JSONObject[] crearPlanetas(ArrayList<Planeta> planetas) {
        JSONObject[] planetasJson = new JSONObject[planetas.size()];
        for (int i = 0; i < planetas.size(); i++) {
            planetasJson[i] = crearObjetoPlanetas(planetas.get(i));
        }
        return planetasJson;
    }

    public JSONObject[] crearPlanetasNeutrales(ArrayList<PlanetaNeutral> planetasNeutrales) {
        JSONObject[] planetasNeutralesJson = new JSONObject[planetasNeutrales.size()];
        for (int i = 0; i < planetasNeutrales.size(); i++) {
            planetasNeutralesJson[i] = crearObjetoPlanetasNeutrales(planetasNeutrales.get(i));
        }
        return planetasNeutralesJson;
    }

    public boolean creador(String direccion, String nombre, String texto) {
        System.out.println("creando txt  ..........."+  direccion + nombre);
        try {
            String ruta = direccion + "/" + nombre + ".json";
            String contenido = texto;
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("");
            bw.write(contenido);
            bw.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    
    public boolean modificador(String direccion, String texto) {
        System.out.println("modificando json  ...........");
        try {
            String ruta = direccion;
            String contenido = texto;
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("");
            bw.write(contenido);
            bw.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public String  leerArchivo(String path) {
        String texto="";
        try (FileReader entrada = new FileReader(path)) {
            int c = 0;
            while (c != -1) {
                c = entrada.read();
                char letra = (char) c;
                texto += letra;
            }
            return texto;
        } catch (IOException e) {
            System.out.println("No se ha encontrado el archivo");
            return "";
        }
    }
}
/*public static void main(String[] args) {
        JSONObject myJson = new JSONObject(
                "{ \"number_list\": [ 1.9, 2.9, 3.4, 3.5 ],"
                        + " \"extra_data\": {}, \"name\": \"Carlos\", \"last_name\": \"Carlos\","
                        + " \"bank_account_balance\": 20.2, \"age\": 21, \"is_developer\": true }");
        
        // Obtener llave especifica de un objeto JSON
         System.out.println(myJson);
        System.out.print(myJson.get("name")+"\n"); // Carlos
        System.out.print(myJson.get("age")); // 21
    }
    public static void main(String[] args) {
        JSONObject myObject = new JSONObject();

        // Cadenas de texto básicas
        myObject.put("name", "Carlos");
        myObject.put("last_name", "Carlos");
        
        // Valores primitivos
        myObject.put("age", new Integer(21));
        myObject.put("bank_account_balance", new Double(20.2));
        myObject.put("is_developer", new Boolean(true));
        
        // Matrices
        double[] myList = {1.9, 2.9, 3.4, 3.5};
        myObject.put("number_list", myList);
        
        // Objeto dentro de objeto
        JSONObject subdata = new JSONObject();
        subdata.put("edad", new Integer(33));
        subdata.put("tipo", "niño");
        myObject.put("extra_data", subdata);

        // Generar cadena de texto JSON
        System.out.print(myObject);
    }

}*/
