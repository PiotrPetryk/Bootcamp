package sprzedaz;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JOptionPane;

public class Sprzedaz2 {
	
	public static void statystykaTransakcjiDlaMiasta(List<Transakcja> transakcje, String miasto) {
		int ilosc =0;
		BigDecimal min=transakcje.get(0).getCena().multiply(BigDecimal.valueOf(transakcje.get(0).getSztuk()));
		BigDecimal max=min;
		BigDecimal suma=BigDecimal.ZERO;
		for (Transakcja transakcja : transakcje) {
			if (miasto.equals(transakcja.getMiasto())) {
				ilosc++;
				BigDecimal wartosc = transakcja.getCena().multiply(BigDecimal.valueOf(transakcja.getSztuk()));
				min = (wartosc.compareTo(min)==-1)? wartosc : min;
				max = (wartosc.compareTo(max)==1)? wartosc : max;
				suma=suma.add(wartosc);
			}
		}
		BigDecimal srednia=suma.divide(BigDecimal.valueOf(ilosc), 2, RoundingMode.HALF_UP);
		JOptionPane.showMessageDialog(null, String.format("W mieście %s wykonano:\n"
				+ "transakcji: %d\nna kwotę: %.2f\nwartość najniższa: %.2f\nwartość najwyższa: %.2f\nwartość średnia: %.2f",
				miasto, ilosc, suma, min, max, srednia));
	}

	public static void main(String[] args) {
		
		Set <String> katTowaru = new TreeSet<>();
		Set <String> miasta = new TreeSet<>();
		
		List<Transakcja> transakcje = ObslugaCSV.wczytaj();
		System.out.println("Odczytano " + transakcje.size() + " rekordów");
		if (transakcje.size()==0) return;
		for (Transakcja transakcja : transakcje) {
			katTowaru.add(transakcja.getKategoria());
			miasta.add(transakcja.getMiasto());
		}
		
		String wybor = (String) JOptionPane.showInputDialog(null,
			"Wybierz miasto dla jakiego chcesz wyświetlić dane: ", "Wybór",
			JOptionPane.QUESTION_MESSAGE, null, miasta.toArray(), miasta.toArray()[0]);
		
		if (!wybor.isEmpty()) {
			statystykaTransakcjiDlaMiasta(transakcje, wybor);
		}
	}

}
