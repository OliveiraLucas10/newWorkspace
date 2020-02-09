package com.oliveiralucas;

import java.util.function.Consumer;

class Mostrador implements Consumer<Usuario>
{

	@Override
	public void accept(Usuario u)
	{
		System.out.println(u.getNome());
	}

}
