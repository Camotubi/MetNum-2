import javax.swing.JOptionPane;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.ImageIcon;
public class Main {

	public static void main(String[] args)throws IOException {

	//MenuPrincipal();
		//BufferedReader r = new BufferedReader( new InputStreamReader(System.in));
		ArrayList<Double> p = new ArrayList<Double>();
		double f ;
		p.add(15.0);
		p.add(-3.0);
		p.add(-1.0);
		f = 3800.0;
		LinearEquation e1 = new LinearEquation(p,f);
		p = new ArrayList<Double>();
		p.add(-3.0);
		p.add(18.0);
		p.add(-6.0);
		f= 1200.0;
		LinearEquation e2 = new LinearEquation(p,f);
		p =  new ArrayList<Double>();
		p.add(-4.0);
		p.add(-1.0);
		p.add(12.0);
		f= 2350.0;
		LinearEquation e3 = new LinearEquation(p,f);
		p =  new ArrayList<Double>();
		
		ArrayList<LinearEquation> e = new ArrayList<>();
		e.add(e1);
		e.add(e2);
		e.add(e3);
		SeidelProcedure s = new SeidelProcedure();
		s.setEquation(e);
		
		ArrayList<Double[]> resp = new ArrayList<Double[]>();
		resp = s.solveSystem(0.001);
		for(int i = 0; i<resp.size();i++)
		{
			for(int n = 0;n< resp.get(i).length;n++)
			{
				System.out.print(resp.get(i)[n]+"\t");
			}
			System.out.println("");
		}
		
		
		
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
