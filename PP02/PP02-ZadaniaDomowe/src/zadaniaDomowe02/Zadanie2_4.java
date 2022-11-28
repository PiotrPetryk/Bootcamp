package zadaniaDomowe02;

import java.util.Random;
import java.util.Scanner;

public class Zadanie2_4 {
    public static void main(String[] args){
        Random r = new Random();
        Scanner scanner = new Scanner(System.in);
        int x = r.nextInt(1000);
        int licznik=0;
        boolean trafiona = false;

        while (!trafiona){
            System.out.print("Podaj liczbę:");
            int strzal =scanner.nextInt();
            if (strzal>x) System.out.println("Podana liczba jest za duża.");
            if (strzal<x) System.out.println("Podana liczba jest za mała.");
            trafiona = x == strzal;
            licznik++;
        }
        System.out.printf("Trafiona w %d strzale!",licznik);
        scanner.close();
    }
}
