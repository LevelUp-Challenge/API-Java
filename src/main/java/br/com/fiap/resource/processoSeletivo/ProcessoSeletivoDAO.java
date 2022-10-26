package br.com.fiap.resource.processoSeletivo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.resource.conexao.Conexao;

public class ProcessoSeletivoDAO {
	private Connection con = null;

	public static List<ProcessoSeletivoTO> listaVagas;

	private ProcessoSeletivoTO processoSeletivo;

	public ProcessoSeletivoDAO() {
		this.con = new Conexao().abrirConexao();
	}

	public List<ProcessoSeletivoTO> getVaga() {
		// recrutador = null;
		listaVagas = new ArrayList<ProcessoSeletivoTO>();
		String sql = "select * from t_lup_processo_seletivo";
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					processoSeletivo = new ProcessoSeletivoTO();
					processoSeletivo.setId(rs.getInt(1));
					processoSeletivo.setNomeVaga(rs.getString(2));
					processoSeletivo.setDescricaoVaga(rs.getString(3));
					processoSeletivo.setAreaVaga(rs.getString(4));
					processoSeletivo.setSalario(rs.getDouble(5));
					processoSeletivo.setBeneficiosVaga(rs.getString(6));
					processoSeletivo.setModalidadeVaga(rs.getString(7));
					processoSeletivo.setPcdAplicavel(rs.getString(8));
					processoSeletivo.setDesafio(rs.getString(9));
					processoSeletivo.setInscritos(rs.getInt(10));
					processoSeletivo.setMediaInscritos(rs.getString(11));
					listaVagas.add(processoSeletivo);

				}
				Conexao.fecharConexao(con);
				return listaVagas;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	public List<ProcessoSeletivoTO> select(int id) {
		String sql = "select * from t_lup_processo_seletivo where id_vaga =?";
		List<ProcessoSeletivoTO> vagaLista = new ArrayList();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				processoSeletivo = new ProcessoSeletivoTO();
				processoSeletivo.setId(rs.getInt(1));
				processoSeletivo.setNomeVaga(rs.getString(2));
				processoSeletivo.setDescricaoVaga(rs.getString(3));
				processoSeletivo.setAreaVaga(rs.getString(4));
				processoSeletivo.setSalario(rs.getDouble(5));
				processoSeletivo.setBeneficiosVaga(rs.getString(6));
				processoSeletivo.setModalidadeVaga(rs.getString(7));
				processoSeletivo.setPcdAplicavel(rs.getString(8));
				processoSeletivo.setDesafio(rs.getString(9));
				processoSeletivo.setInscritos(rs.getInt(10));
				processoSeletivo.setMediaInscritos(rs.getString(11));
				vagaLista.add(processoSeletivo);
				Conexao.fecharConexao(con);
				return vagaLista;
			}
			Conexao.fecharConexao(con);
			return null;

		} catch (SQLException e) {
			return null;
		}
	}

	public int insert(ProcessoSeletivoTO psto) {
		String sql = "insert into T_LUP_PROCESSO_SELETIVO" + " (id_vaga," + " ds_nome_vaga," + " ds_descricao_vaga,"
				+ " ds_area_vaga," + " ds_salario," + " ds_beneficios_vaga," + "ds_modalidade_vaga," + " pcd_aplicavel,"
				+ " ts_desafio," + " qt_inscritos," + " md_sexo_inscritos"
				+ " ) values (SQ_LUP_PROCESSO_SELETIVO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			// ps.setInt(1, psto.getId());
			ps.setString(1, psto.getNomeVaga());
			ps.setString(2, psto.getDescricaoVaga());
			ps.setString(3, psto.getAreaVaga());
			ps.setDouble(4, psto.getSalario());
			ps.setString(5, psto.getBeneficiosVaga());
			ps.setString(6, psto.getModalidadeVaga());
			ps.setString(7, psto.getPcdAplicavel());
			ps.setString(8, psto.getDesafio());
			ps.setInt(9, psto.getInscritos());
			ps.setString(10, psto.getMediaInscritos());
			return ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 1;
		}

	}

	public int update(ProcessoSeletivoTO psto) {

		String sql = "update T_LUP_PROCESSO_SELETIVO set ds_nome_vaga = ?, ds_descricao_vaga = ?, ds_area_vaga = ?, ds_salario = ?,"
				+ "ds_beneficios_vaga = ?, "
				+ "ds_modalidade_vaga = ?, pcd_aplicavel = ?, ts_desafio = ?, qt_inscritos = ?, md_sexo_inscritos = ?"
				+ "where id_vaga = ?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, psto.getNomeVaga());
			ps.setString(2, psto.getDescricaoVaga());
			ps.setString(3, psto.getAreaVaga());
			ps.setDouble(4, psto.getSalario());
			ps.setString(5, psto.getBeneficiosVaga());
			ps.setString(6, psto.getModalidadeVaga());
			ps.setString(7, psto.getPcdAplicavel());
			ps.setString(8, psto.getDesafio());
			ps.setInt(9, psto.getInscritos());
			ps.setString(10, psto.getMediaInscritos());
			ps.setInt(11, psto.getId());

			return ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 1;
		}
	}

	public int delete(int id) {
		String sql = "delete from T_LUP_PROCESSO_SELETIVO where id_vaga = ?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			return ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 1;
		}
	}

}
