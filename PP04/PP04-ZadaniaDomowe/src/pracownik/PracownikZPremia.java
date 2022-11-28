package pracownik;

public class PracownikZPremia extends Pracownik{

	private int premia;
	
	public PracownikZPremia(int stawka) {
		super(stawka);
	}
	
	public void premia(int kwota) {
		if (kwota<0) throw new IllegalArgumentException("Ujemna wartość premii");
		premia+=kwota;
	}
	
	@Override
	public int wyplata() {
		int doWyplaty = premia;
		premia =0;
		return super.wyplata()+doWyplaty;
	}
}
