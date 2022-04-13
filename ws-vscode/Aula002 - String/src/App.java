public class App {
    public static void main(String[] args) throws Exception {
        String str1 = "Fernando", str2 = "fernando";
        System.out.println(str1 + ", " + 34);
        System.out.println(str1.compareTo(str2));
        System.out.println(str1.equals(str2)); //preferir .equals() para comparar strings

        String frase = "This is Java";
        System.out.println(frase.substring(0, 7));

        char[] rev = frase.toCharArray();
        for(int i = rev.length-1; i >= 0; i--){
            System.out.print(rev[i]);
        }
        System.out.print("\n");
        System.out.print(frase.contains("is "));

        int[] valores = new int[3];
        valores[0] = 1;
        valores[1] = 2;
        valores[2] = 3;
        System.out.print("\n");

        for(int i = 0; i < valores.length; i++) {
            System.out.println("Valores[" + i + "]: " + valores[i]);
        }
    }
}