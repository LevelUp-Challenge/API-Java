package br.com.fiap.resource.candidato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.resource.conexao.Conexao;

public class FormacaoDAO {
	private Connection con = null;

	public static List<FormacaoTO> listaFormacao;

	private FormacaoTO formacao;

	public FormacaoDAO() {
		this.con = new Conexao().abrirConexao();
	}

	public List<FormacaoTO> getRecrutadores() {
		listaFormacao = new ArrayList<FormacaoTO>();
		String sql = "select * from t_lup_formacao";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					formacao = new FormacaoTO();
					formacao.setId(rs.getInt(1));
					formacao.setNmFormacao(rs.getString(2));
					formacao.setNmInstituicao(rs.getString(3));
					formacao.setGrauFormacao(rs.getString(4));
					formacao.setDtInicio(rs.getString(5));
					formacao.setDtTermino(rs.getString(6));
					listaFormacao.add(formacao);

				}
				Conexao.fecharConexao(con);
				return listaFormacao;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	public List<FormacaoTO> select(int id) {
		String sql = "select * from t_lup_formacao where id_curriculo = ?";
		List<FormacaoTO> formacaoLista = new ArrayList();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				formacao = new FormacaoTO();
				formacao.setId(rs.getInt(1));
				formacao.setNmFormacao(rs.getString(2));
				formacao.setNmInstituicao(rs.getString(3));
				formacao.setGrauFormacao(rs.getString(4));
				formacao.setDtInicio(rs.getString(5));
				formacao.setDtTermino(rs.getString(6));
				formacaoLista.add(formacao);
				Conexao.fecharConexao(con);
				return formacaoLista;
			}
			Conexao.fecharConexao(con);
			return null;

		} catch (SQLException e) {
			return null;
		}
	}

	public String insert(FormacaoTO fto) {
		String sql = "insert into T_LUP_FORMACAO (id_curriculo, ds_grau_formacao, "
				+ "dt_conclusao, dt_inicio, nm_formacao, nm_instituicao)"
				+ "values(SQ_LUP_FORMACAO.NEXTVAL,?,?,?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);

			ps.setString(1, fto.getGrauFormacao());
			ps.setString(2, fto.getDtTermino());
			ps.setString(3, fto.getDtInicio());
			ps.setString(4, fto.getNmFormacao());
			ps.setString(5, fto.getNmInstituicao());

			if (ps.executeUpdate() > 0) {
				return "inserido com sucesso!";
			} else {
				return "Erro ao inserir!";
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public String update(FormacaoTO fto) {
		String sql = "update T_LUP_FORMACAO set ds_grau_formacao =?, "
				+ "dt_conclusao =?, dt_inicio =?, nm_formacao =?, nm_instituicao =?";
		sql += "where id_curriculo =?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);

			ps.setString(1, fto.getGrauFormacao());
			ps.setString(2, fto.getDtTermino());
			ps.setString(3, fto.getDtInicio());
			ps.setString(4, fto.getNmFormacao());
			ps.setString(5, fto.getNmInstituicao());
			ps.setInt(6, fto.getId());

			if (ps.executeUpdate() > 0) {
				return "alterado com sucesso!";
			} else {
				return "Erro ao alterado!";
			}

		} catch (SQLException e) {
			return null;
		}

	}

	public String delete(int id) {
		String sql = "delete from T_LUP_FORMACAO where id_curriculo =?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			if (ps.executeUpdate() > 0) {
				return "deletado com sucesso!";
			} else {
				return "Erro ao deletar!";
			}

		} catch (SQLException e) {
			return null;
		}

	}

}
