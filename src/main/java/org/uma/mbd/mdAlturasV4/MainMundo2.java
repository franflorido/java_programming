package org.uma.mbd.mdAlturasV4;

import org.uma.mbd.mdAlturasV4.alturas.Mundo;
import org.uma.mbd.mdAlturasV4.alturas.Pais;

import java.io.FileNotFoundException;
import java.util.*;

public class MainMundo2 {
    public static void main(String args[]) throws FileNotFoundException {
        Mundo mundo = new Mundo();
        mundo.leePaises("recursos/mdAlturas/alturas.txt");
        /*
        for (String continente : mundo.getContinentes()){
            System.out.println(continente);
        }

         */
        //System.out.println(mundo.todosMayores(1.65));
        //System.out.println(mundo.paisMayorAltura());
        /*for(Map.Entry<String,List<Pais>> par : mundo.paisesPorContinente().entrySet() ){
            System.out.println(par.getKey());
            for (Pais p :par.getValue()){
                System.out.println("\t" + p);
            }
        }

         */
        Map<String , Set<Double>> map = mundo.alturasPorContinente();
        for(String continente : map.keySet()){
            System.out.println(continente+ " "+ map.get(continente)) ;
        }
    }
}
