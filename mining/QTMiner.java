package mining;
import data.Data;
import data.Tuple;

/**
 * Classe concreta che ha lo scopo di implementare l'algoritmo QT (Quality Threshold) per il clustering di dati
 */
public class QTMiner 
{

    /**
    * Array di cluster
    */
    private ClusterSet C;

    /**
    * Raggio massimo di distanza
    */
    private double radius;

    /**
    * Costruttore che inizializza l'array di cluster e imposta il radius
    * @param radius intero che rappresenta il raggio massimo di distanza
    */
    public QTMiner(double radius) 
    {
        this.C = new ClusterSet();
        this.radius = radius;
    }

    /**
    * Restituisce l'array di Cluster
    * @return l'insieme dei {@code Cluster}
    */
    public ClusterSet getC() 
    {
        return C;
    }

    /**
    * Costruttore che inizializza l'array di cluster e imposta il radius
    * @param data oggetto di tipo {@code Data} da cui prelevare le tuple
    * @return intero che rappresenta il numero di cluster scoperti 
    */
    public int compute(Data data)
    {
        int numclusters = 0;
        boolean[] isClustered = new boolean[data.getNumberOfExamples()];

        for (int i = 0; i < isClustered.length; i++)
            isClustered[i] = false;

        int countClustered = 0;
        while (countClustered != data.getNumberOfExamples())
        {
            Cluster c = buildCandidateCluster(data, isClustered);
            C.add(c);

            numclusters++;

            int[] clusteredTupleId = c.iterator();
            for(int i = 0; i < clusteredTupleId.length; i++)
                isClustered[clusteredTupleId[i]] = true;

            countClustered += c.getSize();
        }
        return numclusters;
    }

    /**
    * costruisce un cluster per ciascuna tupla di data non ancora clusterizzata in un cluster di C
    * @param data oggetto di tipo {@code Data} da raggruppare in cluster
    * @param isClustered informazione booleana sullo stato di clusterizzazione di una tupla
    * @return restituisce il cluster candidato più popoloso 
    */
    public Cluster buildCandidateCluster(Data data, boolean isClustered[]) 
    {
        Cluster bestCluster = null;
        int maxSize = 0;

        for (int i = 0; i < data.getNumberOfExamples(); i++) 
        {
            if (!isClustered[i])
            {
                Tuple centroid = data.getItemSet(i);
                Cluster currentCluster = new Cluster(centroid);
                currentCluster.addData(i);

                for (int j = 0; j < data.getNumberOfExamples(); j++) 
                {
                    if (i != j && !isClustered[j]) 
                    {
                        Tuple other = data.getItemSet(j);
                        double distance = centroid.getDistance(other);
                        if (distance <= radius) 
                            currentCluster.addData(j);
                    }
                }

                if (currentCluster.getSize() > maxSize) 
                {
                    maxSize = currentCluster.getSize();
                    bestCluster = currentCluster;
                }
            }
        }

        return bestCluster;
    }
}
