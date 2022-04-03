import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            //Inicio
            int dobro = 2;
            int s = a + (1 * b);
            for(int r = 0; r < n; r++) {
            System.out.print(s + " ");
            int c = (dobro * b);
            s = s + c;
            dobro = dobro * 2;
            }
            System.out.println();
            //Fim
        }
        in.close();
    }
}
/*
run:
2
0
2
10
2 6 14 30 62 126 254 510 1022 2046 
5
3
5
8 14 26 50 98 
BUILD SUCCESSFUL (total time: 15 seconds)
*/