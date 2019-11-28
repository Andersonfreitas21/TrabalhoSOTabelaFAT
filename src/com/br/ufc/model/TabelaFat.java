package com.br.ufc.model;

import java.util.List;

import lombok.Data;

@Data
public class TabelaFat {

	private int tamanhoDisco;
	private int totalBlocos;
	private int blocosOcupados;
	private int memoriaOcupada;
	private int [] tabelaFat;
	private Integer politicaAlocacao;
	private List<Arquivo> listaArquivos; 
	
	public int[] inicializarFat(int tamanhoDisco, Integer politicaAlocacao) {
		if(tamanhoDisco > 0) {
			tabelaFat = new int[tamanhoDisco];
		}
		return tabelaFat;
	}
	
	public void adicionaArquivo (Arquivo arquivo, Integer politica) {
		// Adicionar as referências do arquivo na Tabela FAT (ID,TAMANHO EM BLOCOS) de acordo com a política de alocação

		if(politica.equals(1)) {
			// Best Fit - Melhor espaço
			
		} else if(politica.equals(2)) {
			// First Fit - Primeiro espaço disponível
			
		} else {
			// Worst Fit - Pior espaço para alocação
			
		}
		
		listaArquivos.add(arquivo);
	}
	
	public void imprimeFat() {
		
		System.out.println("Total de Blocos do disco: " + totalBlocos);
		System.out.println("Blocos ocupados: " +  blocosOcupados);
		System.out.println("Memoria Ocupada (Blocos): " + memoriaOcupada);
		System.out.println("Blocos Livres: " + (totalBlocos - blocosOcupados));
		System.out.println("Memoria Livre (Blocos): " + (tamanhoDisco - memoriaOcupada));
		System.out.println();
		

		for (int i = 0; i < tabelaFat.length; i++) {
			System.out.println(i + "         " + tabelaFat[i]);
		}
		System.out.println();
	}

	public Boolean verificaCapacidade() {
		Boolean blocosLivres;
		if(tabelaFat.length > 0 || tabelaFat.length <= tamanhoDisco) {
			blocosLivres = true;
		} else {
			blocosLivres = false;
		}
		return blocosLivres;
	}
}
