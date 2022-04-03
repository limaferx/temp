package simplearraysum;

import java.util.Scanner;

public class SimpleArraySum {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int[] array = new int[x];
        for(int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
        int sum = 0;
        for(int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        System.out.println(sum);
    }


}