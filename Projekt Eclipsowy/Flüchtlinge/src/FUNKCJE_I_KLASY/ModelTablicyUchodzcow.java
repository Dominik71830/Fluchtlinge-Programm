package FUNKCJE_I_KLASY;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class ModelTablicyUchodzcow extends AbstractTableModel{
	
	Funkcje funkcje;
	
	private static final long serialVersionUID = 1L;
	public static final  int OBJECT_COL =-1;
	public static final  int ID_COL     = -2;
	public static final  int IMIE_COL  = 0;
	public static final  int NAZWISKO_COL  = 1;
	public static final  int DATA_URODZENIA_COL   = 2;
	public static final  int PLEC_COL   = 3;
	public static final  int KRAJ_POCHODZENIA_COL   = 4;
	public static final  int ZASILEK_COL = 5;
	public static final  int PRZYDZIELONE_MIASTO_COL = 6;
	public static final  int DATA_PRZYDZIALU_COL = 7;
	
	private String[] nazwykolumn = {"Imiê", "Nazwisko","Data urodzenia","P³eæ","Kraj pochodzenia","Zasi³ek","Przydzielone miasto","Data przydzia³u"};
	
	private List<Uchodzca> uchodzcy;

	public ModelTablicyUchodzcow(List<Uchodzca> uchodzcy) throws Exception {
		super();
		this.uchodzcy = uchodzcy;
		funkcje = new Funkcje();
	}
	
	@Override
	public int getColumnCount() {
		return nazwykolumn.length;
	}

	@Override
	public int getRowCount() {
		return uchodzcy.size();
	}
	
	public String getColumnName(int _nr) {
		return nazwykolumn[_nr];
	}

	@Override
	public Object getValueAt(int row, int col) {
		Uchodzca temp = uchodzcy.get(row);

		switch (col) {
		case IMIE_COL:
			return temp.getImie();
		case NAZWISKO_COL:
			return temp.getNazwisko();
		case DATA_URODZENIA_COL:
			return temp.getData_urodzenia();
		case PLEC_COL:
			return temp.getPlec();
		case KRAJ_POCHODZENIA_COL:
			return temp.getKraj_pochodzenia();
		case ZASILEK_COL:
			return temp.getZasilek();
		case  PRZYDZIELONE_MIASTO_COL:
			//return temp.getPrzydzielone_miasto();
			try {
				return funkcje.pobierzNazweMiastaDla(temp.getPrzydzielone_miasto());
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e);
			}
		case DATA_PRZYDZIALU_COL:
			return temp.getData_przydzialu();
		case OBJECT_COL:
			return temp;
		default:
			return temp.getNazwisko();
		}
	}
}
