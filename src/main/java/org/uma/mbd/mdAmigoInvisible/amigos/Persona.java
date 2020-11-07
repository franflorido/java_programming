package org.uma.mbd.mdAmigoInvisible.amigos;

public class Persona implements Comparable<Persona> {
    public String nombre;
    protected Persona amigo;

    public Persona(String nom){
        nombre = nom;
    }

    public void setAmigo(Persona am){
        amigo = am;
    }
    public String getNombre(){
        return nombre;
    }
    public Persona getAmigo(){
        return amigo;
    }
    @Override
    public boolean equals(Object obj){
        boolean res = obj instanceof Persona;
        Persona per = res ? (Persona)obj : null;
        return res && (nombre.equalsIgnoreCase(per.nombre));
    }
    @Override
    public int hashCode(){
        return nombre.toLowerCase().hashCode();
    }
    public int compareTo(Persona p) {
        int resultado = nombre.compareTo(p.getNombre());
        return resultado;
    }
    @Override
    public String toString(){
        return(amigo== null)?nombre +" --> " +"Sin amigo": nombre + " --> "+ amigo.getNombre() ;

    }
}
