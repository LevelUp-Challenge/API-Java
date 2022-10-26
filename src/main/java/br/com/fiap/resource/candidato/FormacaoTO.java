package br.com.fiap.resource.candidato;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FormacaoTO {
	private int id;
	private String grauFormacao, nmFormacao, nmInstituicao;
	private String dtInicio, dtTermino;
	
	public FormacaoTO() {
		
	}

	public FormacaoTO(int id, String grauFormacao, String nmFormacao, String nmInstituicao, String dtInicio,
			String dtTermino) {
		super();
		this.id = id;
		this.grauFormacao = grauFormacao;
		this.nmFormacao = nmFormacao;
		this.nmInstituicao = nmInstituicao;
		this.dtInicio = dtInicio;
		this.dtTermino = dtTermino;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGrauFormacao() {
		return grauFormacao;
	}

	public void setGrauFormacao(String grauFormacao) {
		this.grauFormacao = grauFormacao;
	}

	public String getNmFormacao() {
		return nmFormacao;
	}

	public void setNmFormacao(String nmFormacao) {
		this.nmFormacao = nmFormacao;
	}

	public String getNmInstituicao() {
		return nmInstituicao;
	}

	public void setNmInstituicao(String nmInstituicao) {
		this.nmInstituicao = nmInstituicao;
	}

	public String getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(String dtInicio) {
		this.dtInicio = dtInicio;
	}

	public String getDtTermino() {
		return dtTermino;
	}

	public void setDtTermino(String dtTermino) {
		this.dtTermino = dtTermino;
	}
	
	
	
	
	
}
