package com.br.ufc;

import java.util.Scanner;

import com.br.ufc.model.Arquivo;
import com.br.ufc.model.TabelaFat;

import lombok.Data;

@Data	
public class Principal {

	private static Scanner scanner;
	private static int tamanhoDisco = 0;
	private static Integer politicaAlocacao = null;
	private static int opt = 0;
	private static boolean fatInvalido = false;
	private static String nomeArq = null;

	public static void main(String[] args) {
		
		TabelaFat tabelaFat = new TabelaFat();
		scanner = new Scanner(System.in);
		
		do {
			System.out.print("Digite o tamanho do disco. [Em Blocos] :  ");

			try {
				tamanhoDisco = scanner.nextInt();

				if (tamanhoDisco > 0) {
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

						if (tabelaFat.inicializaMemoria(tamanhoDisco) == null) {
							fatInvalido = false;
						} else {
							fatInvalido = true;
						}

					} catch (Exception e) {
						System.out.println("Formato Inválido! Erro : " + e.getMessage());
					}
				}

			} catch (Exception e) {
				fatInvalido = true;
				opt = 1;
				System.out.println(
						"Formato Inválido! Erro de leitura, informe a entrada tipo int. " + "" + e.getMessage());
			}

		} while (!fatInvalido);

		if (fatInvalido && opt == 0) {
			System.out.println("Escolha uma das opções abaixo:\n");
			System.out.println();

			do {

				System.out.println("[1] - Adicionar Arquivo\n" + "[2] - Excluir Arquivo\n" + "[3] - Imprimir FAT\n"
						+ "[0] - Sair\n");
				opt = scanner.nextInt();

				switch (opt) {
				case 1:
					// Verificar se o disco tem espaço para alocar um arquivo
					if (tabelaFat.verificaCapacidade()) {
						// Adicionando um arquivo
						System.out.println("Digite o nome do Arquivo: ");
						nomeArq = scanner.next();

						System.out.println("Digite o tamanho do arquivo. [Em Blocos] : ");
						int tamanhoDoArquivoEmBlocos = scanner.nextInt();

						Arquivo arquivo = new Arquivo(nomeArq, tamanhoDoArquivoEmBlocos);
						tabelaFat.adicionaArquivo(arquivo, politicaAlocacao);
						
					} else {
						System.out.println("Memória cheia.");
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
