package recrutador;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ContatoRecrutadorTO {
	private int id; // retirar
	private String email;
	private int telefone;
	private int ddd;
	private int ddi;

	public ContatoRecrutadorTO() {

	}

	public ContatoRecrutadorTO(int id, String email, int telefone, int ddd, int ddi) {
		this.id = id;
		this.email = email;
		this.telefone = telefone;
		this.ddd = ddd;
		this.ddi = ddi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public int getDdi() {
		return ddi;
	}

	public void setDdi(int ddi) {
		this.ddi = ddi;
	}

}
