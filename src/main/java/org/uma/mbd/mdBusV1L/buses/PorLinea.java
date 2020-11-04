package org.uma.mbd.mdBusV1L.buses;

public class PorLinea implements Criterio{
    private int codLinea;

    public PorLinea(int codigo){
        codLinea = codigo;
    }
    @Override
    public boolean esSeleccionable(Bus bus) {
        if (bus.getCodLinea() == codLinea) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public String toString(){
        return "Autobuses de la linea " + codLinea;
    }
}
