import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        for(int h = 0; h < loop; h++) {
            String s = sc.next();
            for(int i = 0; i < s.length(); i += 2){
                System.out.print(s.charAt(i));
            }
            System.out.print(" ");
                for(int j = 1; j < s.length(); j += 2) {
                System.out.print(s.charAt(j));
                }
            System.out.println();
        }
    }
}

/*
run:
2
HACKER
HCE AKR
RANK
RN AK
BUILD SUCCESSFUL (total time: 10 seconds)

*/