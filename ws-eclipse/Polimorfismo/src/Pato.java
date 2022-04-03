
public class Pato { //classe modelo
	public String acao() {
		return("");
	}

}

class patoBorracha extends Pato {
	public String acao() {
		return ("Pato de borracha nada.");
	}
}

class patoMadeira extends Pato {
	public String acao() {
		return ("Pato de madeira anda.");
	}
}

class patoVoador extends Pato {
	public String acao() {
		return ("Pato voador voa.");
	}
}

class patoNormal extends Pato {
	public String acao() {
		return ("Pato normal voa, anda e nada.");
	}
}

/*
 * Polimorfismo e a alteracao do comportamento de um metodo existente na classe modelo.
 */


