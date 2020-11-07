package org.uma.mbd.mdAmigoInvisible.amigos;

public class Pareja {
    private Persona uno;
    private Persona otro;

    public Pareja(Persona persona1, Persona persona2){
        uno = persona1;
        otro = persona2;
    }

    @Override
    public String toString(){
        return "(" + uno.getNombre() + "," + otro.getNombre() + ")";
    }


    @Override
    public boolean equals(Object obj){
        boolean res = obj instanceof Pareja;
        Pareja par = res ? (Pareja)obj : null;
        return res && ((uno.getNombre().equalsIgnoreCase(par.otro.getNombre())) && (otro.getNombre().equalsIgnoreCase(par.uno.getNombre()))
        || (uno.getNombre().equalsIgnoreCase(par.uno.getNombre()))&&(otro.getNombre().equalsIgnoreCase(par.otro.getNombre())));
    }
    @Override
    public int hashCode(){
        return uno.hashCode() + otro.hashCode();
    }


}
