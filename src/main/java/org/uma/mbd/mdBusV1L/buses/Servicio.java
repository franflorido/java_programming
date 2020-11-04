package org.uma.mbd.mdBusV1L.buses;

import org.uma.mbd.mdTestL.tests.Test;

import java.io.*;
import java.util.*;

public class Servicio {
    private String ciudad;
    private List<Bus> buses;

    public Servicio(String ciud) {
        ciudad = ciud;
        buses = new LinkedList<>();
    }

    public String getCiudad() {
        return ciudad;
    }

    public List<Bus> getBuses() {
        return buses;
    }

    public void leeBuses(String file) throws IOException {
        try (Scanner sc = new Scanner(new File(file))) {
            leeBuses(sc);
        }
    }

    public void leeBuses(Scanner sc) {
        while (sc.hasNextLine()) {
            String datoBus = sc.nextLine();

            try {
                Bus bus = stringtoBus(datoBus);
                buses.add(bus);
            }

            catch (InputMismatchException e) {
                System.err.println(datoBus + "Error: dato no numerico");
            } catch (NoSuchElementException e) {
                System.err.println(datoBus + "Error: no hay dato");
            }
        }

    }

    private Bus stringtoBus(String datoBus) {
        try (Scanner sc = new Scanner(datoBus)) {
            sc.useDelimiter("[,,]+");
            int codBus = sc.nextInt();
            String matricula = sc.next();
            int ncodLinea = sc.nextInt();
            Bus bus = new Bus(codBus, matricula);
            bus.setCodLinea(ncodLinea);
            return bus;
        }

    }
    public List<Bus> filtra(Criterio cr){
        List<Bus> busesSeleccionados = new LinkedList<>();
        for(Bus bus : buses){
            if( cr.esSeleccionable(bus)){
                busesSeleccionados.add(bus);
            }
        }
        return busesSeleccionados;
    }
    public void guarda(String file, Criterio cr)throws IOException {
        PrintWriter pwF = new PrintWriter(file);
        guarda(pwF, cr);

    }
    public void guarda(PrintWriter pw,Criterio cr){
        List<Bus> seleccionados = filtra(cr);
        pw.println(cr);
        for(Bus bus: seleccionados){
                pw.println(bus);
        }

    }
}



