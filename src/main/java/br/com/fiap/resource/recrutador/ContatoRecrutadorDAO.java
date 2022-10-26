package br.com.fiap.resource.recrutador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.resource.conexao.Conexao;

public class ContatoRecrutadorDAO {
	private Connection con = null;

	public static List<ContatoRecrutadorTO> listaContato;

	private ContatoRecrutadorTO contatoRecrutador;

	public ContatoRecrutadorDAO() {
		super();
		this.con = new Conexao().abrirConexao();
	}

	public List<ContatoRecrutadorTO> getContato() {
		listaContato = new ArrayList();
		String sql = "select * from t_lup_contato_recrutador";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					contatoRecrutador = new ContatoRecrutadorTO();
					contatoRecrutador.setId(rs.getInt(1));
					contatoRecrutador.setEmail(rs.getString(2));
					contatoRecrutador.setTelefone(rs.getInt(3));
					contatoRecrutador.setDdd(rs.getInt(4));
					contatoRecrutador.setDdi(rs.getInt(5));
					listaContato.add(contatoRecrutador);

				}
				Conexao.fecharConexao(con);
				return listaContato;

			} else {
				return null;
			}

		} catch (SQLException e) {
			return null;
		}

	}

	public List<ContatoRecrutadorTO> select(int id) {
		List<ContatoRecrutadorTO> contatoLista = new ArrayList();
		String sql = "select * " + "from t_lup_contato_recrutador where id_contato =?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				contatoRecrutador = new ContatoRecrutadorTO();
				contatoRecrutador.setId(rs.getInt(1));
				contatoRecrutador.setEmail(rs.getString(2));
				contatoRecrutador.setTelefone(rs.getInt(3));
				contatoRecrutador.setDdd(rs.getInt(4));
				contatoRecrutador.setDdi(rs.getInt(5));
				contatoLista.add(contatoRecrutador);
				Conexao.fecharConexao(con);
				return contatoLista;
			}
			Conexao.fecharConexao(con);
			return null;

		} catch (SQLException e) {
			return null;
		}

	}

	public int insert(ContatoRecrutadorTO crt) {
		String sql = "insert into t_lup_contato_recrutador" + " (id_contato, ds_emails, ds_telefone, ds_ddd, ds_ddi)"
				+ "values (sq_lup_contato_recrutador.nextval,?,?,?,?) ";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			//ps.setInt(1, crt.getId());
			ps.setString(1, crt.getEmail());
			ps.setInt(2, crt.getTelefone());
			ps.setInt(3, crt.getDdd());
			ps.setInt(4, crt.getDdi());
			return ps.executeUpdate() ;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 1;
		}

	}

	public String update(ContatoRecrutadorTO crt) {
		String sql = "update t_lup_contato_recrutador set ds_emails = ?, ds_telefone= ?, ds_ddd = ?,"
				+ " ds_ddi= ? where id_contato = ? ";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, crt.getEmail());
			ps.setInt(2, crt.getTelefone());
			ps.setInt(3, crt.getDdd());
			ps.setInt(4, crt.getDdi());
			ps.setInt(5, crt.getId());
			if (ps.executeUpdate() > 0) {
				return "alterado com sucesso";

			} else {
				return "Falha ao alterar!";

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public String delete(int id) {
		String sql = "delete from t_lup_contato_recrutador where id_contato = ?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			if (ps.executeUpdate() > 0) {
				return "deletado com sucesso!";
			} else {
				return "Falha ao deletar!";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		}
	}

}
