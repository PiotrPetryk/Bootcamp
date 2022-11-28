package zadaniaDomowe03_ogloszenia;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SerwisOgloszeniowy {

	public static void main(String[] args) {
		
		List <Ogloszenie> ogloszenia = new ArrayList<>();
		
		
		Sprzedawca s1 = new Sprzedawca("Andrzej", "Abacki", 123456789, "Abkowice", 01001, "Akacji", 1, 1);
		Sprzedawca s2 = new Sprzedawca("Bartłomiej", "Babacki", 987654321, "Babkowice", 02002, "Bociania", 2, 2);
		
		ogloszenia.add(new OgloszenieSamochodowe("Sprzedam Opla", "Jak nowy, Niemiec pod kocem trzymał", s1, 1500, 0.23, true, "Opel", "Astra", "Rdzawy", 1990, 100000, 100, 1.4, Paliwo.PB));
		ogloszenia.add(new Ogloszenie("Cebula", "Tanio cebulę sprzedam", s1, 1, 0.08, false));
		
		ogloszenia.add(new OgloszenieMieszkaniowe("Mikroapartament", "Nowoczesnay apartament w centrum miasta", s2, 100000000000.99, 0.23, true, "Wąchock", 14, 1, TypNieruchomosci.MIESZKANIE));
		
		//ogloszenia.sort((x,y)-> (x.isPremium()? 0 : 1)-(y.isPremium()? 0 : 1));
		ogloszenia.sort(Comparator.comparing(Ogloszenie::isPremium));
		
		for (Ogloszenie ogloszenie : ogloszenia) {
			System.out.println(ogloszenie.toString()+"\n\n");
		}
		

	}

}
