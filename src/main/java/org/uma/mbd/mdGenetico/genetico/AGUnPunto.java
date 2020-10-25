package org.uma.mbd.mdGenetico.genetico;

public class AGUnPunto extends AlgoritmoGenetico {

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
	public AGUnPunto(int tPoblacion, int longCromosoma, int pasos,
			double probMutacion, Problema problema) {
		super(tPoblacion, longCromosoma, pasos, probMutacion, problema);
	}

	/**
	 * @see AlgoritmoGenetico#recombinar(Cromosoma, Cromosoma)
	 */
	@Override
	protected Cromosoma recombinar(Cromosoma cromosoma1, Cromosoma cromosoma2) {
		Cromosoma resultante = new Cromosoma(cromosoma1.getLongitud(), false);
		int z = Cromosoma.gna.nextInt(cromosoma1.getLongitud());
		for(int i = 0; i < z; i++){
			resultante.setGen(i,cromosoma1.getGen(i));
		}
		for(int i = z; i< cromosoma1.getLongitud(); i++){
			resultante.setGen(i,cromosoma2.getGen(i));
		}
		return resultante;
	}

}
