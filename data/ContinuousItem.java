package data;

/**
 * Classe concreta che rappresenta un elemento (“item”) il cui attributo
 * è di tipo continuo. Estende la classe astratta {@link Item}
 * e fornisce una distanza binaria: 0 se i valori sono uguali, 1 altrimenti.
 * @see Item
 */
public class ContinuousItem extends Item
{
    /**
     * Costruisce un nuovo {@code ContinuousItem} associando l’attributo continuo
     * e il corrispondente valore.
     *
     * @param attribute
     *     l’attributo continuo da assegnare a questo item; non può essere {@code null}
     * @param value
     *     il valore categorico da associare all’attributo; non può essere {@code null}
     * @throws NullPointerException
     *     se {@code attribute} o {@code value} è {@code null}
     */
    public ContinuousItem(ContinuousAttribute attribute, double value)
    {
        super(attribute, value);
        this.value = value;
    }

    /**
     * Calcola la distanza discreta tra questo item e un altro oggetto
     * @param a l’oggetto con cui confrontare il valore di questo item;
     * @return 0.0 se i valori sono uguali, 1.0 altrimenti
     * @throws IllegalArgumentException se il tipo di {@code a} non e' lo stesso dell'oggetto corrente
     */
    @Override
    protected double distance(Object a) 
    {
        if (!(a instanceof ContinuousItem))
            throw new IllegalArgumentException("Tipo errato.");

        ContinuousItem other = (ContinuousItem) a;

        ContinuousAttribute thisAttr = (ContinuousAttribute) this.getAttribute();
        ContinuousAttribute otherAttr = (ContinuousAttribute) other.getAttribute();

        double thisScaled = thisAttr.getScaledValue((Double) this.getValue());
        double otherScaled = otherAttr.getScaledValue((Double) other.getValue());

        return Math.abs(thisScaled - otherScaled);
    }

}