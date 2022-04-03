//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        Map<String, Integer> agenda = new HashMap<String, Integer>();
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            agenda.put(name, phone);
        }
        while(in.hasNext()){
            String s = in.next();
            if(agenda.get(s) == null) {
                System.out.println("Not found");
            } else {
            System.out.println(s + "=" + agenda.get(s));
            }
        }
        System.out.println(agenda.toString());
        in.close();
    }
}

/*
run:
3
fernando
111111
ricardo
222222
larissa
333333

fernando
fernando=111111
carolina
Not found
ricardo
ricardo=222222
*/