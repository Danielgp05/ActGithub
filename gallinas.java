package Examenes.FuncionesMatricesVectores;

import java.util.Scanner;

public class Ex2019_ejer2 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		// Declarar variables
		int gallinas;

		int[] v = asignarDatos();

		imprimirVector(v);

		System.out.print("¿Cuántas gallinas ha comprado? (Introduzca -1 para salir del programa): ");
		gallinas = teclado.nextInt();

		do {

			// Pedir datos al usuario

			if (gallinas == -1) {

				break;

			} else if(gallinas > 4) {

				System.out.printf("“Lo siento, no admitimos grupos de %d gallinas, devuelvalas y compre 'packs' de 4 gallinas como máximo e intente de nuevo”", gallinas);
				imprimirVector(v);
				System.out.println();

			}else {

				boolean valido = rellenarGallinero(v, gallinas);

				if(!valido) {
					
					System.out.println("Lo siento, en estos momentos no queda sitio en ningún gallinero.");
					System.out.println("HASTA PRONTO");
					break;
					
				}

			}

			System.out.print("¿Cuántas gallinas ha comprado? (Introduzca -1 para salir del programa): ");
			gallinas = teclado.nextInt();

		} while (gallinas != -1);

	}

	public static void imprimirVector(int[] miVector) {

		System.out.println("");

		// 1.- Linea de arriba
		System.out.print("┌───────────┬");
		for (int i = 0; i < miVector.length - 1; i++) {
			System.out.print("──────┬");
		}
		System.out.println("──────┐");

		// 2.- Posicion
		System.out.print("│ Posición: │");
		for (int i = 0; i < miVector.length; i++) {

			// La posición i del vector
			System.out.printf("%5d │", i + 1);
		}
		System.out.println();

		// 3.- Linea del medio
		System.out.print("├───────────┼");
		for (int i = 1; i < miVector.length; i++) {
			System.out.print("──────┼");
		}
		System.out.println("──────┤");

		// 4.- Valor
		System.out.print("│ Valor:    │");
		for (int i = 0; i < miVector.length; i++) {

			// Recuperar el valor de la posición i del vector
			System.out.printf("%5d │", miVector[i]);
		}
		System.out.printf("\n");

		// 5.- Linea de abajo
		System.out.print("└───────────┴");
		for (int i = 1; i < miVector.length; i++) {
			System.out.print("──────┴");
		}
		System.out.println("──────┘");
		System.out.println();
	}

	public static int[] asignarDatos () {

		int[] v = new int[10];

		int fin = 4;
		int ini = 0;

		for (int i = 0; i < v.length; i++) {

			v[i] = (int)((Math.random()*(fin-ini+1)) + ini);
		}
		return v;
	}

	public static boolean rellenarGallinero(int [] v, int gallinas) {

		boolean valido = false;
		
		//Recorrer vector y rellenar ceros

		for (int i = 0; i < v.length; i++) {

			if(v[i] == 0) {

				v[i] = v[i] + gallinas;
				System.out.printf("Por favor, introduzca las gallinas en el gallinero número %d", i+1);
				imprimirVector(v);
				valido = true;
				break;

			}
			
			if((v[i] + gallinas) <= 4 && v[i] != 0) {

				v[i] = v[i] + gallinas;
				System.out.printf("Tendrán que compartir gallinero. Por favor, introduzca las gallinas en el gallinero número %d", i+1);
				imprimirVector(v);
				
				valido = true;
				break;

			}
			
		}

		return valido;
	}


}
