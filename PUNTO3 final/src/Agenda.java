import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JOptionPane;




public class Agenda {

	HashSet<Contacto>agenda=new HashSet<Contacto>(); 
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
	
	//-----------------------------------------------------------------------------------------------------------
	public void menu()
	{
		int op;
		do
		{
			op = Integer.parseInt(JOptionPane.showInputDialog(" 1--->Agregar Un Contacto\n 2--->Verificar Existencia de un Contacto\n 3--->Mostrar todos los contactos\n 4--->Buscar un Contacto\n 5--->Buscar Contacto por Telefono\n 6--->Eliminar Contacto\n 0--->Salir\\"));
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
			
			}
		}while(op != 0);
	}
}