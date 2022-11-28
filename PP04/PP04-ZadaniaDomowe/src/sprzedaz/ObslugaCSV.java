package sprzedaz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.math.BigDecimal;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

// To jest przykład tzw. klasy narzędziowej (utility class),
// w której są zdefiniowane różne funkcje - w formie metod statycznych.

public class ObslugaCSV {

    public static List<Transakcja> wczytaj(File plik) {
   	 List<Transakcja> lista = new ArrayList<>();
   	 try (Scanner scanner = new Scanner(plik)) {
   		 scanner.nextLine();
   		 while(scanner.hasNextLine()) {
   			 String linia = scanner.nextLine();
   			 String[] t = linia.split(";",11);
   			 
   			 Transakcja transakcja = new Transakcja(Integer.parseInt(t[0]), LocalDate.parse(t[1]),
   					 t[2], t[3], t[4], t[5], BigDecimal.valueOf(Double.parseDouble(t[6])), Integer.parseInt(t[7]));
   			 lista.add(transakcja);
   		 }
   	 } catch (FileNotFoundException e) {
   		 e.printStackTrace();
   	 }
   	 
   	 return lista;
    }
    
    public static List<Transakcja> wczytaj(String sciezka) {
   	 return wczytaj(new File(sciezka));
    }
    
    public static List<Transakcja> wczytaj() {
    	JFileChooser chooser = new JFileChooser(".");
		
		chooser.setDialogTitle("Wybierz plik do otwarcia");
		chooser.setFileFilter(new FileNameExtensionFilter("pliki tekstowe", "txt", "csv", "java", "py"));
		int wybor = chooser.showOpenDialog(null);

		if (wybor==JFileChooser.APPROVE_OPTION) {
			return wczytaj(chooser.getSelectedFile());
		} else return List.of();
    }
    
    public static void zapisz(List<Transakcja> transakcje) {
    	
    	JFileChooser chooser = new JFileChooser(".");
    	String rozszerzenie ="";
    	
		chooser.setDialogTitle("Wybierz plik do zapisu wyfiltrowanych danych:");
		chooser.setFileFilter(new FileNameExtensionFilter("pliki tekstowe", "txt", "csv"));
		int wybor = chooser.showSaveDialog(null);
		if (!(chooser.getSelectedFile().toString().endsWith(".csv") || chooser.getSelectedFile().toString().endsWith(".txt"))) {
			rozszerzenie =".csv";
		}
		
		if (wybor==JFileChooser.APPROVE_OPTION) {
			try (PrintWriter out = new PrintWriter(chooser.getSelectedFile()+rozszerzenie)) {
	    		out.println("id;data;miasto;sklep;kategoria;towar;cena;sztuk");
	      		int ilosc=0;
	    		for (Transakcja transakcja : transakcje) {
	      			out.println(transakcja.toStringtoFile());
	      			ilosc++;
				}
	      		JOptionPane.showMessageDialog(null, "Zapisano "+ ilosc + " rekordów.");
	    	} catch (FileNotFoundException e) {
	      		 e.printStackTrace();
	      	 }	
		}
    	
    }
}



