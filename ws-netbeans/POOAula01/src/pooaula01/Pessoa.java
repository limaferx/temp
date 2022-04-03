package pooaula01;
public class Pessoa {
    public int idade = 0;
    Pessoa p;
    
    public Pessoa() {
        System.out.println("Inicializando o objeto");
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    
    public void mostrarIdade() {
        System.out.println("Idade: " + idade);
    }
    
    public void alterarIdade(int midade) {
        idade = midade;
    }
    
    public void setPessoa(Pessoa pe){
        p = pe;
    }
    
}
