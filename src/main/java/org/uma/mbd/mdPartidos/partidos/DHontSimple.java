package org.uma.mbd.mdPartidos.partidos;


import java.util.*;


public class DHontSimple implements CriterioSeleccion{

    private Set<Token> creaTokens(List<Partido> par, int numEsc){
        SortedSet<Token> set = new TreeSet<>();
        for(Partido p : par){
            for(int n=1; n<=numEsc; n++){
                Token t = new Token(p, p.getVotos()/n);
                set.add(t);
            }
        }
        return set;
    }
    @Override
    public Map<Partido, Integer> ejecuta(List<Partido> partidos, int numEscaños) {
        Set<Token> TokenInicial = creaTokens(partidos,numEscaños);
        Set<Token> TokenSeleccion = Token.seleccionaTokens(TokenInicial, numEscaños);
        Map<Partido, Integer> map = Token.generaResultados(TokenSeleccion);
        return map;
    }
}
