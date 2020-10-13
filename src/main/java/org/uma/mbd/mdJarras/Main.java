package org.uma.mbd.mdJarras;

import org.uma.mbd.mdJarras.jarras.Jarra;
import org.uma.mbd.mdJarras.jarras.Mesa;

public class Main {
    public static void main(String[] args){
        Jarra jarra = new Jarra(5);
        Jarra jarra1 = new Jarra(7);
        Mesa mesa = new Mesa(jarra,jarra1);
        mesa.llenaA();
        mesa.vuelcaASobreB();
        mesa.llenaA();
        mesa.vuelcaASobreB();
        mesa.vaciaB();
        mesa.vuelcaASobreB();
        mesa.llenaA();
        mesa.vuelcaASobreB();
        System.out.println(mesa);





    }
}
