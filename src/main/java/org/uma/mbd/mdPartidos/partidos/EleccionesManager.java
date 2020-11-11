package org.uma.mbd.mdPartidos.partidos;

import org.uma.mbd.mdAmigoInvisible.amigos.AmigoException;
import org.uma.mbd.mdBusV1L.buses.Criterio;

import java.io.IOException;
import java.util.Map;

public class EleccionesManager {
    private String fEntrada;
    private String fSalida;
    private boolean consola;
    private String[] datos;
    private CriterioSeleccion cs;
    private int numEsc;
    private Elecciones elecciones;

    public EleccionesManager(Elecciones elecciones){
        this.elecciones = elecciones;
    }
    public EleccionesManager setDatos(String[] datos ){
        this.datos = datos;
        return this;
    }
    public EleccionesManager setCriterioSeleccion(CriterioSeleccion cr){
        cs = cr;
        return this;
    }
    public EleccionesManager setNumEsc(int numEsc){
        this.numEsc = numEsc;
        return this;
    }
    public EleccionesManager setEntrada(String fEntrada){
        this.fEntrada = fEntrada;
        return this ;
    }
    public EleccionesManager setSalida(String fSalida){
        this.fSalida = fSalida;
        return this ;
    }
    public EleccionesManager setConsola(boolean consola){
        this.consola = consola;
        return this;
    }
    private void verify(){
        if (fEntrada == null && datos == null){
            throw new EleccionesException("Error: fichero de entrada o array de datos inexistentes= "+ fEntrada + datos);
        }
        if(cs == null){
            throw new EleccionesException("Error: Criterio de selección inválido: "+ cs);
        }
        if(numEsc <= 0){
            throw new EleccionesException("Error: El número de escaños debe ser positivo: "+ numEsc);
        }
        if(fSalida == null && !consola){
            throw new EleccionesException("Error: fichero de salida o consola erroneos: " + fSalida + consola);
        }
    }
    public void build() throws IOException {

        verify();
        if(datos == null) {
            elecciones.leeDatos(fEntrada);
        }else{
            elecciones.leeDatos(datos);
        }
        Map<Partido,Integer> map = elecciones.generaResultados(cs,numEsc);

        if(consola) {
            elecciones.presentaResultados(fSalida, map);
        }else{
            for (Partido p : map.keySet()) {
                if (map.get(p) == 0) {
                    System.out.println(p + ", " + "Sin representación");
                } else {
                    System.out.println(p + ", " + map.get(p));
                }
            }
        }
    }

}
