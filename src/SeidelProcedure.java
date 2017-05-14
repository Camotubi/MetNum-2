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
	public void solveEquations()
	{
		Function.clear();

		for(int i =0; i<Equation.size();i++)
		{

			Function.add(Equation.get(i).solveForX(i));
		}
	}
	public ArrayList<Double[]> solveSystem(double tolerance)
	{
		solveEquations();
		ArrayList<Double[]> procedureTable = new ArrayList<Double[]>();
		Double iterData[] =  new Double[Equation.size()+2];
		for(int i= 0; i < iterData.length;i++)
		{
			iterData[i] = 0.0;
		}
		procedureTable.add(iterData);
		do
		{	
			iterData =  new Double[Equation.size()+2];
			
			iterData[0] = procedureTable.get(procedureTable.size()-1)[0]+1;
			for(int i = 0; i<iterData.length-1;i++)
			{
				iterData[i+1] =  procedureTable.get(procedureTable.size()-1)[i+1];
			}
			double prevX0 = procedureTable.get(procedureTable.size()-1)[1];
			for(int i = 0; i<Function.size() ; i++)
			{	
				Double[] evaluationNumbers = new Double[Function.size()-1];
				int evaluationNumberCounter =0;
				for(int n = 0;n<Function.size(); n++)
				{
					
					if(i == n)
					{
						continue;
					}
					else
					{
						evaluationNumbers[evaluationNumberCounter] = iterData[n+1];
						evaluationNumberCounter++;
					}
				}
				iterData[i+1] = Function.get(i).evaluate( evaluationNumbers );
				
			}
			iterData[iterData.length-1] = Math.abs((iterData[1]-prevX0)/iterData[1]);
			procedureTable.add(iterData);
		}while(procedureTable.get(procedureTable.size()-1)[iterData.length-1]>tolerance && procedureTable.get(procedureTable.size()-1)[0]<40);
		
		return procedureTable;
	}

}
