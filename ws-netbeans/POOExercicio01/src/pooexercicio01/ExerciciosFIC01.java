package pooexercicio01;

public class ExerciciosFIC01 {

    public static void main(String[] args) {
        
        double XX=13;
        
        if(XX<10) XX=XX*10;
        
        System.out.println("part 1");
        if(XX<0){
            System.out.println(""+(XX-1));
        }else if(XX>=0 && XX<50){
            System.out.println((""+XX)+10);
        }else{
            System.out.println("No Solution!");
        }
            
        System.out.println("part 2");    
        if(!(XX<0) || (XX>=50)){
            System.out.println("Code before!"+(XX-25));
            if(XX>75 && (XX-25)<100){
                System.out.println("Code inside!"+XX);
            }
            String text=""+XX;
            text=""+text.charAt(0);
            System.out.println("Code after!"+text);
        }
        
        System.out.println("part 3");
        String text=""+XX;
        Integer yy= Integer.parseInt(text.substring(0,1));
        int kk=(yy<5?yy:yy-5);
        while(kk>0){
            System.out.println("kk:"+yy);
            kk=kk-1;
            for(int zz=kk+2; zz>(kk);zz=zz-1){
                System.out.println("zz:"+zz);
            }
        }
        
        System.out.println("part 4");
        Teste tswap=null;
        for(;yy>=0;){
            if(yy<=0) break;
            Teste t=new Teste();
            t.addValor(yy);
            tswap=t;
            tswap.addValor(1);
            yy=yy-1;
        }
        tswap.mostrarValor();
        
    }
}
//===========Classe de teste
class Teste{
    private int valor;
    
    Teste teste;
    
    public void setTeste(Teste teste){
        this.teste=teste;
    }
    
    public void addValor(int valor){
        this.valor=this.valor+valor;
    }
    
    public void mostrarValor(){
        System.out.println("Valor:"+valor);
    }
}