package GUI;

import FUNKCJE_I_KLASY.*;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;

public class WyszukiwarkaZaawansowana extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldImie;
	private JTextField textFieldNazwisko;
	private JTextField textFieldKrajPochodzenia;
	private JTextField textFieldZasilekOd;
	private JTextField textFieldZasilekDo;
	private JTextField textFieldPrzydzieloneMiasto;
	Funkcje funkcje;
	Double zasilek_do = null;
	Double zasilek_od = null;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WyszukiwarkaZaawansowana dialog = new WyszukiwarkaZaawansowana(null);
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
	 * @param table 
	 * @throws Exception 
	 */
	public WyszukiwarkaZaawansowana(JTable table) throws Exception {
		setTitle("Wyszukiwanie zaawansowane");
		funkcje = new Funkcje();
		
		setBounds(100, 100, 450, 246);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
	
		
		
		JButton btnAnuluj = new JButton("Anuluj");
		btnAnuluj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnAnuluj.setBounds(251, 176, 91, 23);
		getContentPane().add(btnAnuluj);
		
		JLabel lblImi = new JLabel("Imi\u0119");
		lblImi.setBounds(10, 11, 46, 14);
		getContentPane().add(lblImi);
		
		JLabel lblNazwisko = new JLabel("Nazwisko");
		lblNazwisko.setBounds(10, 33, 46, 14);
		getContentPane().add(lblNazwisko);
		
		textFieldImie = new JTextField();
		textFieldImie.setBounds(164, 8, 268, 20);
		getContentPane().add(textFieldImie);
		textFieldImie.setColumns(10);
		
		textFieldNazwisko = new JTextField();
		textFieldNazwisko.setBounds(164, 33, 268, 20);
		getContentPane().add(textFieldNazwisko);
		textFieldNazwisko.setColumns(10);
		
		JLabel lblPe = new JLabel("P\u0142e\u0107");
		lblPe.setBounds(10, 61, 46, 14);
		getContentPane().add(lblPe);
		
		
		String[] listaplci = {"M�czyzna","Kobieta"};
		JComboBox<String> comboBoxPlec = new JComboBox<String>(listaplci);
		comboBoxPlec.setBounds(164, 57, 122, 22);
		getContentPane().add(comboBoxPlec);
		comboBoxPlec.setSelectedItem(null);
		
		
		JLabel lblKrajPochodzenia = new JLabel("Kraj pochodzenia");
		lblKrajPochodzenia.setBounds(10, 85, 105, 14);
		getContentPane().add(lblKrajPochodzenia);
		
		textFieldKrajPochodzenia = new JTextField();
		textFieldKrajPochodzenia.setBounds(164, 82, 268, 20);
		getContentPane().add(textFieldKrajPochodzenia);
		textFieldKrajPochodzenia.setColumns(10);
		
		JLabel lblZasiek = new JLabel("Zasi\u0142ek");
		lblZasiek.setBounds(10, 110, 46, 14);
		getContentPane().add(lblZasiek);
		
		JLabel lblOd = new JLabel("Od:");
		lblOd.setBounds(164, 110, 46, 14);
		getContentPane().add(lblOd);
		
		textFieldZasilekOd = new JTextField();
		textFieldZasilekOd.setBounds(200, 107, 86, 20);
		getContentPane().add(textFieldZasilekOd);
		textFieldZasilekOd.setColumns(10);
		
		JLabel lblDo = new JLabel("Do:");
		lblDo.setBounds(307, 110, 46, 14);
		getContentPane().add(lblDo);
		
		textFieldZasilekDo = new JTextField();
		textFieldZasilekDo.setBounds(346, 107, 86, 20);
		getContentPane().add(textFieldZasilekDo);
		textFieldZasilekDo.setColumns(10);
		
		JLabel lblPrzydzieloneMiasto = new JLabel("Przydzielone miasto");
		lblPrzydzieloneMiasto.setBounds(10, 135, 105, 14);
		getContentPane().add(lblPrzydzieloneMiasto);
		
		textFieldPrzydzieloneMiasto = new JTextField();
		textFieldPrzydzieloneMiasto.setBounds(164, 132, 268, 20);
		getContentPane().add(textFieldPrzydzieloneMiasto);
		textFieldPrzydzieloneMiasto.setColumns(10);
		
		
		JButton btnSzukaj = new JButton("Szukaj");
		btnSzukaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String imie = textFieldImie.getText();
				String nazwisko = textFieldNazwisko.getText();
				String plec = (String) comboBoxPlec.getSelectedItem();
				String kraj_pochodzenia = textFieldKrajPochodzenia.getText();
				if(!textFieldZasilekDo.getText().isEmpty()){
					zasilek_do = Double.parseDouble(textFieldZasilekDo.getText());
				}
				if(!textFieldZasilekOd.getText().isEmpty()){
					zasilek_od = Double.parseDouble(textFieldZasilekOd.getText());
				}
				String  przydzielone_miasto = textFieldPrzydzieloneMiasto.getText();
				
				
				List<Uchodzca> lista = new ArrayList<Uchodzca>();
				try {
					lista = funkcje.getAllUchodzcy();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				
				List<Integer> indexy = new ArrayList<Integer>();
				
			
				if (imie != null && imie.trim().length() > 0) //IMIE
				{ 
					for(Uchodzca u : lista)
					{	
						if(!u.getImie().equals(imie))
						{
							if(!indexy.contains(lista.indexOf(u)))
							indexy.add(lista.indexOf(u));
						}
					}
				}
				
				//JOptionPane.showMessageDialog(null, indexy.toString());
				
				if (nazwisko != null && nazwisko.trim().length() > 0) //NAZWISKO
				{ 
					for(Uchodzca u : lista)
					{	
						if(!u.getNazwisko().equals(nazwisko))
						{
							if(!indexy.contains(lista.indexOf(u)))
							indexy.add(lista.indexOf(u));
						}
					}
				}
				
				//JOptionPane.showMessageDialog(null, indexy.toString());
				
				if (plec != null && plec.trim().length() > 0) //PLEC
				{ 
					for(Uchodzca u : lista)
					{	
						if(!u.getPlec().equals(plec))
						{
							if(!indexy.contains(lista.indexOf(u)))
							indexy.add(lista.indexOf(u));
						}
					}
				}
				
				
				if (kraj_pochodzenia != null && kraj_pochodzenia.trim().length() > 0) //KRAJ_POCHODZENIA
				{ 
					for(Uchodzca u : lista)
					{	
						if(!u.getKraj_pochodzenia().equals(kraj_pochodzenia))
						{
							if(!indexy.contains(lista.indexOf(u)))
							indexy.add(lista.indexOf(u));
						}
					}
				}
				
				
				if (zasilek_do != null ) //ZASILEK_DO
				{ 
					for(Uchodzca u : lista)
					{	
						if(u.getZasilek() > zasilek_do)
						{
							if(!indexy.contains(lista.indexOf(u)))
							indexy.add(lista.indexOf(u));
						}
					}
				}
				
				
				if (zasilek_od != null ) //ZASILEK_OD
				{ 
					for(Uchodzca u : lista)
					{	
						if(u.getZasilek() < zasilek_od)
						{
							if(!indexy.contains(lista.indexOf(u)))
							indexy.add(lista.indexOf(u));
						}
					}
				}
				
				
				if (przydzielone_miasto != null && przydzielone_miasto.trim().length() > 0) //PRZYDZIELONE_MIASTO
				{ 
					for(Uchodzca u : lista)
					{	
						String nazwa_miasta = null;
						try {
							nazwa_miasta = funkcje.pobierzNazweMiastaDla(u.getPrzydzielone_miasto());
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(null, e1);
						}
						if(!nazwa_miasta.equals(przydzielone_miasto))
						{
							if(!indexy.contains(lista.indexOf(u)))
							indexy.add(lista.indexOf(u));
						}
					}
				}
				
				
				
				//JOptionPane.showMessageDialog(null, indexy.toString());
				indexy.sort(null);
				//JOptionPane.showMessageDialog(null, indexy.toString());
				Collections.reverse(indexy);
				
				//JOptionPane.showMessageDialog(null, indexy.toString());
				/////usuwanie z tablicy
				
				for(Integer i : indexy)
				{
					//JOptionPane.showMessageDialog(null, "Usuwam " +lista.get(i).toString() );
					lista.remove(lista.get(i));
				}
				
				//JOptionPane.showMessageDialog(null, "Pozosta�o " + lista.toString());
				
				ModelTablicyUchodzcow model;
				try {
					model = new ModelTablicyUchodzcow(lista);
					table.setModel(model);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				setVisible(false);
				dispose();
			}
		});
		btnSzukaj.setBounds(103, 176, 91, 23);
		getContentPane().add(btnSzukaj);

	}

}
