/**
 * Classe concreta che rappresenta un elemento (“item”) il cui attributo
 * è di tipo discreto. Estende la classe astratta {@link Item}
 * e fornisce una distanza binaria: 0 se i valori sono uguali, 1 altrimenti.
 *
 * @see Item
 */
public class DiscreteItem extends Item
{
    /**
     * Costruisce un nuovo {@code DiscreteItem} associando l’attributo discreto
     * e il corrispondente valore.
     *
     * @param attribute
     *     l’attributo discreto da assegnare a questo item; non può essere {@code null}
     * @param value
     *     il valore categorico da associare all’attributo; non può essere {@code null}
     * @throws NullPointerException
     *     se {@code attribute} o {@code value} è {@code null}
     */
    public DiscreteItem(DiscreteAttribute attribute, String value)
    {
        super(attribute, value);
    }

    /**
     * Calcola la distanza discreta tra questo item e un altro oggetto.
     * Il risultato è:
     * <ul>
     *   <li>0.0 se il valore di questo item è uguale (via {@code equals}) all’argomento;</li>
     *   <li>1.0 altrimenti.</li>
     * </ul>
     * Se l’argomento non è una stringa o un {@link DiscreteItem}, o è {@code null},
     * il metodo restituirà 1.0.
     *
     * @param a
     *     l’oggetto con cui confrontare il valore di questo item;
     *     può essere una {@link String} o un altro {@code DiscreteItem}.
     * @return
     *     0.0 se i valori sono uguali, 1.0 altrimenti
     */
    @Override
    public double distance(Object a)
    {
        return getValue().equals(a) ? 0.0 : 1.0;
    }
}
