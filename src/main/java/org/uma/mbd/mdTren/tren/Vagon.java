package org.uma.mbd.mdTren.tren;

public class Vagon {
    private int toneladas;
    private int carga;

    public Vagon(int ton){
        toneladas=ton;
        carga = 0;
    }

    public int carga (int ton){

        int cantidadllenado = toneladas-carga;
        if (ton>cantidadllenado){
            carga = toneladas;
            return (ton-cantidadllenado);
        }else{
            carga = ton;
            return 0;}
    }

    public int descarga(int ton){

        if(ton > carga){

            ton = ton - carga;
            carga = 0;
            return (ton);

        }else {
            carga = carga - ton;
            return 0;
        }
    }

    public int getCarga(){return carga;}
    public Integer getCapacidad(){return (toneladas-carga);}

    @Override
    public String toString(){
        return "V(" + carga + "/" + toneladas + ")";
    }


}
