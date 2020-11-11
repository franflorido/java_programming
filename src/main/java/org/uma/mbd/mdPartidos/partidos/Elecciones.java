package org.uma.mbd.mdPartidos.partidos;
import org.uma.mbd.mdBusV1L.buses.Bus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Elecciones {
    private List<Partido> partidos = new LinkedList();

    static private Partido stringToPartido(String dato){
        try(Scanner sc = new Scanner(dato)){

            sc.useDelimiter("[,]+");
            String Nombre =sc.next();
            int numVotos = sc.nextInt();
            return new Partido(Nombre,numVotos);

        } catch (InputMismatchException e){
            throw new EleccionesException(dato + "Error: Votos no numéricos en ");
        } catch (NoSuchElementException e){
            throw new EleccionesException(dato + "Error: Faltan datos en ");
        }
    }

    public void leeDatos(String[] datos){
        for(String dato:datos){
            partidos.add(stringToPartido(dato));
        }
    }

    public void leeDatos(String nombreFichero) throws IOException{
        try (Scanner sc = new Scanner(new File(nombreFichero))) {
            leeDatos(sc);
        }
    }

    public void leeDatos(Scanner sc) {
        while (sc.hasNextLine()) {
            String dato = sc.nextLine();

            try {
                Partido par = stringToPartido(dato);
                partidos.add(par);
            }catch (InputMismatchException e) {
                throw new EleccionesException(dato + "Error: dato no numerico");
            } catch (NoSuchElementException e) {
                throw new EleccionesException(dato + "Error: Faltan datos");
            }
        }
    }
    public Map<Partido,Integer> generaResultados(CriterioSeleccion cs, int numEsc){
        Map<Partido, Integer> map = cs.ejecuta(partidos,numEsc);
        for (Partido p : partidos) {
            int escanosPartido = map.getOrDefault(p, 0);
            map.put(p, escanosPartido);
        }
        return map;
    }

    public void presentaResultados(String nombreFichero, Map<Partido,Integer> map) throws FileNotFoundException{
        try(PrintWriter pwF = new PrintWriter(nombreFichero)){
            presentaResultados(pwF,map);
        }
    }
    public void presentaResultados(PrintWriter pw,Map<Partido,Integer> map){
        for (Partido p : partidos) {
            if (map.get(p) == 0) {
                pw.println(p + ", " + "Sin representación");
            } else {
                pw.println(p + ", " + map.get(p));
            }
        }
    }
}
