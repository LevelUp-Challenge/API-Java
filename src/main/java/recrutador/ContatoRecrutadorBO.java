package recrutador;

import java.util.List;

public class ContatoRecrutadorBO {
	//private ContatoRecrutadorDAO crdao;
	ContatoRecrutadorDAO crdao;
	
	
	public List<ContatoRecrutadorTO> listar() {
		crdao = new ContatoRecrutadorDAO();
		return crdao.getContato();
	}
	public List<ContatoRecrutadorTO> listar(int id) {
		crdao = new ContatoRecrutadorDAO();
		return crdao.select(id);
	}
	public int inserir(ContatoRecrutadorTO crt) {
		crdao = new ContatoRecrutadorDAO();
		return crdao.insert(crt);
	}
	public String atualizar(ContatoRecrutadorTO crt) {
		crdao = new ContatoRecrutadorDAO();

		return crdao.update(crt);
	}
	public String excluir(int id) {
		crdao = new ContatoRecrutadorDAO();

		return crdao.delete(id);
	}
		
	
	

}
