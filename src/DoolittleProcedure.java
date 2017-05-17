import java.util.ArrayList;

public class DoolittleProcedure {
	
	private ArrayList<LinearEquation> Equation ;

	
	public DoolittleProcedure(ArrayList<LinearEquation> eqn)
	{
		Equation = eqn;
	}
	public double[] solveSystem()
	{
		Double [][] a = new Double[Equation.size()][Equation.size()];
		Double [] b = new Double[Equation.size()];
		 double sup[][]= new double[b.length][b.length];
		 double inf[][]= new double[b.length][b.length];
		for(int i=0;i<Equation.size();i++)
		{
			LinearEquation tmpEqn =  Equation.get(i);
			a[i]= tmpEqn.getVarCoef().toArray( new Double[tmpEqn.getVarCoef().size()]);
			b[i] =tmpEqn.getFreeTerm();
		}

		
		double[] y = new double[b.length];
		double[] x = new double[b.length];
		
		for(int r = 0;r<a.length;r++)
		{
			for(int c = 0; c < a.length;c++)
			{
				double val = a[r][c];
				if(c>=r)
				{
					for(int i= 0; i<r;i++)
					{
						val=val-inf[r][i]*sup[i][c];
					}
					sup[r][c]=val;
					if(r==c)
					{
						inf[r][c]=1.0;
					}
					else
					{
						inf[r][c]=0.0;
					}
					
				}
				else
				{
					for(int i= 0; i<c;i++)
					{
						val=val-inf[r][i]*sup[i][c];
					}
					inf[r][c]=val/sup[c][c];
					sup[r][c]=0.0;
					
				}
			}
		}
		for(int r = 0;r<a.length;r++)
		{
			
				y[r] = b[r];
				for(int i = 0 ;i< r;i++)
				{
					y[r] = y[r]-y[i]*inf[r][i];
				}
			
		}
		for(int r = a.length-1;r>=0;r--)
		{

				
				
				x[r] = y[r];
				for(int i =a.length-1; i >r  ;i--)
				{
					x[r] = x[r]-x[i]*sup[r][i];
				}
				x[r] = x[r]/sup[r][r];
			
		}
		
		return x;
		
	}



	public double[][] getA() {
		return a;
	}



	public void setA(double a[][]) {
		this.a = a;
	}



	public double[] getB() {
		return b;
	}



	public void setB(double b[]) {
		this.b = b;
	}



	public double[][] getSup() {
		return sup;
	}



	public void setSup(double sup[][]) {
		this.sup = sup;
	}



	public double[][] getInf() {
		return inf;
	}



	public void setInf(double inf[][]) {
		this.inf = inf;
	}

	

}
