import java.util.Arrays;
import java.util.Random;
public class SortSavingAccount {

	public static void main(String[] args) {
		
		//...
		Random rand = new Random();
		// Genera un numero casuale di libretti di risparmio, massimo 10 (da 0 a 9)
		SavingsAccount[] s = new SavingsAccount[rand.nextInt(10)];
		
		// inizializzazione di s[i]
		for (int i = 0; i < s.length; i++)
			// Generiamo tanti libretti di risparmio con un tasso di 100 monete ognuno
			// ma con un tasso di interesse casuale da 0 a 9
			s[i] = new SavingsAccount(100, rand.nextInt(10));
		
		// Ordinamento dei conti
		Arrays.sort(s);
		
		// Stampa dei libretti ordinati 
		for (int i = 0; i < s.length; i++)
			System.out.println(s[i].toString());
	}
}
