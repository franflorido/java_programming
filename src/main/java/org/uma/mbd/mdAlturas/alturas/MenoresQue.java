package org.uma.mbd.mdAlturas.alturas;

public class MenoresQue implements Seleccion{
    private double alturaMinima;

    public MenoresQue(double alt){
        alturaMinima = alt;
    }
    @Override
    public boolean test(Pais pais) {
        if(pais.getAltura()<alturaMinima){
            return true;
        }else{return false;}
    }
}
