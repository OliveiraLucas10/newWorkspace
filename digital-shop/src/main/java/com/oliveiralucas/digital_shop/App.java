package com.oliveiralucas.digital_shop;

import static java.util.Arrays.asList;

import java.math.BigDecimal;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		// Adding Data
		Customer paulo = new Customer("Paulo Silveira");
		Customer rodrigo = new Customer("Rodrigo Turini");
		Customer guilherme = new Customer("Guilherme Silveira");
		Customer adriano = new Customer("Adriano Almeida");

		Product bach = new Product("Bach Completo",
				Paths.get("/music/bach.mp3"), new BigDecimal(100));
		Product poderosas = new Product("Poderosas Anita",
				Paths.get("/music/poderosas.mp3"), new BigDecimal(90));
		Product bandeira = new Product("Bandeira Brasil",
				Paths.get("/images/brasil.jpg"), new BigDecimal(50));
		Product beauty = new Product("Beleza Americana",
				Paths.get("beauty.mov"), new BigDecimal(150));
		Product vingadores = new Product("Os Vingadores",
				Paths.get("/movies/vingadores.mov"), new BigDecimal(200));
		Product amelie = new Product("Amelie Poulain",
				Paths.get("/movies/amelie.mov"), new BigDecimal(100));

		LocalDateTime today = LocalDateTime.now();
		LocalDateTime yesterday = today.minusDays(1);
		LocalDateTime lastMonth = today.minusMonths(1);

		Payment payment1 = new Payment(asList(bach, poderosas), today, paulo);
		Payment payment2 = new Payment(asList(bach, bandeira, amelie),
				yesterday, rodrigo);
		Payment payment3 = new Payment(asList(beauty, vingadores, bach), today,
				adriano);
		Payment payment4 = new Payment(asList(bach, poderosas, amelie),
				lastMonth, guilherme);
		Payment payment5 = new Payment(asList(beauty, amelie), yesterday,
				paulo);

		List<Payment> payments = asList(payment1, payment2, payment3, payment4,
				payment5);

		// Print payments by date
		payments.stream().sorted(Comparator.comparing(Payment::getDate))
				.forEach(System.out::println);

		// Total price payment1
		payment1.getProducts().stream().map(Product::getPrice)
				.reduce(BigDecimal::add).ifPresent(System.out::println);

		// E se precisarmos somar todos os valores de todos os pagamentos da
		// lista payments?
		Stream<BigDecimal> pricesStream = payments.stream()
				.map(p -> p.getProducts().stream().map(Product::getPrice)
						.reduce(BigDecimal.ZERO, BigDecimal::add));

		/*
		 * Precisamos repetir a operação de reduce para somar esses valores
		 * intermediários. Isto é, realizamos a soma de preços dos produtos de
		 * cada pagamento, agora vamos somar cada um desses subtotais:
		 */
		BigDecimal total = payments.stream()
				.map(p -> p.getProducts().stream().map(Product::getPrice)
						.reduce(BigDecimal.ZERO, BigDecimal::add))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		System.out.println(total);

		/*
		 * Emvez de realizarmos operações de somaem momentos distintos, podemos
		 * criar um único Stream<BigDecimal> com os valores de todos os produtos
		 * de todos pagamentos. Conseguimos esse Stream usando o flatMap:
		 */

		Stream<BigDecimal> priceOfEachProduct = payments.stream()
				.flatMap(p -> p.getProducts().stream().map(Product::getPrice));

		/*
		 * Para somar todo esse Stream<BigDecimal>, basta realizarmos a operação
		 * de reduce que conhecemos:
		 */

		BigDecimal totalFlat = payments.stream()
				.flatMap(p -> p.getProducts().stream().map(Product::getPrice))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		System.out.println(totalFlat);

		// Queremos saber nossos campeões de vendas

		Map<Product, Long> topProducts = payments.stream()
				.flatMap(p -> p.getProducts().stream())
				.collect(Collectors.groupingBy(Function.identity(),
						Collectors.counting()));

		System.out.println(topProducts);
		topProducts.entrySet().stream().forEach(System.out::println);
		System.out.println("___MAX___");
		topProducts.entrySet().stream()
				.max(Comparator.comparing(Map.Entry::getValue))
				.ifPresent(System.out::println);

		// Calculamos a quantidade de vendas por produtos. E a soma do valor por
		// produto?
		System.out.println("--- Pricing ---");
		Map<Product, BigDecimal> totalValuePerProduct = payments.stream()
				.flatMap(p -> p.getProducts().stream())
				.collect(Collectors.groupingBy(Function.identity(),
						Collectors.reducing(BigDecimal.ZERO, Product::getPrice,
								BigDecimal::add)));

		totalValuePerProduct.entrySet().stream()
				.sorted(Comparator.comparing(Map.Entry::getValue))
				.forEach(System.out::println);

		/*
		 * Em um primeiro momento, podemos ter, para cada Customer, sua
		 * List<Payment>,
		 */
		Map<Customer, List<Payment>> customerToPaymet = payments.stream()
				.collect(Collectors.groupingBy(Payment::getCustomer));
		
		Map<Customer, List<List<Product>>> customerToProductsList =
				payments.stream()
				.collect(Collectors.groupingBy(Payment::getCustomer,
				Collectors.mapping(Payment::getProducts, Collectors.toList())));
				customerToProductsList.entrySet().stream()
				.sorted(Comparator.comparing(e -> e.getKey().getName()))
				.forEach(System.out::println);
		
		
		Map<Customer, List<Product>> customerToProducts2steps =
				customerToProductsList.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey,
				e -> e.getValue().stream()
				.flatMap(List::stream)
				.collect(Collectors.toList())));
				customerToProducts2steps.entrySet().stream()
				.sorted(Comparator.comparing(e -> e.getKey().getName()))
				.forEach(System.out::println);

	}
}
