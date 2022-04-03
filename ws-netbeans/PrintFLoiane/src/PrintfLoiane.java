

public class PrintfLoiane {
    public static void main(String[] args) {
        String str1 = "Pão ";
        String str2 = "com ";
        String str3 = "homus.";
        
        //Impressao formatada:
        System.out.printf("%-30s", str1.concat(str2).concat(str3));
        /*
        Primeiro informa, entre aspas, o comando da formatacao. Em seguida,
        separando com virgula(,), a variavel a ser formatada. Nesse caso "%s" e
        o comando para imprimir uma String. A informacao -30 significa que a
        impressao deve considerar 30 posicoes de caracteres. Se nao forem
        preenchidos, o programa completa com espacos depois da sequencia.
        */
        System.out.println(); //Comando para saltar uma linha depois do printf.
        
        System.out.printf("%30s", str1 + str2 + str3);
        /*
        "%30s" O programa deve considerar 30 posicoes de caracteres, que se
        nao forem preenchidos, o programa deve completar com espacos antes da
        sequencia.
        */
        
        System.out.println();
        
        int num = 123456789;
        double onum = 12.121209;
        System.out.printf("%d", num);
        System.out.println();
        System.out.printf("%,2f", onum);
        System.out.println();
    }
    
}
