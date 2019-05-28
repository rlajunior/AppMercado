package modelo;


public abstract class Produto {

	private String nome;
	private float peso;
	private double valor;
	protected static int quantidade;

	public Produto(String nome, float peso, double valor) {
		super();
		this.nome = nome;
		this.peso = peso;
		this.valor = valor;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public static int getquantidade() {
		return quantidade;
	}

	public static void setquantidade(int quantidade) {
		Produto.quantidade = quantidade;
	}
	
	@Override
	public String toString() {
		return String.format("%d - %s - %.2f - %.2f", quantidade, this.nome, this.peso, this.valor);
	}
	
	public void exibir() {
		System.out.println(toString());
	}
	
	
}
