package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import taskDash.ListaTarefas;
import taskDash.Status;

public class Principa {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<ListaTarefas> minhasTarefas = new ArrayList<>();

        do {
            System.out.println("--- Sistema de Lista de Tarefas ---");
            System.out.println("Selecione a opção que deseja abaixo: ");
            System.out.println("1 - Criar tasks.");
            System.out.println("2 - Listar tasks");
            System.out.println("3 - concluir tasks");
            System.out.println("4 - sair");
            int opcao = scan.nextInt();
            scan.nextLine(); 

            switch (opcao) {

                case 1:
          
                    System.out.print("NOME DA TASK: ");
                    String nome = scan.nextLine();
                    System.out.print("DATA DA TASK: ");
                    String descricao = scan.nextLine();
                    System.out.print("DESCRIÇÃO DA TASK: ");
                    String data = scan.nextLine();
                    ListaTarefas tarefa1 = new ListaTarefas(nome, data, descricao);
                    minhasTarefas.add(tarefa1);
                    System.out.println("TAREFA ADICIONADA COM SUCESSO.\n");
                    break;

                case 2:
                  
                    System.out.println("\nQUAL TIPO DE TASK GOSTARIA DE LISTAR: ");
                    System.out.println(" 1 - TAREFAS CONCLUÍDAS");
                    System.out.println(" 2 - TAREFAS PENDENTES");
                    System.out.println(" 3 - TAREFAS EM ANDAMENTO");
                    int lista1 = scan.nextInt();
                    scan.nextLine(); 
                    switch (lista1) {
                        case 1:
                            System.out.println("\n--- TAREFAS CONCLUÍDAS ---");
                            for (ListaTarefas tarefa : minhasTarefas) {
                                if (tarefa.getStatus() == Status.CONCLUIDAS) {
                                    System.out.println("NOME: " + tarefa.getNome() + " | DATA: " + tarefa.getData() + " | DESCRIÇÃO: " + tarefa.getDescricao());
                                }
                            }
                            System.out.println("--------------------------\n");
                            break; 
                        case 2:
                            System.out.println("\n--- TAREFAS PENDENTES ---");
                            if (minhasTarefas.isEmpty()) {
                                System.out.println("Nenhuma tarefa encontrada.");
                            } else {
                                for (ListaTarefas tarefa : minhasTarefas) {
                                    if (tarefa.getStatus() == Status.PENDENTE) {
                                        System.out.println("NOME: " + tarefa.getNome() + " | DATA: " + tarefa.getData() + " | DATA: " + tarefa.getDescricao());
                                    }
                                }
                            }
                            System.out.println("-----------------------\n");
                            break; 
                        case 3:
                            System.out.println("\n--- TAREFAS EM ANDAMENTO ---");
                             for (ListaTarefas tarefa : minhasTarefas) {
                                if (tarefa.getStatus() == Status.EM_ANDAMENTO) {
                                    System.out.println("NOME: " + tarefa.getNome() + " | DATA: " + tarefa.getData() + " | DESCRIÇÃO: " + tarefa.getDescricao());
                                }
                            }
                            System.out.println("----------------------------\n");
                            break;
                        default:
                            System.out.println("Opção de listagem inválida.\n");
                            break;
                    }
                    break;
                    
                case 3:
          
                    System.out.println("VOCÊ GOSTARIA DE: ");
                    System.out.println("");
                    System.out.println(" 1 - concluir tasks \n"
                    		+ " 2 - excluir tasks ");
                    
                    int lista2 = scan.nextInt();
                    scan.nextLine();
                    
                    switch (lista2) {
                    
                    case 1: 
                    	for (int i = 0; i <  minhasTarefas.size() ; i++) {
                    		 ListaTarefas tarefa = minhasTarefas.get(i);
                    		if (tarefa.getStatus() == Status.PENDENTE || tarefa.getStatus() == Status.EM_ANDAMENTO) {
                    			System.out.println((i + 1 ) + " - " + tarefa.getNome());
                    		}
                    	}
                    	System.out.println("QUAL NÚMERO DA TASK QUE VOCÊ GOSTARIA DE CONCLUIR ?");
                    	int concluir = scan.nextInt();
                    	int indice = concluir - 1;
                    	if (concluir >= 0 && indice < minhasTarefas.size()) {
                    		ListaTarefas tarefaPalterar = minhasTarefas.get(indice);
                        	tarefaPalterar.setStatus(Status.CONCLUIDAS);
                        	
                        	System.out.println("tarefa concluida com sucesso!");
                        	
                    	} else {
                    		System.out.println("ERRO: número da task errado");
                    	}
						break;
                    
                    case 2:
                    	
                    	for (int i = 0; i <  minhasTarefas.size() ; i++) {
                   		 ListaTarefas tarefa = minhasTarefas.get(i);
                   		if (tarefa.getStatus() == Status.CONCLUIDAS ) {
                   			System.out.println((i + 1 ) + " - " + tarefa.getNome());
                   		}
                   	}
                   	System.out.println("QUAL NÚMERO DA TASK QUE VOCÊ GOSTARIA DE EXCLUIR ?");
                   	int excluir = scan.nextInt();
                   	int indicee = excluir - 1;
                   	if (excluir >= 0 && indicee < minhasTarefas.size()) {
                   		ListaTarefas tarefaPexcluir = minhasTarefas.get(indicee);
                   		minhasTarefas.remove(indicee);
                       	
                       	System.out.println("tarefa excluida com sucesso!");
                       	
                   	} else {
                   		System.out.println("ERRO: número da task errado");
                   	}}
                    break; 
                    	
                case 4:
                    System.out.println("Saindo do sistema...");
                    
                    scan.close(); 
                    return; 

                default:
                    System.out.println("Opção inválida.");
                    break; 
            
            } 

        } while (true);
    
    } 

} 