
import java.util.Scanner;

public class PrintStringDoubleInt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int integer = scanner.nextInt();
        double adouble = scanner.nextDouble();
        scanner.nextLine();
        scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        scanner.close();
        System.out.println("String: " + message);
        System.out.println("Double: " + adouble);
        System.out.println("Int: " + integer);
    }
    
}
/*
run:
22
4,6
Fernando
String: Fernando
Double: 4.6
Int: 22
BUILD SUCCESSFUL (total time: 8 seconds)

*/