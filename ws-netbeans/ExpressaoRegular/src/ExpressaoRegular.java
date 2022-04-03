

public class ExpressaoRegular {
    public static void main(String[] args) {
        String padrao = "Java";
        String texto = "Java";
        boolean a = texto.matches(padrao);
        System.out.println(a);
        boolean b = "Java".matches("Java");
        System.out.println(b);
        boolean c = "Java".matches("java");
        System.out.println(c);
        
        
        /*
        <<< MODIFICADORES >>>
        
        (?i) ignora upper e lowercase
        (?x) identifica comentarios
        (?m) multilinhas
        (?s) dottal
        
        */
        boolean d = "Java".matches("(?i)java"); //Pode-se usar um modificador.
        System.out.println(d);
        boolean e = "Java".matches("(?im)java");//Ou mais de um ao mesmo tempo.
        System.out.println(e);
        
        /*
        <<< METACARACTERES >>>
        
        Indicam a ocorrencia de numeros e letras no texto.
        
         . qualquer caractere
        \\d digitos
        \\D nao e digito
        \\s espacos
        \\S nao e espaco
        \\w letra
        \\W nao e letra
        
        */
        boolean f = "@".matches(".");
        System.out.println(f);
        boolean g = "2".matches("\\d");
        System.out.println(g);
        boolean h = "a".matches("\\d");
        System.out.println(h);
        boolean i = "Fernando".matches("........"); //Expressao regular para avaliar caracteres.
        System.out.println(i);
        boolean j = "74013-035".matches("\\d\\d\\d\\d\\d\\W\\d\\d\\d"); // Expressao regular para avaliar CEP.
        System.out.println(j);
        boolean k = "74013-035".matches("\\d\\d\\d\\d\\d-\\d\\d\\d"); // Expressao regular para avaliar CEP.
        System.out.println(k);
        
        /*
        <<< QUANTIFICADORES >>>
        
        X{n}    exatamente n vezes
        X{n,}   pelo menos n vezes
        X{n, m} pelo menos n, mas nao mais que m vezes
        X?      0 ou 1 vez
        X*      0 ou + vezes
        X+      1 ou + vezes
        
        */
        
        
        
    }
    
}
