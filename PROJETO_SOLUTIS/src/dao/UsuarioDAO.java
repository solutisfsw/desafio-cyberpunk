package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.clones;

public class UsuarioDAO {
	// a conexão com o banco de dados
	private Connection con;

	public UsuarioDAO() {
		this.con = (Connection) ConexaoSingleton.getInstance();
	}

	public boolean adicionar(clones clones) {

		boolean retorno = false;

		String sql = "insert into CLONE "
				+ "(nome,skill,idade,criacao,genero,especial)"
				+ " values (?,?,?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = con.prepareStatement(sql);

			// seta os valores (da ?) da instrução SQL
			stmt.setString(1, clones.getNome());
			stmt.setString(2, clones.getSkill());
			stmt.setInt(3, clones.getIdade());
			stmt.setString(4, clones.getCriacao());
			stmt.setString(5, clones.getGenero());
			stmt.setString(6, clones.getEspecial());
			
		
			

			// executa
			stmt.execute();
			stmt.close();
			retorno = true;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return retorno;
	}

	public List<clones> getListaclones() {
		try {
			List<clones> listaclones = new ArrayList<clones>();
			PreparedStatement stmt = this.con.prepareStatement("select *from CLONE");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Usuario para adicionar na lista
				clones clones = new clones();
				clones.setIdClone(rs.getInt("idClone"));
				clones.setNome(rs.getString("nome"));
				clones.setSkill(rs.getString("skill"));
				clones.setIdade(rs.getInt("idade"));
				clones.setCriacao(rs.getString("criacao"));
				clones.setGenero(rs.getString("genero"));
				clones.setEspecial(rs.getString("especial"));
				
			

				// adicionando o objeto à lista
				listaclones.add(clones);
			}
			rs.close();
			stmt.close();
			return listaclones;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public clones obterclones (int idClone) {
		clones clones = new clones();
		try {
			PreparedStatement preparedStatement = con
					.prepareStatement("select * from CLONE where idClone = ?");
			preparedStatement.setInt(1, idClone);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				// criando o objeto Usuario para adicionar na lista
			
				clones.setIdClone(rs.getInt("idClone"));
				clones.setNome(rs.getString("nome"));
				clones.setSkill(rs.getString("skill"));
				clones.setIdade(rs.getInt("idade"));
				clones.setCriacao(rs.getString("criacao"));
				clones.setGenero(rs.getString("genero"));
				clones.setEspecial(rs.getString("especial"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return clones;
	}

	
	public clones obterinfo (String nome) {
		clones clones = new clones();
		try {
			PreparedStatement preparedStatement = con
					.prepareStatement("select * from CLONE where nome = ?");
			preparedStatement.setString(1, nome);

			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				// criando o objeto Usuario para adicionar na lista
			
				clones.setNome(rs.getString("nome"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return clones;
	}
	
	public List<clones> pesquisa(String nome, String skill, String idClone, String idade, String criacao, String genero, String especial) {
		try {
			List<clones> listaclones = new ArrayList<clones>();
			PreparedStatement stmt = this.con.prepareStatement("select *from CLONE where nome = ? or skill = ? or idClone = ? or idade=? or criacao=? or genero=? or especial=?");
			stmt.setString(1, nome);
			stmt.setString(2, skill);
			stmt.setString(3, idClone);
			stmt.setString(4, idade);
			stmt.setString(5, criacao);
			stmt.setString(6, genero);
			stmt.setString(7, especial);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Usuario para adicionar na lista
				clones clones = new clones();
				clones.setIdClone(rs.getInt("idClone"));
				clones.setNome(rs.getString("nome"));
				clones.setSkill(rs.getString("skill"));
				clones.setIdade(rs.getInt("idade"));
				clones.setCriacao(rs.getString("criacao"));
				clones.setGenero(rs.getString("genero"));
				clones.setEspecial(rs.getString("especial"));
				
			

				// adicionando o objeto à lista
				listaclones.add(clones);
			}
			rs.close();
			stmt.close();
			return listaclones;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean alterar(clones clones) {
		boolean retorno = false;
		String sql = "update CLONE"
				+ " set skill=?, idade=?, criacao=?, genero=?, especial=?"
				+ " where idClone=?";
		

		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			
			stmt.setString(1, clones.getSkill());
			stmt.setInt(2, clones.getIdade());
			stmt.setString(3, clones.getCriacao());
			stmt.setString(4, clones.getGenero());
			stmt.setString(5, clones.getEspecial());
			stmt.setInt(6, clones.getIdClone());

			stmt.execute();
			stmt.close();
			retorno = true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return retorno;
	}
	
	public boolean remover(clones clones) {
 	    boolean retorno = false; 
		try {
 	         PreparedStatement stmt = con.prepareStatement("delete " +
 	                 "from CLONE where idClone=?");
 	         stmt.setLong(1, clones.getIdClone());
 	         stmt.execute();
 	         stmt.close();
 	         retorno = true;
 	     } catch (SQLException e) {
 	         throw new RuntimeException(e);
 	     }
		return retorno;
 	 }

}
