package com.projeto.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.projeto.java.dto.PessoaDTO;
import com.projeto.java.jdbc.ConnectionUtil;

public class PessoaDAO {

	public void inserir(PessoaDTO pessoaDTO) {
		try {
			Connection connection = ConnectionUtil.getInstance().getConnection();
			
			String sql = "INSERT INTO PESSOA (nome) VALUES(?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, pessoaDTO.getNome());
			
			statement.execute();

			statement.close();
			connection.close();
		} catch(Exception exception) {
			exception.printStackTrace();
		}
	}
	
	public void remover(int id) {
		try {
			Connection connection = ConnectionUtil.getInstance().getConnection();
		
			String sql = "DELETE FROM PESSOA WHERE id_pessoa = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.execute();
			
			statement.close();
			connection.close();
		} catch(Exception exception) {
			exception.printStackTrace();
		}
	}
	
	public List<PessoaDTO> listarTodos() {
		List<PessoaDTO> listaPessoas = new ArrayList<PessoaDTO>();
		
		try {
			Connection connection = ConnectionUtil.getInstance().getConnection();
			
			String sql = "SELECT * FROM PESSOA";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.execute();
			
			ResultSet resultSet = statement.executeQuery();
				
			while(resultSet.next()) {
				PessoaDTO pessoa = new PessoaDTO();
				pessoa.setId_pessoa(resultSet.getInt("id_pessoa"));
				pessoa.setNome(resultSet.getString("nome"));
				
				listaPessoas.add(pessoa);
			}
			
			statement.close();
			connection.close();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		return listaPessoas;
	}
	
}
