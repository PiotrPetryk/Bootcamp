package zadaniaDomowe02;

import java.util.Random;
import java.util.Scanner;

public class Zadanie2_3 {
    public static boolean czyPozaPlansza(int[] gracz){
        if (gracz[0]<1 || gracz[0]>10 || gracz[1]<1 || gracz[1]>10) {
            System.out.println("Gracz poza planszą! PRZEGRANA!");
            return true;
        }
        return false;
    }

    public static boolean czyWygrana(int[] gracz, int[] skarb, int liczbaRuchow){
        if (gracz[0]==skarb[0] && gracz[1]==skarb[1]) {
            System.out.println("BRAWO! Skarb znaleziony w "+liczbaRuchow+" ruchach.");
            return true;
        }
        return false;
    }

    public static double jakDaleko(int[] gracz, int[] skarb, double odleglosc){
        double odlegloscNowa =Math.sqrt((skarb[0]-gracz[0])*(skarb[0]-gracz[0])+(skarb[1]-gracz[1])*(skarb[1]-gracz[1]));
        if (odlegloscNowa>odleglosc) System.out.println("Jesteś dalej od skarbu.\n");
        if (odlegloscNowa<odleglosc) System.out.println("Jesteś bliżej skarbu.\n");
        return odlegloscNowa;
    }

    public static void main (String[] args){
        Random losuj = new Random();
        Scanner sc = new Scanner(System.in);
        int[] gracz = {losuj.nextInt(10)+1, losuj.nextInt(10)+1};
        int[] skarb = {losuj.nextInt(10)+1, losuj.nextInt(10)+1};
        double odleglosc = Math.sqrt((skarb[0]-gracz[0])*(skarb[0]-gracz[0])+(skarb[1]-gracz[1])*(skarb[1]-gracz[1]));
        boolean koniec=false;
        int liczbaRuchow=0;

        while (!koniec){
            //System.out.printf("skarb: %d, %d; gracz: %d, %d\n",skarb[0],skarb[1],gracz[0],gracz[1]);
            //System.out.println("");
            System.out.print("Wykonaj ruch [W/S/A/D] lub Q-wyjście:");
            String ruch = sc.nextLine().toUpperCase();
            liczbaRuchow++;
            switch (ruch){
                case "W" -> gracz[1]++;
                case "S" -> gracz[1]--;
                case "A" -> gracz[0]--;
                case "D" -> gracz[0]++;
                case "Q" -> {
                    System.out.println("Do widzenia.");
                    return;
                }
                default -> {
                    System.out.println("Podano nieprawidłową komendę.");
                    liczbaRuchow--;
                }
            }
            koniec = czyPozaPlansza(gracz) || czyWygrana(gracz,skarb, liczbaRuchow);
            if (!koniec) odleglosc=jakDaleko(gracz, skarb, odleglosc);
        }
        sc.close();
    }
}
