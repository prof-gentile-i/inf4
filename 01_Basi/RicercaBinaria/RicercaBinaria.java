import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class RicercaBinaria {

	public static int ricercaBinaria(char[] v, char key) {
		int left = 0;
		int right = v.length -1;
		
		while (left <= right ) {
			int mid = (left + right) /2;
			if (v[mid] == key)
				return mid;
		else
			if (v[mid] < key)
				left = mid + 1;
			else
				right = mid - 1;
		}
		return -1;
	}
	public static void main(String[] Args) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("RICERCA BINARIA DI UN CARATTERE");
		char[] v = {'A', 'B', 'C', 'K', 'Z'};
		
		System.out.print("Inserisci il carattere da cercare: ");
		char c = stdin.readLine().charAt(0);
		int i = ricercaBinaria(v, c);
		if (i >= 0)
			System.out.println("Elemento presente in posizione " + i);
		else 
			System.out.println("Elemento non presente");
	}
}
