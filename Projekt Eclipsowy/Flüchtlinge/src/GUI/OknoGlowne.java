package GUI;

import FUNKCJE_I_KLASY.*;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import FUNKCJE_I_KLASY.Funkcje;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class OknoGlowne extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	Funkcje funkcje;
	boolean updatemode = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OknoGlowne frame = new OknoGlowne();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public OknoGlowne() throws Exception {
		setTitle("Fl\u00FCchtlinge");
		funkcje = new Funkcje();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(308, 11, 344, 387);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnZarejestrujUchodc = new JButton("Zarejestruj uchod\u017Ac\u0119");
		btnZarejestrujUchodc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RejestracjaUchodzcyPodstawoweDane okno;
				try {
					okno = new RejestracjaUchodzcyPodstawoweDane(null,updatemode,null,table);
					okno.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnZarejestrujUchodc.setBounds(10, 11, 288, 23);
		contentPane.add(btnZarejestrujUchodc);
		
		JButton btnWywietlPrzydzielonychUchodcw = new JButton("Wy\u015Bwietl przydzielonych uchod\u017Ac\u00F3w");
		btnWywietlPrzydzielonychUchodcw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				
				if (row < 0) {
					JOptionPane.showMessageDialog(null, "Zaznacz miasto");				
					return;
				}
				
				
				Miasto temp = (Miasto) table.getValueAt(row, ModelTablicyMiast.OBJECT_COL);
				
				WyswietlanieUchodzcowDlaMiasta okno;
				try {
					okno = new WyswietlanieUchodzcowDlaMiasta(temp);
					okno.setVisible(true);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		btnWywietlPrzydzielonychUchodcw.setBounds(10, 79, 288, 23);
		contentPane.add(btnWywietlPrzydzielonychUchodcw);
		
		JButton btnWyzerujLiczbUchodcw = new JButton("Wyzeruj liczb\u0119 uchod\u017Ac\u00F3w");
		btnWyzerujLiczbUchodcw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				
				if (row < 0) {
					JOptionPane.showMessageDialog(null, "Zaznacz miasto");				
					return;
				}
				
				
				Miasto temp = (Miasto) table.getValueAt(row, ModelTablicyMiast.OBJECT_COL);
				
				try {
					funkcje.wyzeruj(temp);
					funkcje.odswiezMiasta(table);
					JOptionPane.showMessageDialog(null,"Wyzerowano");
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e);
				}
				
				

			}
		});
		btnWyzerujLiczbUchodcw.setBounds(10, 113, 288, 23);
		contentPane.add(btnWyzerujLiczbUchodcw);
		////////////////////////
		List<Miasto> lista = new ArrayList<Miasto>();
		lista = funkcje.getAllMiasta();
		
		ModelTablicyMiast model = new ModelTablicyMiast(lista);
		table.setModel(model);
		
		JButton btnNewButton = new JButton("Wyszukiwarka uchod\u017Ac\u00F3w");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WyszukiwarkaUchodzcow okno;
				try {
					okno = new WyszukiwarkaUchodzcow(table);
					okno.setVisible(true);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		btnNewButton.setBounds(10, 45, 288, 23);
		contentPane.add(btnNewButton);
		
		JButton btnWyjd = new JButton("Wyjd\u017A");
		btnWyjd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnWyjd.setBounds(10, 375, 288, 23);
		contentPane.add(btnWyjd);
		
		
		
		
		
	}
}
