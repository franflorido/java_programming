package org.uma.mbd.mdPartidos.partidos;

import org.uma.mbd.mdAmigoInvisible.amigos.Persona;

public class Partido implements Comparable<Partido>{
    private String nombrePartido;
    private int numVotos;

    public Partido(String nombre,int votos){
        nombrePartido = nombre;
        numVotos = votos;
    }
    public String getNombre(){
        return nombrePartido;
    }
    public int getVotos(){
        return numVotos;
    }
    @Override
    public boolean equals(Object obj){
        boolean res = obj instanceof Partido;
        Partido par = res ? (Partido)obj : null;
        return res && (nombrePartido.equalsIgnoreCase(par.nombrePartido));
    }
    @Override
    public int hashCode(){
        return nombrePartido.toLowerCase().hashCode();
    }
    @Override
    public String toString(){
        return nombrePartido + " : " + numVotos;
    }

    @Override
    public int compareTo(Partido p) {
        int resultado = Integer.compare(p.numVotos, numVotos);
        if (resultado == 0) {
            resultado = nombrePartido.compareTo(p.nombrePartido);
        }
        return resultado;
    }
}
