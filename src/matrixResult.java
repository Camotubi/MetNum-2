import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class matrixResult extends JFrame {

	private JPanel contentPane;
	private JTable a;
	private JTable b;
	private JButton btnAtras;
	private DefaultTableModel model1;
	private DefaultTableModel model2 ;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	}*/

	/**
	 * Create the frame.
	 */
	public matrixResult(Object[][] i) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 169);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Object[] name = new Object[i[0].length];
		name[0]="Iteracion";
		name[name.length-1]="Error";
		for(int n=1;n<(name.length-2);n++)
		{
			name[n]="x"+n;
		}
		DefaultTableModel model1 = new DefaultTableModel(i,name) ;
		DefaultTableModel model2 = new DefaultTableModel(i,name) ;
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
		
	
		a = new JTable(model1);
		a.setColumnSelectionAllowed(true);
		a.setCellSelectionEnabled(true);
		JScrollPane scrollPane_3 = new JScrollPane(a);
		
		JLabel label = new JLabel("=");
		
		
		
		b = new JTable(model2);
		b.setCellSelectionEnabled(true);
		b.setColumnSelectionAllowed(true);
		JScrollPane scrollPane_2 = new JScrollPane(b);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_1.add(scrollPane_3);
		panel_1.add(label);
		panel_1.add(scrollPane_2);
		
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
}
