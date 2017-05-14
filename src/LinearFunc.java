import java.util.ArrayList;

public class LinearFunc {
	private ArrayList<Double> coef;
	private int eqN ;
	private String name;
	
	public LinearFunc( ArrayList<Double> coef, String name)
	{
		this.setName(name);
		this.coef = coef;
		this.eqN = eqN;
	}
	public double evaluate(Double[] x)
	{
		double evaluation=coef.get(coef.size()-1);
		for(int n = 0; n<coef.size()-1;n++)
		{
			evaluation += x[n]*coef.get(n);
			
		}

		return evaluation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
