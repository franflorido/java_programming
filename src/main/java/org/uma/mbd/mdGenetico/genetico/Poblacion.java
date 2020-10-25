package org.uma.mbd.mdGenetico.genetico;

public class Poblacion {
	private Individuo[] individuos;
	private int numIndividuos;
	/**
	 * 
	 * @param tamaño
	 *            Número de individuos de la población.
	 * @param longitud
	 *            Tamaño de los cromosomas de los individuos de la población.
	 * @param problema
	 *            Problema a resolver.
	 * @throws RuntimeException
	 *             si el tamaño de la población o la longitud de los cromosomas
	 *             indicados no son válidos.
	 */
	public Poblacion(int tamaño, int longitud, Problema problema) {
		if(tamaño<0||longitud<0){
			throw new RuntimeException("tamaño o longitud no validos");
		}
		numIndividuos=tamaño;
		individuos = new Individuo[tamaño];
		for (int i = 0; i<tamaño; i++){
			individuos[i]= new Individuo(longitud,problema);
		}
	}

	/**
	 * Devuelve el número de individuos.
	 * 
	 * @return Número de individuos en la población.
	 */
	public int getNumIndividuos() {
		return individuos.length;
	}

	/**
	 * Devuelve el individuo con fitness mayor de la población.
	 * 
	 * @return Individuo con mejor fitness.
	 */
	public Individuo mejorIndividuo() {

		Individuo resultante = individuos[0];

		for(int i = 1; i<individuos.length; i++){
			double numfitnes = individuos[i].getFitness();
			if(numfitnes> resultante.getFitness()){
				resultante = individuos[i];
			}

		}
		return resultante;
	}

	/**
	 * Devuelve el i-ésimo individuo de la población.
	 * 
	 * @param i
	 *            Posición del individuo a devolver.
	 * @return Individuo en la posición i.
	 * @throws RuntimeException
	 *             si el índice está fuera del rango de valores válidos.
	 */
	public Individuo getIndividuo(int i) {

		if (i<0 || i >individuos.length){
			throw new RuntimeException("Indice no válido");
		}

		return individuos[i];
	}

	/**
	 * Si el individuo que se pasa como argumento tienen mejor fitness que el
	 * peor de los individuos de la población, entonces el peor es sustituido
	 * por el que se pasa.
	 * 
	 * @param ind
	 *            Individuo con el que se sustituye el peor de los individuos si
	 *            este es mejor.
	 */
	public void reemplaza(Individuo ind) {

		Individuo resultante = individuos[0];
		int pos = 0;
		for(int i = 1; i<individuos.length; i++){  //selecciono al peor individuo
			double numfitnes = individuos[i].getFitness();
			if(numfitnes< resultante.getFitness()){
				resultante = individuos[i];
				pos = i;
			}
		}
		if (ind.getFitness()> resultante.getFitness()){ // substituyo el peor individuo si el dado tiene mejor fitness
			individuos[pos] = ind;
		}

	}

}
