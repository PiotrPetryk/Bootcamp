package zadaniaDomowe03_ogloszenia;

import java.util.Objects;

public class OgloszenieMieszkaniowe extends Ogloszenie{
		private String miejscowosc;
		private int metraz, liczbaPokoi;
		private TypNieruchomosci typ;
		
		protected OgloszenieMieszkaniowe(String tytul, String opis, Sprzedawca sprzedawca, double cena,
				double stawkaVAT, boolean premium, String miejscowosc, int metraz, int liczbaPokoi,
				TypNieruchomosci typ) {
			super(tytul, opis, sprzedawca, cena, stawkaVAT, premium);
			this.miejscowosc = miejscowosc;
			this.metraz = metraz;
			this.liczbaPokoi = liczbaPokoi;
			this.typ = typ;
		}

		protected String getMiejscowosc() {
			return miejscowosc;
		}

		protected void setMiejscowosc(String miejscowosc) {
			this.miejscowosc = miejscowosc;
		}

		protected int getMetraz() {
			return metraz;
		}

		protected void setMetraz(int metraz) {
			this.metraz = metraz;
		}

		protected int getLiczbaPokoi() {
			return liczbaPokoi;
		}

		protected void setLiczbaPokoi(int liczbaPokoi) {
			this.liczbaPokoi = liczbaPokoi;
		}

		protected TypNieruchomosci getTyp() {
			return typ;
		}

		protected void setTyp(TypNieruchomosci typ) {
			this.typ = typ;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + Objects.hash(liczbaPokoi, metraz, miejscowosc, typ);
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
			OgloszenieMieszkaniowe other = (OgloszenieMieszkaniowe) obj;
			return liczbaPokoi == other.liczbaPokoi && metraz == other.metraz
					&& Objects.equals(miejscowosc, other.miejscowosc) && typ == other.typ;
		}

		@Override
		public String toString() {
			return super.toString()+
					"\nSzczegóły nieruchomości:"+
					"\nMiejscowość: " + miejscowosc + 
					"\nMetraż: " + metraz + 
					"\nLiczba Pokoi: " + liczbaPokoi + 
					"\nTyp=" + typ;
		}
		
		
		
}
