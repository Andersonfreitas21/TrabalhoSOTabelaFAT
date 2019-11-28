package com.br.ufc;

import java.util.Scanner;

import com.br.ufc.model.Arquivo;
import com.br.ufc.model.TabelaFat;

public class Principal {

	private static Scanner scanner;

	public static void main(String[] args) {
		TabelaFat tabelaFat = new TabelaFat();

		scanner = new Scanner(System.in);
		int opt;
		boolean fatInvalido = false;
		Integer politicaAlocacao = null;
		int tamDisco = 0;
		String nomeArq = null;

		do {
			System.out.println("Digite o tamanho do disco. [Em Blocos] : ");

			try {
				tamDisco = scanner.nextInt();

				if (tamDisco > 0) {
					System.out.print("Digite a política de alocação." + "\n" + "Best fit  - [1]\n" + "First fit - [2]\n"
							+ "Worst fit - [3]\n" + "Sair      - [0]\n");
					try {
						politicaAlocacao = scanner.nextInt();

						switch (politicaAlocacao) {
						case 1:
						case 2:
						case 3:
							break;
						case 0:
							System.out.println("Saindo...");
							System.exit(0);
							break;
						default:
							System.out.println("Opção Inválida.");
							break;
						}

						if (tabelaFat.inicializarFat(tamDisco, politicaAlocacao) == null) {
							fatInvalido = false;
						} else {
							fatInvalido = true;
						}

					} catch (Exception e) {
						System.out.println("Formato Inválido! Erro : " + e.getMessage());
					}
				}

			} catch (Exception e) {
				System.out
						.println("Formato Inválido! Erro de leitura, informe a entrada tipo Inteiro." + e.getMessage());
				fatInvalido = true;
			}

		} while (!fatInvalido);

		if (fatInvalido) {
			System.out.println("Escolha uma das opções abaixo:\n");
			System.out.println();

			do {

				System.out.println("[1] - Adicionar Arquivo\n" + "[2] - Excluir Arquivo\n" + "[3] - Imprimir FAT\n"
						+ "[0] - Sair\n");
				opt = scanner.nextInt();

				switch (opt) {
				case 1:
					// Verificar se a tabela FAT não está em sua capacidade máxima
					if (tabelaFat.verificaCapacidade()) {
						// Adicionando um arquivo
						System.out.println("Digite o nome do Arquivo: ");
						nomeArq = scanner.next();

						System.out.println("Digite o tamanho do arquivo. [Em Blocos] : ");
						int tamArq = scanner.nextInt();

						Arquivo arquivo = new Arquivo(nomeArq, tamArq);
					} else {
						System.out.println("Tabela FAT está em sua capacidade de armazenamento esgotada.");
						tabelaFat.imprimeFat();
					}

					break;

				case 2:
					// Excluindo um arquivo
					tabelaFat.imprimeFat();
					System.out.println("Qual arquivo deseja excluir ? : ");

					break;

				case 3:
					tabelaFat.imprimeFat();
					break;

				case 0:
					System.out.println("Saindo...");
					System.exit(0);
					break;

				default:
					System.out.println("Opção invalida! ");
					break;
				}
			} while (opt != 0);
		}
	}
}
