package org.uma.mbd.mdMastermindL.masterMind;
import java.util.*;
public class MasterMind {
    public final int TAMANO_POR_DEFECTO= 4;
    private Random alea;
    public int longitud;
    public String secreto;

    public MasterMind(int tamano){
        if(tamano>10 || tamano <0){
            throw new MasterMindException("Número de cifras inválido "+ tamano);
        }
        longitud = tamano;
        alea = new Random();
        generaCombinacionSecreta(tamano);


    }
    public MasterMind(){
        longitud = TAMANO_POR_DEFECTO;
        alea = new Random();
        generaCombinacionSecreta(TAMANO_POR_DEFECTO);

    }
    public MasterMind(String secreto){
        longitud = secreto.length();
        this.secreto = secreto;
    }

    public int getLongitud(){return longitud;}

    private void generaCombinacionSecreta(int tamano){
        int numeros[] = new int[tamano];

        numeros[0] = alea.nextInt(10);
        for (int i = 1; i<tamano; i++){
            numeros[i] = alea.nextInt(10);
            for(int pos=0;pos<i;pos++) {
                if (numeros[i]==numeros[pos]){
                    i--;
                }
            }
        }
        StringBuilder secreto = new StringBuilder();
        for (int x=0;x<numeros.length;x++){
            secreto =secreto.append(numeros[x]);
        }
        this.secreto=secreto.toString();

    }




    private boolean validaCombinacion(String cifras){

        boolean resultado;
        try {                                           // verificación de que sean todos números
            Integer.parseInt(cifras);
        } catch (NumberFormatException excepcion) {
        }
        int valor = Integer.parseInt(cifras);
        int rep = 0;                                    // Mirar si se repiten las cifras
        for(int j = 0; j<cifras.length() ; j++) {
            int d = Integer.valueOf(String.valueOf(cifras.charAt(j)));
            for (int i = j+1; i < cifras.length(); i++) {
                if (Integer.valueOf(String.valueOf(cifras.charAt(i))) == d) {
                    rep++;
                }
            }
        }
        if (cifras.length()==longitud && rep == 0){ //condición de si la cifra es válida
            return true;
        }else{return false;}

    }

    public Movimiento intento(String cifras){
        if (!validaCombinacion(cifras)){
            throw new MasterMindException("Cifra " + cifras + " no Valida");
        }
        int colocadas = 0;
        int descolocadas = 0;
        char[] arrayDeCifras = cifras.toCharArray();
        char[] arrayDeSecreto = secreto.toCharArray();
        for (int i = 0; i < cifras.length(); i++) {
            if (arrayDeCifras[i] == arrayDeSecreto[i]) {
                colocadas++;
            }
            for(int j = 0; j<cifras.length();j++){
                if (arrayDeCifras[i] == arrayDeSecreto[j] && j!=i){
                    descolocadas++;
                }
            }
        }
        Movimiento mov = new Movimiento(cifras,colocadas,descolocadas);
        return mov;
    }


}
