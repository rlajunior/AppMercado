package modelo;


public abstract class Produto {

	private Integer idProduto;
	private String nome;
	private float peso;
	private double valor;
	protected static int quantidade;

	public Produto(Integer idProduto, String nome, float peso, double valor) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.peso = peso;
		this.valor = valor;
	}

	
	
	public Integer getIdProduto() {
		return idProduto;
	}



	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
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



	public static int getQuantidade() {
		return quantidade;
	}



	public static void setQuantidade(int quantidade) {
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
