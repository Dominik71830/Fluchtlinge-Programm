package GUI;

import java.awt.BorderLayout;
import java.awt.Color;

import FUNKCJE_I_KLASY.*;
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RejestracjaUchodzcyZasilekiMiasto extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	Funkcje funkcje;
	JComboBox<Double> comboBoxZasilek=null;
	JComboBox<Miasto> comboBoxMiasto = null;
	JButton btnNewButtonKolorki =  null;
	
	//private JComboBox<Double> comboBoxZasilek;
	//private JComboBox<Miasto> comboBoxMiasto;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			RejestracjaUchodzcyZasilekiMiasto dialog = new RejestracjaUchodzcyZasilekiMiasto(null,(Boolean) null,null,null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 * @param uchodzca 
	 * @param updatemode 
	 * @param table 
	 * @param tabelazmiastami 
	 * @throws Exception 
	 */
	public RejestracjaUchodzcyZasilekiMiasto(Uchodzca uchodzca, boolean updatemode, JTable table, JTable tabelazmiastami) throws Exception {
		setTitle("Rejestracja - zasi\u0142ek i przydzielone miasto");
		funkcje = new Funkcje();
		
		
		
		JButton btnNewButtonKolorki = new JButton("");
		btnNewButtonKolorki.setEnabled(false);
		btnNewButtonKolorki.setBounds(686, 36, 22, 22);
		contentPanel.add(btnNewButtonKolorki);
		
		
		setBounds(100, 100, 726, 156);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			JLabel lblWysokoZasiku = new JLabel("Wysoko\u015B\u0107 zasi\u0142ku (\u20AC)");
			lblWysokoZasiku.setBounds(10, 11, 138, 14);
			contentPanel.add(lblWysokoZasiku);
		}
		{
			JLabel lblPrzyznaneMiasto = new JLabel("Przyznane miasto");
			lblPrzyznaneMiasto.setBounds(382, 11, 138, 14);
			contentPanel.add(lblPrzyznaneMiasto);
		}
		{
			Double[] zasilki = {500.0,600.0,700.0,800.0,900.0,1000.0,1100.0,1200.0,1300.0};
			comboBoxZasilek = new JComboBox<Double>(zasilki);
			comboBoxZasilek.setBounds(10, 36, 301, 22);
			contentPanel.add(comboBoxZasilek);
		}
		{
			comboBoxMiasto = new JComboBox<Miasto>();
			comboBoxMiasto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Miasto temp = (Miasto) comboBoxMiasto.getSelectedItem();
					if(temp.isCzy_przyjmuje())
					{
						btnNewButtonKolorki.setBackground(Color.GREEN);
					}
					else
					{
						btnNewButtonKolorki.setBackground(Color.RED);
					}
				}
			});
			comboBoxMiasto.setBounds(382, 36, 294, 22);
			contentPanel.add(comboBoxMiasto);
			funkcje.wypelnijComboboxaMiastami(comboBoxMiasto);
		}
		
		
		
		if(updatemode)
		{//JOptionPane.showMessageDialog(null, uchodzca.getPrzydzielone_miasto());
			if(uchodzca.getPrzydzielone_miasto()!=0)
			{
				Miasto temp = funkcje.getMiasto(uchodzca.getPrzydzielone_miasto());
				//JOptionPane.showMessageDialog(null,temp.getId());
				comboBoxMiasto.setSelectedIndex(temp.getId()-1);
			}
			comboBoxZasilek.setSelectedItem(uchodzca.getZasilek());	
		}
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Zarejestruj");
				if(updatemode)
				okButton.setText("Uaktualnij");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {//JOptionPane.showMessageDialog(null, uchodzca.toString());
						//zebranie danych
						Miasto stare_miasto = null;
						Date data_przydzialu = new Timestamp(System.currentTimeMillis());
						Double zasilek = (Double) comboBoxZasilek.getSelectedItem();
						Miasto przydzielone_miasto = (Miasto) comboBoxMiasto.getSelectedItem();
						
						try {
							stare_miasto = funkcje.getMiasto(uchodzca.getPrzydzielone_miasto());
						} catch (SQLException e2) {
							JOptionPane.showMessageDialog(null, e2);
						}
						
						int id_miasta = przydzielone_miasto.getId();
						
						if(przydzielone_miasto.isCzy_przyjmuje())
						{
						//zmodyfikowanie uchodzcy
						uchodzca.setData_przydzialu(data_przydzialu);
						uchodzca.setZasilek(zasilek);
						uchodzca.setPrzydzielone_miasto(id_miasta);
						
						if(!updatemode)
						{
						try {
							funkcje.addUchodzca(uchodzca);
							funkcje.ustawIloscMiejscWMiescie(przydzielone_miasto,przydzielone_miasto.getLiczba_uchodzcow()+1);
							funkcje.odswiezMiasta(tabelazmiastami);
							funkcje.odswiezUchodzcow(table);
							JOptionPane.showMessageDialog(null, "Uchod�ca zarejestrowany");
							setVisible(false);
							dispose();
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, e1);
						}
						}
						
						if(updatemode)
						{
						try {
							funkcje.updateUchodzca(uchodzca);
							
							
							if(stare_miasto==null)
							{
								funkcje.ustawIloscMiejscWMiescie(przydzielone_miasto,przydzielone_miasto.getLiczba_uchodzcow()+1);
								//JOptionPane.showMessageDialog(null, "stare jest nullem");
							}
					
							else if(stare_miasto!= null && stare_miasto.getId() != przydzielone_miasto.getId())
							{
								funkcje.ustawIloscMiejscWMiescie(stare_miasto,stare_miasto.getLiczba_uchodzcow()-1);
								funkcje.ustawIloscMiejscWMiescie(przydzielone_miasto,przydzielone_miasto.getLiczba_uchodzcow()+1);
								//JOptionPane.showMessageDialog(null, "dwa r�ne");
							}
							else if (stare_miasto!= null && stare_miasto.getId()==przydzielone_miasto.getId())
							{
								//JOptionPane.showMessageDialog(null, "te same miasta");
							}
							
							
							
							
							funkcje.odswiezMiasta(tabelazmiastami);
							funkcje.odswiezUchodzcow(table);
							JOptionPane.showMessageDialog(null, "Dane uchod�cy zauktualizowane");
							
							
							
							setVisible(false);
							dispose();
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, e1);
						}
						}
						
						
						}
						
						else
						{
							JOptionPane.showMessageDialog(null, "Wybrane miasto nie przyjmuje w tej chwili nowych os�b. Prosz� wybra� inne.");
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Anuluj");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
