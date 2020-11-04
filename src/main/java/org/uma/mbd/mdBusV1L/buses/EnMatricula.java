package org.uma.mbd.mdBusV1L.buses;

public class EnMatricula implements Criterio{
    private String dato;
    public EnMatricula(String cadena){
        dato = cadena;
    }
    @Override
    public boolean esSeleccionable(Bus bus) {
        if(bus.getMatricula().contains(dato)){
            return true;
        }else{return false;}

    }
    @Override
    public String toString(){
        return "Autobuses cuya matricula contine " + dato;
    }
}
