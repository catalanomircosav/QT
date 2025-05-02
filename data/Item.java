package data;
/**
 * Classe astratta che rappresenta un generico oggetto "@{code Item}" con un attributo e un valore associato.
 * Le classi derivate devono implementare il metodo `distance` per calcolare la distanza tra due oggetti.
 */
public abstract class Item
{
    /**
     * L'attributo che è associato all'item.
     */
    protected Attribute attribute;

    /**
     * Il valore assegnato all'attributo dell'item.
     */
    protected Object value;

    /**
     * Calcola la distanza tra l'oggetto corrente e un altro oggetto passato come parametro.
     * Questo metodo è astratto e deve essere implementato dalle classi derivate per definire
     * il comportamento specifico della distanza tra gli oggetti.
     *
     * @param a L'oggetto con cui si vuole calcolare la distanza.
     * @return La distanza tra l'oggetto corrente e l'oggetto passato come parametro.
     * @throws IllegalArgumentException se l'oggetto passato come parametro non è valido o compatibile con l'item.
     */
    protected abstract double distance(Object a);

    /**
     * Costruttore che inizializza un item con un attributo e un valore specificato.
     * Questo costruttore associa un attributo e un valore all'item, che possono essere utilizzati
     * per calcolare la distanza o per altre operazioni dipendenti dall'implementazione derivata.
     *
     * @param attribute L'attributo da associare all'item.
     * @param value Il valore da associare all'item.
     * @throws NullPointerException se uno dei parametri è nullo.
     */
    protected Item(Attribute attribute, Object value)
    {
        if (attribute == null || value == null)
            throw new NullPointerException("L'attributo e il valore non possono essere nulli.");

        this.attribute = attribute;
        this.value = value;
    }

    /**
     * Restituisce l'attributo associato all'item.
     * @return L'attributo dell'item.
     * @throws IllegalStateException se l'attributo non è stato inizializzato correttamente.
     */
    public Attribute getAttribute()
    {
        if (attribute == null)
            throw new IllegalStateException("L'attributo non è stato inizializzato.");

        return attribute;
    }

    /**
     * Restituisce il valore associato all'item.
     * @return Il valore dell'item.
     * @throws IllegalStateException se il valore non è stato inizializzato correttamente.
     */
    public Object getValue()
    {
        if (value == null)
            throw new IllegalStateException("Il valore non è stato inizializzato.");

        return value;
    }

    /**
     * Restituisce una rappresentazione in formato stringa del valore associato all'item.
     * @return La rappresentazione stringa del valore dell'item.
     * @throws IllegalStateException se il valore non è stato inizializzato correttamente.
     */
    @Override
    public String toString()
    {
        if(value == null)
            throw new IllegalStateException("Il valore non è stato inizializzato.");

        return value.toString();
    }
}
