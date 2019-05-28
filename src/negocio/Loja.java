package negocio;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import auxiliar.Constante;
import modelo.Produto;

public class Loja {
	private String nome;
	private String endereco;
	private String bairro;
	private List<Produto> produtosList = new ArrayList<Produto>();
	private int[] qtdProdutos;
	private Supervisor supervisor;
	
	
	
	public Loja() {
		super();
	}


	public Loja(String nome, String endereco, String bairro, List<Produto> produtosList) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.bairro = bairro;
		this.produtosList = produtosList;
	}

	

	public Loja(String nome, String endereco, String bairro) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.bairro = bairro;
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

	public Supervisor getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Supervisor supervisor) {
		this.supervisor = supervisor;
	}

	public List<Produto> getProdutosList() {
		return produtosList;
	}

	public void setProdutosList(List<Produto> produtosList) {
		this.produtosList = produtosList;
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
		return Produto.getquantidade() == this.produtosList.size();
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
