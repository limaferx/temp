package initializerblock;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static Scanner sc = new Scanner(System.in);
    private static boolean flag = true;
    private static int area;
    private static int B = sc.nextInt();
    private static int H = sc.nextInt();

static {
    if(B <= 0 || H <= 0) {
        System.out.println("java.lang.Exception: Breadth and height must be positive");
        flag = false;
    } else if(B > 100 || H > 100) {
        flag = false;
    }
}

public static void main(String[] args){
		if(flag){
                    int area = B * H;
                    System.out.print(area);
		}
		
	}//end of main

}//end of class

