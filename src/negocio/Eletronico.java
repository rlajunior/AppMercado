package negocio;

import modelo.Produto;

public class Eletronico extends Produto {
	
	private String local;
	private String locaRetirada;
	private int anoGarantia;
	boolean possuiGarantia;


	public Eletronico(Integer idProduto, String nome, float peso, double valor, String local, String locaRetirada,
			int anoGarantia, boolean possuiGarantia) {
		super(idProduto, nome, peso, valor);
		this.local = local;
		this.locaRetirada = locaRetirada;
		this.anoGarantia = anoGarantia;
		this.possuiGarantia = possuiGarantia;
		quantidade++;
	}

	public void exibir() {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return String.format("%s - %s - %s - %d, %s", super.toString(), this.getLocal(), this.getNome(),
				this.getAnoGarantia(), 
				this.possuiGarantia

		);
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getLocaRetirada() {
		return locaRetirada;
	}

	public void setLocaRetirada(String locaRetirada) {
		this.locaRetirada = locaRetirada;
	}

	public int getAnoGarantia() {
		return anoGarantia;
	}

	public void setAnoGarantia(int anoGarantia) {
		this.anoGarantia = anoGarantia;
	}

	public boolean isPossuiGarantia() {
		return possuiGarantia;
	}

	public void setPossuiGarantia(boolean possuiGarantia) {
		this.possuiGarantia = possuiGarantia;
	}



	}