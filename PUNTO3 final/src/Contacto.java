import javax.swing.JOptionPane;
public class Contacto implements Comparable<Contacto>{
	String nombre, telefono, email;
	public boolean esIgual (Contacto c)
	{
		return nombre.equals(c.nombre);
	}
	static public Contacto ingresarContacto()
	{
		Contacto c = new Contacto();
		c.nombre = JOptionPane.showInputDialog("Ingree el nombre del contacto");
		c.telefono = JOptionPane.showInputDialog("Ingree el telefono del contacto");
		c.email = JOptionPane.showInputDialog("Ingree el email del contacto");
		return c;
	}
	static public void imprimirContacto(Contacto c)
	{
		System.out.println("CONTACTO : ");
		System.out.println("NOMBRE : "+c.nombre);
		System.out.println("TELEFONO : "+c.telefono);
		System.out.println("EMAIL : "+c.email);
	}
	
	@Override
	public int compareTo(Contacto c) {
		if(this.nombre.equals(c.nombre))
			return 0;
		return 1;
	}
	@Override
	public int hashCode()
	{
		return nombre.hashCode();
	}
	@Override
	public boolean equals(Object c)
	{
		if(c.getClass() == this.getClass())
		{
			Contacto k = (Contacto)c;
			return nombre.equals(k.nombre);
		}
		return false;
	}
	
}