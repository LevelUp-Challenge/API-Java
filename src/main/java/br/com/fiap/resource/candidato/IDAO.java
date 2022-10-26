package br.com.fiap.resource.candidato;

import java.util.ArrayList;

public interface IDAO {
	
	public String inserir(Object obj);
	
	public String alterar(Object obj);
	
	public String excluir(Object obj);
	
	public ArrayList<String> listar(int id);
	
	//public String currval(Object obj);

}
