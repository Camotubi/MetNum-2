import java.util.ArrayList;

public class LinearFunc {
	private ArrayList<Double> coef;
	private String name;
	
	public LinearFunc( ArrayList<Double> coef, String name)
	{
		this.setName(name);
		this.coef = coef;
	}
	public double evaluate(double x)
	{
		double evaluation=coef.get(0);
		for(int n = 1; n<coef.size();n++)
		{
			evaluation += x*coef.get(n);
			
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
