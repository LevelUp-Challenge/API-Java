package teste;

import candidato.CandidatoDAO;
import candidato.CandidatoTO;
import candidato.CertificadosDAO;
import candidato.CertificadosTO;
import candidato.EnderecoDAO;
import candidato.EnderecoTO;
import candidato.FormacaoCandidatoDAO;
import candidato.FormacaoCandidatoTO;
import candidato.FormacaoDAO;
import candidato.FormacaoTO;
import processoSeletivo.DesafioCandidatoDAO;
import processoSeletivo.DesafioCandidatoTO;
import processoSeletivo.ProcessoSeletivoDAO;
import processoSeletivo.ProcessoSeletivoTO;
import recrutador.ContatoRecrutadorDAO;
import recrutador.ContatoRecrutadorTO;
import recrutador.RecrutadorDAO;
import recrutador.RecrutadorTO;

public class Teste {

	public static void main(String[] args) {
		
//		//Recrutador tudo OK!!!
//		RecrutadorDAO rdao = new RecrutadorDAO();
//		RecrutadorTO rto = new RecrutadorTO();
////		rto.setNome("jhonatas");
////		rto.setLogin("jhonas2004");
////		rto.setSenha("1234");
////		rto.setAreas_recrutamento("abcd");
//	//	rto.setId(27);
		
//		System.out.println(rdao.delete(50));
		
		
//		//Contato Recrutador TUDO ok!!!
//		ContatoRecrutadorDAO crdao = new ContatoRecrutadorDAO();
//		ContatoRecrutadorTO cto = new ContatoRecrutadorTO();
//		cto.setEmail("11111");
//		cto.setTelefone(1);
//		cto.setDdd(1);
//		cto.setDdi(26);
//		cto.setId(26);
//		
//		System.out.println(crdao.delete(26));
//		
//		ProcessoSeletivoDAO psdao = new ProcessoSeletivoDAO();
//		ProcessoSeletivoTO psto = new ProcessoSeletivoTO();
//		psto.setAreaVaga("ti");
//		psto.setBeneficiosVaga("vARIOS");
//		psto.setDesafio("game");
//		psto.setDescricaoVaga("alou");
//		psto.setInscritos(500);
//		psto.setMediaInscritos("Masculino");
//		psto.setModalidadeVaga("Junior");
//		psto.setNomeVaga("Vaga ti Backend");
//		psto.setPcdAplicavel("sim");
//		psto.setSalario(500.00);
//		
//		System.out.println(psdao.);
		
		
//		DESAFIO CANDIDATO TUDO OK!
//		DesafioCandidatoDAO ddao = new DesafioCandidatoDAO();
//		DesafioCandidatoTO dto = new DesafioCandidatoTO();
//		
//		//dto.setIdDesafioCandidato(41);
//		dto.setPontuacao(10);
//		dto.setStatus("mira");
//		dto.setTempoAplicacao("mira");
//		dto.setAprovacao("mira");
//		dto.setId(1);
//		
//		System.out.println(ddao.delete(1));
	
		
//		FormacaoDAO fdao = new FormacaoDAO();
//		FormacaoTO fto = new FormacaoTO();
////		fto.setDtInicio("aaaaa");
////		fto.setDtTermino("aaaaa");
////		fto.setGrauFormacao("aaaaa");
////		fto.setNmFormacao("aaaaa");
////		fto.setNmInstituicao("aaaaa");
////		fto.setId(9);
//		System.out.println(fdao.delete(9));
		
//		FormacaoCandidatoDAO fcdao = new FormacaoCandidatoDAO();
//		FormacaoCandidatoTO fto = new FormacaoCandidatoTO();
//		fto.setStatus("C");
//		fto.setTpFormacao("A");
//		fto.setId(4);
//		
//		System.out.println(fcdao.delete(4));
		
//		CandidatoDAO cdao = new CandidatoDAO();
//		CandidatoTO cto = new CandidatoTO();
//		
////		cto.setNome("jhonny");
////		cto.setDataNasc("60");
////		cto.setIdade("18");
////		cto.setLogin("abc");
////		cto.setSenha("13");
////		cto.setSexo("mascaaaaaaaa");
////		cto.setTelefone("134");
////		cto.setId(4);
////		
//		
//		System.out.println(cdao.delete(4));
//		
		
//		CertificadosTO cto = new CertificadosTO();
//		CertificadosDAO cdao = new CertificadosDAO();
//		
//		cto.setCurso("abc");
//		cto.setDescricao("abc");
//		cto.setIdCertificados(26);
//		
//		System.out.println(cdao.insert(cto));
		
		EnderecoDAO edao = new EnderecoDAO();
		EnderecoTO eto = new EnderecoTO();
		
		eto.setId(1234);
		eto.setCep(121113);
		eto.setCidade("sp");
		eto.setBairro("pq america");
		eto.setComplemento("aoi");
		eto.setEstado("abc");
		eto.setLogradouro("abc");
		
		System.out.println(edao.insert(eto));
		
		

	}

}
