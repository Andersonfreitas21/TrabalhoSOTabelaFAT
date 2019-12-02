package com.br.ufc.algoritmo;

import com.br.ufc.model.Arquivo;

public class Best_fit {

	/*
	 * Seleciona o menor segmento livre disponível com o tamanho suficiente para
	 * armazenar o arquivo e é necessária a busca em toda a lista, caso esta não
	 * esteja ordenada por tamanho
	 */

	private int[] tamanhoDiscoEmBlocos;
	private int[] tamanhoArquivoEmBlocos;

	public Best_fit(int[] memoria, Arquivo arquivo) {
		this.tamanhoDiscoEmBlocos = memoria;
		this.tamanhoArquivoEmBlocos = new int[arquivo.getTamanhoArquivoEmBlocos()];
	}

	public void preenchendoMemoria() {
		
		
		
	}

}
