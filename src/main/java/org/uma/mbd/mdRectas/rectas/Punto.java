package org.uma.mbd.mdRectas.rectas;

public class Punto {
    private double x, y; // declaro una variable local provada x e y

    public Punto() {
        x = y = 0;
    } // declaro una construccion de un objeto Punto con x e y = 0

    public Punto(double a, double b) {
        x = a;
        y = b;
    } // declaro una construccion de un objeto Punto con x e y proporcionadas a la entrada

    public double getX() {
        return x;
    }

    public void setX(double a) {
        x = a;
    }

    public double getY() {
        return y;
    }

    public void setY(double b) {
        y = b;
    }

    public void trasladar(double a, double b) { //declaro un método para trasladar un punto
        x += a;
        y += b;
    }

    public double distancia(Punto pto) { // metodo que devuleve la distancia entre dos puntos

        return Math.sqrt(Math.pow(x - pto.x, 2) + Math.pow(y - pto.y, 2));
    }

    public String toString() { // visualización

        return "P(" + x + "," + y + ")";
    }

}
