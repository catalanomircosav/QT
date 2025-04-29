/**
 * Classe concreta che modella l'insieme di transazioni
 */

public class Data 
{

	/**
	 * Una matrice di tipo Object dove ogni riga modella una transazioni descritta
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
	private Attribute attributeSet[];

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

		attributeSet = new Attribute[5];

		String outLookValues[] = new String[3];
		outLookValues[0] = "overcast";
		outLookValues[1] = "rain";
		outLookValues[2] = "sunny";
		attributeSet[0] = new DiscreteAttribute("Outlook", 0, outLookValues);

		String temperatureValues[] = new String[3];
		temperatureValues[0] = "cool";
		temperatureValues[1] = "hot";
		temperatureValues[2] = "mild";
		attributeSet[1] = new DiscreteAttribute("Temperature", 1, temperatureValues);

		String humidityValues[] = new String[2];
		humidityValues[0] = "high";
		humidityValues[1] = "normal";
		attributeSet[2] = new DiscreteAttribute("Humidity", 2, humidityValues);

		String windValues[] = new String[2];
		windValues[0] = "weak";
		windValues[1] = "strong";
		attributeSet[3] = new DiscreteAttribute("Wind", 3, windValues);

		String playtennisValues[] = new String[2];
		playtennisValues[0] = "yes";
		playtennisValues[1] = "no";
		attributeSet[4] = new DiscreteAttribute("Play tennis", 4, playtennisValues);

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
		return this.attributeSet.length;
	}

	/**
	 * Restituisce lo schema dei dati
	 * @return array di Attribute contenente lo schema dei dati
	 */
	public Attribute[] getAttributeSchema() 
	{
		return this.attributeSet;
	}

	/**
	 * Restituisce un valore assunto in data in una determinata posizione
	 * @param exampleIndex   riga da cui prelevare il valore
	 * @param attributeIndex colonna da cui prelevare il valore
	 * @return oggetto contenente un valore assunto in data in una determinata
	 *         posizione
	 */
	public Object getValue(int exampleIndex, int attributeIndex) 
	{
		return this.data[exampleIndex][attributeIndex];
	}

	/**
	 * Restituisce un attributo
	 * @return un Attribute contenente un attributo
	 */
	public Attribute getAttribute(int index) 
	{
		return this.attributeSet[index];
	}

	/**
	 * Restituisce una stringa che modella lo stato dell'oggetto
	 * @return una stringa di contenente i dati enumerati
	 */
	@Override
	public String toString() 
	{
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < attributeSet.length; i++) 
		{
			sb.append(attributeSet[i].getName());
			if (i < attributeSet.length - 1)
				sb.append(",");
		}
		sb.append("\n");

		for (int i = 0; i < numberOfExamples; i++) 
		{
			sb.append((i + 1)).append(":");
			for (int j = 0; j < attributeSet.length; j++)
				sb.append(data[i][j]).append(",");
			sb.append("\n");
		}

		return sb.toString();
	}

	public class Main 
	{
		public static void main(String args[]) 
		{
			Data trainingSet = new Data();
			System.out.println(trainingSet);
		}
	}

}
