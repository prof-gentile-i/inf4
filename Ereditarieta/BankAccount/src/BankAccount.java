
public class BankAccount { // CONTO BANCARIO
	private final int accountNumber; // Numero di conto
	private double balance; // Quanto abbiamo sul conto
	private static int newAccountNumber = 1; // Numero disponibile per il prossimo conto
	
	// COSTRUTTORI
	public BankAccount() { // Costruttore di Default
		this(0); // richiamiamo il costruttore a 1 parametro con valore pari a 0
	}
	public BankAccount(double initialBalance) { // Costruttore 
		accountNumber = getNewAccountNumber(); // Creiamo il numero di conto
		balance = initialBalance;
	}
	private int getNewAccountNumber() { return newAccountNumber++; }
	
	// METODI GETTER
	public double getBalance() {return balance;} // Quanto abbiamo sul conto
	public int getAccountNumber() {return accountNumber; } // Numero di conto
	
	// ALTRI METODI
	public void deposit(double amount) { // Depositiamo sul conto
		balance += amount;
	}
	
	public void withdraw(double amount) { // Preleviamo dal conto
		balance -= amount;
	}
	
	// Trasferire soldi dal nostro conto a un altro
	public void transfer(BankAccount other, double amount) {
		withdraw(amount); 
		other.deposit(amount);
	}
	
	
	public String toString() { return "BankAccount[balance=" + balance + "]";}
	

}
