package org.uma.mbd.mdGenetico.genetico;

public abstract class AlgoritmoGenetico {


	/**
	 * Población de soluciones tentativas.
	 */
	private Poblacion poblacion;

	/**
	 * Problema a resolver.
	 */
	private Problema problema;

	/**
	 * Número de pasos que debe realizar.
	 */
	private int pasos;

	/**
	 * Probabilidad de mutación de los genes de los individuos.
	 */
	private double probMutacion;

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
	public AlgoritmoGenetico(int tPoblacion, int longCromosoma, int pasos,
			double probMutacion, Problema problema) {

			poblacion = new Poblacion(tPoblacion,longCromosoma,problema);
			this.pasos = pasos;
			this.probMutacion = probMutacion;
			this.problema=problema;

	}

	/**
	 * Ejecuta la secuencia siguiente tantas veces como indique el número de
	 * pasos: seleccionar dos individuos de la población aleatoriamente, tomar
	 * sus cromosomas y recombinarlos usando el método abstracto recombinar(),
	 * mutar el resultado y, por último, crear un individuo con el cromosoma
	 * resultante que insertará en la población reemplazando al peor individuo
	 * siempre y cuando sea mejor que éste.
	 * 
	 * @return Mejor individuo de la población después de la terminación del
	 *         bucle.
	 */
	public Individuo ejecuta() {
		for (int i = 0; i < pasos; i++) {
			// Nos aseguramos de coger dos individuos distintos
			int a1 = Cromosoma.gna.nextInt(poblacion.getNumIndividuos());
			int a2;
			do {
				a2 = Cromosoma.gna.nextInt(poblacion.getNumIndividuos());
			} while (a1 == a2);
			Individuo I1 = poblacion.getIndividuo(a1);
			Individuo I2 = poblacion.getIndividuo(a2);
			Cromosoma a3 = recombinar(I1.getCromosoma(), I2.getCromosoma());
			a3.mutar(probMutacion);
			Individuo I3 = new Individuo(a3,problema);
			poblacion.reemplaza(I3);
 		}

		return poblacion.mejorIndividuo();
	}

	/**
	 * Recombina los cromosomas pasados como argumento generando un tercer
	 * cromosoma.
	 * 
	 * Dado que el método es protected supnemos que siempre se llama con dos
	 * cromosomas de la misma longitud.
	 * 
	 * @param cromosoma1
	 *            Uno de los cromosoma a recombinar.
	 * @param cromosoma2
	 *            Uno de los cromosoma a recombinar.
	 * @return
	 * 			El cromosoma resultante de la recombinación
	 */
	protected abstract Cromosoma recombinar(Cromosoma cromosoma1,
											Cromosoma cromosoma2);
}
