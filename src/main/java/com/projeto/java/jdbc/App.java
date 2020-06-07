package com.projeto.java.jdbc;

import java.util.List;

import com.projeto.java.dao.PessoaDAO;
import com.projeto.java.dto.PessoaDTO;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
    	
    	PessoaDAO pessoaDAO = new PessoaDAO();
    	int opc, id;
    	String nome;
    	Scanner sc = new Scanner(System.in);
    	
    	do {
    		System.out.println("\n1) Inserir uma pessoa");
    		System.out.println("2) Atualizar uma pessoa");
    		System.out.println("3) Remover uma pessoa");
    		System.out.println("4) Listar todas as pessoas");
    		System.out.println("5) Sair");
    		System.out.print(">>> ");
    		
    		opc = sc.nextInt();
    		
    		if (opc == 1) {
    			sc.nextLine();
    			
    			System.out.print("\nNome: ");
    			nome = sc.nextLine();
    			
    			PessoaDTO pessoaDTO = new PessoaDTO();
    	        pessoaDTO.setNome(nome);
    			pessoaDAO.inserir(pessoaDTO);
    			
    			System.out.println("\nPessoa inserida com sucesso!\n");
    		} else if (opc == 2) {
    			
    			System.out.print("\nId: ");
    			id = sc.nextInt();
    			
    			sc.nextLine();
    			System.out.print("Nome: ");
    			nome = sc.nextLine();
    			
    			PessoaDTO pessoaDTO = new PessoaDTO();
    	        pessoaDTO.setId_pessoa(id);
    	        pessoaDTO.setNome(nome);
    	        pessoaDAO.atualizar(pessoaDTO);
	
    		} else if (opc == 3) {
    			System.out.print("\nId: ");
    			
    			id = sc.nextInt();
    			
    			pessoaDAO.remover(id);
    		} else if (opc == 4) {
    			System.out.println("\nListando todas as pessoas\n");
    			List<PessoaDTO> pessoas = pessoaDAO.listarTodos();
    	        pessoas.forEach(pessoa -> {
    	        	System.out.print("Id: " + pessoa.getId_pessoa());
    	        	System.out.print("\tNome: " + pessoa.getNome() + "\n");
    	        });
    		} else if (opc == 5) {
    			System.out.println("\nSaiu\n");
    		} else {
    			System.out.println("\nOpcao nao reconhecida\n");
    		}
    		
    	} while(opc != 5);
   
        sc.close();
    }
}
