package org.uma.mbd.mdTren.tren;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tren {
    private int numvagones;
    private int capacidad;
    private List<Vagon> vagones;

    public Tren(int numVagones, int capacidad_vagones) {
        numvagones = numVagones;
        capacidad = capacidad_vagones;
        vagones = new ArrayList<>(numVagones);
        for (int i = 0; i<numVagones ; i++) {
            vagones.add(new Vagon(capacidad_vagones));
        }
    }

    public void carga(int ton){
        int restante = 0;
        int pos=0;
        while(pos<numvagones && ton != 0) {
            restante = vagones.get(pos).carga(ton);
            ton=restante;
            pos++;
        }

        while(ton>0){
            vagones.add(new Vagon(capacidad));
            restante = vagones.get(pos).carga(ton);
            ton = restante;
            pos++;
            numvagones++;
        }
    }

    public void gasta(int ton){
        int restante = 0;
        int pos = 0;
        while(pos<vagones.size() && ton != 0){
            restante = vagones.get(pos).descarga(ton);
            ton= restante;
            pos++;
        }
        if(restante>0){
            throw new RuntimeException("El tren no ha podido ser descargado");
        }
    }
    public void optimiza() {
        int i = 0;
        while (i < vagones.size()) {
            if (vagones.get(i).getCarga() == 0) {
                vagones.remove(i);
                numvagones--;
            } else {
                i++;
            }
        }
    }

    @Override
    public String toString(){

        return "Tren[" + vagones.toString() + "]" ;
    }
}
