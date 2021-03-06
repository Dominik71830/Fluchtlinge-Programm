package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import FUNKCJE_I_KLASY.Funkcje;
import FUNKCJE_I_KLASY.Uchodzca;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class RejestracjaUchodzcyPodstawoweDane extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldDD;
	private JTextField textFieldMM;
	private JTextField textFieldRRRR;
	private JTextField textFieldImie;
	private JTextField textFieldNazwisko;
	private JTextField textFieldKrajPochodzenia;
	Funkcje funkcje;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			RejestracjaUchodzcyPodstawoweDane dialog = new RejestracjaUchodzcyPodstawoweDane(null, false,null,null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 * @param updatemode 
	 * @param temp 
	 * @param table 
	 * @param table2 
	 * @throws Exception 
	 */
	public RejestracjaUchodzcyPodstawoweDane(Uchodzca temp, boolean updatemode, JTable table, JTable tabelazmiastami) throws Exception {
		funkcje = new Funkcje();
		
		
		
		setTitle("Rejestracja - Podstawowe dane");
		setBounds(100, 100, 450, 229);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblImi = new JLabel("Imi\u0119");
		lblImi.setBounds(10, 11, 46, 14);
		contentPanel.add(lblImi);
		{
			JLabel lblNazwisko = new JLabel("Nazwisko");
			lblNazwisko.setBounds(10, 36, 81, 14);
			contentPanel.add(lblNazwisko);
		}
		{
			JLabel lblDataUrodzenia = new JLabel("Data urodzenia");
			lblDataUrodzenia.setBounds(10, 61, 110, 14);
			contentPanel.add(lblDataUrodzenia);
		}
		{
			JLabel lblPe = new JLabel("P\u0142e\u0107");
			lblPe.setBounds(10, 86, 46, 14);
			contentPanel.add(lblPe);
		}
		{
			JLabel lblKrajPochodzenia = new JLabel("Kraj pochodzenia");
			lblKrajPochodzenia.setBounds(10, 111, 110, 14);
			contentPanel.add(lblKrajPochodzenia);
		}
		{
			JLabel lblDd = new JLabel("DD");
			lblDd.setBounds(148, 61, 20, 14);
			contentPanel.add(lblDd);
		}
		
		textFieldDD = new JTextField();
		textFieldDD.setBounds(178, 58, 20, 20);
		contentPanel.add(textFieldDD);
		textFieldDD.setColumns(10);
		
		JLabel lblMm = new JLabel("MM");
		lblMm.setBounds(208, 61, 20, 14);
		contentPanel.add(lblMm);
		
		textFieldMM = new JTextField();
		textFieldMM.setBounds(238, 58, 20, 20);
		contentPanel.add(textFieldMM);
		textFieldMM.setColumns(10);
		{
			JLabel lblRrrr = new JLabel("RRRR");
			lblRrrr.setBounds(268, 61, 34, 14);
			contentPanel.add(lblRrrr);
		}
		{
			textFieldRRRR = new JTextField();
			textFieldRRRR.setBounds(310, 58, 34, 20);
			contentPanel.add(textFieldRRRR);
			textFieldRRRR.setColumns(10);
		}
		{
			textFieldImie = new JTextField();
			textFieldImie.setBounds(147, 8, 285, 20);
			contentPanel.add(textFieldImie);
			textFieldImie.setColumns(10);
		}
		{
			textFieldNazwisko = new JTextField();
			textFieldNazwisko.setBounds(147, 33, 285, 20);
			contentPanel.add(textFieldNazwisko);
			textFieldNazwisko.setColumns(10);
		}
		{
			textFieldKrajPochodzenia = new JTextField();
			textFieldKrajPochodzenia.setBounds(147, 108, 288, 20);
			contentPanel.add(textFieldKrajPochodzenia);
			textFieldKrajPochodzenia.setColumns(10);
		}
		
		String[] listaplci = {"M�czyzna","Kobieta"};
		JComboBox<String> comboBoxPlec = new JComboBox<String>(listaplci);
		comboBoxPlec.setBounds(147, 82, 157, 22);
		contentPanel.add(comboBoxPlec);
		{
			JButton okButton = new JButton("Dalej");
			okButton.setBounds(271, 157, 73, 23);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//zebranie danych
					String imie = textFieldImie.getText();
					String nazwisko = textFieldNazwisko.getText();
					String dd = textFieldDD.getText();
					String mm = textFieldMM.getText();
					String rrrr = textFieldRRRR.getText();
					String plec = (String) comboBoxPlec.getSelectedItem();
					String kraj_pochodzenia = textFieldKrajPochodzenia.getText();
					//int intdd = Integer.parseInt(dd);
					//int intmm = Integer.parseInt(mm);
					//int intrrrr = Integer.parseInt(rrrr);
					
					
					///////////////////////////////IDIOTOODPORNOSC
					if (	imie.trim().length() 				!= 0
							&&
							nazwisko.trim().length() 			!= 0
							&&
							dd.trim().length() 					<= 2
							&&
							Integer.parseInt(dd) >=1 && Integer.parseInt(dd) <=31
							&&
							mm.trim().length() 					<= 2
							&&
							Integer.parseInt(mm) >=1 && Integer.parseInt(mm) <=12
							&&
							rrrr.trim().length()				== 4
							&&
							Integer.parseInt(rrrr) >=1900 && Integer.parseInt(rrrr) <=2016
							&&
							plec.trim().length() 				!= 0
							&&
							kraj_pochodzenia.trim().length()	!= 0	)
					{
						//zrobienie daty
						if(dd.trim().length()==1){dd = '0'+dd;}
						if(mm.trim().length()==1){mm = '0'+mm;}
						String data_urodzenia= rrrr+'-'+mm+'-'+dd;	  
					
					Uchodzca uchodzca;
					uchodzca = new Uchodzca(imie, nazwisko,data_urodzenia , plec, kraj_pochodzenia);
					
					if(!updatemode)
					{
					////////////////////////////////////////przej�cie do nast�pnego okna
					RejestracjaUchodzcyZasilekiMiasto okno;
					try {
						okno = new RejestracjaUchodzcyZasilekiMiasto(uchodzca,updatemode,null,tabelazmiastami);
						okno.setVisible(true);
						setVisible(false);
						dispose();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1);
					}
					
				}
				//tu sie konczy if
				
				if(updatemode)
				{
					Uchodzca nowy = temp;
					nowy.setImie(imie);
					nowy.setNazwisko(nazwisko);
					nowy.setData_urodzenia(data_urodzenia);
					nowy.setPlec(plec);
					nowy.setKraj_pochodzenia(kraj_pochodzenia);
					
					//JOptionPane.showMessageDialog(null, nowy.toString());
					RejestracjaUchodzcyZasilekiMiasto okno;
					try {
						okno = new RejestracjaUchodzcyZasilekiMiasto(nowy,updatemode,table,tabelazmiastami);
						okno.setVisible(true);
						setVisible(false);
						dispose();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1);
					}
				}
				
				
				}
					else
					{
						JOptionPane.showMessageDialog(null, "Prosz� uzupe�ni� poprawnie wszystkie pola");
					}
				
					}
						
					
					///////////////////////////////
					
					
					
					
				
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Anuluj");
			cancelButton.setBounds(351, 157, 81, 23);
			contentPanel.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
		//comboBoxPlec.setSelectedItem(null);
		
		
		if(updatemode)
		{
			textFieldImie.setText(temp.getImie());
			textFieldNazwisko.setText(temp.getNazwisko());
			textFieldDD.setText(temp.getData_urodzenia().substring(8,10));
			textFieldMM.setText(temp.getData_urodzenia().substring(5, 7));
			textFieldRRRR.setText(temp.getData_urodzenia().substring(0, 4));
			textFieldKrajPochodzenia.setText(temp.getKraj_pochodzenia());
			comboBoxPlec.setSelectedItem(temp.getPlec());
			
			
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
