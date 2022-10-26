package br.com.fiap.resource.candidato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.resource.conexao.Conexao;

public class FormacaoCandidatoDAO {
	private Connection con = null;

	public static List<FormacaoCandidatoTO> listaFormacao;

	private FormacaoCandidatoTO formacao;

	public FormacaoCandidatoDAO() {
		this.con = new Conexao().abrirConexao();
	}

	public List<FormacaoCandidatoTO> getFormacao() {
		listaFormacao = new ArrayList<FormacaoCandidatoTO>();
		String sql = "select * from t_lup_formacao_candidato";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					formacao = new FormacaoCandidatoTO();
					formacao.setId(rs.getInt(1));
					formacao.setTpFormacao(rs.getString(2));
					formacao.setStatus(rs.getString(3));
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

	public List<FormacaoCandidatoTO> select(int id) {
		String sql = "select * from T_LUP_formacao_candidato where id_formacao_candidato = ?";
		List<FormacaoCandidatoTO> formacaoLista = new ArrayList();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				formacao = new FormacaoCandidatoTO();
				formacao.setId(rs.getInt(1));
				formacao.setTpFormacao(rs.getString(2));
				formacao.setStatus(rs.getString(3));
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

	public String insert(FormacaoCandidatoTO fcto) {
		String sql = "insert into T_LUP_FORMACAO_CANDIDATO (id_formacao_candidato, tp_formacao, ds_status_formacao)"
				+ "values (SQ_LUP_FORMACAO_CANDIDATO.NEXTVAL,?,?)";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, fcto.getTpFormacao());
			ps.setString(2, fcto.getStatus());
			if (ps.executeUpdate() > 0) {
				return "inserido com sucesso!";
			} else {
				return "Erro ao inserir!";
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		}

	}

	public String update(FormacaoCandidatoTO fcto) {
		String sql = "update T_LUP_FORMACAO_CANDIDATO set tp_formacao =?, ds_status_formacao =?";
		sql += "where id_formacao_candidato =?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, fcto.getTpFormacao());
			ps.setString(2, fcto.getStatus());
			ps.setInt(3, fcto.getId());
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

	public String delete(int id) {
		String sql = "delete from T_LUP_FORMACAO_CANDIDATO where id_formacao_candidato = ?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);

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
}
