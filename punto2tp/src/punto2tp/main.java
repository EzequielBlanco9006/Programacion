package punto2tp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class main {
	public static void main(String[] args) {
		ArrayList<String> Archivo = LeerArchivo("texto.txt");

		ConvertiraMayusculaDespuesdeunPunto(Archivo);

//		for (String linea : Archivo) {
//
//			System.out.println(linea);
//		}

	}

	private static void ConvertiraMayusculaDespuesdeunPunto(ArrayList<String> Archivo) {

		for (String linea : Archivo) {

			boolean cambiar = true;
			char[] vec = linea.toCharArray();
			for (int i = 0; i < vec.length; i++) {
				if (vec[i] == '.') {
					int siguiente = i + 1;
					if (siguiente < vec.length) {
						while (vec[siguiente] == ' ' || vec[siguiente] == '.') {
							if (siguiente < vec.length-1) {
								siguiente++;
							} else {
								cambiar = false;
								break;
							}
						}
					}

					if (cambiar)
						vec[siguiente] = String.valueOf(vec[siguiente]).toUpperCase().charAt(0);
				}
			}

			System.out.println(vec);
		}
	}

	private static ArrayList<String> LeerArchivo(String Archivo) {
		// TODO Auto-generated method stub
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<String> Texto = new ArrayList<String>();

		try {
			/*
			 * Apertura del fichero y creacion de BufferedReader para poder
			 * hacer una lectura comoda (disponer del metodo readLine()).
			 */
			fr = new FileReader(Archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			while ((linea = br.readLine()) != null) {
				Texto.add(linea);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			/*
			 * En el finally cerramos el fichero, para asegurarnos que se cierra
			 * tanto si todo va bien como si salta una excepcion.
			 */
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			return Texto;
		}
	}
}
