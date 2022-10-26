package processoSeletivo;

import java.util.List;

public class ProcessoSeletivoBO {
	
	private ProcessoSeletivoDAO rdao ;
	
	public List<ProcessoSeletivoTO> listar() {
		rdao = new ProcessoSeletivoDAO();
		return rdao.getVaga();
		
	}
	public List<ProcessoSeletivoTO> listar(int id) {
		rdao = new ProcessoSeletivoDAO();
		return rdao.select(id);
		
	}
	public int inserir(ProcessoSeletivoTO psto) {
		rdao = new ProcessoSeletivoDAO();
		return rdao.insert(psto);

	}
	public int alterar(ProcessoSeletivoTO psto) {
		rdao = new ProcessoSeletivoDAO();
		return rdao.update(psto);

	}
	public int deletar(int id) {
		rdao = new ProcessoSeletivoDAO();
		return rdao.delete(id);

	}

}
