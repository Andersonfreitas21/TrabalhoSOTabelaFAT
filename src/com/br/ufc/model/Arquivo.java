package com.br.ufc.model;

public class Arquivo {

	private String nomeArquivo;
	private int blocoInicial;
	private int tamanhoArquivoEmBlocos;
	
	public Arquivo(String nomeArq, int tamArq) {
		this.nomeArquivo = nomeArq;
		this.tamanhoArquivoEmBlocos = tamArq;
	}
	
	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public int getTamanhoArquivoEmBlocos() {
		return tamanhoArquivoEmBlocos;
	}

	public void setTamanhoArquivoEmBlocos(int tamanhoArquivoEmBlocos) {
		this.tamanhoArquivoEmBlocos = tamanhoArquivoEmBlocos;
	}

}
