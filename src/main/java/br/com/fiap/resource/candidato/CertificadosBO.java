package br.com.fiap.resource.candidato;

import java.util.List;

import br.com.fiap.resource.recrutador.RecrutadorDAO;
import br.com.fiap.resource.recrutador.RecrutadorTO;

public class CertificadosBO {
private CertificadosDAO rdao ;
	
	public List<CertificadosTO> listar() {
		rdao = new CertificadosDAO();
		return rdao.getCertificados();
		
	}
	public List<CertificadosTO> listar(int id) {
		rdao = new CertificadosDAO();
		return rdao.select(id);
		
	}
	public String inserir(CertificadosTO rto) {
		rdao = new CertificadosDAO();
		return rdao.insert(rto);
	}
	public String atualizar(CertificadosTO rto) {
		rdao = new CertificadosDAO();
		return rdao.update(rto);
	}
	public String deletar(int id) {
		rdao = new CertificadosDAO();
		return rdao.delete(id);
		
	}
	


}
