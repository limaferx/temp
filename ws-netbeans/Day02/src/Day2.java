

import java.io.*;
import static java.lang.Math.round;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'solve' function below.
     *
     * The function accepts following parameters:
     *  1. DOUBLE meal_cost
     *  2. INTEGER tip_percent
     *  3. INTEGER tax_percent
     */

    public static void solve(double meal_cost, int tip_percent, int tax_percent) {
    // Write your code here
    double calc1 = ((meal_cost / 100) * tip_percent);
    double calc2 = ((((double)tax_percent / 100) * tip_percent));
    double total = meal_cost + calc1 + calc2;
    }

}

public class Day2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        double meal_cost = Double.parseDouble(bufferedReader.readLine().trim());

        int tip_percent = Integer.parseInt(bufferedReader.readLine().trim());

        int tax_percent = Integer.parseInt(bufferedReader.readLine().trim());

        Result.solve(meal_cost, tip_percent, tax_percent);
        
        //Inicio
        double calc1 = ((meal_cost / 100) * tip_percent);
        double calc2 = ((((double)tax_percent / 100) * tip_percent));
        double total = meal_cost + calc1 + calc2;
        System.out.println(round(total));
        //Fim

        bufferedReader.close();
    }
}

/*
run:
12
20
8
16
BUILD SUCCESSFUL (total time: 7 seconds)

*/