import java.io.IOException;

public class TestMensola {

	public static void main(String[] args) throws IOException {
		Mensola m = new Mensola("./testo/libri1.csv");
		
		System.out.print(m);
		
		Libro l = new Libro ("Dune", "Frank Herbert", 700);
		
		try {
			m.setVolume(l, 0);
		} catch (MensolaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			m.setVolume(l, 2);
		} catch (MensolaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			m.rimuoviVolume(6);
		} catch (MensolaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			m.rimuoviVolume(3);
		} catch (MensolaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			m.getVolume(-1);
		} catch (MensolaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			m.getVolume(3);
		} catch (MensolaException e) {
			System.out.println(e.getMessage());
		}
		
		

	}

}
