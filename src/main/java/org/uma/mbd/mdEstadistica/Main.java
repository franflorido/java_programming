package org.uma.mbd.mdEstadistica;

import org.uma.mbd.mdEstadistica.estadistica.Estadistica;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Estadistica es = new Estadistica(); // como no se ha construido ninguno existe un contrtuctor que inicializa a 0 las variables
        Random rnd = new Random();
        for (int i=0; i<1000000;i++){
            es.agrega(rnd.nextGaussian());
        }
        System.out.println("Media "+ es.media());
        System.out.println("Desviación típica "+ es.desviaciontipica());
    }
}
