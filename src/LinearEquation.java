import java.util.ArrayList;

public class LinearEquation {
	private double freeTerm;
	private ArrayList<Double> varCoef;
	
	
	public LinearEquation(ArrayList<Double> varCoef, double freeTerm)
	{
		this.setVarCoef(varCoef);
		this.setFreeTerm(freeTerm);
	}


	public double getFreeTerm() {
		return freeTerm;
	}


	public void setFreeTerm(double freeTerm) {
		this.freeTerm = freeTerm;
	}


	public ArrayList<Double> getVarCoef() {
		return varCoef;
	}


	public void setVarCoef(ArrayList<Double> varCoef) {
		this.varCoef = varCoef;
	}

	public LinearFunc solveForX(int x)
	{
		ArrayList<Double> solvedForXCoef = new ArrayList<Double>();
		solvedForXCoef.add(freeTerm);
		for(int i = 0; i< varCoef.size();i++)
		{
			if(i == x)
			{
				continue;
			}
			else
			{
				solvedForXCoef.add(-varCoef.get(i));
			}
		}
		return new  LinearFunc(solvedForXCoef,"x"+x);
	}



}
