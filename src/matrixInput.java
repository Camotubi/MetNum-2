import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class matrixInput extends JFrame {

	private JPanel contentPane;
	private JTable a;
	private JTable b;
	private DefaultTableModel model1;
	private DefaultTableModel model2 ;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public matrixInput(int i) {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 187);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		 model1 = new DefaultTableModel(i,i) ;
		 model2 = new DefaultTableModel(i,1) ;
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		
	
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		a = new JTable(model1);
		panel_1.add(a);
		
		JLabel label = new JLabel("=");
		panel_1.add(label);
		
		b = new JTable(model2);
		panel_1.add(b);
	}
	public matrixInput(Object am[][], Object bm[]) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 187);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Object[] name = new Object[am[0].length];


			for(int n=1;n<(name.length);n++)
			{
				name[n]="x"+n;
			}
			Double [][] bm2=new Double[bm.length][1];
			for(int i =0;i<bm.length;i++)
			{
				bm2[i][0]=(Double) bm[i];
			}
		model1 = new DefaultTableModel(am,name) ;
		 model2 = new DefaultTableModel(bm2, new String[] {""}) ;
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		
	
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		a = new JTable(model1);
		panel_1.add(a);
		
		JLabel label = new JLabel("=");
		panel_1.add(label);
		
		b = new JTable(model2);
		panel_1.add(b);
	}
	
	public void	showme()
	{
		JOptionPane.showOptionDialog(null, contentPane, "Sirena",
	            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
	            new String[] { "Aceptar", "Cancelar" }, "Aceptar");
	}

	public DefaultTableModel getModel1() {
		return model1;
	}

	public void setModel1(DefaultTableModel model1) {
		this.model1 = model1;
	}
	public ArrayList<LinearEquation> getEquationData()
	{
		JOptionPane.showOptionDialog(null, contentPane, "Sirena",
	            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
	            new String[] { "Aceptar", "Cancelar" }, "Aceptar");
		  a.getCellEditor().stopCellEditing();
		  b.getCellEditor().stopCellEditing();
		int nRow= model1.getRowCount();
		int nCol = model1.getColumnCount();
	System.out.println(model1.getValueAt(0, 0));
		ArrayList<LinearEquation> equationSystem = new ArrayList<LinearEquation>();
		for(int r=0;r<nRow;r++)
		{
			ArrayList<Double> eqnCoef = new ArrayList<Double>();
			for(int c = 0;c<nCol;c++)
			{
				eqnCoef.add(Double.parseDouble( (String) model1.getValueAt(r, c)));
			}
			double freeTerm =Double.parseDouble( (String) model2.getValueAt(r,0));
			LinearEquation eqnN = new  LinearEquation(eqnCoef,freeTerm);
			equationSystem.add(eqnN);
		}
		
		
		return equationSystem;
	}
}
