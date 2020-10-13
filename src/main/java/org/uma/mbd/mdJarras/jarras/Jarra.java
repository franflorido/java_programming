package org.uma.mbd.mdJarras.jarras;


public class Jarra {
    private int capacidad, contenido; // creo los estados de los que va a depender la jarra
    //private Jarra ja;

    public Jarra(int a) {
        capacidad = a;
        contenido = 0;
    } // se crea un constructor al que se le especifica la capacidad de la jarra y el contenido

    public void llena() {contenido = capacidad;}
    public void vacia() {contenido = 0;}
    public int getContenido(){return contenido;}
    public int getCapacidad(){return capacidad;}

    public void llenaDesde(Jarra ja) {

        int cantidadMinima = Math.min(capacidad- contenido, ja.contenido);

        contenido += cantidadMinima;
        ja.contenido -= cantidadMinima;
    }
    public String toString(){ // visualización
        return "Jarra(" + "Cap = " + capacidad + "," + "Cont = " + contenido + ")";
    }

}
