package processoSeletivo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DesafioCandidatoTO {
	private int id;
	private String status, tempoAplicacao, aprovacao;
	private int pontuacao;
	
	
	public DesafioCandidatoTO() {
		
	}
	
	
	public DesafioCandidatoTO(int idDesafioCandidato, String status, String tempoAplicacao, String aprovacao,
			int pontuacao) {
		super();
		this.id = id;
		this.status = status;
		this.tempoAplicacao = tempoAplicacao;
		this.aprovacao = aprovacao;
		this.pontuacao = pontuacao;
	}


	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getTempoAplicacao() {
		return tempoAplicacao;
	}


	public void setTempoAplicacao(String tempoAplicacao) {
		this.tempoAplicacao = tempoAplicacao;
	}


	public String getAprovacao() {
		return aprovacao;
	}


	public void setAprovacao(String aprovacao) {
		this.aprovacao = aprovacao;
	}


	public int getPontuacao() {
		return pontuacao;
	}


	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	
	
	
	
	
	

}
