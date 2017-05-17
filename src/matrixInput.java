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
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class matrixInput extends JFrame {

	private JPanel contentPane;
	private JTable a;
	private JTable b;
	private JButton btnAtras;
	private DefaultTableModel model1;
	private DefaultTableModel model2 ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int i = Integer.parseInt(JOptionPane.showInputDialog(null, "matris"));
					matrixInput frame = new matrixInput(i);
					frame.setVisible(true);
					frame.pack();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public matrixInput(int i) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 187);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		DefaultTableModel model1 = new DefaultTableModel(i,i) ;
		DefaultTableModel model2 = new DefaultTableModel(i,1) ;
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnAtras);
		panel.add(btnSiguiente);
		
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
	
	void	updateTable(double[][] matrix)
	{
		setModel1(new DefaultTableModel(matrix,1 ));
		System.out.println("r"+model1.getRowCount());
	}

	public DefaultTableModel getModel1() {
		return model1;
	}

	public void setModel1(DefaultTableModel model1) {
		this.model1 = model1;
	}
	public ArrayList<LinearEquation> getEquationData()
	{
		int nRow= model1.getRowCount();
		int nCol = model1.getColumnCount();
	
		ArrayList<LinearEquation> equationSystem = new ArrayList<LinearEquation>();
		for(int r=0;r<nRow;r++)
		{
			ArrayList<Double> eqnCoef = new ArrayList<Double>();
			for(int c = 0;c<nCol;c++)
			{
				eqnCoef.add((Double) model1.getValueAt(r, c));
			}
			double freeTerm =(double) model2.getValueAt(r,0);
			LinearEquation eqnN = new  LinearEquation(eqnCoef,freeTerm);
			equationSystem.add(eqnN);
		}
		return equationSystem;
	}
}
