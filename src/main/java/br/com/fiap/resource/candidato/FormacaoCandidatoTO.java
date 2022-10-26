package br.com.fiap.resource.candidato;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FormacaoCandidatoTO {
	
	private int id;
	private String tpFormacao, status;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTpFormacao() {
		return tpFormacao;
	}
	public void setTpFormacao(String tpFormacao) {
		this.tpFormacao = tpFormacao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
