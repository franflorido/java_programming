package org.uma.mbd.mdCovid;

import org.uma.mbd.mdCovid.covid.Region;
import org.uma.mbd.mdCovid.covid.Indicadores;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Indicadores ind = new Indicadores();
            ind.leeIndicadores("recursos/mdCovid/indicadores.txt");
            List<Region> lista = ind.getIndicadores();
            /* implementar programación funcional en comparator
            Comparator<Region> ccuci = (r1,r2) -> Double.compare(r1.getOcupUCIs(),r2.getOcupUCIs());
            Comparator<Region> cnom = (r1,r2) -> r1.getRegion().compareTo(r2.getRegion());
            Comparator<Region> cia14 = (r1,r2) -> Double.compare(r1.getIa14(), r2.getIa14());
            //lista.sort(ccuci.thenComparing(cnom)); // ordena por camas uci y si es el mismo numero por nombre.
            //lista.sort(cia14);//ordena por ia14
            lista.sort(cia14.reversed());//ordena por ia14 de mayor a menos

             */
            /* Dar un paso más a la parte de arriba
            Comparator<Region> ccui = Comparator.comparingDouble(r -> r.getOcupUCIs());//hacer el comparador  ccui mas facil
            Comparator<Region> cnom = Comparator.comparing(r -> r.getRegion()); //hacer el comparador cnom mas facil
            Comparator<Region> cia14 = Comparator.comparingDouble(r -> r.getIa14()); //hacer el comparador cia14 mas facil
            lista.sort(ccui);

             */
            Comparator<Region> ccui = Comparator.comparingDouble(Region::getOcupUCIs);//hacer el comparador  ccui mas facil
            Comparator<Region> cnom = Comparator.comparing(Region::getRegion); //hacer el comparador cnom mas facil
            Comparator<Region> cia14 = Comparator.comparingDouble(Region::getIa14); //hacer el comparador cia14 mas facil
            lista.sort(ccui);

            for (Region region : lista) {
                System.out.println(region);
            }
        } catch (IOException e) {
            System.err.println("Error de E/S "+ e.getMessage());
        }
    }
}
