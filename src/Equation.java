import java.util.ArrayList;

public class Equation {
	private double freeTerm;
	private ArrayList<Double> varCoef;
	
	
	public Equation(ArrayList<Double> varCoef, double freeTerm)
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

	
}
