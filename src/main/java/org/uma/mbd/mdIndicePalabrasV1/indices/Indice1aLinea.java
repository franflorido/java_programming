package org.uma.mbd.mdIndicePalabrasV1.indices;
import java.io.PrintWriter;
import java.util.*;
public class Indice1aLinea extends Indice{

    public Map<String, Integer> palabras;

    public Indice1aLinea() {
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
                        if(!palabras.containsKey(pal)) {
                            palabras.put(pal, numLinea);
                        }
                    }
                }
            }
            numLinea++;
        }
    }

    public void presentarIndice(PrintWriter pw) {
        for(String p : palabras.keySet()) {
            pw.println(p + "\t" + palabras.get(p));
        }
    }
}
