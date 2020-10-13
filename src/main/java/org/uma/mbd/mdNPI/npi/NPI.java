package org.uma.mbd.mdNPI.npi;

public class NPI {
    private double x,y,z,t; // declaración de las variables
    public NPI() { x=y=z=t=0;} //contructor por defecto
    public void entra(double valor){t=z;z=y;y=x;x=valor;}//entrada del primer numero por la calculadora
    public void suma(){x=x+y;y=z;z=t;}
    public void resta(){x=y-x;y=z;z=t;}
    public void multiplica(){x=x*y;y=z;z=t;}
    public void divide(){x=y/x;y=z;z=t;}
    public double getResultado(){return x;}
    public String toString(){ // visualización
        return "NPI(" + "x = " + x + "," + "y = " + y + "z = " + z + "t = " + t + ")";
    }

}
