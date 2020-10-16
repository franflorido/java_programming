package org.uma.mbd.mdUrna;
import java.lang.Integer;
import org.uma.mbd.mdUrna.urna.Urna;
import org.uma.mbd.mdUrna.urna.Urna.ColorBola;

public class Main {
    public static void main(String[] args) {

        int nBlancas = Integer.parseInt(args[0]);
        int  nNegras = Integer.parseInt(args[1]);

        Urna urna = new Urna(nBlancas, nNegras);
        System.out.println(urna);
        ColorBola color1,color2;

        while (urna.totalBolas() > 1) {
            color1 = urna.extraerBola();
            color2 = urna.extraerBola();
            System.out.println("la primera bola extraida ha sido= " + color1);
            System.out.println("la segunda bola extraida ha sido= " + color2);
            System.out.println(urna);

            if (color1.equals(color2)) {
                urna.ponerBlanca();
            } else {
                urna.ponerNegra();
            }
            System.out.println(urna);
        }
        System.out.println("La última bola sacada es: " + urna.extraerBola());
        System.out.println(urna);
    }
}
