package org.uma.mbd.mdUrna.urna;

import org.w3c.dom.ranges.RangeException;

import java.awt.*;
import java.util.*;

public class Urna {
    static public enum ColorBola{Blanca,Negra};
    private int nBlancas, nNegras;
    private static Random alea = new Random(); // CReo una variable aleatoria comun a toda la clase

    public Urna(int nBlancas,int nNegras){
        if(nBlancas<0 || nNegras<0){
            throw new IllegalArgumentException("numero de bolas erroneo");
        }
        this.nBlancas = nBlancas;
        this.nNegras = nNegras;
    }

    public int totalBolas(){
        return nBlancas+nNegras;
    }

    public void ponerBlanca(){
        nBlancas++;
    }

    public void ponerNegra(){
        nNegras++;
    }

    public ColorBola extraerBola(){
        if (totalBolas()==0){
            throw new NoSuchElementException("No hay bolas para sacar");
        }
        ColorBola bolaSacada = null; //inicializo el color de la bola sacada
        int i = 1+ alea.nextInt(totalBolas());
        if( i<=nBlancas ){
            bolaSacada = ColorBola.Blanca;
            nBlancas--;
        } else{
            bolaSacada = ColorBola.Negra;
            nNegras--;
        }
        return bolaSacada;
    }

    @Override
    public String toString(){
        return "Urna("  + nBlancas + ","  + nNegras + ")";
    }

}
/*
Imagina que la urna tiene 6 bolas negras y 2 blancas

 */