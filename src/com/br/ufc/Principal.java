package com.br.ufc;

import java.util.Scanner;

import com.br.ufc.model.Arquivo;
import com.br.ufc.model.TabelaFat;

public class Principal {

	private static Scanner scanner;

	public static void main(String[] args) {
		TabelaFat fat = new TabelaFat();

		scanner = new Scanner(System.in);
		int opt;
		boolean fatInvalido = false;
		Integer politicaAlocacao = null;
		int tamDisco = 0;

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

						if (fat.inicializarFat(tamDisco, politicaAlocacao) == null) {
							fatInvalido = false;
						} else {
							fatInvalido = true;
						}

					} catch (Exception e) {
						System.out.println("Formato Inválido! Erro : ");
						e.printStackTrace();
					}
				}

			} catch (Exception e) {
				System.out.println("Formato Inválido! Erro de leitura, informe a entrada tipo Inteiro.");
				fatInvalido = true;
			}

		} while (!fatInvalido);

		if (!fatInvalido) {
			System.out.println("Escolha uma das opções abaixo:\n");
			System.out.println();

			do {

				System.out.println("[1] - Adicionar Arquivo\n" + "[2] - Excluir Arquivo\n" + "[3] - Imprimir FAT\n"
						+ "[0] - Sair\n");
				opt = scanner.nextInt();

				switch (opt) {
				case 1:
					//Adicionando um arquivo
					System.out.println("Digite o nome do Arquivo: ");
					String nomeArq = scanner.nextLine();
					
					System.out.println("Digite o tamanho do arquivo. [Em Blocos] : ");
					int tamArq = scanner.nextInt();
					
					Arquivo arquivo = new Arquivo(nomeArq,tamArq);

					break;

				case 2:
					//Excluindo um arquivo
					
					break;

				case 3:
					fat.imprimeFat();
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
