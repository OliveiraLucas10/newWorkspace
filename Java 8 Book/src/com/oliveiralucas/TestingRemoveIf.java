package com.oliveiralucas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

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

		ToIntFunction<Usuario> extraiPontos = u -> u.getPontos();
		ToIntFunction<Usuario> extraiPontos2 = Usuario::getPontos;
		Comparator<Usuario> comparator = Comparator.comparingInt(extraiPontos);
		usuarios.sort(comparator);
		usuarios.forEach(u -> System.out.println(u.getPontos()));
		usuarios.sort(Comparator.comparingInt(Usuario::getPontos));
		usuarios.forEach(u -> System.out.println(u.getPontos()));

		Function<Usuario, String> byName = Usuario::getNome;
		usuarios.sort(Comparator.comparing(byName));
	}
}
