package recrutador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;

public class RecrutadorDAO {
	private Connection con = null;

	public static List<RecrutadorTO> listaRec;

	private RecrutadorTO recrutador;

	public RecrutadorDAO() {
		this.con = new Conexao().abrirConexao();
	}

	public List<RecrutadorTO> getRecrutadores() {
		listaRec = new ArrayList<RecrutadorTO>();
		String sql = "select * from t_lup_recrutador";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					recrutador = new RecrutadorTO();
					recrutador.setId(rs.getInt(1));
					recrutador.setNome(rs.getString(2));
					recrutador.setLogin(rs.getString(3));
					recrutador.setSenha(rs.getString(4));
					recrutador.setAreas_recrutamento(rs.getString(5));
					listaRec.add(recrutador);

				}
				Conexao.fecharConexao(con);
				return listaRec;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	public List<RecrutadorTO> select(int id) {
		String sql = "select * from T_LUP_RECRUTADOR where id_recrutador = ?";
		List<RecrutadorTO> recrutadorLista = new ArrayList();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				recrutador = new RecrutadorTO();
				recrutador.setId(rs.getInt(1));
				recrutador.setNome(rs.getString(2));
				recrutador.setLogin(rs.getString(3));
				recrutador.setSenha(rs.getString(4));
				recrutador.setAreas_recrutamento(rs.getString(5));
				recrutadorLista.add(recrutador);
				Conexao.fecharConexao(con);
				return recrutadorLista;
			}
			Conexao.fecharConexao(con);
			return null;

		} catch (SQLException e) {
			return null;
		}
	}

	public int insert(RecrutadorTO rto) {
		String sql = "insert into t_lup_recrutador" + "(id_recrutador, nm_recrutador,"
				+ " ds_login, ds_senha, ds_areas_recrutamento) " + " values(sq_lup_recrutador.nextval,?,?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, rto.getNome());
			ps.setString(2, rto.getLogin());
			ps.setString(3, rto.getSenha());
			ps.setString(4, rto.getAreas_recrutamento());
			return ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 1;
		}
	}

	public String update(RecrutadorTO rto) {
		String sql = "update t_lup_recrutador " + "set nm_recrutador = ?" + ",ds_login = ?," + " ds_senha = ?,"
				+ " ds_areas_recrutamento = ?" + "where id_recrutador = ?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, rto.getNome());
			ps.setString(2, rto.getLogin());
			ps.setString(3, rto.getSenha());
			ps.setString(4, rto.getAreas_recrutamento());
			ps.setInt(5, rto.getId());
			if (ps.executeUpdate() > 0) {
				return "Deletado com sucesso!";

			} else {
				return "Erro ao deletar!";

			}
			// return ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String delete(int id) {
		String sql = "delete from t_lup_recrutador where id_recrutador = ?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			if (ps.executeUpdate() > 0) {
				return "Deletado com sucesso!";

			} else {
				return "Erro ao deletar!";

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

}
