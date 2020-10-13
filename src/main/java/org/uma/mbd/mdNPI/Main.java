package org.uma.mbd.mdNPI;

import org.uma.mbd.mdNPI.npi.NPI;


public class Main {
	public static void main(String [] args) {
		// 5 + (6 - 2) * 3;
		// NPI 5 6 2 - 3 * +
		NPI cpi = new NPI();
		cpi.entra(5);
		cpi.entra(6);
		cpi.entra(2);
		cpi.resta();
		cpi.entra(3);
		cpi.multiplica();
		cpi.suma();
		System.out.println(cpi);
		System.out.println("Resultado " + cpi.getResultado());

		//3 * (6 - 2) + (2 + 7) / 5
		NPI cpi2 = new NPI();
		cpi2.entra(3);
		cpi2.entra(6);
		cpi2.entra(2);
		cpi2.resta();
		cpi2.multiplica();
		cpi2.entra(2);
		cpi2.entra(7);
		cpi2.suma();
		cpi2.entra(5);
		cpi2.divide();
		cpi2.suma();
		System.out.println(cpi2);
		System.out.println("Resultado " + cpi2.getResultado());




 	}
}
