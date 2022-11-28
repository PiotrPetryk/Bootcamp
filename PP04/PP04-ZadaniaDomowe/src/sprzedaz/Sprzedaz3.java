package sprzedaz;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Sprzedaz3 {
	
	public static void sumaTransakcjiZMiast(List<Transakcja> transakcje){
		Map<String, BigDecimal> miasta = new TreeMap<>();
		
		for (Transakcja transakcja : transakcje) {
			miasta.merge(transakcja.getMiasto(), transakcja.getCena().multiply(BigDecimal.valueOf(transakcja.getSztuk())), BigDecimal::add);
		}
		
		Set<String> klucze = miasta.keySet();
		
		for (String klucz : klucze) {
			System.out.println(klucz+" - "+miasta.get(klucz));
		}
		
	}

	public static void main(String[] args) {
				
		List<Transakcja> transakcje = ObslugaCSV.wczytaj();
		System.out.println("Odczytano " + transakcje.size() + " rekordów");
		if (transakcje.size()==0) return;

		sumaTransakcjiZMiast(transakcje);
	}

}
