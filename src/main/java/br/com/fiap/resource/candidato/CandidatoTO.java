package br.com.fiap.resource.candidato;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CandidatoTO extends Pessoa {
	private int id;

	public CandidatoTO() {

	}

	public CandidatoTO(String nome, String idade, String dataNasc, String telefone, String email, String endereco,
			String login, String senha, int id, String status, int idCandidato) {

		super.setId(id);
		super.setNome(nome);
		super.setLogin(login);
		super.setSenha(senha);
		super.setIdade(idade);
		super.setTelefone(telefone);

		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
