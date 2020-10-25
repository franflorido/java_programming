package org.uma.mbd.mdGenetico.genetico;

public class OneMax implements Problema {

	double num_1;
	/**
	 * El fitness de un individuo es el número de unos que tiene el cromosoma.
	 * @see Problema#evalua(Cromosoma)
	 */
	public double evalua(Cromosoma cromosoma) {
		num_1= 0;
		for(int i = 0;i< cromosoma.getLongitud();i++){
			if(cromosoma.getGen(i)==1){
				num_1++;
			}
		}
		return num_1;
	}
}
