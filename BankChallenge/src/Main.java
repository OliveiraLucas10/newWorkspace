
public class Main
{

	public static void main(String[] args)
	{
		// Account account1 = new Account(1, 100.00, "Lucas Oliveira", "oliveiralucas@gmail.com", "9304068017");
		// System.out.println(account1.toString());
		// account1.deposit(55.30);
		// System.out.println(account1.toString());
		// account1.withdraw(500);
		// System.out.println(account1.toString());
		// account1.withdraw(155.2);
		// System.out.println(account1.toString());

		VipCustomer vip = new VipCustomer();
		System.out.println(vip.toString());
		VipCustomer vip2 = new VipCustomer("Lucas Oliveira", "myvipemail@google.com");
		System.out.println(vip2);
	}

}
