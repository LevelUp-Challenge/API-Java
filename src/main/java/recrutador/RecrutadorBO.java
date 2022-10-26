package recrutador;


import java.util.List;

public class RecrutadorBO {
	private RecrutadorDAO rdao ;
	
	public List<RecrutadorTO> listar() {
		rdao = new RecrutadorDAO();
		return rdao.getRecrutadores();
		
	}
	public List<RecrutadorTO> listar(int id) {
		rdao = new RecrutadorDAO();
		return rdao.select(id);
		
	}
	public int inserir(RecrutadorTO rto) {
		rdao = new RecrutadorDAO();
		return rdao.insert(rto);
	}
	public String atualizar(RecrutadorTO rto) {
		rdao = new RecrutadorDAO();
		return rdao.update(rto);
	}
	public String deletar(int id) {
		rdao = new RecrutadorDAO();
		return rdao.delete(id);
		
	}
	

}
