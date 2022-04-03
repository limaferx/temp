package datatypes;;
import java.util.*;
import java.io.*;

class DataTypes{
    public static void main(String []argh)
    {

        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();

        for(int i=0;i<t;i++)
        {

            try
            {
                long x=sc.nextLong();
                System.out.println(x+" can be fitted in:");
                if(x>=-128 && x<=127)System.out.println("* byte");
                if(x >= -32768 && x <= 32767)System.out.println("* short");
                if(x >= -2147483648 && x <= 2147483647)System.out.println("* int");
                if(x >= (long)-9223372036854775808L && x <= (long)9223372036854775807L)System.out.println("* long");
                //Complete the code
            }
            catch(Exception e)
            {
                System.out.println(sc.next()+" can't be fitted anywhere.");
            }

        }
    }
}

/*
3
-150
-150 can be fitted in:
* short
* int
* long
2133333333333333333333333333333333333
2133333333333333333333333333333333333 can't be fitted anywhere.
9876543
9876543 can be fitted in:
* int
* long
BUILD SUCCESSFUL (total time: 27 seconds)
*/



