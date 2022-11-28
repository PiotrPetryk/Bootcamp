package zadaniaDomowe02;

import java.math.BigInteger;
import java.util.Scanner;

public class Zadanie2_1 {

    public static int sumaCyfr(long n){
        int suma=0;
        while (n>0){
            suma+=n%10;
            n/=10;
        }
        return suma;
    }

    public static BigInteger fib(int n){
        if (n==0) return BigInteger.ZERO;
        if (n==1) return BigInteger.ONE;

        BigInteger wartosc= fib(n-1).add(fib(n-2));

        return wartosc;
    }
    
    public static BigInteger fib2(int n){
    	BigInteger n1 = BigInteger.ZERO;
    	BigInteger n2 = BigInteger.ONE;
    	
    	if (n==0) return n1;
    	if (n==1) return n2;
    	BigInteger wartosc=BigInteger.ZERO;
    	for (int i=2; i<=n; i++) {
    		wartosc= n1.add(n2);
    		n1=n2;
    		n2=wartosc;
    	}
    	return wartosc;
    }

    public static boolean czyPierwsza(long i){

        if (i<=0) return false;
        if (i==1) return true;

        for (int j = 2; j <=(i/2+1) ; j++) {
            if (i % j == 0) return false;
        }
        return true;
    }

    public static void main (String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Podaj liczbę której sumę cyfr chcesz obliczyć:");
        long i = sc.nextLong();
        System.out.printf("suma cyfr liczby %d wynosi %d\n",i,sumaCyfr(i));

        System.out.println("Podaj ktorą wartość ciągu Fibonacciego chcesz obliczyć:");
        int f = sc.nextInt();
        System.out.printf("%d wartośc ciągu Fibonacciego to %d\n",f,fib(f));

        System.out.println("Podaj ktorą wartość ciągu Fibonacciego chcesz obliczyć:");
        int fi = sc.nextInt();
        System.out.printf("%d wartośc ciągu Fibonacciego to %d\n",fi,fib2(fi));
        
        System.out.println("Podaj liczbę to sprawdzenia czy jest liczbą pierwsza:");
        int p = sc.nextInt();
        if (czyPierwsza(p)) {
            System.out.printf("Liczba %d jest liczbą pierwszą", p);
        } else{
            System.out.printf("Liczba %d nie jest liczbą pierwszą", p);
        }
        sc.close();
    }
}
