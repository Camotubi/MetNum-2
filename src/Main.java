import javax.swing.JOptionPane;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
public class Main {

	public static void main(String[] args)throws IOException {
		MenuPrincipal();
	//	int l = Integer.parseInt(JOptionPane.showInputDialog(null, "matris"));
		
		/*
	//MenuPrincipal();
		//BufferedReader r = new BufferedReader( new InputStreamReader(System.in));
		ArrayList<Double> p = new ArrayList<Double>();
		double f ;
		p.add(10.0);
		p.add(1.0);
		p.add(2.0);
		p.add(3.0);
		f = 4.0;
		LinearEquation e1 = new LinearEquation(p,f);
		p = new ArrayList<Double>();
		p.add(1.0);
		p.add(9.0);
		p.add(2.0);
		p.add(3.0);
		f= 5.0;
		LinearEquation e2 = new LinearEquation(p,f);
		p =  new ArrayList<Double>();
		p.add(1.0);
		p.add(1.0);
		p.add(8.0);
		p.add(3.0);
		f= 7.0;
		LinearEquation e3 = new LinearEquation(p,f);
		p =  new ArrayList<Double>();
		p.add(1.0);
		p.add(1.0);
		p.add(2.0);
		p.add(7.0);
		f= 6.0;
		LinearEquation e4 = new LinearEquation(p,f);
		
		ArrayList<LinearEquation> e = new ArrayList<>();
		e.add(e1);
		e.add(e2);
		e.add(e3);
		e.add(e4);
		SeidelProcedure s = new SeidelProcedure();
		s.setEquation(e);
		
		ArrayList<Double[]> resp = new ArrayList<Double[]>();
		resp = s.solveSystem(0.001);
		Double[][] respArr = new Double[resp.size()][resp.get(0).length];
		for(int i = 0; i<resp.size();i++)
		{
			for(int n = 0;n< resp.get(i).length;n++)
			{
				respArr[i][n]=resp.get(i)[n];
			}
		}
		matrixResult frame = new matrixResult(respArr);
		frame.setVisible(true);
		frame.pack();
		
		//frame.updateTable(respArr);

			for(int i = 0; i<resp.size();i++)
		{
			for(int n = 0;n< resp.get(i).length;n++)
			{
				System.out.print(resp.get(i)[n]+"\t");
			}
			System.out.println("");
		}
		
	/*	double resp[]= d.solveSystem();
		for(int i = 0; i<resp.length;i++)
		{
		
				System.out.print(resp[i]+"\t");
		}
		
		*/
		
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
			case 1:MetodoDoolittle(); break;
			case 2:MetodoSeidel(); break;
			
			}
		}while (opcion!=3);
		
	}
	
	static void MetodoDoolittle()
	{
		DoolittleProcedure d = new DoolittleProcedure(equatioInput());
		double resultado[] =d.solveSystem();
		int opcion =0;
		do{
			opcion=0;
			try{
				opcion=Integer.parseInt(JOptionPane.showInputDialog(null, "1. Matriz Principal \n"
						+ "2. Matriz Superior \n"
						+ "3. Matriz Inferior \n"
						+ "4. Resultados \n"
						+ "0. Menu Principal"));
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Error. Introduzca una de las opciones.");
			}
			switch(opcion)
			{
			case 1:
				{
					
					new matrixInput(d.getSystemCoefArray(),d.getSytemFreeTermArray()).showme();;
				}
				break;
			case 2: 
				new matrixResult(d.getSup(),0).showme();
			
				break;
			case 3: 
				new matrixResult(d.getInf(),0).showme();
				break;
			case 4:
			{
				String resultadoStr = "";
				for(int i=0;i<resultado.length;i++)
				{
					resultadoStr = resultadoStr +"x"+i+": " +resultado[i]+"\n";
				}
				JOptionPane.showMessageDialog(null, "Resultado\n"+resultadoStr);
			}
				break;
			
			
			}
		}while (opcion!=0);
	}
	static void MetodoSeidel()
	{
		SeidelProcedure s = new SeidelProcedure();
		s.setEquation(equatioInput());
		ArrayList<Double []>resp=s.solveSystem(0.00001);
		Double[][] procedure = new Double[resp.size()][resp.get(0).length];
		for(int i = 0; i<resp.size();i++)
		{
			procedure[i]=resp.get(i);
		}
		
		int opcion =0;
		do{
			opcion=0;
			try{
				opcion=Integer.parseInt(JOptionPane.showInputDialog(null, "1. Tabla o cuadro de iteracion \n"
						+ "2. Resultados del Sistema de Ecuacion Algebraica Lineal \n"
						+ "0. Menu Principal"));
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Error. Introduzca una de las opciones.");
			}
			switch(opcion)
			{
			case 1:
				{
					
					new matrixResult(procedure,1).showme();;
				}
				break;
			case 2: 
			{
				String resultadoStr = "";
				for(int i=0;i<s.getEquation().size();i++)
				{
					resultadoStr = resultadoStr +"x"+i+": " +s.getSolution()[i]+"\n";
				}
				JOptionPane.showMessageDialog(null, "Resultado\n"+resultadoStr);
			}
				break;

			
		
			}
		}while (opcion!=0);
		
	}
	static ArrayList<LinearEquation> equatioInput()
	{
		
		matrixInput frame = new matrixInput(Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cuantas variables por ecuacion tiene su sistema?")));
		frame.pack();
		return frame.getEquationData();
		
	}
}
