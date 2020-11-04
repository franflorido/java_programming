package org.uma.mbd.mdAlturas.alturas;

public class EnContinente implements Seleccion{
    private String texto;
    public EnContinente(String continente){
        texto = continente;
    }

    @Override
    public boolean test(Pais pais) {
        if(pais.getContinente().equals(texto)){
            return true;
        }else{return false;}
    }
}
