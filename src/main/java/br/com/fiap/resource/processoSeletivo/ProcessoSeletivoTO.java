package br.com.fiap.resource.processoSeletivo;

public class ProcessoSeletivoTO {
	private String nomeVaga, descricaoVaga, areaVaga, beneficiosVaga, modalidadeVaga, pcdAplicavel, desafio,
			mediaInscritos;
	private int inscritos, id;
	private double salario;

	public String getNomeVaga() {
		return nomeVaga;
	}

	public void setNomeVaga(String nomeVaga) {
		this.nomeVaga = nomeVaga;
	}

	public String getDescricaoVaga() {
		return descricaoVaga;
	}

	public void setDescricaoVaga(String descricaoVaga) {
		this.descricaoVaga = descricaoVaga;
	}

	public String getAreaVaga() {
		return areaVaga;
	}

	public void setAreaVaga(String areaVaga) {
		this.areaVaga = areaVaga;
	}

	public String getBeneficiosVaga() {
		return beneficiosVaga;
	}

	public void setBeneficiosVaga(String beneficiosVaga) {
		this.beneficiosVaga = beneficiosVaga;
	}

	public String getModalidadeVaga() {
		return modalidadeVaga;
	}

	public void setModalidadeVaga(String modalidadeVaga) {
		this.modalidadeVaga = modalidadeVaga;
	}

	public String getPcdAplicavel() {
		return pcdAplicavel;
	}

	public void setPcdAplicavel(String pcdAplicavel) {
		this.pcdAplicavel = pcdAplicavel;
	}

	public String getDesafio() {
		return desafio;
	}

	public void setDesafio(String desafio) {
		this.desafio = desafio;
	}

	public String getMediaInscritos() {
		return mediaInscritos;
	}

	public void setMediaInscritos(String mediaInscritos) {
		this.mediaInscritos = mediaInscritos;
	}

	public int getInscritos() {
		return inscritos;
	}

	public void setInscritos(int inscritos) {
		this.inscritos = inscritos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}
