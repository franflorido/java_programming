package org.uma.mbd.mdAlturasV3;

import org.uma.mbd.mdAlturasV3.alturas.Mundo;

import java.io.FileNotFoundException;

public class MainMundo {
    public static void main(String args[]) throws FileNotFoundException {
        Mundo mundo = new Mundo();
        mundo.leePaises("recursos/mdAlturas/alturas.txt");
        System.out.println(mundo.extraeMenoresDeContinente("Europe",1.75));
        System.out.println(mundo.extraeMayoresDeContinente("Europe",1.75));
    }
}
