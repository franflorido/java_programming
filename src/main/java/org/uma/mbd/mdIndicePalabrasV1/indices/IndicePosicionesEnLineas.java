package org.uma.mbd.mdIndicePalabrasV1.indices;
import java.io.PrintWriter;
import java.util.*;
public class IndicePosicionesEnLineas extends Indice{
    public Map<String, Map<Integer, Set<Integer>>> palabras;

    public IndicePosicionesEnLineas() {
        super();
        palabras = new TreeMap<>();
    }
    public void agregarLinea(String linea) {
        texto.add(linea);
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
                int numPos = 1;
                while(sc.hasNext()) {
                    String pal = sc.next().toLowerCase();
                    if(!pNoSignificativas.contains(pal)) {
                        Map<Integer, Set<Integer>> mapa = palabras.get(pal);
                        if(mapa == null) {
                            mapa = new TreeMap<>();
                            palabras.put(pal, mapa);
                        }
                        Set<Integer> set = mapa.get(numLinea);
                        if(set == null) {
                            set = new TreeSet<>();
                            mapa.put(numLinea, set);
                        }
                        set.add(numPos);
                    }
                    numPos++;
                }
            }
            numLinea++;
        }
    }

    @Override
    public void presentarIndice(PrintWriter pw) {
        for(String p : palabras.keySet()) {
            pw.println(p);
            for(int i : palabras.get(p).keySet()) {
                pw.print("\t" + i + "\t");
                for(int j : palabras.get(p).get(i)) {
                    pw.print(p + ".");
                }
                pw.println();
            }
        }
    }
}
