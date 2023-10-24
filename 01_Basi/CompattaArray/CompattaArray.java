
public class CompattaArray{
	// Spostiamo tutti i val alla fine dell'array
	public static void compactArray(int[] arr, int val) {
		int n = arr.length;
		int count = 0;

		// Copiamo prima tutti i Non val 
		for (int i = 0; i < n; i++) {
			if (arr[i] != val) {
				arr[count] = arr[i];
				count++;
			}
		}

		// Riempire la parte rimanente dell'array con val
		while (count < n) {
			arr[count] = 2;
			count++;
		}
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 4, 2, 7, 8, 9, 2};
		compactArray(arr);

		// Stampa l'array compattato
		for (int num : arr) {
			System.out.print(num + " ");
		}
	}
}