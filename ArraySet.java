import java.util.Arrays;

/**
 * Classe concreta che modella un insieme di interi non negativi
 */
public class ArraySet 
{
	/**
	 * Array booleano: true se l'intero i è presente
	 */
	private boolean[] set;

	/**
	 * Massimo indice attualmente usato (più 1)
	 */
	private int size = 0;

	/**
	 * Numero totale di elementi presenti (cioè true)
	 */
	private int cardinality = 0;

	/**
	 * Costruttore che inizializza un array di booleani con 50 elementi e imposta i
	 * valori su false.
	 */
	public ArraySet() 
	{
		set = new boolean[50];
		for (int i = 0; i < set.length; i++)
			set[i] = false;
	}

	/**
	 * Aggiunge un intero i all'array booleano se non presente
	 * 
	 * @param i intero da aggiungere dall'array booleano
	 * @return booleano che indica true se l'aggiunta è avvenuta altrimenti false
	 */
	public boolean add(int i) 
	{
		if (i >= set.length) 
		{
			boolean[] temp = new boolean[set.length * 2];
			Arrays.fill(temp, false);

			System.arraycopy(set, 0, temp, 0, set.length);
			set = temp;
		}
		boolean added = set[i];
		set[i] = true;

		if (i >= size)
			size = i + 1;
		if (!added)
			cardinality++;

		return !added;
	}

	/**
	 * Elimina se presente l'intero i dall'array booleano e aggiorna il size
	 * 
	 * @param i intero da eliminare dall'array booleano
	 * @return booleano che indica true se l'eliminazione è avvenuta altrimenti
	 *         false
	 */
	public boolean delete(int i) 
	{
		if (i < size) 
		{
			boolean deleted = set[i];
			set[i] = false;
			if (i == size - 1) 
			{
				int j; 
				for (j = size - 1; j >= 0 && !set[j]; j--);
				size = j + 1;
			}
			if (deleted)
				cardinality--;
			return deleted;
		}
		return false;
	}

	/**
	 * Restituisce un valore dell'array booleano
	 * 
	 * @return valore booleano presente nell'array
	 */
	public boolean get(int i) 
	{
		if (i < size)
			throw new IllegalArgumentException("Parametro non valido.");
		return set[i];
	}

	/**
	 * Restituisce la cardinalita' dell'array booleano
	 * 
	 * @return intero che rappresenta la cardinalita' dell'array booleano
	 */
	public int size() 
	{
		return cardinality;
	}

	/**
	 * Crea un array di interi con i valori presenti nell'array booleano
	 * 
	 * @return array di interi con i valori dell'array booleano
	 */
	int[] toArray() 
	{
		int[] a = new int[0];
		for (int i = 0; i < size; i++) 
		{
			if (get(i)) 
			{
				int[] temp = new int[a.length + 1];
				System.arraycopy(a, 0, temp, 0, a.length);
				a = temp;
				a[a.length - 1] = i;
			}
		}
		return a;
	}
}
