package org.uma.mbd.mdPartidos.partidos;
import java.util.*;

public class Token implements Comparable<Token>{
    private Partido partido;
    private double ratio;

    public Token(Partido par, double rat){
        partido = par;
        ratio = rat;
    }

    public double getRatio() {
        return ratio;
    }
    public Partido getPartido(){
        return partido;
    }
    @Override
    public int compareTo(Token t) {
        int resultado = Double.compare(t.ratio, ratio);
        if (resultado == 0) {
            resultado = partido.getNombre().compareTo(t.partido.getNombre());
        }
        return resultado;
    }
    public static Set<Token> seleccionaTokens(Set<Token> tks, int numEsc){
        Set<Token> tokens = new TreeSet<>();
        Iterator<Token> it = tks.iterator();
        for (int i = 0; i < numEsc; i++) {
            tokens.add(it.next());
        }
        return tokens;
    }
    public static Map<Partido, Integer> generaResultados(Set<Token> tks){
        Map<Partido,Integer> map = new TreeMap<>();
        for(Token t : tks){
            if(map.containsKey(t.getPartido())){
                map.put(t.getPartido(),map.get(t.getPartido())+1);
            }else{
                map.put(t.getPartido(),1);
            }
        }
            return map;
    }

}
