package data;
import exceptions.*;
import java.util.List;
import java.util.LinkedList;

/**
 * Classe concreta che modella l'insieme di transazioni
 */
public class Data 
{

    /**
     * Una matrice di tipo Object dove ogni riga modella una transazione descritta
     * dagli attributi riportati sulle colonne
     */
    private Object data[][];

    /**
     * Cardinalità dell’insieme di transazioni
     */
    private int numberOfExamples;

    /**
     * Insieme di possibili attributi
     */
    private List<Attribute> attributeSet;

    /**
     * Costruttore che inizializza il dataset e imposta l'insieme degli attributi.
     */
    public Data() 
    {
        data = new Object[14][5];

        data[0] = new Object[] { "sunny", "hot", "high", "weak", "no" };
        data[1] = new Object[] { "sunny", "hot", "high", "strong", "no" };
        data[2] = new Object[] { "overcast", "hot", "high", "weak", "yes" };
        data[3] = new Object[] { "rain", "mild", "high", "weak", "yes" };
        data[4] = new Object[] { "rain", "cool", "normal", "weak", "yes" };
        data[5] = new Object[] { "rain", "cool", "normal", "strong", "no" };
        data[6] = new Object[] { "overcast", "cool", "normal", "strong", "yes" };
        data[7] = new Object[] { "sunny", "mild", "high", "weak", "no" };
        data[8] = new Object[] { "sunny", "cool", "normal", "weak", "yes" };
        data[9] = new Object[] { "rain", "mild", "normal", "weak", "yes" };
        data[10] = new Object[] { "sunny", "mild", "normal", "strong", "yes" };
        data[11] = new Object[] { "overcast", "mild", "high", "strong", "yes" };
        data[12] = new Object[] { "overcast", "hot", "normal", "weak", "yes" };
        data[13] = new Object[] { "rain", "mild", "high", "strong", "no" };

        numberOfExamples = 14;

        attributeSet = new LinkedList<>();

        String outLookValues[] = new String[3];
        outLookValues[0] = "overcast";
        outLookValues[1] = "rain";
        outLookValues[2] = "sunny";
        attributeSet.add(new DiscreteAttribute("Outlook", 0, outLookValues));

        String temperatureValues[] = new String[3];
        temperatureValues[0] = "cool";
        temperatureValues[1] = "hot";
        temperatureValues[2] = "mild";
        attributeSet.add(new DiscreteAttribute("Temperature", 1, temperatureValues));

        String humidityValues[] = new String[2];
        humidityValues[0] = "high";
        humidityValues[1] = "normal";
        attributeSet.add(new DiscreteAttribute("Humidity", 2, humidityValues));

        String windValues[] = new String[2];
        windValues[0] = "weak";
        windValues[1] = "strong";
        attributeSet.add(new DiscreteAttribute("Wind", 3, windValues));

        String playtennisValues[] = new String[2];
        playtennisValues[0] = "yes";
        playtennisValues[1] = "no";
        attributeSet.add(new DiscreteAttribute("Play tennis", 4, playtennisValues));
    }

    /**
     * Restituisce la cardinalità dell'insieme di transazioni
     * @return intero contenente la cardinalità dell'insieme di transazioni
     */
    public int getNumberOfExamples() 
    {
        return this.numberOfExamples;
    }

    /**
     * Restituisce la cardinalità dell'insieme degli attributi
     * @return intero contenente la cardinalità dell'insieme degli attributi
     */
    public int getNumberOfAttributes() 
    {
        return this.attributeSet.size();
    }

    /**
     * Restituisce lo schema dei dati
     * @return array di Attribute contenente lo schema dei dati
     */
    public List<Attribute> getAttributeSchema() 
    {
        return this.attributeSet;
    }

    /**
     * Restituisce un valore assunto in data in una determinata posizione
     * @param exampleIndex   riga da cui prelevare il valore
     * @param attributeIndex colonna da cui prelevare il valore
     * @return oggetto che rappresenta un valore del dataset in una determinata posizione
     */
    public Object getValue(int exampleIndex, int attributeIndex) 
    {
        return this.data[exampleIndex][attributeIndex];
    }

    /**
     * Restituisce un attributo
     * @param index posizione da cui prelevare l'attributo
     * @return un {@code Attribute} contenente l'attributo
     */
    Attribute getAttribute(int index) 
    {
        return this.attributeSet.get(index);
    }

    @Override
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < attributeSet.size(); i++) 
        {
            sb.append(attributeSet.get(i).getName());
            if (i < attributeSet.size() - 1)
                sb.append(",");
        }
        sb.append("\n");

        for (int i = 0; i < numberOfExamples; i++) 
        {
            sb.append((i + 1)).append(":");
            for (int j = 0; j < attributeSet.size(); j++)
                sb.append(data[i][j]).append(",");
            sb.append("\n");
        }

        return sb.toString();
    }

    /**
     * Crea e restituisce un oggetto di Tuple che modella come sequenza di  coppie Attributo-valore la i-esima riga in data. 
     * @param index intero che corrisponde alla riga del dataset
     * @return oggetto {@code Tuple} con un coppia modellata
     */
    public Tuple getItemSet(int index) { 
        Tuple tuple = new Tuple(attributeSet.size()); 

        for (int i = 0; i < attributeSet.size(); i++) {
            DiscreteAttribute attr = (DiscreteAttribute) attributeSet.get(i);

            String value = (String) data[index][i];

            tuple.add(new DiscreteItem(attr, value), i); 
        }

        return tuple; 
    }


    /**
     * Verifica se il dataset è vuoto controllando se non contiene esempi 
     * ({@code numberOfExamples == 0}) o se il riferimento ai dati è {@code null}.
     * 
     * @throws EmptyDatasetException se il dataset è vuoto (non contiene esempi o {@code data} è null),
     *         con un messaggio che descrive l'errore.
     * @see EmptyDatasetException
     */
    public void checkIfEmpty() throws EmptyDatasetException {
        if (numberOfExamples == 0 || data == null) {
            throw new EmptyDatasetException("Il dataset è vuoto. Impossibile eseguire l'operazione.");
        }
    }
}