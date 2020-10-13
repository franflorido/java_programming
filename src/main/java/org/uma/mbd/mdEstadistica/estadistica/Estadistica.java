package org.uma.mbd.mdEstadistica.estadistica;

public class Estadistica {
    private int numElementos;
    private double sumaX;
    private double sumaX2;

    public void agrega(double d){
        this.agrega(d,1);
    }
    public void agrega(double d, int nVeces) {
        numElementos+=nVeces;
        sumaX+=d*nVeces;
        sumaX2+=d*d*nVeces;
    }
    public double media(){
        return sumaX/numElementos;
    }
    public double varianza(){
        return sumaX2/numElementos-Math.pow(media(),2);
    }
    public double desviaciontipica(){
        return Math.sqrt(varianza());
    }
    public String toString(){
        return "E(" + numElementos + ", " + sumaX + ", " + sumaX2 + ")";
    }
}
