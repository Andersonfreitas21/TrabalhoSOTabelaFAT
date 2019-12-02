package com.br.ufc.algoritmo;

import com.br.ufc.model.Arquivo;

public class First_fit {

	/**
	 * Seleciona o primeiro segmento livre com o tamanho suficiente para alocar o
	 * arquivo e a busca é feita seqüencialmente, interrompendo ao achar um segmento
	 * livre do tamanho adequado.
	 */
	
	private int[] tamanhoDiscoEmBlocos;
	private int[] tamanhoArquivoEmBlocos;

	public First_fit(int[] memoria, Arquivo arquivo) {
		this.tamanhoDiscoEmBlocos = memoria;
		this.tamanhoArquivoEmBlocos = new int[arquivo.getTamanhoArquivoEmBlocos()];
	}

	public void preenchendoMemoria() {
		
		
		
	}

}
