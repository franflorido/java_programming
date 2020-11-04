package org.uma.mbd.mdBusV1L;

import org.uma.mbd.mdBusV1L.buses.Bus;
import org.uma.mbd.mdBusV1L.buses.Servicio;

import java.io.IOException;

public class PrubaMain {
    public static void main(String[] args) throws IOException {
        Servicio so = new Servicio("Malaga");
        so.leeBuses("recursos/mdBusesV1L/buses.txt");
        System.out.println(so.getBuses());
    }
}
