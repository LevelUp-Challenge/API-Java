package br.com.fiap.resource.candidato;

import java.util.List;

public class FormacaoCandidatoBO {
private FormacaoCandidatoDAO rdao ;
	
	public List<FormacaoCandidatoTO> listar() {
		rdao = new FormacaoCandidatoDAO();
		return rdao.getFormacao();
		
	}
	public List<FormacaoCandidatoTO> listar(int id) {
		rdao = new FormacaoCandidatoDAO();
		return rdao.select(id);
		
	}
	
	public String inserir(FormacaoCandidatoTO rto) {
		rdao = new FormacaoCandidatoDAO();
		return rdao.insert(rto);
	}
	public String atualizar(FormacaoCandidatoTO rto) {
		rdao = new FormacaoCandidatoDAO();
		return rdao.update(rto);
	}
	public String deletar(int id) {
		rdao = new FormacaoCandidatoDAO();
		return rdao.delete(id);
		
	}


}
