
public class Account
{

	private int accountNumber;

	private double balance;

	private String customerName;

	private String email;

	private String phoneNumber;

	public Account(int accountNumber, double balance, String customerName, String email, String phoneNumber)
	{
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.customerName = customerName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public int getAccountNumber()
	{
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber)
	{
		this.accountNumber = accountNumber;
	}

	public double getBalance()
	{
		return balance;
	}

	public void setBalance(double balance)
	{
		this.balance = balance;
	}

	public String getCustomerName()
	{
		return customerName;
	}

	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public void deposit(double value)
	{
		this.balance += value;
	}

	public void withdraw(double value)
	{
		if (value > this.balance)
		{
			System.out.println("This operation is not allowed, there isn't enough money!!");
		}
		else
		{
			double newValue = (this.balance - value) * 100;
			this.balance = (int) newValue / 100d;
		}
	}

	@Override
	public String toString()
	{
		return "Account [accountNumber=" + accountNumber + ", balance=" + balance + ", customerName=" + customerName + ", email=" + email
						+ ", phoneNumber=" + phoneNumber + "]";
	}

}
