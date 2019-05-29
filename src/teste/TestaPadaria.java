package teste;

import modelo.Produto;
import negocio.Padaria;

public class TestaPadaria {

	public static void main(String[] args) {

		Padaria p1 = new Padaria(1, "Pão", 1, 3.00, null, null, null);
		p1.setLocalDepartamento("Corredor C");
		p1.setLocaRetirada("Balcão");
		p1.setNomeAtendente("Romerito da Silva");
		p1.Exibir();

		Padaria p2 = new Padaria(2, "Quejo Minas Frescal", 200, 5.00, null, null, null);
		p2.setLocalDepartamento("Corredor C");
		p2.setLocaRetirada("Balcão");
		p2.setNomeAtendente("Tamara de Oliveira");
		p2.Exibir();

	}

}
