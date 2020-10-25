package org.uma.mbd.mdGenetico.genetico;

public class AGUniforme extends AlgoritmoGenetico {

	/**
	 * 
	 * @param tPoblacion
	 *            Tamaño de la población que va a utilizar.
	 * @param longCromosoma
	 *            Longitud de los cromosomas de los individuos de dicha
	 *            población.
	 * @param pasos
	 *            Número de pasos del algoritmo (generaciones).
	 * @param probMutacion
	 *            Probabilidad de mutar un gen en el cromosoma.
	 * @param problema
	 *            Problema que se debe resolver.
	 */
	public AGUniforme(int tPoblacion, int longCromosoma, int pasos,
			double probMutacion, Problema problema) {
		super(tPoblacion, longCromosoma, pasos, probMutacion, problema);
	}

	/**
	 * @see AlgoritmoGenetico#recombinar(Cromosoma, Cromosoma)
	 */
	@Override
	protected Cromosoma recombinar(Cromosoma cromosoma1, Cromosoma cromosoma2) {

		Cromosoma resultante = new Cromosoma(cromosoma1.getLongitud(), false);
		Cromosoma cromo [] = new Cromosoma[2];
		cromo[0]=cromosoma1;
		cromo[1]=cromosoma2;

		for (int i = 0; i< cromosoma1.getLongitud(); i++ ){
			int z = Cromosoma.gna.nextInt(2);
			if(z==0){
				resultante.setGen(i,cromosoma1.getGen(i));
			}else{
				resultante.setGen(i,cromosoma2.getGen(i));
			}
		}

		return resultante;
	}

}
