package pooaula01;
public class POOAula01 {
    public static void main(String[] args) {
        
        Pessoa joao = null; //instancia um objeto
        joao = new Pessoa(); //atribui a variavel pessoa o objeto do tipo Pessoa
        System.out.println(joao); //imprime a referência do objeto
        System.out.println(joao.hashCode()); //imprime o identificador
        joao.alterarIdade(20); //passa um numero como parametro para idade
        joao.mostrarIdade(); //imprime o parametro atribuido ao objeto
        joao.setPessoa(joao); //passa um objeto como parametro para joao
        System.out.println(joao.equals(joao)); //compara se os objetos sao iguais
        System.out.println(joao); //imprime a referencia do objeto novamente
        System.out.println(joao.hashCode()); //imprime novamente o identificador
        joao = null; //atribui a variavel do tipo Pessoa o valor null
        System.out.println(joao);
        System.out.println(joao.hashCode());
        
//        Pessoa jose;
//        jose = new Pessoa();
//        jose.alterarIdade(22);
//        jose.mostrarIdade();
//        
//        joao.setPessoa(joao);
//        joao.mostrarIdade();
//        joao = null;
//        System.out.println();
    }
    
}