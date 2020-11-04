package org.uma.mbd.mdAlturas.alturas;

import org.uma.mbd.mdTestL.tests.Test;

public class Pais {
    private String nombre;
    private String continente;
    private double altura;

    public Pais(String n, String c, double alt){
        nombre = n;
        continente = c;
        altura = alt;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContinente() {
        return continente;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public boolean equals(Object obj){
        boolean res = obj instanceof Pais;
        Pais pais = res ? (Pais)obj : null;
        return res && (nombre.equalsIgnoreCase(pais.nombre));
    }
    @Override
    public int hashCode(){
        return nombre.toLowerCase().hashCode();
    }
    @Override
    public String toString(){
        return "Pais(" + nombre + ", " + continente + ", " + altura + ")";
    }
}
