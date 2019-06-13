package negocio;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import auxiliar.Constante;
import modelo.Produto;

public class Loja {
	private Integer idLoja;
	private String nome;
	private String endereco;
	private String bairro;
	private List<Produto> produtosList = new ArrayList<Produto>();
	private Supervisor supervisor;
	private int[] qtdProdutos;
	
	public Loja(Integer idLoja, String nome, String endereco, String bairro, List<Produto> produtosList,
			Supervisor supervisor, int[] qtdProdutos) {
		super();
		this.idLoja = idLoja;
		this.nome = nome;
		this.endereco = endereco;
		this.bairro = bairro;
		this.produtosList = produtosList;
		this.supervisor = supervisor;
		this.qtdProdutos = qtdProdutos;
	}
	
	public Loja(Integer idLoja, String nome, String endereco, String bairro) {
		super();
		this.idLoja = idLoja;
		this.nome = nome;
		this.endereco = endereco;
		this.bairro = bairro;
	}

	public Loja(String nome, String endereco, String bairro) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.bairro = bairro;
	}

	
	public Integer getIdLoja() {
		return idLoja;
	}

	public void setIdLoja(Integer idLoja) {
		this.idLoja = idLoja;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public List<Produto> getProdutosList() {
		return produtosList;
	}

	public void setProdutosList(List<Produto> produtosList) {
		this.produtosList = produtosList;
	}

	public Supervisor getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Supervisor supervisor) {
		this.supervisor = supervisor;
	}

	public int[] getQtdProdutos() {
		return qtdProdutos;
	}

	public void setQtdProdutos(int[] qtdProdutos) {
		this.qtdProdutos = qtdProdutos;
	}

	public void exibir() {

		if (validar()) {
			System.out.println(this.toString());
			this.getSupervisor().exibir();
		} else {
			System.out.println("Invalido");
		}

		for (Produto produto : this.getProdutosList()) {
			produto.exibir();
			contabilizar(produto);
			showContabiliza();
		}

	}
	public boolean validar() {
		return Produto.getQuantidade() == this.produtosList.size();
	}
	
	
	private void contabilizar(Produto produto) {

		qtdProdutos = new int[Constante.PRODUTOS.length];

		if (produto instanceof Eletronico) {
			qtdProdutos[0]++;

		} else
			qtdProdutos[1]++;
	}

	private void showContabiliza() {
		System.out.println("Contabiliza:");
		for (int i = 0; i < qtdProdutos.length; i++) {
			System.err.println(
					"- " + Constante.PRODUTOS[i] + 
					": " + qtdProdutos[i]
			);
		}

	}

	public void associa(Supervisor supervisor) {
		setSupervisor(supervisor);
	}

	public void adiciona(Produto produto) {
		this.produtosList.add(produto);
	}
	
	public void listarProdutos() {
		for(Produto produto: produtosList) {
			produto.exibir();
			contabilizar(produto);
		}
	}


	@Override
	public String toString() {
		return "Mercado [nome=" + nome + ", endereco=" + endereco + ", bairro=" + bairro + ", produtosList="
				+ produtosList + ", qtdProdutos=" + Arrays.toString(qtdProdutos) + ", supervisor=" + supervisor
				+ ", getNome()=" + getNome() + ", getEndereco()=" + getEndereco() + ", getBairro()=" + getBairro()
				+ ", getSupervisor()=" + getSupervisor() + ", getProdutosList()=" + getProdutosList() + ", validar()="
				+ validar() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
