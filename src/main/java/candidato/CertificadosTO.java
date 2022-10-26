package candidato;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CertificadosTO {
	private int idCertificados;
	private String descricao, curso;
	
	public CertificadosTO() {
		
	}

	public CertificadosTO(int idCertificados, String descricao, String curso) {
		super();
		this.idCertificados = idCertificados;
		this.descricao = descricao;
		this.curso = curso;
	}

	public int getIdCertificados() {
		return idCertificados;
	}

	public void setIdCertificados(int idCertificados) {
		this.idCertificados = idCertificados;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	
	

	
}
