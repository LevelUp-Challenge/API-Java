package processoSeletivo;

import java.util.List;

public class DesafioCandidatoBO {
	private DesafioCandidatoDAO rdao ;
	
	public List<DesafioCandidatoTO> listar() {
		rdao = new DesafioCandidatoDAO();
		return rdao.getDesafio();
		
	}
	public List<DesafioCandidatoTO> listar(int id) {
		rdao = new DesafioCandidatoDAO();
		return rdao.select(id);
		
	}
	
	public String inserir(DesafioCandidatoTO dcto) {
		rdao = new DesafioCandidatoDAO();
		return rdao.inserir(dcto);
	}
	
	public String alterar(DesafioCandidatoTO dcto) {
		rdao = new DesafioCandidatoDAO();
		return rdao.alterar(dcto);
	}
	
	public String deletar(int id) {
		rdao = new DesafioCandidatoDAO();
		return rdao.delete(id);
	}

	
	
	
	
	

}
