package teste;

import auxiliar.Constante;
import modelo.Produto;
import negocio.Eletronico;
import negocio.Loja;
import negocio.Padaria;
import negocio.Supervisor;

public class TestaMercado {
		

		public static void main(String[] args) {
			

			Padaria padaria = new Padaria(1, "P�o", 1, 3.00, "Bloco 9", "Armaz�m 07", "Evandro Mesquita");
			padaria.setLocalDepartamento("Corredor C");
			padaria.setLocaRetirada("Balc�o");
			padaria.setNomeAtendente("Romerito da Silva");
		
			Eletronico eletronico = new Eletronico(1, "TV de 55 Polegadas", 20, 2800.00, "Bloco B",  "Armaz�m 5", 2019, false);
			eletronico.setLocal("Corredor B");
			eletronico.setLocaRetirada("Caixa 2");
			eletronico.setAnoGarantia(1);
			eletronico.setPossuiGarantia(true);
			
			
			Supervisor supervisor = new Supervisor(1, "Jose Mauricio Prado", "josem@mercadoonline.com.br",1990, true);
			
			Loja mercado = new Loja("Mercado F�cil", "Rua Conde de Bonfim,205","Tijuca");
		/*	mercado.adiciona(padaria);
			mercado.adiciona(eletronico);*/
			
			
			System.out.println(
					"Mostre-me a qtdd de instancias : " +
					Produto.getQuantidade()
			);
			
			System.out.println(
					"Mostre-me a valida��o : " + mercado.validar()
					
			);
//			/mercado.exibir();
						
			
		}

	}


