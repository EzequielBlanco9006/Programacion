
public class Texto {

	private String  texto = null;		
	private String palabras [] = null;  
	
	public Texto(String txt) {
		this.texto = txt;
		this.palabras = txt.split(" ");
	}


}
