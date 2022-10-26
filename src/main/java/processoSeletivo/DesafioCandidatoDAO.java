package processoSeletivo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;

public class DesafioCandidatoDAO {
	private Connection con = null;

	public static List<DesafioCandidatoTO> listaDesafio;

	private DesafioCandidatoTO desafio;

	public DesafioCandidatoDAO() {
		this.con = new Conexao().abrirConexao();
	}

	public List<DesafioCandidatoTO> getDesafio() {
		// recrutador = null;
		listaDesafio = new ArrayList<DesafioCandidatoTO>();
		String sql = "select * from T_LUP_DESAFIO_CANDIDATO";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					desafio = new DesafioCandidatoTO();
					desafio.setId(rs.getInt(1));
					desafio.setStatus(rs.getString(2));
					desafio.setPontuacao(rs.getInt(3));
					desafio.setTempoAplicacao(rs.getString(4));
					desafio.setAprovacao(rs.getString(5));
					listaDesafio.add(desafio);

				}
				Conexao.fecharConexao(con);
				return listaDesafio;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	public List<DesafioCandidatoTO> select(int id) {
		String sql = "select * from T_LUP_DESAFIO_CANDIDATO where id_teste_vaga = ?";
		List<DesafioCandidatoTO> desafioLista = new ArrayList();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				desafio = new DesafioCandidatoTO();
				desafio.setId(rs.getInt(1));
				desafio.setAprovacao(rs.getString(2));
				desafio.setPontuacao(rs.getInt(3));
				desafio.setTempoAplicacao(rs.getString(3));
				desafio.setAprovacao(rs.getString(2));
				desafioLista.add(desafio);
				Conexao.fecharConexao(con);
				return desafioLista;
			}
			Conexao.fecharConexao(con);
			return null;

		} catch (SQLException e) {
			return null;
		}
	}

	public String inserir(DesafioCandidatoTO dto) {
		String sql = "insert into T_LUP_DESAFIO_CANDIDATO(id_teste_vaga,"
				+ "ds_aprovacao,"
				+ " ds_pontuacao,"
				+ " ds_tempo_aplicacao,"
				+ " ds_aprovado)"
				+ " values(sq_lup_desafio_candidato.nextval,?,?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			//ps.setInt(1, dto.getIdDesafioCandidato());
			ps.setString(1, dto.getAprovacao());
			ps.setInt(2, dto.getPontuacao());
			ps.setString(3, dto.getTempoAplicacao());
			ps.setString(4, dto.getStatus());

			if (ps.executeUpdate() > 0) {
				return "Desafio do Candidato inserido com sucesso!";
			} else {
				return "Erro ao inserir Desafio do Candidato!";
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public String alterar(DesafioCandidatoTO dto) {
		String sql = "update T_LUP_DESAFIO_CANDIDATO set ds_aprovacao = ?, ds_pontuacao = ?, ds_tempo_aplicacao =?, ds_aprovado=? "
				+ "where id_teste_vaga = ?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getAprovacao());
			ps.setInt(2, dto.getPontuacao());
			ps.setString(3, dto.getTempoAplicacao());
			ps.setString(4, dto.getStatus());
			ps.setInt(5, dto.getId());
			
			if (ps.executeUpdate() > 0) {
				return "Desafio do Candidato alterado com sucesso!";
			} else {
				return "Erro ao alterar Desafio do Candidato!";
			}

		} catch (SQLException e) {
			return null;
		}

		
	}
	public String delete(int id) {
		String sql = "delete from T_LUP_DESAFIO_CANDIDATO where id_teste_vaga  = ?";
		PreparedStatement ps = null;
		try {
			 ps = con.prepareStatement(sql);
			 ps.setInt(1, id);
			 
			 if (ps.executeUpdate() > 0) {
					return "Desafio do Candidato deletado com sucesso!";
				} else {
					return "Erro ao deletar Desafio do Candidato!";
				}
			
		} catch (SQLException e) {
			return null;
		}

	}

}
