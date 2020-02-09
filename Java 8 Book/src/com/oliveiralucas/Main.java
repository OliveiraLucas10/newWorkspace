package com.oliveiralucas;

public class Main
{

	@FunctionalInterface
	interface Validador<T>
	{

		boolean valida(T t);
	}

	public static void main(String[] args)
	{
		Validador<String> validadorCEP = valor -> valor.matches("[0-9]{5}-[0-9]{3}");

		System.out.println("CEP is " + validadorCEP.valida("04101-300"));
	}

}
