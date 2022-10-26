package br.com.fiap.resource.candidato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.resource.conexao.Conexao;
import br.com.fiap.resource.recrutador.RecrutadorTO;

public class CertificadosDAO {
	
	private Connection con = null;

	public static List<CertificadosTO> listaCertificados;

	private CertificadosTO certificados;

	public CertificadosDAO() {
		this.con = new Conexao().abrirConexao();
	}

	public List<CertificadosTO> getCertificados() {
		listaCertificados = new ArrayList<CertificadosTO>();
		String sql = "select * from t_lup_certificados";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					certificados = new CertificadosTO();
					certificados.setIdCertificados(rs.getInt(1));
					certificados.setDescricao(rs.getString(2));
					certificados.setCurso(rs.getString(3));
					listaCertificados.add(certificados);

				}
				Conexao.fecharConexao(con);
				return listaCertificados;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	public List<CertificadosTO> select(int id) {
		String sql = "select * from T_LUP_CERTIFICADOS where id_certificados = ?";
		List<CertificadosTO> certificadosLista = new ArrayList();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				certificados = new CertificadosTO();
				certificados.setIdCertificados(rs.getInt(1));
				certificados.setDescricao(rs.getString(2));
				certificados.setCurso(rs.getString(3));
				
				certificadosLista.add(certificados);
				Conexao.fecharConexao(con);
				return certificadosLista;
			}
			Conexao.fecharConexao(con);
			return null;

		} catch (SQLException e) {
			return null;
		}
	}

	public String insert(CertificadosTO rto) {
		String sql = "insert into T_LUP_CERTIFICADOS (id_certificados, ds_certificados, ds_cursos)"
				+ "values (SQ_LUP_CERTIFICADOS.NEXTVAL,?,?)";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, rto.getDescricao());
			ps.setString(2, rto.getCurso());
			
			if (ps.executeUpdate() > 0) {
				return "Certificado inserido com sucesso!";
			} else {
				return "Erro ao inserir o certificado!";
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String update(CertificadosTO rto) {
		String sql = "update T_LUP_CERTIFICADOS set ds_certificados = ?, ds_cursos = ?"
				+ "where id_certificados = ?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, rto.getDescricao());
			ps.setString(2, rto.getCurso());
			ps.setInt(3, rto.getIdCertificados());
			if (ps.executeUpdate() > 0) {
				return "alterado com sucesso!";

			} else {
				return "Erro ao alterar!";

			}
			// return ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String delete(int id) {
		String sql = "delete from T_LUP_CERTIFICADOS where id_certificados = ?";		PreparedStatement ps = null;
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
