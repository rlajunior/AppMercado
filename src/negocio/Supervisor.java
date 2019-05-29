package negocio;

public class Supervisor {
	
	private int id;
	private String nome;
	private String email;
	private int anoEntrada;
	private boolean ativo;

	

	public Supervisor(int id, String nome, String email, int anoEntrada, boolean ativo) {
		super();
		this.id = id;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAnoEntrada() {
		return anoEntrada;
	}

	public void setAnoEntrada(int anoEntrada) {
		this.anoEntrada = anoEntrada;
	}

	public boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	
}
