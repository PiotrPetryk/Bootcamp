package zadaniaDomowe03_zawodnicy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

public class ObslugaZawodnikow {
	
	static String wybierzKraj(String tekstZapytania) {
		Object[] kraje = Zawodnik.getKraje().toArray();
		Arrays.sort(kraje);

		String wybor = (String) JOptionPane.showInputDialog(null,tekstZapytania, "Wybór", JOptionPane.QUESTION_MESSAGE, null, kraje, kraje[0]);
		
		return wybor;
	}
	
	static int lacznaWaga(List<Zawodnik> zawodnicy, String wyborKraju) {
		int suma=0;
		for (Zawodnik zawodnik : zawodnicy) {
			if (zawodnik.getKraj().equals(wyborKraju)){
				suma+=zawodnik.getWaga();
			}
		}
		return suma;
	}
	
	static void naj(List<Zawodnik> zawodnicy) {
		Zawodnik maxWaga=zawodnicy.get(0);
		Zawodnik minWaga=zawodnicy.get(0);
		Zawodnik maxWzrost=zawodnicy.get(0);
		Zawodnik minWzrost=zawodnicy.get(0);
		
		for (Zawodnik zawodnik : zawodnicy) {
			if (zawodnik.getWaga()>maxWaga.getWaga()) maxWaga=zawodnik;
			if (zawodnik.getWaga()<minWaga.getWaga()) minWaga=zawodnik;
			if (zawodnik.getWzrost()>maxWzrost.getWzrost()) maxWzrost=zawodnik;
			if (zawodnik.getWzrost()<minWzrost.getWzrost()) minWzrost=zawodnik;	
		}
		JOptionPane.showMessageDialog(null, String.format("Zawodnik o największej masie to %s %s.\n"
				+ "Zawodnik o najmniejszej masie to %s %s.\n"
				+ "Zawodnik o największym wzoście to %s %s.\n"
				+ "Zawodnik o najmniejszym wzroście to %s %s", maxWaga.getImie(), maxWaga.getNazwisko(), minWaga.getImie(), minWaga.getNazwisko(),
				maxWzrost.getImie(), maxWzrost.getNazwisko(), minWzrost.getImie(), minWzrost.getNazwisko()));
	}
	
	static void ilu(List<Zawodnik> zawodnicy) {
		for (String kraj : Zawodnik.getKraje()) {
			int liczba=0;
			double sumaWzrostu=0;
			for (Zawodnik zawodnik : zawodnicy) {
				if (zawodnik.getKraj().equals(kraj)) {
					liczba++;
					sumaWzrostu+=zawodnik.getWzrost();
				}
			}
			System.out.println(kraj+ " - liczba: "+liczba+", średni wzrost: "+sumaWzrostu/liczba);
		}
		
	}

	public static void main(String[] args) {
		List<Zawodnik> zawodnicy = new ArrayList<>();
		
		zawodnicy = ObslugaCSV.wczytaj("zawodnicy.csv");
		if (zawodnicy.isEmpty()) return;
		System.out.println("Wczytano dane "+ zawodnicy.size()+ " zawodników");
		
		String wybranyKraj=wybierzKraj("Wybierz kraj, z którego chcesz obliczyć masę zawodników:");
		JOptionPane.showMessageDialog(null, "Masa zawodników z kraju "+wybranyKraj+ "wynosi "+lacznaWaga(zawodnicy, wybranyKraj));
		
		naj(zawodnicy);
		
		ilu(zawodnicy);

	}

}
