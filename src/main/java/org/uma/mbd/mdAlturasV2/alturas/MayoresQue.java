package org.uma.mbd.mdAlturasV2.alturas;

public class MayoresQue implements Seleccion {
    private double altura;

    public MayoresQue(double alt){
        altura = alt;
    }
    @Override
    public boolean test(Pais pais) {
        if(pais.getAltura()>altura){
            return true;
        }else{return false;}

    }
}
