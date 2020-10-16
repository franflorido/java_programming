package org.uma.mbd.mdRectas.rectas;

public class Recta {
    private Vector direccion;
    private Punto pto;


    public Recta(Vector vec, Punto p) {
        this.direccion = vec;
        this.pto = p;
    }

    public Recta(Punto p1, Punto p2) {
        this.direccion = new Vector(p1, p2);
        this.pto = new Punto(p1.getX(), p1.getY());
    }

    public boolean paralelaA(Recta rec) {
        if (this.direccion.paraleloA(rec.direccion)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean pasaPor(Punto p1) {
        if (this.direccion.paraleloA(new Vector(p1,this.pto))) {
            return true;
        } else {
            return false;
        }
    }

    public Recta paralelaPor(Punto p1) {

        return new Recta(this.direccion, p1);
    }

    public Recta perpendicularPor(Punto p1) {

        return new Recta(this.direccion.Ortogonal(), p1);
    }

    public Punto interseccionCon(Recta rec) {
        double d = this.direccion.getComponenteX() * rec.direccion.getComponenteY() - rec.direccion.getComponenteX() * this.direccion.getComponenteY();
        double d1 = this.direccion.getComponenteX() * this.pto.getY() - this.direccion.getComponenteY() * this.pto.getX();
        double d2 = rec.direccion.getComponenteX() * rec.pto.getY() - rec.direccion.getComponenteY() * rec.pto.getX();
        return new Punto((d1 * rec.direccion.getComponenteX() - d2 * this.direccion.getComponenteX()) / d, (d1 * rec.direccion.getComponenteY() - d2 * this.direccion.getComponenteY()) / d);
    }

    public double distanciaDesde(Punto p1) {
        //se crea la recta perpendicular
        Recta rec1 = new Recta(this.direccion, pto); // se crea la recta principal
        Recta rec2 = rec1.perpendicularPor(p1);
        // intersecciónn entre la recta perpendicular y la principal
        return p1.distancia(rec1.interseccionCon(rec2));
    }

    @Override
    public String toString() { // visualización
        return "R(" + direccion + "," + pto + ")";
    }

}
