
package org.uma.mbd.mdPunto;

import org.uma.mbd.mdPunto.puntos.Punto;
import org.uma.mbd.mdPunto.puntos.Segmento;

public class Main {
    public static void main(String[] args){
        Punto pto = new Punto(3,5); // declaro un objeto punto con metodos de la clase Punto
        System.out.println(pto);
        pto.trasladar(2,-3); // llamo al metodo trasladar para trasladar el pto un numero (2,-3) con respecto a su posición
        System.out.println(pto);

        Punto pto2 = new Punto(-1,2); //creo un objeto Punto de la clase Punto
        Segmento seg = new Segmento(pto,pto2); // creo un segmento que es un objeto de la clase Segmento
        System.out.println(seg);
        System.out.println(seg.longitud());





    }
}
