package org.uma.mbd.mdCovid.covid;

import java.io.IOException;
import java.util.*;
import java.io.*;

public class Indicadores {
    private List<Region> indicadores;

    public Indicadores() {
        indicadores= new ArrayList<>();
    }

    public void leeIndicadores(String nomFichero) throws IOException {
        try (Scanner sc = new Scanner(new File(nomFichero))){
            leeIndicadores(sc);
        }
    }

    public void leeIndicadores(Scanner sc) {
        while (sc.hasNextLine()) {
            String datosComunidad = sc.nextLine();
            try {
                Region region = stringToCovid(datosComunidad);
                indicadores.add(region);
            } catch (InputMismatchException e) {
                System.err.println("Error: dato no numérico en " + datosComunidad);
            } catch (NoSuchElementException e) {
                System.err.println("Error: faltan datos en " + datosComunidad);
            }
        }
    }

    private Region stringToCovid(String datos) {
        try (Scanner sc = new Scanner(datos)) {
            sc.useDelimiter("\t");
            String comunidad = sc.next();
            double ia14 = sc.nextDouble();
            double ia7 = sc.nextDouble();
            double positividad = sc.nextDouble();
            double ocupCamas = sc.nextDouble();
            double ocupUCIs = sc.nextDouble();
            Region region = new Region(comunidad, ia14, ia7, positividad, ocupCamas, ocupUCIs);
            return region;
        }
    }

    public List<Region> getIndicadores() {
        return indicadores;
    }
}
