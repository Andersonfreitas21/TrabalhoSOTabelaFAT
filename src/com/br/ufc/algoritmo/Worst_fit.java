package com.br.ufc.algoritmo;

import com.br.ufc.model.Arquivo;

public class Worst_fit {

	/**
	 * Seleciona o maior segmento livre e a busca funciona como no caso anterior.
	 */
	
	private int[] tamanhoDiscoEmBlocos;
	private int[] tamanhoArquivoEmBlocos;

	public Worst_fit(int[] memoria, Arquivo arquivo) {
		this.tamanhoDiscoEmBlocos = memoria;
		this.tamanhoArquivoEmBlocos = new int[arquivo.getTamanhoArquivoEmBlocos()];
	}

	public void preenchendoMemoria() {
		
		
		
	}

}
