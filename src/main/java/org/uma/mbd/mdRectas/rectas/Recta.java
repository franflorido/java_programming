package org.uma.mbd.mdRectas.rectas;

public class Recta {
    private Vector direccion;
    private Punto pto;
    private double d,d1,d2;

    public Recta(Vector vec,Punto p){
        this.direccion=vec;
        this.pto=p;
    }

    public Recta(Punto p1, Punto p2){
        this.direccion= new Vector(p1,p2);
        this.pto = new Punto(p1.getX(),p1.getY());
    }

    public boolean paralelaA(Recta rec){
        if(direccion.paraleloA(rec.direccion)){
            return true;
        }else{return false;}
    }
    public boolean pasaPor(Punto p1){
        if(direccion.paraleloA(new Vector(p1, pto))){
            return true;
        }else{return false;}
    }
    public Recta paralelaPor(Punto p1){

        return new Recta(direccion,p1);
    }
    public Recta perpendicularPor(Punto p1){

        return new Recta(direccion.Ortogonal(),p1);
    }
    public Punto interseccionCon(Recta rec) {
        d = direccion.getComponenteX() * rec.direccion.getComponenteY() - rec.direccion.getComponenteX() * direccion.getComponenteY();
        d1 = direccion.getComponenteX() * pto.getY() - direccion.getComponenteY() * pto.getX();
        d1 = rec.direccion.getComponenteX() * rec.pto.getY() - rec.direccion.getComponenteY() * pto.getX();
        return new Punto((d1 * rec.direccion.getComponenteX() - d2 * direccion.getComponenteX()) / d, (d1 * rec.direccion.getComponenteY() - d2 * direccion.getComponenteY()) / d);
    }
    public double distanciaDesde(Punto p1){
        Recta rec1 = new Recta(direccion.Ortogonal(),p1);//se crea la recta perpendicular
        Recta rec2 = new Recta(direccion,pto); // se crea la recta principal
        // intersecciónn entre la recta perpendicular y la principal
        return pto.distancia(rec2.interseccionCon(rec1));
    }
    public String toString() { // visualización
        return "R(" + direccion + "," + pto + ")";
    }

}
