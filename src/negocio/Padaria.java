package negocio;

import modelo.Produto;

public class Padaria extends Produto {

	private String localDepartamento;
	private String locaRetirada;
	private String nomeAtendente;


	public Padaria(int id, String nome, float peso, double valor, String localDepartamento, String locaRetirada,
			String nomeAtendente) {
		super(id, nome, peso, valor);
		this.localDepartamento = localDepartamento;
		this.locaRetirada = locaRetirada;
		this.nomeAtendente = nomeAtendente;
		quantidade++;

	}

	

	@Override
	public String toString() {
		return String.format("%s - %s - %s", super.toString(), this.getLocalDepartamento(), this.getLocaRetirada(),
				this.getNomeAtendente());
	}

	public void Exibir() {
		System.out.println(this.toString());
	}

	public String getLocalDepartamento() {
		return localDepartamento;
	}

	public void setLocalDepartamento(String localDepartamento) {
		this.localDepartamento = localDepartamento;
	}

	public String getLocaRetirada() {
		return locaRetirada;
	}

	public void setLocaRetirada(String locaRetirada) {
		this.locaRetirada = locaRetirada;
	}

	public String getNomeAtendente() {
		return nomeAtendente;
	}

	public void setNomeAtendente(String nomeAtendente) {
		this.nomeAtendente = nomeAtendente;
	}

}
