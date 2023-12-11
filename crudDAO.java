package br.org.sesisp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.org.sesisp.controller.Conexao;
import br.org.sesisp.model.Aluno;

public class crudDAO {
	//cruddao
	//crud c-Create r-Read u-Update d-Delete
	
	//Create (inserir DADOS)
	public void create(Aluno aluno) {
		String sql = "INSERT INTO alunos(nome, idade) VALUES (?, ?)";
		Connection conn = null;
		PreparedStatement p = null;
		try {
			conn = Conexao.criandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql);//cast classe de pai ve a filha
			p.setString(1, aluno.getNome());
			p.setInt(2, aluno.getIdade());
			p.execute();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "erro ao inserir dados! \nERRO: " + e);
		}finally {
			try {
				if(p != null);
				p.close();
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		
	}//fim create
	
	//metodo atualizar (update)
	public void update(Aluno aluno) {
		String sql = "UPDATE alunos SET nome = ?, idade = ?  WHERE ra = ?";
		Connection conn = null;
		PreparedStatement p = null;
		try {
			conn = Conexao.criandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql);//cast classe de pai ve a filha
			p.setString(1, aluno.getNome());
			p.setInt(2, aluno.getIdade());
			p.setInt(3, aluno.getRa());
			p.execute();//"executa inst para gravar" dados no banco
			JOptionPane.showMessageDialog(null, "dados atualizados com sucesso!");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "erro ao inserir dados! \nERRO: " + e);
		}finally {
			try {
				if(p != null);
				p.close();
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}//fim update
	
	//read
	public List<Aluno> read(){
		String sql = "SELECT * FROM alunos";
		List<Aluno> alunos = new ArrayList<Aluno>();
		Connection conn = null;
		PreparedStatement p = null;
		ResultSet resultado = null;
		try {
			conn = Conexao.criandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql);//cast classe de pai ve a filha
		    resultado = p.executeQuery();//mostra os dados da consulta sql
		    while(resultado.next()){
		    	Aluno ver_aluno = new Aluno();
		    	//recuperar ra
		    	ver_aluno.setRa(resultado.getInt("ra"));
		    	//recuperar nome
		    	ver_aluno.setNome(resultado.getString("nome"));
		    	//recuperar a idade
		    	ver_aluno.setIdade(resultado.getInt("idade"));
		    	//adicionar na lista
		    	alunos.add(ver_aluno);
		    }
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
				try {
					if(p != null);
					p.close();
				}catch (Exception e){
					e.printStackTrace();
				}
		}
			return alunos;
	}//fim read
	
	//delete
	public boolean delete(int ra) {
		String sql = "DELETE FROM alunos WHERE ra = ?";
		Connection conn = null;
		PreparedStatement p = null;
		try {
			conn = Conexao.criandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql);//cast classe de pai ve a filha
			p.setInt(1, ra);
			p.execute();
			JOptionPane.showMessageDialog(null, "dados excluidos com sucesso!");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "erro ao excluir dados \nERRO: " + e);
		}finally {
				try {
					if(p != null);
					p.close();
				}catch (Exception e){
					e.printStackTrace();
				}
		}
		return false;
	}//fim delete
	
}//fim class crud


