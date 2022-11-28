package sprzedaz;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JOptionPane;

public class FiltrowanieSprzedazy {
	
	public static List<Transakcja> filtrujTransakcje(List<Transakcja> transakcje, String kategoria) {
		List<Transakcja> wyfiltrowane = new ArrayList<>();
		int ilosc=0;
		for (Transakcja transakcja : transakcje) {
			if (kategoria.equals(transakcja.getKategoria())) {
				ilosc++;
				wyfiltrowane.add(transakcja);
			}
		}
		JOptionPane.showMessageDialog(null, "Wyfiltrowano "+ ilosc + " transakcji.");
		return wyfiltrowane;
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
			"Wybierz kategorię towaru dlajakiej chcesz odfiltrować dane: ", "Wybór",
			JOptionPane.QUESTION_MESSAGE, null, katTowaru.toArray(), katTowaru.toArray()[0]);
		
		if (wybor!=null) {
			
			ObslugaCSV.zapisz(filtrujTransakcje(transakcje, wybor));
		}
	}

}
