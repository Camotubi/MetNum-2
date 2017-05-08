import javax.swing.JOptionPane;
import java.io.IOException;
import javax.swing.ImageIcon;
public class Main {

	public static void main(String[] args)throws IOException {

	MenuPrincipal();
	}

	static void MenuPrincipal(){
		int opcion=0;
		do{
			opcion=0;
			try{
				opcion=Integer.parseInt(JOptionPane.showInputDialog(null, "1. Pagina de presentación.\n "
						+ "2. Metodos de sistemas de ecuaciones lineales. \n "
						+ "3. Salir del Programa."));
			
				
			}
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(null, "Por favor, selecciona algunas de las opciones en pantalla.");
			}
			switch(opcion)
			{
			case 1: PaginaDePresentacion();break;
			case 2: MenuMetodosEcLineales();break;
			case 3: System.exit(0);
			default: JOptionPane.showMessageDialog(null, "Opcion invalida.");
			}
		}while(opcion!=3);
	}
	
	
	static void PaginaDePresentacion(){
		ImageIcon presentacion = new ImageIcon(Main.class.getClassLoader().getResource("presentacion.jpg"));
		JOptionPane.showMessageDialog(null, presentacion);
	}
	
	
	
	static void MenuMetodosEcLineales(){
		//Lo que DIOS quiera pues :D 
		int opcion =0;
		do{
			opcion=0;
			try{
				opcion=Integer.parseInt(JOptionPane.showInputDialog(null, "1. Metodo Doollitle \n"
						+ "2. Metodo Iterativo \n"
						+ "3. Regresar al menu principal. \n"));
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Error. Introduzca una de las opciones.");
			}
			switch(opcion)
			{
			case 1: break;
			case 2: break;
			
			}
		}while (opcion!=3);
		
	}
}
