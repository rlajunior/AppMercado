package teste;

import modelo.Produto;
import negocio.Padaria;

public class TestaPadaria {

	public static void main(String[] args) {

		Padaria p1 = new Padaria("Pão", 1, 3.00);
		p1.setLocalDepartamento("Corredor C");
		p1.setLocaRetirada("Balcão");
		p1.setNomeAtendente("Romerito da Silva");
		p1.Exibir();

		Padaria p2 = new Padaria("Quejo Minas Frescal", 200, 5.00);
		p2.setLocalDepartamento("Corredor C");
		p2.setLocaRetirada("Balcão");
		p2.setNomeAtendente("Tamara de Oliveira");
		p2.Exibir();

	}

}
