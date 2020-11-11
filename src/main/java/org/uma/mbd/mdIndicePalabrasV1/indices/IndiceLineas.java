package org.uma.mbd.mdIndicePalabrasV1.indices;

import java.io.PrintWriter;
import java.util.*;

public class IndiceLineas extends Indice{

    public Map<String, Set<Integer>> palabras;
    public void agregarLinea(String linea) {
        texto.add(linea);
    }
    public IndiceLineas() {
        super();
        palabras = new TreeMap<>();
    }

    @Override
    public void resolver(String delimitadores, Collection<String> noSignificativas) {
        Set<String> pNoSignificativas = new HashSet<>();

        for(String p : noSignificativas) {
            pNoSignificativas.add(p.toLowerCase());
        }

        int numLinea = 1;

        for(String linea : texto) {
            try (Scanner sc = new Scanner(linea)) {
                sc.useDelimiter(delimitadores);
                while(sc.hasNext()) {
                    String pal = sc.next().toLowerCase();
                    if(!pNoSignificativas.contains(pal)) {
                        Set<Integer> set = palabras.get(pal);
                        if(set == null) {
                            set = new TreeSet<>();
                            palabras.put(pal, set);
                        }
                        set.add(numLinea);
                    }
                }
            }
            numLinea++;
        }
    }

    @Override
    public void presentarIndice(PrintWriter pw) {
        for(String p : palabras.keySet()) {
            pw.print(p + "\t");
            for(int i : palabras.get(p)) {
                pw.print(i + ".");
            }
            pw.println();
        }
    }
}
