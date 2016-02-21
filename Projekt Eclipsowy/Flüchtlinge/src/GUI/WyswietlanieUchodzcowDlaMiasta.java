package GUI;

import java.awt.BorderLayout;
import FUNKCJE_I_KLASY.*;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import FUNKCJE_I_KLASY.Miasto;
import FUNKCJE_I_KLASY.ModelTablicyUchodzcow;
import FUNKCJE_I_KLASY.Uchodzca;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WyswietlanieUchodzcowDlaMiasta extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			WyswietlanieUchodzcowDlaMiasta dialog = new WyswietlanieUchodzcowDlaMiasta(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 * @param temp 
	 * @throws Exception 
	 */
	public WyswietlanieUchodzcowDlaMiasta(Miasto _miasto) throws Exception {
		setTitle("Uchodücy zarejestrowani w " + _miasto.getNazwa());
		Funkcje funkcje = new Funkcje();
		setBounds(100, 100, 1000, 436);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 972, 354);
			contentPanel.add(scrollPane);
			{
				table = new JTable();
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		///////////////////////////////
		
		
		
		List<Uchodzca> lista = new ArrayList<Uchodzca>();
		lista = funkcje.getAllUchodzcyZMiasta(_miasto);
		
		ModelTablicyUchodzcow model = new ModelTablicyUchodzcow(lista);
		table.setModel(model);
	}

}
