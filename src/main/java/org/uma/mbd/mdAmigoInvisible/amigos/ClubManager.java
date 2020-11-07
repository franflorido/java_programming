package org.uma.mbd.mdAmigoInvisible.amigos;

import java.io.FileNotFoundException;

public class ClubManager {
    private String fEntrada;
    private String fSalida;
    private String delimitadores;
    private boolean consola;
    private Club club;

    public ClubManager(Club c){
        club = c;
    }

    public ClubManager setEntrada(String fEntrada, String delim){
        this.fEntrada = fEntrada;
        delimitadores = delim;
        return this;
    }
    public ClubManager setSalida(String salida){
        fSalida = salida;
        return this;
    }
    public ClubManager setConsola(boolean cons){
        consola = cons;
        return this;
    }
    private void verify(){
        if (fEntrada == null){
            throw new AmigoException("Error: fichero de entrada= "+ fEntrada);
        }
        if(fSalida == null && consola == false){
            throw new AmigoException("Error: fichero de salida o consola erroneos: " + fSalida + consola);
        }
    }
    public void build() throws FileNotFoundException {
        verify();
        club.lee(fEntrada,delimitadores);
        club.hacerAmigos();
        if(consola){
            club.presentaAmigos(fSalida);
        }else{
            System.out.println(club.socios.toString());
        }

    }
}
