package data;

/**
 * Classe concreta che rappresenta un elemento (“item”) il cui attributo
 * è di tipo discreto. Estende la classe astratta {@link Item}
 * e fornisce una distanza binaria: 0 se i valori sono uguali, 1 altrimenti.
 * @see Item
 */
public class DiscreteItem extends Item <DiscreteAttribute, String>
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
    DiscreteItem(DiscreteAttribute attribute, String value)
    {
        super(attribute, value);
    }

    /**
     * Calcola la distanza discreta tra questo item e un altro oggetto
     * @param obj l’oggetto con cui confrontare il valore di questo item;
     * @return 0.0 se i valori sono uguali, 1.0 altrimenti
     * @throws IllegalArgumentException se il tipo di {@code obj} non e' lo stesso dell'oggetto corrente
     */
    @Override
    public double distance(Object obj)
    {
        if (!(obj instanceof DiscreteItem))
            throw new IllegalArgumentException("Tipo errato.");

        DiscreteItem other = (DiscreteItem) obj;
        
        return this.getValue().equals(other.getValue()) ? 0.0 : 1.0;
    }
}
