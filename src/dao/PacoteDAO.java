package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pacote.TurismoPacote;
import pacote.TurismoPasseio;


public class PacoteDAO {
	
	public TurismoPacote adicionarPacote(TurismoPacote pacote) throws SQLException{
		TurismoPacote novo = null;
		Connection con = null;
		
		String sql = "insert into pacote (descPacote,dataEmbarque,dataRetorno,custo)" 
		+ "values(?,?,?,?)";
		
		String sql2 = "select max(idPacote),descPacote,dataEmbarque,dataRetorno,custo from pacote ";
		
		try{

			con = Conexao.getConexao();
			
			PreparedStatement smt = con.prepareStatement(sql);
			smt.setString(1, pacote.getDesc());
			smt.setDate(2, new Date (pacote.getDataEmbarque().getTime()));
			smt.setDate(3, new Date (pacote.getDataRetorno().getTime()));
			smt.setDouble(4, pacote.getCusto());
			smt.execute();
			
			PreparedStatement smt2 = con.prepareStatement(sql2);
			
			ResultSet rs = smt2.executeQuery();
			while(rs.next()) {
				novo = new TurismoPacote();
				
				novo.setId(rs.getInt(1));
				novo.setDesc(rs.getString(2));
				novo.setDataEmbarque(rs.getDate(3));
				novo.setDataRetorno(rs.getDate(4));
				novo.setCusto(rs.getDouble(5));
				
			}
			
			smt.close();
						
		} catch (Exception e){
			
			e.printStackTrace();
			
		}finally{
			
			con.close();
			
		}
		return novo;
	}
	public void adicionarPacotePasseio(int idPacote,int idPasseio) throws SQLException{
		
		Connection con = null;
		
		String sql = "insert into passeiopacote (idPacote,idPasseio)" 
		+ "values(?,?)";
		
		try{
			con = Conexao.getConexao();
			
			PreparedStatement smt = con.prepareStatement(sql);
			
			smt.setInt(1,idPacote);
			smt.setInt(2,idPasseio);
			smt.execute();
			smt.close();
						
		} catch (Exception e){
			
			e.printStackTrace();
			
		}finally{
			
			con.close();
			
		}
		
	}
	public void removerPacotePasseio(int idPacote) throws SQLException{
		
		Connection con = null;
		
		String sql = "DELETE from passeiopacote where idPacote = ?";
		
		try{
			con = Conexao.getConexao();
			
			PreparedStatement smt = con.prepareStatement(sql);
			
			smt.setInt(1, idPacote);
			
			smt.execute();
			smt.close();
						
		} catch (Exception e){
			
			e.printStackTrace();
			
		}finally{
			
			con.close();
			
		}
		
	}
	
	public void removerPacote(int idPacote) throws SQLException{
		
		Connection con = null;
		
		String sql = "DELETE from pacote where idPacote = ?";
		
		try{
			con = Conexao.getConexao();
			
			PreparedStatement smt = con.prepareStatement(sql);
			
			smt.setInt(1, idPacote);
			
			smt.execute();
			smt.close();
						
		} catch (Exception e){
			
			e.printStackTrace();
			
		}finally{
			
			con.close();
			
		}
		
	}
	
	
	public void inserirPacotePasseio(int idPacote,int idPasseio) throws SQLException{
		
		Connection con = null;
		
		String sql = "insert into passeiopacote (IdPacote,IdPasseio)" 
		+ "values(?,?)";
		
		try{
			con = Conexao.getConexao();
			
			PreparedStatement smt = con.prepareStatement(sql);
			
			smt.setInt(1,idPacote);
			smt.setInt(2, idPasseio);
			
			smt.execute();
			smt.close();
						
		} catch (Exception e){
			
			e.printStackTrace();
			
		}finally{
			
			con.close();
			
		}
		
	}
	public TurismoPacote buscarPacote(int idPacote) throws SQLException{
		
		TurismoPacote pacote = new TurismoPacote();
		
		ArrayList<TurismoPasseio> lista = new ArrayList<TurismoPasseio>();
		
		Connection con = null;
		
		String sql = "select  pacote.idPacote,pacote.descPacote,pacote.dataEmbarque,pacote.dataRetorno,pacote.custo,passeio.idPasseio, "
				+ "passeio.descPasseio,passeio.localPasseio from pacote"
				+ " join passeiopacote on pacote.idPacote = "
				+ "passeiopacote.idPacote join passeio on "
				+ "passeio.idPasseio = passeiopacote.idPasseio  WHERE passeiopacote.idPacote = ?";
		
		try{
			con = Conexao.getConexao();
			
			PreparedStatement smt = con.prepareStatement(sql);
			smt.setInt(1, idPacote);
			
			ResultSet rs = smt.executeQuery();
			while(rs.next()) {
			
			TurismoPasseio passeio = new TurismoPasseio();
			
				pacote.setId(rs.getInt(1));
				pacote.setDesc(rs.getString(2));
				pacote.setDataEmbarque(rs.getDate(3));
				pacote.setDataRetorno(rs.getDate(4));
				pacote.setCusto(rs.getDouble(5));
				
				passeio.setId(rs.getInt(6));
				passeio.setDescPasseio(rs.getString(7));
				passeio.setLocal(rs.getString(8));
				
				
				lista.add(passeio);
				
			}
			smt.execute();
			smt.close();
			pacote.setListaPasseios(lista);
						
		} catch (Exception e){
			
			e.printStackTrace();
			
		}finally{
			
			con.close();
			
		}
		
		return pacote;
	}
	
	public ArrayList<TurismoPacote> listarPacote() throws SQLException{
		
		ArrayList<TurismoPacote> pacote = new ArrayList<TurismoPacote>();
		ArrayList<Integer> lista = new ArrayList<Integer>();
		
		Connection con = null;
		
		String sql = "select * from pacote";
		
		try{
			con = Conexao.getConexao();
			
			PreparedStatement smt = con.prepareStatement(sql);
			
			ResultSet rs = smt.executeQuery();
			while(rs.next()) {
				lista.add(rs.getInt(1));
				
			}
			smt.execute();
			smt.close();
			for(int x: lista){
				pacote.add(this.buscarPacote(x));
			}
						
		} catch (Exception e){
			
			e.printStackTrace();
			
		}finally{
			
			con.close();
			
		}
		
		return pacote;
	}
}