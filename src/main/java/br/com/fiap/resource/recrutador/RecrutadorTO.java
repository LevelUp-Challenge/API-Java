package br.com.fiap.resource.recrutador;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RecrutadorTO{
	private int id; 
	private String nome;
	private String login;
	private String senha;
	private String areas_recrutamento;
	
	public RecrutadorTO() {
		
	}

	public RecrutadorTO(int id, String nome, String login, String senha, String areas_recrutamento) {
		super();
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.areas_recrutamento = areas_recrutamento;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getAreas_recrutamento() {
		return areas_recrutamento;
	}

	public void setAreas_recrutamento(String areas_recrutamento) {
		this.areas_recrutamento = areas_recrutamento;
	}
	


}
