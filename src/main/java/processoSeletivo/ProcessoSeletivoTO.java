package processoSeletivo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProcessoSeletivoTO {
	private String nomeVaga, areaVaga, beneficiosVaga, pcdAplicavel, mediaInscritos, salario;
	private int inscritos, id, desafio;
	

	public ProcessoSeletivoTO() {

	}


	public ProcessoSeletivoTO(String nomeVaga, String areaVaga, String beneficiosVaga, String pcdAplicavel,
			String mediaInscritos, String salario, int inscritos, int id, int desafio) {
		super();
		this.nomeVaga = nomeVaga;
		this.areaVaga = areaVaga;
		this.beneficiosVaga = beneficiosVaga;
		this.pcdAplicavel = pcdAplicavel;
		this.mediaInscritos = mediaInscritos;
		this.salario = salario;
		this.inscritos = inscritos;
		this.id = id;
		this.desafio = desafio;
	}


	public String getNomeVaga() {
		return nomeVaga;
	}


	public void setNomeVaga(String nomeVaga) {
		this.nomeVaga = nomeVaga;
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


	public String getPcdAplicavel() {
		return pcdAplicavel;
	}


	public void setPcdAplicavel(String pcdAplicavel) {
		this.pcdAplicavel = pcdAplicavel;
	}


	public String getMediaInscritos() {
		return mediaInscritos;
	}


	public void setMediaInscritos(String mediaInscritos) {
		this.mediaInscritos = mediaInscritos;
	}


	public String getSalario() {
		return salario;
	}


	public void setSalario(String salario) {
		this.salario = salario;
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


	public int getDesafio() {
		return desafio;
	}


	public void setDesafio(int desafio) {
		this.desafio = desafio;
	}
	
	
	
	

	

}
