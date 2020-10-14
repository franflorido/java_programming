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

    public Vector(Punto interior, Punto exterior) { // constructor de un vector dados dos puntos
        this.origen = interior;
        this.extremo = exterior;
    }

    public double getComponenteX() {
        return extremo.getX();
    }

    public double getComponenteY() {
        return extremo.getY();
    }

    public Vector Ortogonal() {
        return new Vector(-1 * extremo.getY(), extremo.getX());
    }

    public boolean paraleloA(Vector vec) {
        if (extremo.getX() * vec.getComponenteY() == extremo.getY() * vec.getComponenteX()) {
            return true;
        } else {
            return false;
        }
    }

    public Punto extremoDesde(Punto org) {
        return new Punto(org.getX() + extremo.getX(), org.getY() + extremo.getY());
    }

    @Override
    public String toString() { // visualización
        return "V(" + extremo.getX() + "," + extremo.getY() + ")";
    }


}
