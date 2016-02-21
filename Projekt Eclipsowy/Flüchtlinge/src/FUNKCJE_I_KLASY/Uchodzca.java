package FUNKCJE_I_KLASY;

import java.util.Date;

public class Uchodzca {
	private int id;
	private String imie;
	private String nazwisko;
	private String data_urodzenia;
	private String plec;
	private String kraj_pochodzenia;
	private Double zasilek;
	private int przydzielone_miasto;
	private Date data_przydzialu;
	
	public Uchodzca(int id, String imie, String nazwisko, String data_urodzenia2, String plec, String kraj_pochodzenia,
			Double zasilek, int przydzielone_miasto,Date data_przydzia³u) {
		super();
		this.id = id;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.data_urodzenia = data_urodzenia2;
		this.plec = plec;
		this.kraj_pochodzenia = kraj_pochodzenia;
		this.zasilek = zasilek;
		this.przydzielone_miasto = przydzielone_miasto;
		this.data_przydzialu = data_przydzia³u;
	}

	
	
	public Uchodzca(String imie, String nazwisko, String timestamp, String plec, String kraj_pochodzenia) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.data_urodzenia = timestamp;
		this.plec = plec;
		this.kraj_pochodzenia = kraj_pochodzenia;
	}



	public Uchodzca(String imie, String nazwisko, String data_urodzenia, String plec, String kraj_pochodzenia,
			Double zasilek, int przydzielone_miasto,Date data_przydzia³u) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.data_urodzenia = data_urodzenia;
		this.plec = plec;
		this.kraj_pochodzenia = kraj_pochodzenia;
		this.zasilek = zasilek;
		this.przydzielone_miasto = przydzielone_miasto;
		this.data_przydzialu = data_przydzia³u;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public Date getData_przydzialu() {
		return  data_przydzialu;
	}

	public void setData_przydzialu(Date data_przydzia³u) {
		this.data_przydzialu = data_przydzia³u;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getData_urodzenia() {
		return data_urodzenia;
	}

	public void setData_urodzenia(String data_urodzenia) {
		this.data_urodzenia = data_urodzenia;
	}

	public String getPlec() {
		return plec;
	}

	public void setPlec(String plec) {
		this.plec = plec;
	}

	public String getKraj_pochodzenia() {
		return kraj_pochodzenia;
	}

	public void setKraj_pochodzenia(String kraj_pochodzenia) {
		this.kraj_pochodzenia = kraj_pochodzenia;
	}

	public Double getZasilek() {
		return zasilek;
	}

	public void setZasilek(Double zasilek) {
		this.zasilek = zasilek;
	}

	public int getPrzydzielone_miasto() {
		return przydzielone_miasto;
	}

	public void setPrzydzielone_miasto(int przydzielone_miasto) {
		this.przydzielone_miasto = przydzielone_miasto;
	}

	@Override
	public String toString() {
		/*return "Uchodzca [id=" + id + ", imie=" + imie + ", nazwisko=" + nazwisko + ", data_urodzenia=" + data_urodzenia
				+ ", plec=" + plec + ", kraj_pochodzenia=" + kraj_pochodzenia + ", zasilek=" + zasilek
				+ ", przydzielone_miasto=" + przydzielone_miasto + "]";*/
		return imie;
	}
	
	
	
}
