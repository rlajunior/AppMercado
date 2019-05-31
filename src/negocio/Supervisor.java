package negocio;

public class Supervisor {
	
	private Integer id;
	private String nome;
	private String email;
	private Integer anoEntrada;
	private boolean ativo;

	

	public Supervisor(Integer id, String nome, String email, Integer anoEntrada, boolean ativo) {
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Integer getAnoEntrada() {
		return anoEntrada;
	}

	public void setAnoEntrada(Integer anoEntrada) {
		this.anoEntrada = anoEntrada;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}


}
