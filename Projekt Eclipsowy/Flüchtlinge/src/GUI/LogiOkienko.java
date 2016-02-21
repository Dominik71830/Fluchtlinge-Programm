package GUI;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import FUNKCJE_I_KLASY.*;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class LogiOkienko extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableLogi;

	
	public LogiOkienko() {
		setTitle("Logi");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblOstatnieZmiany = new JLabel("Ostatnie zmiany");
		lblOstatnieZmiany.setBounds(10, 11, 89, 14);
		getContentPane().add(lblOstatnieZmiany);
		
		JScrollPane scrollPaneLogi = new JScrollPane();
		scrollPaneLogi.setBounds(20, 36, 404, 188);
		getContentPane().add(scrollPaneLogi);
		
		tableLogi = new JTable();
		scrollPaneLogi.setViewportView(tableLogi);
		
		JButton btnPowrt = new JButton("Powr\u00F3t");
		btnPowrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnPowrt.setBounds(335, 228, 89, 23);
		getContentPane().add(btnPowrt);

	}


		public void populate(Uchodzca temp, List<Log> listalogi) {
			//employeeAuditHistoryLabel.setText(tempEmployee.getFirstName() + " " + tempEmployee.getLastName());
			
			ModelTablicyLogow model = new ModelTablicyLogow(listalogi);
			
			tableLogi.setModel(model);
			
			//TableCellRenderer tableCellRenderer = new DateTimeCellRenderer();
			//table.getColumnModel().getColumn(AuditHistoryTableModel.DATE_TIME_COL).setCellRenderer(tableCellRenderer);	
		}
	
}
