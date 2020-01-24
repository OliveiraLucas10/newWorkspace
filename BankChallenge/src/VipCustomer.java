

public class VipCustomer
{
	private String name;
	private double creditLimit;
	private String email;
	
	public VipCustomer() {
		this("Vip Customer", 1000, "myvip@email.com");
	}
	
	public VipCustomer(String name, String email) {
		this(name, 350, email);
	}
	
	public VipCustomer(String name, double creditLimit, String email) {
		this.name = name;
		this.creditLimit = creditLimit;
		this.email = email;
	}
	
	
	public String getName()
	{
		return name;
	}
	
	public double getCreditLimit()
	{
		return creditLimit;
	}
	
	public String getEmail()
	{
		return email;
	}

	@Override
	public String toString()
	{
		return "VipCustomer [name=" + name + ", creditLimit=" + creditLimit + ", email=" + email + "]";
	}
	
	
	
	
}
