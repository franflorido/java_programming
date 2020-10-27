package org.uma.mbd.mdMastermindL.masterMind;

import org.uma.mbd.mdLibreriaV4L.libreria.Libro;

import java.util.Objects;

public class Movimiento {
    private int colocadas, descolocadas;
    private String cifras;

    public Movimiento(String cifras, int colocadas, int descolocadas){
        this.cifras = cifras;
        this.colocadas = colocadas;
        this.descolocadas = descolocadas;

    }

    public int getColocadas(){return colocadas;}
    public int getDescolocadas(){return descolocadas;}
    public String getCifras(){return cifras;}


    @Override
    public boolean equals(Object o) {
        boolean res = o instanceof Movimiento;
        Movimiento mov = res? (Movimiento)o : null;
        return res && (cifras.equals(mov.cifras));
    }

    @Override
    public int hashCode() {
        return Objects.hash(cifras);
    }

    @Override
    public String toString(){
        return "[" + cifras + ", " + colocadas + ", " + descolocadas + "]";
    }


            /*
            @Override
            public boolean equals(Object o){
                boolean res = o instanceof Movimiento;
                Movimiento movimiento = res? (Movimiento)o:null;
                return res && movimiento.equals(movimiento.cifras);
            }
            @Override
            public int hashCode(){
                return cifras.hashCode();
            }
            */


}
