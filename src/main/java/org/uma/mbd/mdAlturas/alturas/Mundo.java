package org.uma.mbd.mdAlturas.alturas;
import org.uma.mbd.mdBusV1L.buses.Bus;

import java.io.File;
import java.io.IOException;
import java.util.*;
public class Mundo {
    private List<Pais> paises;

    public Mundo(){
        paises = new LinkedList<>();
    }
    public List<Pais> getPaises(){
        return paises;
    }
    public void leePaises(String file) throws IOException {
        try (Scanner sc = new Scanner(new File(file))) {
            leePaises(sc);
        }
    }

    private void leePaises(Scanner sc) {
        while (sc.hasNextLine()) {
            String datoPais = sc.nextLine();

            try {

                Pais p = stringtoPais(datoPais);
                paises.add(p);
            }catch(ArrayIndexOutOfBoundsException e){
                System.err.println(datoPais + "Error: no hay linea");
            }
        }

    }
    private Pais stringtoPais(String datoPais) {
        try (Scanner sc = new Scanner(datoPais)) {
            sc.useDelimiter("[,,]+");
            String nPais = sc.next();
            String nContinente = sc.next();
            String alt =sc.next();
            double altura = Double.parseDouble(alt);
            Pais p = new Pais(nPais, nContinente,altura);
            return p;
        }

    }
    public List<Pais> selecciona(Seleccion sel){
        List<Pais> seleccionado = new LinkedList<>();
        for(Pais p: paises){
            if(sel.test(p)){
                seleccionado.add(p);
            }
        }
        return seleccionado;
    }
}
