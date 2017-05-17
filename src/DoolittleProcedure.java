import java.util.ArrayList;

public class DoolittleProcedure {
	
	private ArrayList<LinearEquation> Equation ;
	private Double sup[][];
	private Double inf[][];
	
	public DoolittleProcedure(ArrayList<LinearEquation> eqn)
	{
		int matrixSize=eqn.size();
		Equation = eqn;
		
		sup= new Double[matrixSize][matrixSize];
		inf= new Double[matrixSize][matrixSize];
	}
	public double[] solveSystem()
	{
		Double [][] a = new Double[Equation.size()][Equation.size()];
		Double [] b = new Double[Equation.size()];

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








	public Double[][] getSup() {
		return sup;
	}



	public void setSup(Double sup[][]) {
		this.sup = sup;
	}



	public Double[][] getInf() {
		return inf;
	}



	public void setInf(Double inf[][]) {
		this.inf = inf;
	}

	

}
