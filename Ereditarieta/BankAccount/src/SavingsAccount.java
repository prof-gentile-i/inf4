// Se non si sono studiate le interfacce eliminare implements Comparable e
// il metodo compareTo
public class SavingsAccount extends BankAccount implements Comparable{ // Conto di risparmio: d� interessi

	private double interestRate; // Tasso di interesse
	
	// Costruttori
	public SavingsAccount(double initialBalance, double rate){
		super(initialBalance);
		interestRate = rate;
	}	
	public SavingsAccount() {this(0,0);}
	
	public double getInterestRate() {return interestRate;} 
	
	// Simula la fine dell'anno per applicare gli interessi
	public void endYear() {
		addInterest();
	}
	
	// Protected perché può servire ad altre classi derivate 
	protected void addInterest() { // Applica il tasso di interess sul deposito
		double interest = getBalance() *interestRate / 100;
		deposit(interest);
	}
	
	public String toString() { return "CheckingAccount[balance=" + getBalance() + ", "
			+ "Interest Rate=" + interestRate +"]";}
	
	// Implementazione del metodo astratto dell'interfaccia Comparable
	public int compareTo(Object other) {
		SavingsAccount o = (SavingsAccount)other;
		if ( interestRate < o.interestRate ) return -1;
		if ( interestRate > o.interestRate ) return 1;
		return 0;
	}
}
