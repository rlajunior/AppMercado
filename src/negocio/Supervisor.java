package negocio;

public class Supervisor {

	private String nome;
	private String email;
	private int anoEntrada;
	boolean ativo;

	public Supervisor(String nome, String email, int anoEntrada, boolean ativo) {
		super();
		this.nome = nome;
		this.email = email;
		this.anoEntrada = anoEntrada;
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return String.format("%s - %s - %d - %b", 
				this.nome, 
				this.email, 
				this.anoEntrada, 
				this.ativo);
	}

	public void exibir() {
		System.out.println(this.toString());
	}

}
