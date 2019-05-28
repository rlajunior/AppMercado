package teste;

import negocio.Eletronico;

public class TestaEletronico {

	public static void main(String[] args) {

		Eletronico l1 = new Eletronico("TV de 55 Polegadas", 20, 2800.00);
		l1.setLocal("Corredor B");
		l1.setLocaRetirada("Caixa 2");
		l1.setAnoGarantia(1);
		l1.setPossuiGarantia(true);
		l1.exibir();

		Eletronico l2 = new Eletronico("Notebook 14 Polegadas Core I7", 5, 3500.00);
		l2.setLocal("Corredor B");
		l2.setLocaRetirada("Caixa 2");
		l2.setAnoGarantia(0);
		l2.setPossuiGarantia(false);

		l2.exibir();

	}

}
