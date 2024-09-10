package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import factory.Conexao;
import model.Tabelas;

// Classe de regra de negócio
public class TabelaDAO {
    /**
     * CRUD CREATE READ UPDATE DELETE
     */
    
    // Utilizando o try-with-resources para fechar conexões automaticamente
    public void save(Tabelas tabela) throws SQLException {
        String sql = "INSERT INTO APOSTAS(esporte, competicao, mandante, visitante, odd, valor, retorno) VALUES (?,?,?,?,?,?,?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, tabela.getEsporte());
            ps.setString(2, tabela.getCompeticao());
            ps.setString(3, tabela.getMandante());
            ps.setString(4, tabela.getVisitante());
            ps.setDouble(5, tabela.getOdd());
            ps.setDouble(6, tabela.getValor());
            ps.setDouble(7, tabela.getRetorno());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<Tabelas> listar() throws SQLException {
        String sql = "SELECT * FROM APOSTAS";
        List<Tabelas> dados = new ArrayList<>();

        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Tabelas tabelas = new Tabelas();
                tabelas.setId_aposta(rs.getInt("id_aposta"));
                tabelas.setCompeticao(rs.getString("competicao"));
                tabelas.setEsporte(rs.getString("esporte"));
                tabelas.setMandante(rs.getString("mandante"));
                tabelas.setVisitante(rs.getString("visitante"));
                tabelas.setOdd(rs.getDouble("odd"));
                tabelas.setValor(rs.getDouble("valor"));
                tabelas.setRetorno(rs.getDouble("retorno"));
                dados.add(tabelas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return dados;
    }

    public void update(Tabelas tabela) throws SQLException {
        String sql = "UPDATE APOSTAS SET esporte = ?, competicao = ?, mandante = ?, visitante = ?, odd = ?, valor = ?, retorno = ? WHERE id_aposta = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, tabela.getEsporte());
            ps.setString(2, tabela.getCompeticao());
            ps.setString(3, tabela.getMandante());
            ps.setString(4, tabela.getVisitante());
            ps.setDouble(5, tabela.getOdd());
            ps.setDouble(6, tabela.getValor());
            ps.setDouble(7, tabela.getRetorno());
            ps.setInt(8, tabela.getId_aposta());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void deleteById(int id) {
    	String sql = "DELETE FROM APOSTAS WHERE id_aposta = ? ";
    	Connection conn = null;
    	PreparedStatement ps = null;
    	
    	try {
    		conn = Conexao.getConexao();
    		ps = conn.prepareStatement(sql);
    		ps.setInt(1,id );
    		
    		ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				
				if(ps!=null) {
					ps.close();
					
				}
				if(conn!=null) {
					conn.close();
					
				}
				
				
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
    	
    }


}
