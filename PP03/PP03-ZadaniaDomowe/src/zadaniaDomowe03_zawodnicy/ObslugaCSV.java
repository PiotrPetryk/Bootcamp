package zadaniaDomowe03_zawodnicy;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ObslugaCSV {

    public static List<Zawodnik> wczytaj(File plik) {
   	 List<Zawodnik> lista = new ArrayList<>();
   	 try (Scanner scanner = new Scanner(plik)) {
   		 while(scanner.hasNextLine()) {
   			 String linia = scanner.nextLine();
   			 String[] t = linia.split(";",11);
   			 
   			 Zawodnik zawodnik = new Zawodnik(t[0], t[1], t[2], LocalDate.parse(t[3]), Integer.parseInt(t[4]), Integer.parseInt(t[5]));
   			 lista.add(zawodnik);
   		 }
   	 } catch (FileNotFoundException e) {
   		 e.printStackTrace();
   	 }
   	 
   	 return lista;
    }
    
    public static List<Zawodnik> wczytaj(String sciezka) {
   	 return wczytaj(new File(sciezka));
    }
    
    public static List<Zawodnik> wczytaj() {
    	JFileChooser chooser = new JFileChooser(".");
		
		chooser.setDialogTitle("Wybierz plik do otwarcia");
		chooser.setFileFilter(new FileNameExtensionFilter("pliki tekstowe", "txt", "csv", "java", "py"));
		int wybor = chooser.showOpenDialog(null);

		if (wybor==JFileChooser.APPROVE_OPTION) {
			return wczytaj(chooser.getSelectedFile());
		} else return List.of();
       }
}



