package candidato;

import java.util.List;




public class CandidatoBO {

	private CandidatoDAO rdao;

	public List<CandidatoTO> listar() {
		rdao = new CandidatoDAO();
		return rdao.getCandidato();

	}

	public List<CandidatoTO> listar(int id) {
		rdao = new CandidatoDAO();
		return rdao.select(id);

	}

	public String inserir(CandidatoTO rto) {
		rdao = new CandidatoDAO();
		return rdao.insert(rto);
	}

	public String atualizar(CandidatoTO rto) {
		rdao = new CandidatoDAO();
		return rdao.update(rto);
	}

	public String deletar(int id) {
		rdao = new CandidatoDAO();
		return rdao.delete(id);

	}

}
