package com.br.ufc.model;

import java.util.List;

import com.br.ufc.algoritmo.Best_fit;
import com.br.ufc.algoritmo.First_fit;
import com.br.ufc.algoritmo.Worst_fit;

import lombok.Data;

@Data
public class TabelaFat {

	private int tamanhoDiscoEmBlocos;
	private int totalBlocos;
	private int blocosOcupados;
	private int memoriaOcupada;
	private int [] memoria;
	private List<Arquivo> listaArquivos; 
	private Arquivo arquivo;
	
	public int[] inicializaMemoria(int tamanhoDisco) {
		this.tamanhoDiscoEmBlocos = tamanhoDisco;
		if(tamanhoDiscoEmBlocos > 0) {
			memoria = new int[tamanhoDiscoEmBlocos];
		}
		return memoria;
	}
	
	public void adicionaArquivo (Arquivo arquivo, Integer politicaAlocacao) {
		// Adicionar as referências do arquivo na Tabela FAT (ID,TAMANHO EM BLOCOS) de acordo com a política de alocação
		this.arquivo = arquivo;
		
		if(politicaAlocacao.equals(1)) {
			// Best Fit - Melhor espaço
			Best_fit best = new Best_fit(memoria, arquivo);
			
		} else if(politicaAlocacao.equals(2)) {
			// First Fit - Primeiro espaço disponível
			First_fit first = new First_fit(memoria, arquivo);
		} else {
			// Worst Fit - Pior espaço para alocação
			Worst_fit worst = new Worst_fit(memoria, arquivo);
		}
		
		listaArquivos.add(arquivo);
	}
	
	public void imprimeFat() {
		
		System.out.println("Total de Blocos do disco: " + this.tamanhoDiscoEmBlocos);
		System.out.println("Blocos ocupados: " +  blocosOcupados);
		System.out.println();
		
	}

	public Boolean verificaCapacidade() {
		Boolean blocosLivres;
		if(memoria.length > 0 || memoria.length <= tamanhoDiscoEmBlocos) {
			blocosLivres = true;
		} else {
			blocosLivres = false;
		}
		return blocosLivres;
	}
}
