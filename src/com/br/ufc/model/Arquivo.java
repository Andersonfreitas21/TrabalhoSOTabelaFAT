package com.br.ufc.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Arquivo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nomeArquivo;
	private int blocoInicial;
	private int tamanhoArquivoEmBlocos;
	
	public Arquivo(String nomeArq, int tamArq) {
		this.nomeArquivo = nomeArq;
		this.tamanhoArquivoEmBlocos = tamArq;
	}
	
	

}
