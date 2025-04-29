/**
 * Classe concreta che estende la classe {@code Attribute} e modella un attributo con un dominio finito di valori.
 */
public class DiscreteAttribute extends Attribute
{
    /**
     * Valori assunti dall'attributo
     */
    private String[] values;

    /**
     * Costruttore che invoca il costruttore della classe madre {@code Attribute} e
     * inizializza i membri aggiunti per estensione.
     * @param name nome dell'attributo
     * @param index identificativo numerico dell'attributo
     * @param values valori assunti dall'attributo
     * @throws IllegalArgumentException se i parametri non sono validi.
     */
    public DiscreteAttribute(String name, int index, String[] values) {
        super(name, index); // chiama il costruttore della superclasse Attribute
        if(values == null || values.length == 0)
            throw new IllegalArgumentException("Parametri non validi. I valori non possono essere null o vuoti.");
        
        this.values = values; // inizializza il dominio

    }

    /**
     * Restituisce il numero di valori discreti nel dominio dell'attributo.
     * @return intero contenente il numero di valori discreti nel dominio dell'attributo.
     */
    public int getNumberOfDistinctValues() 
    {
        return values.length;
    }

    /**
     * Restituisce i valori presenti nell'attributo
     * @return stringa contenente i valori presenti nell'attributo.
     */
    public String getValue(int i) 
    {
        return values[i];
    }

}
