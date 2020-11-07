package org.uma.mbd.mdAmigoInvisible.amigos;
import java.util.*;
public class ClubParejas extends Club{

    private Set<Pareja> parejas;
    public ClubParejas(){
        parejas = new HashSet<>();
    }

    @Override
    protected void creaSocioDesdeString(String nombre){

        String b[];
        b = nombre.split("-");
        Persona par1 = new Persona(b[0]);

        socios.add(par1);
        if(b.length == 2){
            Persona par2 = new Persona (b[1]);
            socios.add(par2);
            Pareja p = new Pareja(par1,par2);
            parejas.add(p);
        }
    }

    @Override
    protected void hacerAmigos(){
        super.hacerAmigos();
        Iterator<Persona> per = socios.iterator();
        while (per.hasNext()) {
            Persona pers = per.next();
            Pareja par = new Pareja(pers,pers.amigo);
            if(parejas.contains(par)){
                hacerAmigos();
            }
        }
    }





}
