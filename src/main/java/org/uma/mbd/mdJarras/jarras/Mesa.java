package org.uma.mbd.mdJarras.jarras;



public class Mesa {
    private Jarra jarraA , jarraB;
    public Mesa(Jarra ja1, Jarra ja2){
       jarraA = ja1;
       jarraB = ja2;
    }
    public void llenaA() {jarraA.llena();}
    public void llenaB() {jarraB.llena();}
    public void vaciaA() {jarraA.vacia();}
    public void vaciaB() {jarraB.vacia();}
    public void vuelcaASobreB(){jarraB.llenaDesde(jarraA);}
    public void vuelcaBSobreA(){jarraA.llenaDesde(jarraB);}
    public int getContenidoA(){return jarraA.getContenido();}
    public int getContenidoB(){return jarraB.getContenido();}
    public int getCapacidadA(){return jarraA.getCapacidad();}
    public int getCapacidadB(){return jarraB.getCapacidad();}
    public int getContenido(){ return jarraA.getContenido()+jarraB.getContenido();}



    public String toString(){
        return "Jarras(" + jarraA + "," + jarraB + ")";
    }


}
