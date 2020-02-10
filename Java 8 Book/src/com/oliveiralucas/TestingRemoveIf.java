package com.oliveiralucas;

import java.util.ArrayList;
import java.util.List;

public class TestingRemoveIf
{

	public static void main(String... args)
	{
		List<Usuario> usuarios = new ArrayList<Usuario>(); // arraysList é uma colleção mutavel, aceita mudançã
		usuarios.add(new Usuario("Lucas", 150));
		usuarios.add(new Usuario("Pedro", 101));
		usuarios.add(new Usuario("Maico", 50));
		usuarios.add(new Usuario("Rafa", 30));

		usuarios.removeIf(u -> u.getPontos() < 100);
		usuarios.forEach(u -> System.out.println(u.getNome()));
	}
}
