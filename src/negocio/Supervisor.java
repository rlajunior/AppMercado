package negocio;

public class Supervisor {
	
	private Integer idSupervisor;
	private String nome;
	private String email;
	private Integer anoEntrada;
	private boolean ativo;
	private Loja loja;

	public Supervisor() {
		// TODO Auto-generated constructor stub
	}
	
	public Supervisor(Integer idsupervisor, String nome, String email, Integer anoEntrada, boolean ativo) {
		super();
		this.idSupervisor = idsupervisor;
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


	public Integer getIdSupervisor() {
		return idSupervisor;
	}


	public void setIdSupervisor(Integer idSupervisor) {
		this.idSupervisor = idSupervisor;
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


	public Loja getLoja() {
		return loja;
	}


	public void setLoja(Loja loja) {
		this.loja = loja;
	}	
		
	
}
	
	