package processoSeletivo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;

public class ProcessoSeletivoDAO {
	private Connection con = null;

	public static List<ProcessoSeletivoTO> listaVagas;

	private ProcessoSeletivoTO processoSeletivo;

	public ProcessoSeletivoDAO() {
		this.con = new Conexao().abrirConexao();
	}

	public List<ProcessoSeletivoTO> getVaga() {
		listaVagas = new ArrayList<ProcessoSeletivoTO>();
		String sql = "select * from t_lup_processo_seletivo";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					processoSeletivo = new ProcessoSeletivoTO();
					processoSeletivo.setId(rs.getInt(1));
					processoSeletivo.setNomeVaga(rs.getString(2));
					processoSeletivo.setAreaVaga(rs.getString(3));
					processoSeletivo.setSalario(rs.getString(4));
					processoSeletivo.setBeneficiosVaga(rs.getString(5));
					processoSeletivo.setPcdAplicavel(rs.getString(6));
					processoSeletivo.setDesafio(rs.getInt(7));
					processoSeletivo.setInscritos(rs.getInt(8));
					processoSeletivo.setMediaInscritos(rs.getString(9));
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
				processoSeletivo.setAreaVaga(rs.getString(3));
				processoSeletivo.setSalario(rs.getString(4));
				processoSeletivo.setBeneficiosVaga(rs.getString(5));
				processoSeletivo.setPcdAplicavel(rs.getString(6));
				processoSeletivo.setDesafio(rs.getInt(7));
				processoSeletivo.setInscritos(rs.getInt(8));
				processoSeletivo.setMediaInscritos(rs.getString(9));
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
		String sql = "insert into T_LUP_PROCESSO_SELETIVO" + " (id_vaga," + " ds_nome_vaga," 
				+ " ds_area_vaga," + " ds_salario," + " ds_beneficios_vaga,"  + " pcd_aplicavel,"
				+ " ts_desafio," + " qt_inscritos," + " md_sexo_inscritos"
				+ " ) values (SQ_LUP_PROCESSO_SELETIVO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, psto.getNomeVaga());
			ps.setString(2, psto.getAreaVaga());
			ps.setString(3, psto.getSalario());
			ps.setString(4, psto.getBeneficiosVaga());
			ps.setString(5, psto.getPcdAplicavel());
			ps.setInt(6, psto.getDesafio());
			ps.setInt(7, psto.getInscritos());
			ps.setString(8, psto.getMediaInscritos());
			return ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 1;
		}

	}

	public int update(ProcessoSeletivoTO psto) {

		String sql = "update T_LUP_PROCESSO_SELETIVO set ds_nome_vaga = ?,  ds_area_vaga = ?, ds_salario = ?,"
				+ "ds_beneficios_vaga = ?, "
				+ " pcd_aplicavel = ?, ts_desafio = ?, qt_inscritos = ?, md_sexo_inscritos = ?"
				+ "where id_vaga = ?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, psto.getNomeVaga());
			ps.setString(2, psto.getAreaVaga());
			ps.setString(3, psto.getSalario());
			ps.setString(4, psto.getBeneficiosVaga());
			ps.setString(5, psto.getPcdAplicavel());
			ps.setInt(6, psto.getDesafio());
			ps.setInt(7, psto.getInscritos());
			ps.setString(8, psto.getMediaInscritos());
			ps.setInt(9, psto.getId());

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
