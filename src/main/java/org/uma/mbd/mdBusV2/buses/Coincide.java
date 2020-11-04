package org.uma.mbd.mdBusV2.buses;

public class Coincide implements Criterio {
    private Bus bus;

    public Coincide(Bus autobus){
        bus = autobus;
    }

    @Override
    public boolean esSeleccionable(Bus autobus) {
        if(bus.equals(autobus)){
            return true;
        }else{return false;}
    }
    @Override
    public String toString(){
        return "Autobus " + bus;
    }
}
