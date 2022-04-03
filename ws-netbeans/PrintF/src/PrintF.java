

import java.util.Scanner;

public class PrintF {
    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("================================");
            for(int i=0;i<3;i++){
                String s1=sc.next();
                int x=sc.nextInt();
                //Complete this line
                System.out.printf("%-15s", s1);
                System.out.printf("%03d", x);
            }
            System.out.println("================================");

    }
}
/*
run:
================================
Fernando
30
Fernando       030
Camila
29
Camila         029
Larissa
52
Larissa        052================================
BUILD SUCCESSFUL (total time: 45 seconds)
*/