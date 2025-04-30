/**
 * Classe concreta che estende la classe {@link Attribute} e modella un attributo numerico continuo.
 * La classe include metodi per "scalare" l'attributo dal dominio dell'attributo all'intervallo [0,1]
 * al fine da rendere confrontabili attributi aventi domini diversi.
 * @see Attribute
 */
public class ContinuousAttribute extends Attribute
{

    /**
     * Valore massimo del nuovo dominio
     */
    private double max;

    /**
     * Valore minimo del nuovo dominio
     */
    private double min;

    /**
     * Costruttore che invoca il costruttore della classe madre {@code Attribute} e
     * inizializza i membri aggiunti per estensione.
     * @param name nome dell'attributo
     * @param index identificativo numerico dell'attributo
     * @param min valore minimo del dominio assunto dall'attributo
     * @param max valore massimo del dominio assunto dall'attributo
     * @throws IllegalArgumentException se i parametri non sono validi.
     */
    public ContinuousAttribute(String name, int index, double min, double max)
    {
        super(name, index);

        if(min >= max)
            throw new IllegalArgumentException("Parametri non validi. min deve essere strettamente minore di max.");
        
        this.min = min;
        this.max = max;
    }

    /**
     * Il metodo calcola e restituisce il valore scalato del parametro passato in input.
     * Lo scaling ha come codominio l'intervallo [0,1].
     * @param v valore su cui scalare l'attributo
     * @return valore scalato nell'intervallo [0,1]
     */
    public double getScaledValue(double v)
    {
        return (v-min)/(max-min);
    }
}
