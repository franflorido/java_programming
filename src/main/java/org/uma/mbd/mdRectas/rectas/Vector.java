package org.uma.mbd.mdRectas.rectas;

public class Vector {
    private Punto extremo;
    private Punto origen;

    public Vector(double a, double b) {
        this.origen = new Punto(0, 0);
        this.extremo = new Punto(a, b);
    } //constructor dados los puntos extremos

    public Vector(Punto extremo) {
        this.origen = new Punto(0, 0);
        this.extremo = extremo;
    }//contructor dado un punto extremo

    public Vector(Punto origen, Punto exterior) { // constructor de un vector dados dos puntos
        origen = new Punto(origen.getX(), origen.getY());
        exterior = new Punto(exterior.getX(), exterior.getY());
        extremo = new Punto(exterior.getX() - origen.getX(), exterior.getY() - origen.getY());

    }

    public double getComponenteX() {
        return extremo.getX();
    }

    public double getComponenteY() {
        return extremo.getY();
    }

    public Vector Ortogonal() {
        Punto punto_O = new Punto(-1 * getComponenteY(),getComponenteX());
        return new Vector(punto_O);
    }

    public boolean paraleloA(Vector vec) {
        if (getComponenteX() * vec.getComponenteY() == getComponenteY() * vec.getComponenteX()) {
            return true;
        } else {
            return false;
        }
    }

    public Punto extremoDesde(Punto org) {
        return new Punto(org.getX() + getComponenteX(), org.getY() + getComponenteY());
    }

    @Override
    public String toString() { // visualización
        return "V(" + getComponenteX() + "," + getComponenteY() + ")";
    }


}
