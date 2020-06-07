package com.projeto.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
	
}
