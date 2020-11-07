package org.uma.mbd.mdAlturasV2;

import org.uma.mbd.mdAlturasV2.alturas.EnContinente;
import org.uma.mbd.mdAlturasV2.alturas.MenoresQue;
import org.uma.mbd.mdAlturasV2.alturas.Mundo;
import org.uma.mbd.mdAlturasV2.alturas.Pais;
import org.uma.mbd.mdBusV2.buses.Bus;
import org.uma.mbd.mdCovid.covid.Region;

import java.io.IOException;
import java.util.Comparator;

public class MainMundo {

    /*  crear los comparadores como en covid.
        crear un metodo al que yo le de el comparador y me devuelva los paises ordenados.
     */
    public static void main(String args[]) throws IOException {
        Mundo paises = new Mundo();

        paises.leePaises("recursos/mdAlturas/alturas.txt");
        Comparator<Pais> apartadoa = Comparator.comparingDouble(Pais::getAltura); //compara por altura de menor a mayor
        Comparator<Pais> apartadob = Comparator.comparing(Pais::getNombre); // compara por paises alfabeticamente
        Comparator<Pais> apartadoc = Comparator.comparing(Pais::getContinente).thenComparing(Pais::getNombre); // compara por continente y dentro del continente alfabeticamente
        Comparator<Pais> apartadod = Comparator.comparing(Pais::getContinente).thenComparing(apartadob.reversed());// compara por continente y dentro del continente alfabeticamente en inverso

        Comparator<Pais> natural = Comparator.<Pais>naturalOrder(); // crea un comparador de orden natural
        Comparator<Pais> apartadof = Comparator.comparing(Pais::getContinente).thenComparing(natural);// compara por continente y si coincide por orden natural

        for (Pais p : paises.compara(apartadof)) {
            System.out.println(p);
        }
        /*
        for (Pais pais : paises.selecciona(new MenoresQue(1.70))) {
            System.out.println(pais);
        }
        System.out.println();
        for (Pais pais : paises.selecciona(new EnContinente("Europe"))) {
            System.out.println(pais);
        }



         */

    }
}
