
public class Libro {
	// Attributi
	private String titolo; // Var. di Istanza
	private String autore; // Var. di Istanza
	private int numeroPagine; // Var. di Istanza
	private static double costoPagina = 0.05; // Variabile di classe
	final double COSTO_FISSO = 5.5;
	
	// Costruttore completo
	public Libro(String titolo, String autore, int numeroPagine) {
		this.titolo = titolo;
		this.autore = autore;
		this.numeroPagine = numeroPagine;
	}
	
	// Costruttore di copia
	public Libro(Libro libro) {
		this.titolo = libro.titolo;
		this.autore = libro.autore;
		this.numeroPagine = libro.numeroPagine;
	}
	
	// Costruttore di default (lista parametri vuota)
	public Libro() {
		this.titolo = "";
		this.autore = "";
		this.numeroPagine = 0;
	}
	
	// Metodi getter e setter
	public String getTitolo() {return titolo;}
	public void setTtitolo(String titolo) {this.titolo = titolo;}
	public String getAutore() {return autore;}
	public void setAutore(String autore) {this.autore = autore;}
	public int getNumeroPagine() {return numeroPagine;}
	public void setNumeroPagine(int numeroPagine) {this.numeroPagine = numeroPagine;}
	
	public double prezzo() {return COSTO_FISSO + numeroPagine * costoPagina;}
	public static void setCostoPagina(double costo) {costoPagina = costo;}
	
	
	public String toString() {
		return titolo + " - " + autore + " - " + numeroPagine + " - " + prezzo() + "€";
	}
	
	public static void main(String[] args) {
		Libro l1 = new Libro("Pinocchio", "C. Collodi", 150);
		Libro l2 = new Libro("Pollicino", "C. Perrault", 80);
		
		Libro l3 = l1;
		
		//System.out.println(l3.stampa());
		
		l1.setNumeroPagine(200);
		
		
		//System.out.println(l1.getTitolo() + ": " + l1.prezzo());
		System.out.println(l1.toString());
		System.out.println(l3.toString());
		
	}

}
