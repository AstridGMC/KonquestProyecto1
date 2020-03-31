/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konquest;

import Backend.Clases.Planeta;
import Backend.FlexYCup.*;
import Frontend.Principal;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

/**
 *
 * @author astridmc
 */
public class Konquest {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Principal principal = new Principal();
        principal.setVisible(true);
        /*try {
            
            AnalizadorLexico lexico = new AnalizadorLexico(new BufferedReader(new StringReader(texto)));
            Parser parser1 = new Parser(lexico);
            parser1.parse();
        } catch (Exception ex) {
            System.out.println("error ..." + ex);
        }
        for (int i = 0; i < Parser.planetas.size(); i++) {
            Planeta planeta = Parser.planetas.get(i);
            System.out.println(planeta.getNombre());
        }
        for (int i = 0; i < Parser.planetasNeutrales.size(); i++) {
            Planeta planeta = Parser.planetas.get(i);
            System.out.println(planeta.getNombre());
        }
        System.out.println("\n idMapa"+Parser.mapa.getIdMapa());
        System.out.println("mapaCiego   "+Parser.mapa.isMapaCiego());
        System.out.println("Alazar   "+Parser.mapa.isAlAzar());
        System.out.println(" acumular" + Parser.mapa.isAcumular());
        System.out.println("Finalizacion   "+Parser.mapa.getFinalizacion());
        System.out.println("Estadisticas   "+Parser.mapa.getPlanetasNeutrales().isMostrarEstadisticas()+ " mostrar Naves"+ Parser.mapa.getPlanetasNeutrales().isMostrarNaves()+"produccion "+Parser.mapa.getPlanetasNeutrales().getProduccion());
        System.out.println("fila   " + Parser.mapa.getTamaño()[0] + " columna "+Parser.mapa.getTamaño()[1]);
        System.out.println("num Planeras" + Parser.mapa.getNumeroPlanetasNeutrales());
        */
    }

    public static String AbrirTXT(File archivo) {
        FileInputStream entrada;
        String contenido = "";
        try {
            entrada = new FileInputStream(archivo);
            int ascci;
            while ((ascci = entrada.read()) != -1) {
                char caracter = (char) ascci;
                contenido += caracter;
            }

        } catch (Exception e) {
        }
        return contenido;
    }

    
}
