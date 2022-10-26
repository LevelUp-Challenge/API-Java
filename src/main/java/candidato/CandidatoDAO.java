package candidato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;

public class CandidatoDAO {
	private Connection con = null;
	public static List<CandidatoTO> listaCandidato;

	private CandidatoTO candidato;

	public CandidatoDAO() {
		this.con = new Conexao().abrirConexao();
	}

	public List<CandidatoTO> getCandidato() {
		// recrutador = null;
		listaCandidato = new ArrayList<CandidatoTO>();
		String sql = "select * from t_lup_candidato";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					candidato = new CandidatoTO();
					candidato.setId(rs.getInt(1));
					candidato.setNome(rs.getString(2));
					candidato.setSexo(rs.getString(3));
					candidato.setDataNasc(rs.getString(4));
					candidato.setTelefone(rs.getString(5));
					candidato.setLogin(rs.getString(6));
					candidato.setSenha(rs.getString(7));
					listaCandidato.add(candidato);

				}
				Conexao.fecharConexao(con);
				return listaCandidato;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	public List<CandidatoTO> select(int id) {
		String sql = "select * from T_LUP_candidato where id_candidato = ?";
		List<CandidatoTO> CandidatoLista = new ArrayList();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				candidato = new CandidatoTO();
				candidato.setId(rs.getInt(1));
				candidato.setNome(rs.getString(2));
				candidato.setSexo(rs.getString(3));
				candidato.setDataNasc(rs.getString(4));
				candidato.setTelefone(rs.getString(5));
				candidato.setLogin(rs.getString(6));
				candidato.setSenha(rs.getString(7));
				CandidatoLista.add(candidato);
				Conexao.fecharConexao(con);
				return CandidatoLista;
			}
			Conexao.fecharConexao(con);
			return null;

		} catch (SQLException e) {
			return null;
		}
	}

	public String insert(CandidatoTO ct) {
		String sql = "insert into t_lup_candidato(id_candidato,"
				+ "nm_candidato,"
				+ "sx_candidato,"
				+ "dt_nascimento,"
				+ "nr_telefone,"
				+ "ds_login,"
				+ "ds_senha)"
				+ " values(sq_lup_candidato.nextval,?,?,?,?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ct.getNome());
			ps.setString(2, ct.getSexo());
			ps.setString(3, ct.getIdade());
			ps.setString(4, ct.getTelefone());
			ps.setString(5, ct.getLogin());
			ps.setString(6, ct.getSenha());



			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso!";
			} else {
				return "Erro ao Inserir!";
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String update(CandidatoTO ct) {
		String sql = "update t_lup_candidato set nm_candidato =?, sx_candidato=?, dt_nascimento=?,"
				+ " nr_telefone =?, ds_login =?, ds_senha =? ";
		sql += "where id_candidato = ?";
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ct.getNome());
			ps.setString(2, ct.getSexo());
			ps.setString(3, ct.getIdade());
			ps.setString(4, ct.getTelefone());
			ps.setString(5, ct.getLogin());
			ps.setString(6, ct.getSenha());
			ps.setInt(7, ct.getId());

			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso!";
			} else {
				return "Erro ao Inserir!";
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public String delete(int id) {
		String sql = "delete from t_lup_candidato where id_candidato = ?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso!";
			} else {
				return "Erro ao Inserir!";
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

}
