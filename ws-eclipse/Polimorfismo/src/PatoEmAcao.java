
public class PatoEmAcao {
	
	public void patoEmAcao (Pato pato) { //metodo que chama os comportamentos distintos
		String str = "";
		str = pato.acao();
		System.out.println(str);
	}

	public static void main(String[] args) {
		PatoEmAcao p = new PatoEmAcao();
		p.patoEmAcao(new patoBorracha());
		p.patoEmAcao(new patoMadeira());
		p.patoEmAcao(new patoVoador());
		p.patoEmAcao(new patoNormal());
	}

}