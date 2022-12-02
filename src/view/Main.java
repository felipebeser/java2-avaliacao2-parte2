package view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import model.Aluno;
import repository.AlunoRepositoryImpl;

public class Main {

	public static void main(String[] args) {
		
		String res;
		Scanner sc = new Scanner(System.in);
		AlunoRepositoryImpl rep = new AlunoRepositoryImpl();
		
		do {
			System.out.println("\n1 - Listar alunos");
			System.out.println("2 - Cadastrar aluno");
			System.out.println("3 - Buscar aluno pela primeira letra");
			System.out.println("4 - Buscar aluno pelo id");
			System.out.println("5 - Atualizar aluno pelo id");
			System.out.println("6 - Deletar aluno pelo id");
			System.out.println("7 - Sair");
			res = sc.nextLine();
			
			switch(res) {
				case "1":
					List<Aluno> alunos = rep.getAll();
					for(Aluno aluno: alunos) {
						System.out.println(aluno.toString());			
					}
					break;
				case "2":
					System.out.println("Cadastrar aluno");
					Aluno novoAluno = new Aluno();
					System.out.println("Digite o nome do aluno:");
					novoAluno.setNome(sc.nextLine());
					System.out.println("Digite o email do aluno:");
					novoAluno.setEmail(sc.nextLine());
					System.out.println("Digite o cpf do aluno:");
					novoAluno.setCpf(sc.nextLine());
					rep.insert(novoAluno);
					System.out.println("Aluno cadastrado.");
					break;
				case "3":
					System.out.println("\nBuscar aluno:");
					System.out.println("Digite a primeira letra do aluno:");
					String letra = sc.nextLine();
					alunos = rep.getAllByFirstLetter(letra);
					if(alunos.size()>0){
						for(Aluno aluno: alunos) {
							System.out.println(aluno.toString());			
						}
					} else {
						System.out.println("Nenhum aluno encontrado.");
					}
					break;
				case "4":
					System.out.println("\nBuscar aluno pelo id:");
					System.out.println("Digite o id do aluno:");
					String id = sc.nextLine();
					Aluno aluno = rep.get(id);
					System.out.println(aluno.toString());
					break;
				case "5":
					System.out.println("Editar Aluno:");
					System.out.println("Digite o id do aluno que gostaria de editar: ");
					id = sc.nextLine();
					aluno = rep.get(id);
					
					if(aluno != null) {
						System.out.println("Editando o aluno: ");
						System.out.println(aluno.toString());
						String[] campos = {"nome", "email", "cpf", "dataNascimento", "naturalidade", "endereco"};
						String escolha;
						String update;
						for(String campo: campos) {
							System.out.println("Deseja editar o campo "+ campo + "? (s/n)");
							escolha = sc.nextLine();
							while(!(escolha.equals("s") || escolha.equals("n"))) {
								System.out.println("Digite s ou n.");
								escolha=sc.nextLine();
							}
							if(escolha.equals("s")) {
								System.out.println("Digite o novo valor do " + campo);
								update = sc.nextLine();
								switch(campo) {
								case "nome":
									aluno.setNome(update);
									break;
								case "email":
									aluno.setEmail(update);
									break;
								case "cpf":
									aluno.setCpf(update);
									break;
								case "dataNascimento":
									aluno.setDataNascimento(update);
									break;
								case "naturalidade":
									aluno.setNaturalidade(update);
									break;
								case "endereco":
									aluno.setEndereco(update);
								}
							}	
							if(escolha.equals("n")) {
								continue;
							}
						}
						rep.update(aluno);
						System.out.println("Aluno editado!");
					} else {
						System.out.println("Aluno não encontrado");
					}
					break;
				case "6":
					System.out.println("\nDeletar aluno:");
					System.out.println("Digite o id do aluno que deseja remover:");
					id = sc.nextLine();
					aluno = rep.get(id);
					rep.delete(aluno);
					System.out.println("Aluno removido.");
					break;
			}
		} while (!res.equals("7"));
		System.out.println("Programa finalizado.");
	}
}
