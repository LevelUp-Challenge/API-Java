package br.com.fiap.resource.candidato;

import java.util.List;

public class EnderecoBO {
	private EnderecoDAO rdao;

	public List<EnderecoTO> listar() {
		rdao = new EnderecoDAO();
		return rdao.getEndereco();

	}

	public List<EnderecoTO> listar(int id) {
		rdao = new EnderecoDAO();
		return rdao.select(id);

	}

	public String inserir(EnderecoTO rto) {
		rdao = new EnderecoDAO();
		return rdao.insert(rto);
	}

	public String atualizar(EnderecoTO rto) {
		rdao = new EnderecoDAO();
		return rdao.update(rto);
	}

	public String deletar(int id) {
		rdao = new EnderecoDAO();
		return rdao.delete(id);

	}

}
