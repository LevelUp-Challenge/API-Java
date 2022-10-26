package br.com.fiap.resource.candidato;

import java.util.List;

import br.com.fiap.resource.recrutador.RecrutadorDAO;
import br.com.fiap.resource.recrutador.RecrutadorTO;

public class FormacaoBO {
	private FormacaoDAO rdao ;
	
	public List<FormacaoTO> listar() {
		rdao = new FormacaoDAO();
		return rdao.getRecrutadores();
		
	}
	public List<FormacaoTO> listar(int id) {
		rdao = new FormacaoDAO();
		return rdao.select(id);
		
	}
	public String inserir(FormacaoTO rto) {
		rdao = new FormacaoDAO();
		return rdao.insert(rto);
	}
	public String atualizar(FormacaoTO rto) {
		rdao = new FormacaoDAO();
		return rdao.update(rto);
	}
	public String deletar(int id) {
		rdao = new FormacaoDAO();
		return rdao.delete(id);
		
	}

	

}
