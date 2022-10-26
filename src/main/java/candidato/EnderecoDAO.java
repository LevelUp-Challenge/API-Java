package candidato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;

public class EnderecoDAO {

	private Connection con = null;

	public static List<EnderecoTO> listaEndereco;

	private EnderecoTO endereco;

	public EnderecoDAO() {
		this.con = new Conexao().abrirConexao();
	}

	public List<EnderecoTO> getEndereco() {
		// recrutador = null;
		listaEndereco = new ArrayList<EnderecoTO>();
		String sql = "select * from t_lup_endereco";

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					endereco = new EnderecoTO();
					endereco.setId(rs.getInt(1));
					endereco.setBairro(rs.getString(2));
					endereco.setLogradouro(rs.getString(3));
					endereco.setEstado(rs.getString(4));
					endereco.setCidade(rs.getString(5));
					endereco.setCep(rs.getInt(6));
					endereco.setComplemento(rs.getString(7));

					listaEndereco.add(endereco);

				}
				Conexao.fecharConexao(con);
				return listaEndereco;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	public List<EnderecoTO> select(int id) {
		String sql = "select * from T_LUP_endereco where id_endereco = ?";
		List<EnderecoTO> enderecoLista = new ArrayList();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				endereco = new EnderecoTO();
				endereco.setId(rs.getInt(1));
				endereco.setBairro(rs.getString(2));
				endereco.setLogradouro(rs.getString(3));
				endereco.setEstado(rs.getString(4));
				endereco.setCidade(rs.getString(5));
				endereco.setCep(rs.getInt(6));
				endereco.setComplemento(rs.getString(7));
				enderecoLista.add(endereco);

				Conexao.fecharConexao(con);
				return enderecoLista;
			}
			Conexao.fecharConexao(con);
			return null;

		} catch (SQLException e) {
			return null;
		}
	}

	public String insert(EnderecoTO rto) {
		String sql = "insert into t_lup_endereco" + " (id_endereco, nm_bairro, ds_logradouro, nm_estado, nm_cidade,"
				+ " nr_cep, ds_complemento) "
				+ "values(sq_lup_endereco.nextval,?,?,?,?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			//ps.setInt(1, rto.getId());
			ps.setString(1, rto.getBairro());
			ps.setString(2, rto.getLogradouro());
			ps.setString(3, rto.getEstado());
			ps.setString(4, rto.getCidade());
			ps.setInt(5, rto.getCep());
			ps.setString(6, rto.getComplemento());
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

	public String update(EnderecoTO rto) {
		String sql = "update t_lup_endereco " + "set nm_bairro = ?" + ",ds_logradouro = ?," + " nm_estado = ?,"
				+ " nm_cidade = ?, nr_cep = ?, ds_complemento = ?" + "where id_endereco = ?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);

			ps.setString(1, rto.getBairro());
			ps.setString(2, rto.getLogradouro());
			ps.setString(3, rto.getEstado());
			ps.setString(4, rto.getCidade());
			ps.setInt(5, rto.getCep());
			ps.setString(6, rto.getComplemento());
			ps.setInt(7, rto.getId());

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
		String sql = "delete from t_lup_endereco where id_endereco = ?";
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
