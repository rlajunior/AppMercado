package teste;

import modelo.Produto;
import negocio.Supervisor;

public class TestaSupervisor {

	public static void main(String[] args) {

		Supervisor supervisor = new Supervisor(1, "Jose Mauricio Prado", "josem@mercadoonline.com.br", 1990, true);
		supervisor.exibir();

	}

}
