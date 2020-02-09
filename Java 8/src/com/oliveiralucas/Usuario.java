package com.oliveiralucas;

class Usuario
{

	private String nome;

	private int pontos;

	private boolean moderador;

	public Usuario(String nome, int pontos)
	{
		super();
		this.nome = nome;
		this.pontos = pontos;
		this.moderador = false;
	}

	public String getNome()
	{
		return nome;
	}

	public int getPontos()
	{
		return pontos;
	}

	public void tornaModerador()
	{
		this.moderador = true;
	}

	public boolean isModerador()
	{
		return moderador;
	}

}
