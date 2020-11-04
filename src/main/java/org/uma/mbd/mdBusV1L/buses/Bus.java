package org.uma.mbd.mdBusV1L.buses;

import org.uma.mbd.mdMastermindL.masterMind.Movimiento;

import java.util.Objects;

public class Bus {
    private int codBus;
    private String matricula;
    private int codLinea;

    public Bus(int codigoBus, String matric){
        codBus = codigoBus;
        matricula = matric;
    }
    public void setCodLinea(int codigoLinea){
        codLinea = codigoLinea;
    }
    public int getCodBus(){
        return codBus;
    }
    public String getMatricula(){
        return matricula;
    }
    public int getCodLinea(){
        return codLinea;
    }
    @Override
    public boolean equals(Object o) {
        boolean res = o instanceof Bus;
        Bus bus = res? (Bus)o : null;
        return res && (matricula.equalsIgnoreCase(bus.matricula))&&(codBus == bus.codBus);
    }
    @Override
    public int hashCode(){
        return matricula.toLowerCase().hashCode()+Integer.hashCode(codBus);
    }
    @Override
    public String toString(){
        return "Bus(" + codBus + "," + matricula + "," + codLinea + ")";
    }


}
