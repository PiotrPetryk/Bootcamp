package sprzedaz;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Transakcja {
	private int id;
	private LocalDate data;
	private String miasto, sklep, kategoria, towar;
	private BigDecimal cena;
	private int sztuk;
	
	public Transakcja(int id, LocalDate data, String miasto, String sklep, String kategoria, String towar,
			BigDecimal cena, int sztuk) {
		this.id = id;
		this.data = data;
		this.miasto = miasto;
		this.sklep = sklep;
		this.kategoria = kategoria;
		this.towar = towar;
		this.cena = cena;
		this.sztuk = sztuk;
	}

	public int getId() {
		return id;
	}

	public LocalDate getData() {
		return data;
	}

	public String getMiasto() {
		return miasto;
	}

	public String getSklep() {
		return sklep;
	}

	public String getKategoria() {
		return kategoria;
	}

	public String getTowar() {
		return towar;
	}

	public BigDecimal getCena() {
		return cena;
	}

	public int getSztuk() {
		return sztuk;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cena, data, id, kategoria, miasto, sklep, sztuk, towar);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transakcja other = (Transakcja) obj;
		return Objects.equals(cena, other.cena) && Objects.equals(data, other.data) && id == other.id
				&& Objects.equals(kategoria, other.kategoria) && Objects.equals(miasto, other.miasto)
				&& Objects.equals(sklep, other.sklep) && sztuk == other.sztuk && Objects.equals(towar, other.towar);
	}

	public String toStringtoFile() {
		return (id + ";" + data + ";" + miasto + ";" + sklep + ";"	+ kategoria + ";" + towar + ";" + cena + ";" + sztuk);
	}

	 
	
}