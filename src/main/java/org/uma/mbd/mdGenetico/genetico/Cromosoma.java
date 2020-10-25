package org.uma.mbd.mdGenetico.genetico;
import java.util.Arrays;
import java.util.Random;

public class Cromosoma {

	private int longitud;
	/**
	 * Datos de un cromosoma, cada posición del array representa un gen del
	 * cromosoma.
	 */
	protected int[] datos;

	/**
	 * Variable de clase de tipo Random.
	 */
	protected static Random gna = new Random(100);

	/**
	 * Valor por defecto 0 para los genes.
	 */
	protected static int GEN_POR_DEFECTO = 0;

	/**
	 * Constructor de la clase Cromosoma
	 * 
	 * @param longitud
	 *            Número de genes que tiene el cromosoma.
	 * @param aleatorio
	 *            Valor booleano que indica si debe asignar de forma aleatoria
	 *            un valor 0 o 1 a cada gen, o inicializarlos con el valor por
	 *            defecto. Si true se asigna aleatoriamente.
	 * @throws RuntimeException
	 *             si longitud no positiva.
	 */
	public Cromosoma(int longitud, boolean aleatorio) {
		if (longitud < 0) {
			throw new RuntimeException("Longitud negativa");
		}

		this.longitud = longitud;
		datos = new int[longitud];

		for (int i = 0; i < longitud; i++) {
			if (aleatorio == true) {

				datos[i] = gna.nextInt(2);
			}else{

				datos[i] = GEN_POR_DEFECTO;}
		}
	}

	/**
	 * Consulta el gen en la posición indicada.
	 * 
	 * @param i
	 *            índice del gen que se consulta.
	 * @return Valor del gen en la posición indicada.
	 * @throws RuntimeException
	 *             si el índice está fuera del rango de valores válidos.
	 */
	public int getGen(int i) {
		if(i<0 || i>longitud){
			throw new RuntimeException("Ese gen no se encuentra en el cromosoma");
		}
		return datos[i];
	}

	/**
	 * Modifica el i-ésimo gen del cromosoma.
	 * 
	 * @param i
	 *            índice del gen a modificar.
	 * @param val
	 *            Nuevo valor para el gen.
	 * @throws RuntimeException
	 *             si i está fuera del rango de valores válidos o si val no es
	 *             un valor válido.
	 */
	public void setGen(int i, int val) {
		if(i<0 || i>longitud ){
			throw new RuntimeException("Indice o valor incorrecto");
		}
		datos[i]=val;
	}

	/**
	 * Invierte los valores de los genes aleatoriamente.
	 * 
	 * @param probMutacion
	 *            Probabilidad de mutacion de cada gen.
	 * @throws RuntimeException
	 *             si la probabilidad indicada no es un valor válido.
	 */
	public void mutar(double probMutacion) {
		probMutacion=1/probMutacion; // se calcula la inversa de la probabilidad de mutación
		int value = (int)probMutacion; // se le da un formato int
		for(int i = 0; i < datos.length ; i++){
			int random = gna.nextInt(value); // para cada gen se seleciona un numero aleatorio entre
											 // 0 y la inversa de la prb de mutacion y si ese numero es igual a 0 se da la condición
			if(random==0) {
				if (datos[i] == 0) {
					datos[i] = 1;
				} else {
					datos[i] = 0;
				}

			}
		}

	}

	/**
	 * Longitud del cromosoma.
	 * 
	 * @return int Longitud del cromosoma.
	 */
	public int getLongitud() {
		return datos.length;
	}

	/**
	 * Realiza una copia en profundidad del cromosoma.
	 * 
	 * @return Un objeto Cromosoma copia del objeto que recibe el mensaje.
	 */
	public Cromosoma copia() {
		Cromosoma cr = new Cromosoma(datos.length,false);
		cr.datos = Arrays.copyOf(this.datos,datos.length);
		return cr;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < datos.length - 1; i++) {
			s.append(datos[i]).append(", ");
		}
		return "Cromosoma(" + s + datos[datos.length - 1] + ")";
	}
}
