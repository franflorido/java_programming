package org.uma.mbd.mdIndicePalabrasV1.indices;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;


public abstract class Indice {
    protected List<String> texto;

    public Indice() {
        texto = new ArrayList<String>();
    }

    public void agregarLinea(String linea) {
        texto.add(linea);
    }

    public void agregarDesdeFichero(String nombreFichero) throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File(nombreFichero))){
            agregarDesdeScanner(sc);
        }
    }
    public void agregarDesdeScanner(Scanner sc)throws FileNotFoundException {
        while(sc.hasNextLine()){
            agregarLinea(sc.nextLine());
        }
    }

    protected Set<String> leeNoSig (String nombreFichero) throws FileNotFoundException{
        Set<String> set;
        try (Scanner sc = new Scanner (new File(nombreFichero))){
            return leeNoSig (sc);
        }
    }

    protected Set<String> leeNoSig(Scanner sc) throws FileNotFoundException{
        Set<String> set = new HashSet<>();
        while(sc.hasNextLine()){
            String linea = sc.nextLine();
            try (Scanner scLinea = new Scanner (linea)){
                while(scLinea.hasNext()){
                    set.add (scLinea.next());
                }
            }
        }
        return set;
    }

    public void resolver (String delimitadores, String nombreFichero) throws FileNotFoundException{
        Set<String> set = leeNoSig(nombreFichero);
        resolver (delimitadores, set);
    }

    public abstract void resolver(String delimitadores, Collection<String> noSignificativas);

    public void presentarIndiceConsola(){
        PrintWriter pw = new PrintWriter(System.out, true);
        presentarIndice(pw);
    }
    public abstract void presentarIndice (PrintWriter pw);

    public void presentarIndice (String nombreFichero) throws FileNotFoundException{
        try (PrintWriter pw = new PrintWriter(nombreFichero)){
            presentarIndice(pw);
        }
    }
}
