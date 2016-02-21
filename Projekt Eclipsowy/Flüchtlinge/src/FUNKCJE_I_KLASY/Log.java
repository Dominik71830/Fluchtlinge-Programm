package FUNKCJE_I_KLASY;

import java.util.Date;

public class Log {
	private int id;
	private int id_obiektu;
	private Date data_powstania;
	private String akcja;
	
	
	public Log(int id, int id_obiektu, Date data_powstania, String akcja) {
		super();
		this.id = id;
		this.id_obiektu = id_obiektu;
		this.data_powstania = data_powstania;
		this.akcja = akcja;
	}


	public Log(int id_obiektu, Date data_powstania, String akcja) {
		super();
		this.id_obiektu = id_obiektu;
		this.data_powstania = data_powstania;
		this.akcja = akcja;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getId_obiektu() {
		return id_obiektu;
	}


	public void setId_obiektu(int id_obiektu) {
		this.id_obiektu = id_obiektu;
	}


	public Date getData_powstania() {
		return data_powstania;
	}


	public void setData_powstania(Date data_powstania) {
		this.data_powstania = data_powstania;
	}


	public String getAkcja() {
		return akcja;
	}


	public void setAkcja(String akcja) {
		this.akcja = akcja;
	}


	@Override
	public String toString() {
		return "Log [id=" + id + ", id_obiektu=" + id_obiektu + ", data_powstania=" + data_powstania + ", akcja="
				+ akcja + "]";
	}
	
	
	
	
}
