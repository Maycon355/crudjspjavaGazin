package com.crudjspjava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.crudjspjava.bean.Usuario;

public class UsuarioDao {

	public static Connection getConnection() {
		Connection con = null;

		// Fazendo a conexão com o Banco de dados
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crudjspjava", "root", "");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static Usuario getRegistroById(int id) {

		Usuario usuario = null;

		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM usuario WHERE id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setDatanascimento(rs.getString("datanascimento"));
				usuario.setHobby(rs.getString("hobby"));
				usuario.setSexo(rs.getString("sexo"));
				usuario.setCidade(rs.getString("cidade"));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return usuario;

	}

	public static int salvarUsuario(Usuario u) {
		int status = 0;

		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement)con.prepareStatement("INSERT INTO usuario (nome, sexo, hobby, cidade, datanascimento) VALUES (?,?,?,?,?);");
			ps.setString(1, u.getNome());
			ps.setString(2, u.getSexo());
			ps.setString(3, u.getHobby());
			ps.setString(4, u.getCidade());
			ps.setString(5, u.getDatanascimento());
		
			status = ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public static int deletarUsuario(Usuario u){
		int status = 0;
		
		

		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM usuario WHERE id=?");
			ps.setInt(1, u.getId());
			
			ps.executeUpdate();
		
		} catch (Exception e) {
			System.out.println(		e);
		}
		return status;
				
	}
		
	public static int updateUsuario(Usuario u) {
		int status = 0;

		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(
					"UPDATE usuario SET nome=?, sexo=?, hobby=?, cidade=?, datanascimento=? WHERE id=?");

			ps.setString(1, u.getNome());
			ps.setString(2, u.getSexo());
			ps.setString(3, u.getHobby());
			ps.setString(4, u.getCidade());
			ps.setString(5, u.getDatanascimento());
			ps.setInt(6, u.getId());

			status = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static List<Usuario> getAllUsuarios() {
		List<Usuario> list = new ArrayList<Usuario>();

		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM usuario");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Usuario usuario = new Usuario();

				// Pegando a instância do Banco
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSexo(rs.getString("sexo"));
				usuario.setDatanascimento(rs.getString("datanascimento"));
				usuario.setHobby(rs.getString("Hobby"));
				usuario.setCidade(rs.getString("Cidade"));
				list.add(usuario);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return list;
	}

}
