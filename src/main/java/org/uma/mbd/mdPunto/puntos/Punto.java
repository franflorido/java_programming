package org.uma.mbd.mdPunto.puntos;

public class Punto {
    private double x,y; // declaro una variable local provada x e y
    public Punto(){x=y=0;} // declaro una construccion de un objeto Punto con x e y = 0
    public Punto(double a, double b){x=a;y=b;} // declaro una construccion de un objeto Punto con x e y proporcionadas a la entrada
    public double abscisa(){return x;} // declaro un metodo que devuelve la parte x de un punto
    public double ordenada(){return y;} // declaro un metodo que devuelve la parte y de un punto
    public void abscisa(double a){x=a;} // declaro un metodo que asigna a a la parte x de un punto
    public void ordenada(double b){y=b;} // declaro un metodo que asigna b a la parte y de un punto
    public void trasladar(double a, double b){ //declaro un método para trasladar un punto
        x += a; y += b;
    }
    public double distancia(Punto pto){ // metodo que devuleve la distancia entre dos puntos
        return Math.sqrt(Math.pow(x-pto.x,2)+Math.pow(y-pto.y,2));
    }
    public String toString(){ // visualización
        return "P(" + x + "," + y + ")";
    }

}
