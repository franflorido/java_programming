package org.uma.mbd.mdAlturasV4.alturas;

public class Pais implements Comparable<Pais> {
    private String nombre;
    private String continente;
    private double altura;

    public Pais(String n, String c, double a) {
        nombre = n;
        continente = c;
        altura = a;
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
    public boolean equals(Object obj) {
        boolean res = obj instanceof Pais;
        Pais pais = res ? (Pais) obj : null;
        return res && nombre.equals(pais.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }

    @Override
    public String toString() {
        return "Pais(" + nombre + ", " + continente + ", " + altura + ")";
    }

    @Override
    public int compareTo(Pais pais) {
        int res = Double.compare(altura, pais.altura);
        if (res == 0) {
            res = nombre.compareTo(pais.nombre);
        }
        return res;
    }
}
