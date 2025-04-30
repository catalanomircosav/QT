/**
 * Rappresenta un cluster in uno spazio di tuple, definito da un centroide
 * e da un insieme di identificatori di tuple assegnate a questo cluster.
 */
public class Cluster {
    
    /**
     * Il centroide del cluster, rappresentato come una {@link Tuple}.
     */
    private Tuple centroid;
    
    /**
     * Insieme di identificatori (interi) delle tuple che appartengono a questo cluster.
     */
    private ArraySet clusteredData;

    /**
     * Costruisce un nuovo cluster con il centroide specificato.
     * @param centroid la {@link Tuple} da usare come centroide del cluster
     */
    public Cluster(Tuple centroid)
    {
        this.centroid = centroid;
        this.clusteredData = new ArraySet();
    }

    /**
     * Restituisce il centroide di questo cluster.
     * @return la {@link Tuple} che rappresenta il centroide
     */
    public Tuple getCentroid()
    {
        return centroid;
    }

    /**
     * Aggiunge l'identificatore di una tupla all'insieme dei dati clusterizzati.
     * @param id l'identificatore (intero) della tupla da aggiungere
     * @return {@code true} se l'aggiunta ha modificato l'insieme, {@code false} altrimenti
     */
    public boolean addData(int id)
    {
        return clusteredData.add(id);
    }

    /**
     * Verifica se una tupla con il dato identificatore è già contenuta nel cluster.
     * @param id l'identificatore della tupla da cercare
     * @return {@code true} se l'identificatore è presente, {@code false} altrimenti
     */
    boolean contain(int id)
    {
        return clusteredData.get(id);
    }

    /**
     * Rimuove l'identificatore di una tupla dall'insieme dei dati clusterizzati.
     * @param id l'identificatore della tupla da rimuovere
     */
    void removeTuple(int id)
    {
        clusteredData.delete(id);
    }

    /**
     * Restituisce il numero di tuple attualmente assegnate a questo cluster.
     * @return la dimensione (numero di elementi) dell'insieme clusterizzato
     */
    int getSize()
    {
        return clusteredData.size();
    }

    /**
     * Fornisce un array di interi contenente tutti gli identificatori delle tuple
     * assegnate a questo cluster.
     * @return array di {@code int} con gli ID delle tuple clusterizzate
     */
    public int[] iterator()
    {
        return clusteredData.toArray();
    }

    /**
     * Restituisce una rappresentazione testuale del cluster, limitata al solo centroide.
     * @return stringa che descrive il centroide del cluster
     */
    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        
        str.append("Centroid = (");
        for (int i = 0; i < centroid.getLength(); i++)
        {
            str.append(centroid.get(i));
            if (i < centroid.getLength() - 1)
                str.append(" ");
        }

        str.append(")");
        return str.toString();
    }

    /**
     * Restituisce una descrizione dettagliata del cluster, comprensiva del centroide,
     * degli esempi (tuple) assegnate con le loro distanze dal centroide, e della
     * distanza media.
     * @param data l'oggetto {@link Data} da cui recuperare i valori delle tuple
     * @return stringa formattata con centroide, esempi e distanza media
     */
    public String toString(Data data)
    {
        StringBuilder str = new StringBuilder();

        str.append("Centroid = (");
        for (int i = 0; i < centroid.getLength(); i++)
            str.append(centroid.get(i)).append("  ");
        str.append(")\nExamples:\n");

        int[] array = clusteredData.toArray();
        for (int i = 0; i < array.length; i++)
        {
            str.append("[");
            for (int j = 0; j < data.getNumberOfAttributes(); j++)
                str.append(data.getValue(array[i], j)).append(" ");

            double dist = getCentroid().getDistance(data.getItemSet(array[i]));
            str.append("] dist = ").append(dist).append("\n");
        }

        double avgDist = getCentroid().avgDistance(data, array);
        str.append("\nAvgDistance = ").append(avgDist);

        return str.toString();
    }
}