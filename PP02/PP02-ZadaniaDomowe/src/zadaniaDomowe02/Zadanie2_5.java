package zadaniaDomowe02;

import java.util.Scanner;

public class Zadanie2_5 {
    public static void oblilcz(String rownanie, int pozZnaku){
        double arg1 = Double.parseDouble(rownanie.substring(0, pozZnaku));
        double arg2 = Double.parseDouble(rownanie.substring(pozZnaku + 1));

        switch (rownanie.charAt(pozZnaku)) {
            case '+' -> System.out.println("Wynik to: " + (arg1 + arg2));
            case '-' -> System.out.println("Wynik to: " + (arg1 - arg2));
            case '*' -> System.out.println("Wynik to: " + (arg1 * arg2));
            case '/' -> System.out.println("Wynik to: " + (arg1 / arg2));
            case '%' -> System.out.println("Wynik to: " + (arg1 % arg2));
            case '^' -> System.out.println("Wynik to: " + Math.pow(arg1, arg2));
        }
    }

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        //boolean koniec=false;

        while (true) {
            System.out.println("Podaj działanie z zakresu [+,-,*,/,%,^] lub KONIEC by zakończyć:");
            String rownanie = sc.nextLine();
            if (rownanie.equalsIgnoreCase("KONIEC")) break;

            int pozZnaku = rownanie.indexOf('+');
            if (pozZnaku == -1) pozZnaku = rownanie.indexOf('-');
            if (pozZnaku == -1) pozZnaku = rownanie.indexOf('*');
            if (pozZnaku == -1) pozZnaku = rownanie.indexOf('/');
            if (pozZnaku == -1) pozZnaku = rownanie.indexOf('%');
            if (pozZnaku == -1) pozZnaku = rownanie.indexOf('^');
            if (pozZnaku == -1) {
                System.out.println("Wpisano nieobsługiwane działanie.");
                continue;
            }
            oblilcz(rownanie,pozZnaku);
        }
        sc.close();
    }
}
