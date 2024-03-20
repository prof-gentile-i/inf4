
public class CheckingAccount extends BankAccount { // Conto Corrente
	
	private int transactionCount; // Numero di operazioni mensili 
	private static final int FREE_TRANSACTIONS = 3; // Numero operazioni gratuite mensili
	private static final double TRANSACTION_FEE = 2.0; // Commissione per ciascun movimento aggiuntivo
	
	// Costruttore
	public CheckingAccount(double initialBalance) {
		super(initialBalance); // si costruisce la superclasse 
		transactionCount = 0; // si inizializza il contatore delle transazioni
	}
	
	// Visto che il deposita non incrementa transactionCount non è necessario
	// implementarlo, basta usare quello eridato
	
	// Override: Preleva da questo conto corrente ed incrementa il numero di transazioni
	public void withdraw(double amount) {
		transactionCount++;
		super.withdraw(amount); // senza super ricorsione infinita!
	}
	
	// Simula la fine del mese
	public void endMonth() {
		deductFees();
	}
	
	// Addebita la commissione complessiva ottenuta applicando la commissione
	// TRANSACTION_FEE ad ogni transazione in esubero rispetto a FREE_TRANSACTIONS 
	// e reimposta a zero il numero di transazioni eseguite
	// protected perché potrebbe essere usato dalle classi derivate
	protected void deductFees() {
		if (transactionCount > FREE_TRANSACTIONS) {
			double fees = TRANSACTION_FEE * (transactionCount - FREE_TRANSACTIONS);
			super.withdraw(fees);
		}
		transactionCount = 0;
	}
	
	public String toString() { return "CheckingAccount[balance=" + getBalance() + ", "
			+ "monthly transactions=" + transactionCount +"]";}

}
