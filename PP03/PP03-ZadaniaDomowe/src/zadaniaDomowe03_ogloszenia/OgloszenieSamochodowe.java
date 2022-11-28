package zadaniaDomowe03_ogloszenia;

import java.util.Objects;

public class OgloszenieSamochodowe extends Ogloszenie{
	private String marka, model, kolor;
	private int rokProd, przebieg, moc;
	private double pojemnosc;
	private Paliwo paliwo;
	
	protected OgloszenieSamochodowe(String tytul, String opis, Sprzedawca sprzedawca, double cena,
			double stawkaVAT, boolean premium, String marka, String model, String kolor, int rokProd, int przebieg,
			int moc, double pojemnosc, Paliwo paliwo) {
		super(tytul, opis, sprzedawca, cena, stawkaVAT, premium);
		this.marka = marka;
		this.model = model;
		this.kolor = kolor;
		this.rokProd = rokProd;
		this.przebieg = przebieg;
		this.moc = moc;
		this.pojemnosc = pojemnosc;
		this.paliwo = paliwo;
	}

	protected String getMarka() {
		return marka;
	}

	protected void setMarka(String marka) {
		this.marka = marka;
	}

	protected String getModel() {
		return model;
	}

	protected void setModel(String model) {
		this.model = model;
	}

	protected String getKolor() {
		return kolor;
	}

	protected void setKolor(String kolor) {
		this.kolor = kolor;
	}

	protected int getRokProd() {
		return rokProd;
	}

	protected void setRokProd(int rokProd) {
		this.rokProd = rokProd;
	}

	protected int getPrzebieg() {
		return przebieg;
	}

	protected void setPrzebieg(int przebieg) {
		this.przebieg = przebieg;
	}

	protected int getMoc() {
		return moc;
	}

	protected void setMoc(int moc) {
		this.moc = moc;
	}

	protected double getPojemnosc() {
		return pojemnosc;
	}

	protected void setPojemnosc(double pojemnosc) {
		this.pojemnosc = pojemnosc;
	}

	protected Paliwo getPaliwo() {
		return paliwo;
	}

	protected void setPaliwo(Paliwo paliwo) {
		this.paliwo = paliwo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(kolor, marka, moc, model, paliwo, pojemnosc, przebieg, rokProd);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		OgloszenieSamochodowe other = (OgloszenieSamochodowe) obj;
		return Objects.equals(kolor, other.kolor) && Objects.equals(marka, other.marka) && moc == other.moc
				&& Objects.equals(model, other.model) && paliwo == other.paliwo
				&& Double.doubleToLongBits(pojemnosc) == Double.doubleToLongBits(other.pojemnosc)
				&& przebieg == other.przebieg && rokProd == other.rokProd;
	}

	@Override
	public String toString() {
		return super.toString()+
				"\nSzczegóły pojazdu: \n" + 
				"Marka: "+ marka + ", Model: " + model + 
				"\nKolor: " + kolor + 
				"\nRok produkcji: " + rokProd + 
				"\nPrzebieg: " + przebieg + 
				"\nMoc: " + moc + ", Pojemność: " + pojemnosc + ", paliwo: "+ paliwo;
	}
	
	
	
	

}
