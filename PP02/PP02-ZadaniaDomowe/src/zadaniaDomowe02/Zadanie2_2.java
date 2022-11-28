package zadaniaDomowe02;

import java.util.ArrayList;
import java.util.List;

public class Zadanie2_2 {
	static void wypiszPodzielne(int[] tab, int x) {
		for (int i : tab) {
			if (i%x==0) System.out.print(i+" ");
		}
		System.out.println("");
	}
	
	static Integer pierwszaPodzielna(int[] tab, int x) {
		for (int i : tab) {
			if (i%x==0) return i;
		}
		return null;
	}
	
	static int sumaPodzielnych(int[] tab, int x) {
		int suma =0;
		for (int i : tab) {
			if (i%x==0) {
				suma+=i;
			}
		}
		return suma;
	}
	
	static int ilePodzielnych(int[] tab, int x) {
		int ile =0;
		for (int i : tab) {
			if (i%x==0) {
				ile++;
			}
		}
		return ile;
	}
	
	static Integer min(int[] t) {
		if (t.length == 0) {
			return null;
		}
		Integer min = t[0];
		for (int i : t) {
			if (i < min) {
				min = i;
			}
		}
		return min;
	}
	
	static Integer max(int[] t) {
		if (t.length == 0) {
			return null;
		}
		Integer max = t[0];
		for (int i : t) {
			if (i> max) {
				max =i;
			}
		}
		return max;
	}
	
	static int roznicaMinMax(int[] t) {
		if (t.length == 0) {
			return 0;
		}else {
			return max(t)-min(t);
		}
	}
	
	static Integer znajdzWspolny(int[] t1, int[] t2) {
		for (int i : t1) {
			for (int j : t2) {
				if (i==j) return i;
			}
		}
		return null;
	}
	
	static List<Integer> wszystkieWspolne(int[] t1, int[] t2) {
		List<Integer> wspolne = new ArrayList<>();
		for (int i : t1) {
			for (int j : t2) {
				if (i==j) wspolne.add(i);
			}
		}
		return wspolne;
	}
	
	public static void main(String[] args) {
		int[] tab = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] tab2 = {-1, 3, 5, 11};
		int x = 2;
		wypiszPodzielne(tab, x);
		System.out.printf("Pierwsza podzielna przez %d to %d\n" ,x ,pierwszaPodzielna(tab, x));
		System.out.printf("Suma podzielnych przez %d to %d\n" ,x ,sumaPodzielnych(tab, x));
		System.out.printf("Liczba podzielnych przez %d to %d\n" ,x ,ilePodzielnych(tab, x));
		System.out.printf("Najmniejsza wartość tablicy to %d\n" ,min(tab));
		System.out.printf("Największa wartość tablicy to %d\n" ,max(tab));
		System.out.printf("Różnica między największą a najmniejszą wartością tablicy to %d\n" ,roznicaMinMax(tab));
		System.out.printf("Wspólny element w obu tablicach to %d\n" ,znajdzWspolny(tab, tab2));
		System.out.println("Wspólne elementy w obu tablicach to:"+ wszystkieWspolne(tab, tab2).toString());
		
		
		
		
		
	}

}
