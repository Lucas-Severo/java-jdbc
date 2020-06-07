package com.projeto.java.jdbc;

import java.util.List;

import com.projeto.java.dao.PessoaDAO;
import com.projeto.java.dto.PessoaDTO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        PessoaDAO pessoaDAO = new PessoaDAO();

        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setId_pessoa(3);
        pessoaDTO.setNome("Joao");
        pessoaDAO.atualizar(pessoaDTO);
        
        List<PessoaDTO> pessoas = pessoaDAO.listarTodos();
        pessoas.forEach(pessoa -> {
        	System.out.print("Id: " + pessoa.getId_pessoa());
        	System.out.print("\tNome: " + pessoa.getNome() + "\n");
        });

    }
}
