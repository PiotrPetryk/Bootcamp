package zadaniaDomowe03_ogloszenia;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

class Ogloszenie {
	private String tytul, opis;
	private Sprzedawca sprzedawca;
	private BigDecimal cena, stawkaVAT=BigDecimal.valueOf(0.23);
	private boolean premium=false;
	
	protected Ogloszenie(String tytul, String opis, Sprzedawca sprzedawca, double cena, double stawkaVAT,
			boolean premium) {
		this.tytul = tytul;
		this.opis = opis;
		this.sprzedawca = sprzedawca;
		this.cena = BigDecimal.valueOf(cena);
		this.stawkaVAT = BigDecimal.valueOf(stawkaVAT);
		this.premium = premium;
	}

	protected String getTytul() {
		return tytul;
	}

	protected void setTytul(String tytul) {
		this.tytul = tytul;
	}

	protected String getOpis() {
		return opis;
	}

	protected void setOpis(String opis) {
		this.opis = opis;
	}

	protected Sprzedawca getSprzedawca() {
		return sprzedawca;
	}

	protected void setSprzedawca(Sprzedawca sprzedawca) {
		this.sprzedawca = sprzedawca;
	}

	protected BigDecimal getCena() {
		return cena;
	}

	protected void setCena(BigDecimal cena) {
		this.cena = cena;
	}

	protected BigDecimal getStawkaVAT() {
		return stawkaVAT;
	}

	protected void setStawkaVAT(BigDecimal stawkaVAT) {
		this.stawkaVAT = stawkaVAT;
	}

	protected boolean isPremium() {
		return premium;
	}

	protected void setPremium(boolean premium) {
		this.premium = premium;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cena, opis, premium, sprzedawca, stawkaVAT, tytul);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ogloszenie other = (Ogloszenie) obj;
		return Objects.equals(cena, other.cena) && Objects.equals(opis, other.opis) && premium == other.premium
				&& Objects.equals(sprzedawca, other.sprzedawca) && Objects.equals(stawkaVAT, other.stawkaVAT)
				&& Objects.equals(tytul, other.tytul);
	}

	@Override
	public String toString() {
		return "Ogłoszenie: \"" + tytul + "\""+
				"\nOpis: " + opis + 
				"\nCena: " + String.format("%.2f",cena) + ", stawkaVAT: " + String.format("%.2f",stawkaVAT) +
				//"\nCena netto: " + String.format("%.2f", cena.divide(stawkaVAT.add(BigDecimal.ONE)))+
				"\nCena netto: " + cena.divide(stawkaVAT.add(BigDecimal.ONE), 2 ,RoundingMode.HALF_UP)+
				"\nSprzedawca:\n" + sprzedawca;
	}
	
		
	
}
