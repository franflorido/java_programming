package org.uma.mbd.mdBusV2.buses;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
    public SortedSet<Bus> filtra(Criterio cr,Comparator<Bus> comp){
        SortedSet<Bus> busesSeleccionados = new TreeSet<>(comp);
        for(Bus bus : buses){
            if( cr.esSeleccionable(bus)){
                busesSeleccionados.add(bus);
            }
        }
        return busesSeleccionados;
    }
    public void guarda(String file,Comparator<Bus> comp ,Criterio cr)throws IOException {
        PrintWriter pwF = new PrintWriter(file);
        guarda(pwF,comp, cr);

    }
    public void guarda(PrintWriter pw,Comparator<Bus> comp ,Criterio cr){
        Set<Bus> seleccionados = filtra(cr,comp);
        pw.println(cr);
        for(Bus bus: seleccionados){
                pw.println(bus);
        }

    }
}



