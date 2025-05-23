package data;

import java.util.Set;

/**
 * Classe concreta che rappresenta una tupla come sequenza di coppie attributo-valore.
 */
public class Tuple {
    
    /**
     * Nome della sequenze di coppie
     */
    private Item<?, ?>[] tuple;

    /**
     * Costruttore che inizializza {@code size} coppie attributo valore
     * @param size numero intero di item che costituirà la tupla
     * @throws IllegalArgumentException se i parametri non sono validi
     */
    Tuple (int size) 
    {
        if(size < 0)
            throw new IllegalArgumentException("Parametri non validi.");
        tuple = new Item [size];
    }

    /**
     * Restituisce la cardinalita' della sequenza di coppie.
     * @return intero che rappresenta la cardinalita' della sequenza di coppie.
     */
    public int getLength() 
    {
        return tuple.length;
    }

    /**
     * Restituisce restituisce l'item in posizione i 
     * @param i numero intero che rappresenta la posizione dell'item da prelevare
     * @return {@code Item} in posizione i
     */
    public Item<?, ?> get(int i) 
    {
        return tuple[i];
    }

    /**
     * Memorizza l'item c in posizione i della sequenza di coppie
     * @param c {@code Item} da aggiungere alla sequenza di coppie in posizione i
     * @param i numero intero che rappresenta la posizione della sequenza su cui scrivere l'item
     */
    public void add(Item<?, ?> c, int i) 
    {
        if (i < 0 || i >= getLength())
            throw new IllegalArgumentException("Parametri non validi.");
        tuple[i] = c;
    }

    /**
     * determina la distanza tra la tupla riferita da obj e la tupla corrente (riferita da this)
     * @param obj Tupla su cui confrontare la distanza
     * @return numero double che rappresenta la distanza tra le due tuple
     */
    public double getDistance(Tuple obj)
    {
        if (obj == null || obj.tuple.length != this.tuple.length)
            throw new IllegalArgumentException("Tuple con lunghezza diversa");

        double distanza = 0;

        for (int i = 0; i < this.tuple.length; i++)
            distanza += this.tuple[i].distance(obj.tuple[i]);
        
        return distanza;
    }

    /**
     * restituisce la media delle distanze tra la tupla corrente e quelle ottenibili dalle righe della matrice in data aventi indice in clusteredData.
     * @param data {@code Data} da cui prelevare le tuple da confrontare
     * @param clusteredData {@code Set<Tuple>} che rappresenta gli indici delle tuple in data
     * @return numero double che rappresenta la distanza media tra le tuple
     */
    public double avgDistance(Data data, Set<Tuple> clusteredData)
    { 
        double p = 0.0, sumD = 0.0; 
        for (Tuple t : clusteredData)
        {
            double d = getDistance(t); 
            sumD += d;
        } 

        p = sumD / clusteredData.size(); 
        return p;
    }
}