
public class Texto {

	
		this.texto = txt;
		this.palabras = txt.split(" ");
	}
	
	public void contarTodas (){
		String palabras [] = this.texto.split(" ");
		String palabrasB [] = this.texto.split(" ");
		
		int cantidad = palabras.length;
		String resultado = "";
		
		
			resultado += palabras[i];
			String palabra = palabras[i];
			
			for (int j = 0; j < cantidad; j++) {
				
				if (palabra.equalsIgnoreCase(palabrasB[j])){
					conatdor++;
					palabras[j] = "";
					
				}
			}
			if (conatdor>0){
				resultado += " "+conatdor+"\n";
			}
			
		}
		
		System.out.print(resultado);
	}
	
	
	
	public int contar_Repetidas (String palabra){
		int contador = 0;		
		for (int i = 0; i < this.palabras.length; i++) {
			if (this.palabras[i].equalsIgnoreCase(palabra)){
				contador++;
			}
		}
		return contador;
	}
	
	
	public void eliminarPalabra (String palabra){
		this.texto.replace(palabra,"");
	}
	
	


}


