package day1;

import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        int i = 4;
        double d = 8.0;
        String s = "HackerRank ";
        Scanner sc = new Scanner(System.in);
        int inteiro = sc.nextInt();
        double duplo = sc.nextDouble();
        sc.nextLine();
        String mensagem = sc.nextLine();
        sc.close();
        System.out.println(i + inteiro);
        System.out.println(d + duplo);
        System.out.println(s + mensagem);
    }
    
}
/*
run:
12
4,5
is the best plataform in the world.
16
12.5
HackerRank is the best plataform in the world.
BUILD SUCCESSFUL (total time: 1 minute 21 seconds)
*/