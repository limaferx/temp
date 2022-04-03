package praticando;

import java.util.Scanner;

public class Weird {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        int case1 = scanner.nextInt();
        if(case1%2 != 0) {
            System.out.println("Weird");
        }else if (case1%2 == 0 && case1 >=6 && case1 <=20) {
            System.out.println("Weird");
        }else {
            System.out.println("Not Weird");
        }
        int case2 = scanner.nextInt();
        if(case2%2 != 0) {
            System.out.println("Weird");
        }else if (case2%2 == 0 && case2 >=6 && case2 <=20) {
            System.out.println("Weird");
        }else {
            System.out.println("Not Weird");
        }
        scanner.close();
    }
    
}
/*
run:
3
Weird
24
Not Weird
BUILD SUCCESSFUL (total time: 9 seconds)

*/