
public class ProvaConti {
	
	public static void main(String[] Args) {
	
		BankAccount b1 = new BankAccount(100.0);
		BankAccount b2 = new BankAccount(150.0);
		CheckingAccount c1 = new CheckingAccount(200.0);
		
		System.out.println(c1);
		
		c1.deposit(20.0);
		for(int i = 1; i <= 4; i++)
			c1.withdraw(50.0);
		
		
		System.out.println(c1);
		c1.endMonth();
		System.out.println(c1);
		
		
	
	}
	

}
