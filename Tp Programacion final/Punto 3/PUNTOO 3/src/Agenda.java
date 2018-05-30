import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JOptionPane;




public class Agenda {

	HashSet<Contacto>agenda=new HashSet<Contacto>();
	private String file; 
	public void agregarContacto(Contacto c) {
		agenda.add(c);		
	}
	
	public boolean existeContacto(Contacto c) {
		return agenda.contains(c);
	}
	
	public ArrayList<Contacto> listarContactos() {
	
		ArrayList<Contacto> Lista = new ArrayList<Contacto>();
		for(Contacto c : agenda)
		{
			Lista.add(c);
		}
		return Lista;
			
	}
	
	public String buscarContacto(String nombre) {
		for(Contacto c : agenda) {
			if(nombre.equals(c.nombre)) {
				
				return c.telefono;
				
				
			}
			
		}
		
		return new String();
		
		
	}
	public ArrayList<Contacto> buscaContactoPorTelefono(String telefono) {
		ArrayList<Contacto> busca= new ArrayList<Contacto>();
		for(Contacto c: agenda) {
			if(c.telefono.contains(telefono))
			{
				busca.add(c);
			}
		}
		return busca;	
	}

	public void eliminarContacto(Contacto c) {
		
		if (existeContacto(c)){
			
			agenda.remove(c);
			System.out.println("Se removio el contacto ");
		}
		else {
			System.out.println("El contacto no se pudo remover ya que no existia");
		}
		
	}
	void guardarContactos()
	{
		try
		{
			System.out.println(file);
			BufferedWriter out = new BufferedWriter(new FileWriter(new File(file)));
			for(Contacto c : agenda)
			{
				out.write(c.nombre +"\n");
				out.write(c.telefono +"\n");
				out.write(c.email +"\n");
			}
			out.close();
		}
		catch(Exception e){
	         e.printStackTrace();
	         return;
	    }
	}
	void guardarContactos(String file)
	{
		this.file = file;
		guardarContactos();
	}
	void cargarContactos(String file)
	{
		this.file = file;
		BufferedReader in = null;
		try
		{
			in = new BufferedReader(new FileReader(new File(file)));
			agenda = new HashSet<Contacto>();
			while(in.ready())
			{
				Contacto c = new Contacto();
				c.nombre = in.readLine();
				c.telefono = in.readLine();
				c.email = in.readLine();
				agenda.add(c);
			}
			in.close();
		}
		catch(Exception e){
	         e.printStackTrace();
	         return;
	    }
		
	}
	
	
	//-----------------------------------------------------------------------------------------------------------
	public void menu()
	{
		int op;
		do
		{
			op = Integer.parseInt(JOptionPane.showInputDialog("\n1-Agregar Contacto\n2-Verificar Existencia de Contacto\n3- Mostrar todos los contactos\n4- Buscar Contacto\n5- Buscar Contacto por Telefono\n6-Eliminar Contacto\n7- Guardar Agenda\n8- Cargar Agenda\n0-Salir"));
			switch(op)
			{
				case 1:
				{
					agregarContacto(Contacto.ingresarContacto());
					break;
				}
				case 2:
				{
					if(existeContacto(Contacto.ingresarContacto()))
						System.out.println("Existe el contacto");
					else
						System.out.println("No existe el contacto");
					break;
				}
				case 3:
				{
					ArrayList <Contacto> contactos = listarContactos();
					for(Contacto c : contactos)
					{
						Contacto.imprimirContacto(c);
					}
					break;
				}
				case 4:
				{
					System.out.println(buscarContacto(JOptionPane.showInputDialog("Ingree el nombre del contacto")));
					break;
				}
				case 5:
				{
					ArrayList<Contacto> contactos = buscaContactoPorTelefono(JOptionPane.showInputDialog("Ingree el telefono del contacto o parte del mismo"));
					for(Contacto c : contactos)
					{
						Contacto.imprimirContacto(c);
					}
					break;
				}
				case 6:
				{
					eliminarContacto(Contacto.ingresarContacto());
					break;
				}
				case 7:
				{
					String _file = JOptionPane.showInputDialog("Ingrese donde guardar la agenda (si no ingresa nada se sobreescribira el archivo actual)");
					if(_file.isEmpty())
						guardarContactos();
					else
						guardarContactos(_file);
					break;
				}
				case 8:
				{
					cargarContactos(JOptionPane.showInputDialog("Ingrese de donde cargar la agenda"));
					break;
				}
			}
		}while(op != 0);
	}
}