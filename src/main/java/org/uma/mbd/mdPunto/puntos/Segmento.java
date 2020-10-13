package org.uma.mbd.mdPunto.puntos;

public class Segmento {
    private Punto origen, extremo; // declaro dos variables de tipo de la clase Punto
    public Segmento(Punto or, Punto ex){
        origen = or;
        extremo = ex;
    }
    public void trasladar(double a, double b){
        origen.trasladar(a,b);
        extremo.trasladar(a,b);
    }
    public double longitud(){
        return origen.distancia(extremo);
    }
    public String toString(){
        return "S(" + origen + "," + extremo + ")";
    }
}
