package org.uma.mbd.mdAmigoInvisible.amigos;
import org.uma.mbd.mdAlturas.alturas.Pais;
import org.uma.mbd.mdBusV1L.buses.Bus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;
public class Club {

    protected List<Persona> socios;

    public Club(){
        socios = new LinkedList<>();
    }
    public void lee(String fEntrada, String delim) throws FileNotFoundException{
        try (Scanner sc = new Scanner(new File(fEntrada))) {
            while(sc.hasNextLine()){
                String linea = sc.nextLine();
                leeSocios(linea,delim);
            }
        }
    }
    private void leeSocios(String linea, String delim){
        try(Scanner sc = new Scanner(linea)){
            while(sc.hasNext()) {
                sc.useDelimiter(delim);
                String nom = sc.next();
                creaSocioDesdeString(nom);

            }
        } catch(ArrayIndexOutOfBoundsException e){
            System.err.println(linea + "Error: no hay linea");
        }

    }
    protected void creaSocioDesdeString(String nombre){
        socios.add(new Persona(nombre));
    }
    protected void hacerAmigos(){
        List<Integer> posAmigos = new LinkedList<>();

        for(int i = 0; i < socios.size() ; i++ ){
            posAmigos.add(i);
        }

        while (hayCoincidencias(posAmigos)) {
            Collections.shuffle(posAmigos);
        }
        for(int i = 0; i < socios.size(); i++){
            socios.get(i).setAmigo(socios.get(posAmigos.get(i)));
        }
    }
    private static boolean hayCoincidencias(List<Integer> posAmigos){
        for(int i = 0; i<posAmigos.size();i++){
            if(posAmigos.get(i) == i){
                return true;
            }
        }
        return false;
    }

    public void presentaAmigos(String fSalida) throws FileNotFoundException{
        try(PrintWriter pwF = new PrintWriter(fSalida)){
            presentaAmigos(pwF);
        }
    }
    private void presentaAmigos(PrintWriter pw){

        Collections.sort(socios);
        for(Persona per: socios){
            pw.println(per);
        }
    }
}
