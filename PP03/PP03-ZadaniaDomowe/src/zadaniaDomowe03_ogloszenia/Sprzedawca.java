package zadaniaDomowe03_ogloszenia;

import java.util.Objects;

class Sprzedawca {
	private String imie, nazwisko;
	private long telefon;
	private String ulica, miasto;
	private int kod, nrDomu, nrMieszk;
	
	protected Sprzedawca(String imie, String nazwisko, long telefon, String miasto, int kod, String ulica, int nrDomu,
			int nrMieszk) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.telefon = telefon;
		this.ulica = ulica;
		this.miasto = miasto;
		this.kod = kod;
		this.nrDomu = nrDomu;
		this.nrMieszk = nrMieszk;
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

	protected long getTelefon() {
		return telefon;
	}

	protected void setTelefon(long telefon) {
		this.telefon = telefon;
	}

	protected String getUlica() {
		return ulica;
	}

	protected void setUlica(String ulica) {
		this.ulica = ulica;
	}

	protected String getMiasto() {
		return miasto;
	}

	protected void setMiasto(String miasto) {
		this.miasto = miasto;
	}

	protected int getKod() {
		return kod;
	}

	protected void setKod(int kod) {
		this.kod = kod;
	}

	protected int getNrDomu() {
		return nrDomu;
	}

	protected void setNrDomu(int nrDomu) {
		this.nrDomu = nrDomu;
	}

	protected int getNrMieszk() {
		return nrMieszk;
	}

	protected void setNrMieszk(int nrMieszk) {
		this.nrMieszk = nrMieszk;
	}

	@Override
	public int hashCode() {
		return Objects.hash(imie, kod, miasto, nazwisko, nrDomu, nrMieszk, telefon, ulica);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;	
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sprzedawca other = (Sprzedawca) obj;
		return Objects.equals(imie, other.imie) && kod == other.kod && Objects.equals(miasto, other.miasto)
				&& Objects.equals(nazwisko, other.nazwisko) && nrDomu == other.nrDomu && nrMieszk == other.nrMieszk
				&& telefon == other.telefon && Objects.equals(ulica, other.ulica);
	}

	@Override
	public String toString() {
		return "Imię i Nazwisko: "+ imie + " " + nazwisko +
				"\ntelefon: " + telefon+ 
				"\nAdres:\n" +
				miasto + " " + kod+
				"\n" + ulica + " " + nrDomu + "/" + nrMieszk;
	}
	
	
}

