import java.util.ArrayList;

public class SeidelProcedure {
	private ArrayList<LinearEquation> Equation = new ArrayList<LinearEquation>();
	private ArrayList<LinearFunc> Function = new ArrayList<LinearFunc>();
	//To-do solve for X for each of the euation then save in Function
	// Iter Function
	public ArrayList<LinearEquation> getEquation() {
		return Equation;
	}
	public void setEquation(ArrayList<LinearEquation> equation) {
		Equation = equation;
	}
	public ArrayList<LinearFunc> getFunction() {
		return Function;
	}
	public void setFunction(ArrayList<LinearFunc> function) {
		Function = function;
	}
	

}
