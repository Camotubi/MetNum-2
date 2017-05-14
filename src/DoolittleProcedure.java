
public class DoolittleProcedure {
	
	private double a[][]={{10.0,1.0,2.0,3.0},{1.0,9.0,2.0,3.0},{1.0,1.0,8.0,3.0},{1.0,1.0,2.0,7.0}};
	private double b[] ={4.0,5.0,7.0,6.0};
	private double sup[][]= new double[4][4];
	private double inf[][]= new double[4][4];

	
	
	public double[] solveSystem()
	{
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
