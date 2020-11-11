package org.uma.mbd.mdPartidos.partidos;

import java.util.*;


public class Proporcional implements CriterioSeleccion{

    private Set<Token> creaTokens(List<Partido> par, int numEsc){
        SortedSet<Token> TokensCreados = new TreeSet<>();
        int totales = 0;
        for(Partido p : par){
            totales += p.getVotos();
        }
        double VotosNecesarios = totales/numEsc;

        for (Partido pa : par) {
            for (int j = 0; j < numEsc - 1; j++) {

                TokensCreados.add(new Token(pa, pa.getVotos() - (VotosNecesarios * j)));
            }
        }
        return TokensCreados;


    }

    @Override
    public Map<Partido, Integer> ejecuta(List<Partido> partidos, int numEscaños) {
        Set<Token> TokenInicial = creaTokens(partidos,numEscaños);
        Set<Token> TokenSeleccion = Token.seleccionaTokens(TokenInicial, numEscaños);
        Map<Partido, Integer> mapProporcional = Token.generaResultados(TokenSeleccion);
        return mapProporcional;
    }
}
