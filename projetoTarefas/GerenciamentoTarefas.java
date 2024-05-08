package projetoTarefas;

import java.util.ArrayList;
import java.util.Scanner;

class Tarefa {
	private String descricao;
	private boolean concluida;
	private String horario;

	public Tarefa(String descricao, String horario) {
		this.descricao = descricao;
		this.horario = horario;
		this.concluida = false;
	}

	public String getDescricao() {
		return descricao;
	}

	public boolean isConcluida() {
		return concluida;
	}

	public void marcarConcluida() {
		this.concluida = true;
	}

	public String getHorario() {
		return horario;
	}

	@Override
	public String toString() {
		return "Tarefa{" + "descricao='" + descricao + '\'' + ", horario='" + horario + '\'' + ", concluida="
				+ concluida + '}';
	}
}

public class GerenciamentoTarefas {
	public static void main(String[] args) {
		ArrayList<Tarefa> tarefas = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\nMenu:");
			System.out.println("1. Adicionar tarefa");
			System.out.println("2. Mostrar todas as tarefas");
			System.out.println("3. Marcar tarefa como concluída");
			System.out.println("4. Sair");
			System.out.print("Escolha uma opção: ");
			int opcao = scanner.nextInt();

			if (opcao == 1) {
				System.out.print("\nDigite a descrição da tarefa: ");
				scanner.nextLine(); 
				String descricao = scanner.nextLine();

				System.out.print("\nDigite o horário da tarefa: ");
				String horario = scanner.nextLine();

				Tarefa tarefa = new Tarefa(descricao, horario);
				tarefas.add(tarefa);
				System.out.println("Tarefa adicionada com sucesso!");
			} else if (opcao == 2) {
				System.out.println("\nTarefas:");
				for (int i = 0; i < tarefas.size(); i++) {
					System.out.println((i + 1) + ". " + tarefas.get(i));
				}
			} else if (opcao == 3) {
				System.out.print("Digite o número da tarefa que deseja marcar como concluída: ");
				int numTarefa = scanner.nextInt();
				if (numTarefa >= 1 && numTarefa <= tarefas.size()) {
					Tarefa tarefa = tarefas.get(numTarefa - 1);
					tarefa.marcarConcluida();
					System.out.println("Tarefa marcada como concluída com sucesso!");
				} else {
					System.out.println("Número de tarefa inválido.");
				}
			} else if (opcao == 4) {
				System.out.println("Saindo...");
				break;
			} else {
				System.out.println("Opção inválida. Tente novamente.");
			}
		}
		scanner.close();
	}
}