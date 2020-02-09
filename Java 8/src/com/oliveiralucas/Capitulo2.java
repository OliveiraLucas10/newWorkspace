package com.oliveiralucas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Capitulo2
{

	public static void main(String... args)
	{
		Usuario user1 = new Usuario("Paulo Silveira", 150);
		Usuario user2 = new Usuario("Rodrigo Turini", 120);
		Usuario user3 = new Usuario("Guilherme Silveira", 190);

		List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

		for (Usuario u : usuarios)
		{
			System.out.println(u.getNome());
		}

		System.out.println("\n==== NEW ====\n");
		Mostrador mostrador = new Mostrador();
		usuarios.forEach(mostrador);

		System.out.println("\n==== NEW ====\n");

		Consumer<Usuario> novoMstrador = new Consumer<Usuario>()
		{

			@Override
			public void accept(Usuario u)
			{
				System.out.println(u.getNome());

			}
		};
		usuarios.forEach(novoMstrador);

		System.out.println("\n==== NEW ====\n");

		usuarios.forEach(new Consumer<Usuario>()
		{

			@Override
			public void accept(Usuario u)
			{
				System.out.println(u.getNome()); 
			}
		});
	}
}
