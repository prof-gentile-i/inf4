
public class TimeDepositAccount extends SavingsAccount{ // Conto di Risparmio vincolato
	
	
	private int periodsToMaturity; // Durata del vincolo
	private static double EARLY_WITHDRAWAL_PENALTY = 20; // Penale prelievo anticipato
	
	// Costruttore	
	public TimeDepositAccount(double initialBalance, double rate, int maturity){
		super(initialBalance, rate);
		periodsToMaturity = maturity;
	}
	
	// endYear non è il caso di crearlo perché è ereditato da SavingAccount
	// ATTENZIONE: endYear (che al suo interno chiama il metodo addInterest) 
	// quando chiamato su un oggetto TimeDepositAccount
	// chiama il metodo addInterest di TimeDepositAccount (e non quello di SavingAccount),
	// proprio come vogliamo noi.
	
	// Gli interessi vengono aggiunti ad ogni unità di periodo 
	// quindi più grande è il vincolo e più saranno gli interessi
	public void addInterest() {
		if (periodsToMaturity > 0) { // Gli interessi si applicano solo nel periodo di vincolo
			periodsToMaturity--; // Decremento del periodo
			super.addInterest();
		}
	}
	
	// Rinnovo del vincolo
	public void renewalBond(int maturity) { periodsToMaturity = maturity;}
	
	// Prelievo: se si preleva prima della scadenza si applica anche la penale
	public void withdraw(double amount) {
		if (periodsToMaturity > 0)
			super.withdraw(EARLY_WITHDRAWAL_PENALTY);
		super.withdraw(amount);
	}
	
	public String toString() { return "SavingsAccount[balance=" + getBalance() + ", "
			+ "Interest Rate=" + getInterestRate() +
			"period to maturity" + periodsToMaturity + "]";}
}
