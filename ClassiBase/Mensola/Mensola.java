
public class Mensola {
	private static final int MAX_NUM_VOLUMI = 15;
	private Libro volumi[];
	
	// Costruttore di defualt
	public Mensola() {
		volumi = new Libro[10];
	}
	
	public Mensola(int numeroLibri) {
		if (numeroLibri <0 || numeroLibri>MAX_NUM_VOLUMI)
			volumi = new Libro[10];
		else 
			volumi = new Libro[numeroLibri];
	}
	
	// Costruttore di copia
	public Mensola(Mensola mensola) {
		int posizione;
		volumi = new Libro[mensola.getNumMaxVolumi()];
		
		int i = 0;
		for(Libro volume: mensola.volumi) {
			volumi[i++] = volume;
		}
		
		/* Vecchio metodo
		for(posizione = 0; posizione < mensola.getNumMaxVolumi(); posizione++) {
			if (mensola.getVolume(posizione) != null)
				volumi[posizione] = mensola.getVolume(posizione);
		}
		*/
	}
	
	// Metodi
	public int setVolume(Libro libro, int posizione) {
		if ((posizione<1) || (posizione > volumi.length))
			return -1;  // posizione non valida
		if (volumi[posizione] != null)
			return -2;  // posizione occupata
		volumi[posizione-1] = new Libro(libro);  // Inserimento libro in posizione
		return posizione;
	}
	
	// Restituisce un libro dalla mensola
	public Libro getVolume(int posizione) {
		if ((posizione<1) || (posizione > volumi.length))
			return null;  // posizione non valida nessun libro restituito
		return volumi[posizione-1];  // restituisce il libro in posizione
	}
	
	// Restituisce un libro dalla mensola
	public int rimuoviVolume(int posizione) {
		if ((posizione <1) || (posizione > volumi.length))
			return -1;  // posizione non valida
		if (volumi[posizione-1] == null)
				return -2; // posizione non valida
		volumi[posizione-1] = null; // rimozione libro in posizione
		return posizione;  // restituisce la posizione liberata
	}
	
	public static int getNumMaxVolumiPossibili() {return MAX_NUM_VOLUMI;}
	
	public int getNumMaxVolumi() {return volumi.length;}
	
	// Numero di volumi presenti nello scaffale
	public int getNumVolumi() {
		
		int n = 0;
		for(Libro volume: volumi) { //forEach
			 if (volume != null)
				 n++;
		}
		
		/* Vecchio modo
		for (int posizione = 0; posizione < MAX_NUM_VOLUMI; posizione++)
			if (volumi[posizione] != null)
				n++;
		*/
		return n;
	}
	
	
	
	// Restituisce una stringa con tutti i libri presenti sullo scaffale
	// La stringa � del tipo seguente
	// 0) Titolo1 - Autore1 - NumeroPagine1
	// 1) Titolo2 - Autore2 - NumeroPagine2
	// ......
	public String toString() {
		String s = "";
		for (int i = 0; i < volumi.length; i++)
			if(volumi[i] != null)
				s += (i+1) +") " + volumi[i]+ "\n"; 
		return s;
	} 

}

