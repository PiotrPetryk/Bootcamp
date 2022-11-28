package zadaniaDomowe03_zawodnicy;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Zawodnik {
	private String imie, nazwisko, kraj;
	private LocalDate dzienUrodzenia;
	private int wzrost, waga;
	private static Set<String> kraje = new HashSet<>();
	
	protected Zawodnik(String imie, String nazwisko, String kraj, LocalDate dzienUrodzenia, int wzrost, int waga) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.kraj = kraj;
		kraje.add(kraj);
		this.dzienUrodzenia = dzienUrodzenia;
		this.wzrost = wzrost;
		this.waga = waga;
	}

	protected String getImie() {
		return imie;
	}

	protected void setImie(String imie) {
		this.imie = imie;
	}

	protected String getNazwisko() {
		return nazwisko;
	}

	protected void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	
	protected String getKraj() {
		return kraj;
	}
	
	protected void setKraj(String kraj) {
		this.kraj = kraj;
		kraje.add(kraj);
	}

	protected LocalDate getDzienUrodzenia() {
		return dzienUrodzenia;
	}

	protected void setDzienUrodzenia(LocalDate dzienUrodzenia) {
		this.dzienUrodzenia = dzienUrodzenia;
	}

	protected int getWzrost() {
		return wzrost;
	}

	protected void setWzrost(int wzrost) {
		this.wzrost = wzrost;
	}

	protected int getWaga() {
		return waga;
	}

	protected void setWaga(int waga) {
		this.waga = waga;
	}

	protected static Set<String> getKraje() {
		return kraje;
	}
	
	

}
