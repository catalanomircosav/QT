/**
 * Classe astratta che modella un attributo caratterizzato da nome e identificativo numerico.
 */
public abstract class Attribute
{
    /**
     * Nome dell'attributo
     */
    private final String name;
    /**
     * Identificativo numerico dell'attributo
     */
    private final int index;

    /**
     * Costruttore che inizializza il nome e l'identificativo numerico dell'attributo.
     * Accessibile solo alle sottoclassi.
     * @param name nome dell'attributo
     * @param index identificativo numerico dell'attributo
     * @throws IllegalArgumentException se i parametri non sono validi
     */
    protected Attribute(String name, int index) 
    {
        if(name == null || name.isEmpty() || index < 0)
            throw new IllegalArgumentException("Parametri non validi.");

        this.name = name;
        this.index = index;
    }

    /**
     * Restituisce il nome dell'attributo.
     * @return stringa contenente il nome dell'attributo
     */
    public String getName()
    {
        return name;
    }

    /**
     * Restituisce l'identificativo numerico dell'attributo.
     * @return numero intero rappresentante l'identificativo
     */
    public int getIndex()
    {
        return index;
    }

    /**
     * Restituisce la rappresentazione testuale dell'attributo.
     * @return stringa contenente il nome dell'attributo
     */
    @Override
    public String toString()
    {
        return name;
    }
}