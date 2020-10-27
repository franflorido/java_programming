package org.uma.mbd.mdMastermindL;

import org.uma.mbd.mdMastermindL.masterMind.MasterMind;
import org.uma.mbd.mdMastermindL.masterMind.MasterMindException;
import org.uma.mbd.mdMastermindL.masterMind.MasterMindMemoria;
import org.uma.mbd.mdMastermindL.masterMind.Movimiento;

import java.util.Scanner;

public class TestMasterMind {

	public static void main(String[] args) throws MasterMindException {
//		MasterMind juego = new MasterMind();
		MasterMindMemoria juego = new MasterMindMemoria();
		

		try (Scanner sc = new Scanner(System.in)) {
			boolean acertado = false;
			String cifras = null;
			int intento = 1;
			while (!acertado) {
				try {
					System.out.print("Intento " + intento
							+ ". Introduce cifra: ");
					cifras = sc.next();
					Movimiento mov = juego.intento(cifras);
					System.out.println(juego.secreto);
					System.out.println("Intento " + intento + " " + mov);
					acertado = mov.getColocadas() == juego.getLongitud();
					intento++;
				} catch (MasterMindException e) {
					System.out.println(cifras + " no validas: "
							+ e.getMessage());
				}
			}
			System.out.println("Correcto en " + (intento - 1) + " intentos");
			System.out.println("Movimientos :" + juego.movimientos());


		}
	}
}
