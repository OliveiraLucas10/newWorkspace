package com.oliveiralucas.digital_shop;

import static java.util.Arrays.asList;

import java.math.BigDecimal;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
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

		Map<Customer, List<List<Product>>> customerToProductsList = payments
				.stream()
				.collect(Collectors.groupingBy(Payment::getCustomer, Collectors
						.mapping(Payment::getProducts, Collectors.toList())));
		customerToProductsList.entrySet().stream()
				.sorted(Comparator.comparing(e -> e.getKey().getName()))
				.forEach(System.out::println);

		Map<Customer, List<Product>> customerToProducts2steps = customerToProductsList
				.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey,
						e -> e.getValue().stream().flatMap(List::stream)
								.collect(Collectors.toList())));
		customerToProducts2steps.entrySet().stream()
				.sorted(Comparator.comparing(e -> e.getKey().getName()))
				.forEach(System.out::println);

		// /* Qual é nosso cliente mais especial? */
		// Map<Customer, BigDecimal> totalValuePerCustomer = payments.stream()
		// .collect(Collectors.groupingBy(Payment::getCustomer,
		// Collectors.reducing(BigDecimal.ZERO, p -> p
		// .getProducts().stream().map(Product::getPrice)
		// .reduce(BigDecimal.ZERO, BigDecimal::add),
		// BigDecimal::add)));

		/*
		 * O código está no mínimo muito acumulado. Cremos já termos passado do
		 * limite da legibilidade.Va mos quebrar essa redução, criando uma
		 * variável temporária responsável por mapear um Payment para a soma de
		 * todos os preços de seus produtos:
		 */
		Function<Payment, BigDecimal> paymentTotal = p -> p.getProducts()
				.stream().map(Product::getPrice)
				.reduce(BigDecimal.ZERO, BigDecimal::add);

		/* Comisso, podemos utilizar essa Function no reducing: */
		Map<Customer, BigDecimal> totalValuePerCustomer = payments.stream()
				.collect(Collectors.groupingBy(Payment::getCustomer,
						Collectors.reducing(BigDecimal.ZERO, paymentTotal,
								BigDecimal::add)));

		totalValuePerCustomer.entrySet().stream()
				.sorted(Comparator.comparing(Map.Entry::getValue))
				.forEach(System.out::println);

		/* Relatórios com datas */

		System.out.println("=== Relatórios com datas ===");
		Map<YearMonth, List<Payment>> paymentsPerMonth = payments.stream()
				.collect(Collectors
						.groupingBy(p -> YearMonth.from(p.getDate())));
		paymentsPerMonth.entrySet().stream().forEach(System.out::println);

		/*
		 * E se quisermos saber, também por mês, quanto foi faturado na loja?
		 * Basta agrupar com o mesmo critério e usar a redução que conhecemos:
		 * somando todos os preços de todos os produtos de todos pagamentos.
		 */

		Map<YearMonth, BigDecimal> paymentsValuePerMonth = payments.stream()
				.collect(Collectors.groupingBy(p -> YearMonth.from(p.getDate()),
						Collectors.reducing(BigDecimal.ZERO, p -> p
								.getProducts().stream().map(Product::getPrice)
								.reduce(BigDecimal.ZERO, BigDecimal::add),
								BigDecimal::add)));

		paymentsValuePerMonth.entrySet().stream()
				.sorted(Comparator.comparing(Map.Entry::getValue))
				.forEach(System.out::println);

		/* trabalhando com as assinaturas */

		System.out.println("=== ASSINATURAS ===");
		BigDecimal monthlyFee = new BigDecimal("99.90");
		Subscription s1 = new Subscription(monthlyFee, yesterday.minusMonths(5),
				paulo);
		Subscription s2 = new Subscription(monthlyFee, yesterday.minusMonths(8),
				today.minusMonths(1), rodrigo);
		Subscription s3 = new Subscription(monthlyFee, yesterday.minusMonths(5),
				today.minusMonths(2), adriano);
		List<Subscription> subscriptions = Arrays.asList(s1, s2, s3);

		/*
		 * Como calcular quantos meses foram pagos através daquela assinatura?
		 * Basta usar o que conhecemos da API de java.time. Mas depende do caso.
		 * Se a assinatura ainda estiver ativa, calculamos o intervalo de tempo
		 * entre begin e a data de hoje:
		 */

		long meses = ChronoUnit.MONTHS.between(s1.getBegin(),
				LocalDateTime.now());

		System.out.println(meses);

		/*
		 * E se a assinatura terminou? Em vez de enchermos nosso código com ifs,
		 * tiramos proveito do Optional:
		 */

		long meses2 = ChronoUnit.MONTHS.between(s1.getBegin(),
				s1.getEnd().orElse(LocalDateTime.now()));
		System.out.println(meses2);

		/*
		 * Para calcular o valor gerado por aquela assinatura, bastamultiplicar
		 * esse número de meses pelo custo mensal:
		 */
		BigDecimal total2 = s1.getMonthlyFee().multiply(
				new BigDecimal(ChronoUnit.MONTHS.between(s1.getBegin(),
						s1.getEnd().orElse(LocalDateTime.now()))));
		System.out.println(total2);

		/*
		 * Dada uma lista de subscriptions, fica fácil somar todo o total pago:
		 */
		BigDecimal totalPaid = subscriptions.stream()
				.map(Subscription::getTotalPaid)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		System.out.println(totalPaid);

	}
}
