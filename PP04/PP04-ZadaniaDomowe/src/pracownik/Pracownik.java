package pracownik;

public class Pracownik {
	private int stawka, czasPracyNorm=0, czasPracyExtra=0;

	public Pracownik(int stawka) {
		if (stawka<0) throw new IllegalArgumentException("Ujemna wartość wynagrodzenia");
		this.stawka = stawka;
	}
	
	public void pracuj(int czas) {
		if (czas<0) throw new IllegalArgumentException("Ujemna ilość godzin");
		if (czas>8) {
			czasPracyNorm+=8;
			czasPracyExtra+=(czas-8);
		}else {
			czasPracyNorm+=czas;
		}
	}

	public int wyplata() {
		int doWyplaty = stawka*(czasPracyNorm+2*czasPracyExtra);
		czasPracyExtra=czasPracyNorm=0;
		return doWyplaty;
	}
	

}
