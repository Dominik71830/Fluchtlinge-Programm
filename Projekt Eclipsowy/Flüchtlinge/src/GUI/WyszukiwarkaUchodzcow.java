package GUI;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import FUNKCJE_I_KLASY.*;



public class WyszukiwarkaUchodzcow extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;
	Funkcje funkcje=null;
	boolean updatemode;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WyszukiwarkaUchodzcow dialog = new WyszukiwarkaUchodzcow(null);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the dialog.
	 * @param tabelamiasta 
	 * @throws Exception 
	 */
	public WyszukiwarkaUchodzcow(JTable tabelamiasta) throws Exception {
		setTitle("Wyszukiwarka");
		funkcje = new Funkcje();
		
		setBounds(100, 100, 1000, 436);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 169, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnWyszukaj = new JButton("Wyszukaj");
		btnWyszukaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ciag = textField.getText();
				
				
				try
				{
					List<Uchodzca> uchodzcy = null;
					
					if (ciag != null && ciag.trim().length() > 0) { 
						uchodzcy = funkcje.searchUchodzca(ciag);
					} else {
						uchodzcy = funkcje.getAllUchodzcy();
					}
					
					ModelTablicyUchodzcow model = new ModelTablicyUchodzcow(uchodzcy);
					
					table.setModel(model);
					
				}
				catch(Exception exc)
				{
					JOptionPane.showMessageDialog(null, "B��d wyszukiwania- " + exc);
				}
			}
		});
		btnWyszukaj.setBounds(189, 10, 91, 23);
		getContentPane().add(btnWyszukaj);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 972, 322);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnPowrt = new JButton("Powr\u00F3t");
		btnPowrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnPowrt.setBounds(891, 375, 91, 23);
		getContentPane().add(btnPowrt);
		
		JButton btnHistoria = new JButton("Historia");
		btnHistoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				
				
				if (row < 0) {
					JOptionPane.showMessageDialog(null, "Zaznacz osob�");				
					return;
				}
				
				
				Uchodzca temp = (Uchodzca) table.getValueAt(row, ModelTablicyUchodzcow.OBJECT_COL);

				try {
					
					//int uchodzcaId = temp.getId();
					List<Log> listalogi = funkcje.getLogi(temp.getId());

					
					LogiOkienko dialog = new LogiOkienko();
					dialog.populate(temp, listalogi);
					
					dialog.setVisible(true);
				}
				catch (Exception exc) {
					JOptionPane.showMessageDialog(null, "B��d przy wy�wieltaniu historii " + exc);					
				}
			}
		});
		btnHistoria.setBounds(10, 375, 91, 23);
		getContentPane().add(btnHistoria);
		
		JButton btnZaawansowane = new JButton("Zaawansowane");
		btnZaawansowane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WyszukiwarkaZaawansowana okno;
				try {
					okno = new WyszukiwarkaZaawansowana(table);
					okno.setVisible(true);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		btnZaawansowane.setBounds(290, 10, 125, 23);
		getContentPane().add(btnZaawansowane);
		
		
		JButton btnEdytuj = new JButton("Edytuj");
		btnEdytuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int row = table.getSelectedRow();
				
				if (row < 0) {
					JOptionPane.showMessageDialog(null,"Wybierz uchod�c�");				
					return;
				}
				
				Uchodzca temp = (Uchodzca) table.getValueAt(row, ModelTablicyUchodzcow.OBJECT_COL);
				
				
				updatemode=true;
				RejestracjaUchodzcyPodstawoweDane okno;
				try {
					okno = new RejestracjaUchodzcyPodstawoweDane(temp,updatemode,table,tabelamiasta);
					okno.setVisible(true);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		btnEdytuj.setBounds(111, 375, 91, 23);
		getContentPane().add(btnEdytuj);

	}

}
