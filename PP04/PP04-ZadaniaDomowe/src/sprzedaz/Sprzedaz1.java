package sprzedaz;

import java.math.BigDecimal;
import java.util.List;

public class Sprzedaz1 {
	
	public static BigDecimal wartoscWszystkichTransakcji(List<Transakcja> transakcje) {
		BigDecimal wartosc=BigDecimal.ZERO;
		for (Transakcja transakcja : transakcje) {
			wartosc=wartosc.add(transakcja.getCena().multiply(BigDecimal.valueOf(transakcja.getSztuk())));
		}
		return wartosc;
	}

	public static void main(String[] args) {
		
		List<Transakcja> transakcje = ObslugaCSV.wczytaj();
		System.out.println("Odczytano " + transakcje.size() + " rekordów");
		
		System.out.println(wartoscWszystkichTransakcji(transakcje));
	}

}
