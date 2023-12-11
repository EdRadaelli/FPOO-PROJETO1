package br.org.sesisp.view;
import br.org.sesisp.dao.crudDAO;
import java.util.Scanner;
import javax.swing.JOptionPane;

import br.org.sesisp.model.Aluno;
public class TelaMain {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		//instaciar um objeto aluno
		crudDAO inserir_aluno = new crudDAO();
		//instaciar um objeto aluno
		Aluno aluno1 = new Aluno();
		boolean valor = false;
		do{
				//int escolha = JOptionPane.showInputDialog("gfcgdb");
				String escolhaA = JOptionPane.showInputDialog(null, "Informe um valor: " + "\nCriar-0" + "\nAtualizar-1" + "\nLerBD-2" + "\nDeletar-3" + "\nSair-4");
				int escolha = Integer.parseInt(escolhaA);
				switch (escolha) {
				case (0)://create
					//criar aluno
					String idadeA = JOptionPane.showInputDialog(null, "Digite a idade do aluno: ");
					int idade = Integer.parseInt(idadeA);
					aluno1.setIdade(idade);
					aluno1.setNome(JOptionPane.showInputDialog(null, "Digite o nome do aluno: "));
					inserir_aluno.create(aluno1);
					JOptionPane.showMessageDialog(null, "Criado aluno de Nome: " + aluno1.getNome() + " Idade: " + aluno1.getIdade());
					break;
				case (1)://update
					//atualizar valoures 
					aluno1.setNome(JOptionPane.showInputDialog(null, "Digite o nome do aluno: "));
					String idadeB = JOptionPane.showInputDialog(null, "Digite a idade do aluno: ");
					int idadeb = Integer.parseInt(idadeB);
					aluno1.setIdade(idadeb);
					String raa = JOptionPane.showInputDialog(null, "Digite o ra do aluno: ");
					int arr = Integer.parseInt(raa);
					aluno1.setRa(arr);
					inserir_aluno.update(aluno1);
					JOptionPane.showMessageDialog(null, "Nome atualizado: " + aluno1.getNome() + "\nIdade atualizada: " + aluno1.getIdade());
					break;
				case (2)://ler lista
					//ler lista
					for (Aluno olho : inserir_aluno.read()) {
						JOptionPane.showMessageDialog(null, "NOME/IDADE/RA" + "\n" + olho.getNome() + " " + olho.getIdade() + " " + olho.getRa() + "\n");
					}
					break;
				case (3)://delete
					//excluir item da lista 
					String RA = JOptionPane.showInputDialog(null, "Digite o RA desejado para exclusao do aluno:");
					int ra = Integer.parseInt(RA);
					inserir_aluno.delete(ra);
					break;
				case (4):
					valor = true;
					JOptionPane.showMessageDialog(null, "Saindo do programa....");
					break;
				}//fim switch
		}while(valor == false);
		
	}//fim main

}//fim telamain
