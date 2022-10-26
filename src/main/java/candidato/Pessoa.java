 package candidato;


public class Pessoa extends Login{
	private String nome;
	private String idade;
	private String dataNasc;
	private String telefone;
	private String email;
	private String sexo;
	private int cpf;
	private String status;
	
	public Pessoa() {
		
	}
	
	
	public Pessoa(String nome, 
			String idade, String dataNasc, String telefone,
			String email, String endereco, String login,
			String senha, int id, String status) {
		
		this.nome = nome;
		this.idade = idade;
		this.dataNasc = dataNasc;
		this.telefone = telefone;
		this.email = email;
		this.status = status;
		super.setLogin(login);
		super.setSenha(senha);
		super.setId(id);
	}
	
	
	


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int calculaId() {
		int userId = super.getId() + 1;
		return userId;
	
	}


	public String getDataNasc() {
		return dataNasc;
	}


	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public int getCpf() {
		return cpf;
	}


	public void setCpf(int cpf) {
		this.cpf = cpf;
	}


	

}
