package negocio;

import modelo.Produto;

public class Eletronico extends Produto {

	private String local;
	private String locaRetirada;
	private int anoGarantia;
	boolean possuiGarantia;

	public Eletronico(String nome, float peso, double valor) {
		super(nome, peso, valor);
		quantidade++;

	}

	public void exibir() {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return String.format("%s - %s - %s - %d, %s", super.toString(), this.getLocal(), this.getNome(),
				this.getAnoGarantia(), this.getPossuiGarantia()

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

	public Boolean getPossuiGarantia() {
		return possuiGarantia;
	}

	public void setPossuiGarantia(Boolean possuiGarantia) {
		this.possuiGarantia = possuiGarantia;
	}

}