package FUNKCJE_I_KLASY;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ModelTablicyMiast extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	public static final  int OBJECT_COL =-1;
	public static final  int ID_COL     = -2;
	public static final  int NAZWA_COL  = 0;
	public static final  int KOD_POCZTOWY_COL  = 1;
	public static final  int LICZBA_UCHODZCOW_COL = 2;
	
	private String[] nazwykolumn = {"Nazwa", "Kod pocztowy","Liczba uchodŸców"};
	
	private List<Miasto> miasta;

	public ModelTablicyMiast(List<Miasto> miasta) {
		super();
		this.miasta = miasta;
	}
	
	@Override
	public int getColumnCount() {
		return nazwykolumn.length;
	}
	
	@Override
	public int getRowCount() {
		return miasta.size();
	}
	
	public String getColumnName(int _nr) {
		return nazwykolumn[_nr];
	}

	@Override
	public Object getValueAt(int row, int col) {
		Miasto temp = miasta.get(row);

		switch (col) {
		case NAZWA_COL:
			return temp.getNazwa();
		case KOD_POCZTOWY_COL:
			return temp.getKod_pocztowy();
		case LICZBA_UCHODZCOW_COL:
			return temp.getLiczba_uchodzcow();
		case OBJECT_COL:
			return temp;
		default:
			return temp.getNazwa();
		}
	}

	
}