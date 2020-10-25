package org.uma.mbd.mdGenetico.genetico;

public class CeroMax implements Problema{
    double num_0;
    /**
     * El fitness de un individuo es el número de unos que tiene el cromosoma.
     * @see Problema#evalua(Cromosoma)
     */
    public double evalua(Cromosoma cromosoma) {
        num_0 = 0;
        for(int i = 0;i< cromosoma.getLongitud();i++){
            if(cromosoma.getGen(i)==0){
                num_0++;
            }
        }
        return num_0;
    }
}
