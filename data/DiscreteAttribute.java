package data;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Classe concreta che estende la classe {@link Attribute} e modella un attributo con un dominio finito di valori.
 * @see Attribute
 */
public class DiscreteAttribute extends Attribute implements Iterable<String>
{
    /**
     * Valori assunti dall'attributo
     */
    private TreeSet<String> values;
    

    /**
     * Costruttore che invoca il costruttore della classe madre {@code Attribute} e
     * inizializza i membri aggiunti per estensione.
     * @param name nome dell'attributo
     * @param index identificativo numerico dell'attributo
     * @param values valori che l'attributo deve assumere
     * @throws IllegalArgumentException se i parametri non sono validi.
     */
    DiscreteAttribute(String name, int index, String[] values)
    {
        super(name, index);
        if(values == null || values.length == 0)
            throw new IllegalArgumentException("Parametri non validi. I valori non possono essere null o vuoti.");
        this.values = new TreeSet<>(Arrays.asList(values));
    }

    /**
     * Restituisce il numero di valori discreti nel dominio dell'attributo.
     * @return intero contenente il numero di valori discreti nel dominio dell'attributo.
     */
    public int getNumberOfDistinctValues() 
    {
        return values.size();
    }

    /**
     * Fornisce un iteratore per scorrere i valori dell'attributo in ordine naturale.
     * @return iteratore sui valori.
     */
    @Override
    public Iterator<String> iterator() {
        return values.iterator();
    }

}
