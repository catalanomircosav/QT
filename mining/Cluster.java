package mining;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import data.Data;
import data.Tuple;

/**
 * Rappresenta un cluster in uno spazio di tuple, definito da un centroide
 * e da un insieme di identificatori di tuple assegnate a questo cluster.
 */
public class Cluster implements Iterable<Integer>, Comparable<Cluster>
{
    
    /**
     * Il centroide del cluster, rappresentato come una {@link Tuple}.
     */
    private Tuple centroid;
    
    /**
     * Insieme di identificatori (interi) delle tuple che appartengono a questo cluster.
     */
    private  Set<Integer> clusteredData;

    /**
     * Costruisce un nuovo cluster con il centroide specificato.
     * @param centroid la {@link Tuple} da usare come centroide del cluster
     */
    Cluster(Tuple centroid)
    {
        this.centroid = centroid;
        this.clusteredData = new HashSet<>();
    }

    /**
     * Restituisce il centroide di questo cluster.
     * @return la {@link Tuple} che rappresenta il centroide
     */
    Tuple getCentroid()
    {
        return centroid;
    }

    /**
     * Aggiunge l'identificatore di una tupla all'insieme dei dati clusterizzati.
     * @param id l'identificatore (intero) della tupla da aggiungere
     * @return {@code true} se l'aggiunta ha modificato l'insieme, {@code false} altrimenti
     */
    boolean addData(int id)
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
        return clusteredData.contains(id);
    }

    /**
     * Rimuove l'identificatore di una tupla dall'insieme dei dati clusterizzati.
     * @param id l'identificatore della tupla da rimuovere
     */
    void removeTuple(int id)
    {
        clusteredData.remove(id);
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
     * Restituisce un array di interi contenente gli identificatori delle tuple assegnate a questo cluster.
     * @return array di {@code int} contenente gli ID delle tuple appartenenti al cluster
     */
    public int[] toArray() 
    {
        return clusteredData.stream().mapToInt(Integer::intValue).toArray();
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
    public String toString(Data data) {
        StringBuilder str = new StringBuilder();

        // Descrizione del centroide
        str.append("Centroid = (");
        for (int i = 0; i < centroid.getLength(); i++)
            str.append(centroid.get(i)).append("  ");
        str.append(")\nExamples:\n");
        
        // Dettagli degli esempi
        Set<Tuple> tupleset = new HashSet<>();

        for (Integer id : clusteredData) 
        {
            str.append("[");
            for (int j = 0; j < data.getNumberOfAttributes(); j++) {
                str.append(data.getValue(id, j)).append(" ");
            }

            Tuple t = data.getItemSet(id);
            tupleset.add(t);

            double dist = getCentroid().getDistance(t);
            str.append("] dist = ").append(dist).append("\n");
        }

        double avgDist = getCentroid().avgDistance(data, tupleset);
        str.append("\nAvgDistance = ").append(avgDist);

        return str.toString();
    }

    /**
    Fornisce un iteratore per scorrere gli ID delle tuple nel cluster.
    @return iteratore sugli ID.
    */
    @Override
    public Iterator<Integer> iterator() 
    {
        return clusteredData.iterator();
    }

    /**
    Confronta due cluster in base alla popolosità (numero di elementi).
    @param otherCluster cluster da confrontare
    @return -1 se questo cluster è meno popoloso, +1 se più popoloso
    */
    @Override
    public int compareTo(Cluster otherCluster) 
    {
        return Integer.compare(this.getSize(), otherCluster.getSize());
    }
}