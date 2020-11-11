package org.uma.mbd.mdPartidos.partidos;
import org.uma.mbd.mdBusV2.buses.Bus;

import java.util.*;
public class DHont extends DHontSimple {
    double minPor;
    public DHont(double por){
        if(por <= 0  || por >= 15){
            throw new EleccionesException(por + "Error: porcentaje no permitido");
        }
        minPor = por;
    }
    private List<Partido> filtraPartidos(List<Partido> partidos){
        int totalVotos = 0;
        for (Partido p : partidos) {
            totalVotos += p.getVotos();
        }

        Iterator<Partido> it = partidos.iterator();
        while (it.hasNext()) {
            Partido p = it.next();
            if (p.getVotos() < (totalVotos * (minPor/100))) {
                it.remove();
            }
        }
        return partidos;
    }
    @Override
    public Map<Partido, Integer> ejecuta(List<Partido> par, int numEsc ){
        //Comparator<Partido> cbon = Comparator.<Partido>naturalOrder();

        return super.ejecuta(filtraPartidos(par),numEsc);
    }
}
