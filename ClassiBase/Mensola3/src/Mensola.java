import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Mensola {
	private static final int MAX_NUM_VOLUMI = 15;
	private Libro volumi[];
	
	// Costruttore di defualt
	public Mensola() {
		volumi = new Libro[10];
	}
	
	public Mensola(int numeroLibri) throws MensolaException {
        if (numeroLibri < 0 || numeroLibri > MAX_NUM_VOLUMI) {
            // Lanciamo un'eccezione personalizzata se il numero di libri non è valido
            throw new MensolaException("Il numero di libri deve essere compreso tra 0 e " + MAX_NUM_VOLUMI + ".");
        } else {
            volumi = new Libro[numeroLibri];
        }
    }
	
	// Costruttore di copia
	public Mensola(Mensola mensola) {
		int posizione;
		volumi = new Libro[mensola.getNumMaxVolumi()];
		
		int i = 0;
		for(Libro volume: mensola.volumi) 
			volumi[i++] = new Libro(volume);
	}
	
	
	// Metodo per impostare un libro in una determinata posizione sulla mensola
    public int setVolume(Libro libro, int posizione) throws MensolaException {
        if ((posizione - 1 < 0) || (posizione - 1 > volumi.length))
            throw new MensolaException("Posizione non valida.");

        if (volumi[posizione - 1] != null)
            throw new MensolaException("Posizione occupata.");

        volumi[posizione - 1] = new Libro(libro);  // Inserimento libro in posizione
        return posizione;
    }
    
    

    // Metodo per ottenere un libro da una determinata posizione sulla mensola
    public Libro getVolume(int posizione) throws MensolaException {
        if ((posizione < 1) || (posizione > volumi.length)) 
            throw new MensolaException("Posizione non valida.");

        if (volumi[posizione - 1] == null)
            throw new MensolaException("Posizione non contiene alcun libro.");

        return new Libro(volumi[posizione - 1]);  // Restituisce il libro in posizione
    }
    
 

    // Metodo per rimuovere un libro da una determinata posizione sulla mensola
    public int rimuoviVolume(int posizione) throws MensolaException {
        if ((posizione < 1) || (posizione > volumi.length)) {
            throw new MensolaException("Posizione non valida.");
        }

        if (volumi[posizione - 1] == null) {
            throw new MensolaException("Posizione non contiene alcun libro.");
        }

        volumi[posizione - 1] = null; // Rimozione libro in posizione
        return posizione;  // Restituisce la posizione liberata
    }

	// Metodi
	
	
	public static int getNumMaxVolumiPossibili() {return MAX_NUM_VOLUMI;}
	
	public int getNumMaxVolumi() {return volumi.length;}
	
	// Numero di volumi presenti nello scaffale
	public int getNumVolumi() {
		
		int n = 0;
		for(Libro volume: volumi) { //forEach
			 if (volume != null)
				 n++;
		}
		
		return n;
	}
	
	
	
	// Restituisce una stringa con tutti i libri presenti sullo scaffale
	// La stringa � del tipo seguente
	// 1) Titolo1 - Autore1 - NumeroPagine1
	// 3) Titolo2 - Autore2 - NumeroPagine2
	// ......
	public String toString() {
		String s = "";
		for (int i = 0; i < volumi.length; i++)
			if(volumi[i] != null)
				s += (i+1) +") " + volumi[i]+ "\n"; 
		return s;
	} 
	
	public void save(String nomeFile) throws IOException { // nomeFile Nome del file senza estensione
		PrintWriter file = new PrintWriter(new FileWriter(nomeFile + ".csv"));
		
		for(int i=0; i < volumi.length; i++) 
			if (volumi[i] != null)
				file.println((i+1) + "," + volumi[i].getTitolo() + "," +volumi[i].getAutore()+ "," 
					+ volumi[i].getNumeroPagine());

		file.close();
	}
	
	
	
	public Mensola(String nomeFile) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader(nomeFile));
		
		String linea;
		volumi = new Libro[grandezzaMensolaFile(nomeFile)];
		
		Scanner sc;
		
		int posizione;
		String titolo, autore;
		int numeroPagine;
		while ((linea = file.readLine()) != null) {
			sc = new Scanner(linea).useDelimiter(",");
			posizione = sc.nextInt();
			titolo = sc.next();
			autore = sc.next();
			numeroPagine = sc.nextInt();			
			
			volumi[posizione-1] = new Libro(titolo, autore, numeroPagine);
			
		}
	}
	
	private int grandezzaMensolaFile(String nomeFile) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader(nomeFile));
		int posizioneMassima = 0, posizione;
		String riga;
		while ((riga = file.readLine()) != null) {
			posizione = new Scanner(riga).useDelimiter(",").nextInt();
			if ( posizione > posizioneMassima) 
				posizioneMassima = posizione;
		}
		file.close();
		return posizioneMassima;
	}
	
}


