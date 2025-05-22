package mining;
import data.Data;
import java.util.TreeSet;
import java.util.Set;
import java.util.Iterator;

/**
 * La classe {@link ClusterSet} rappresenta un insieme di cluster.
 * @see Cluster
 */
public class ClusterSet implements Iterable<Cluster> {

    /**
     * Array di cluster
     */
    private Set<Cluster> C;

    /**
     * Costruttore che inizializza l'array dei cluster come vuoto.
     */
    ClusterSet()
    {
        C = new TreeSet<>();
    }

    /**
     * Metodo che permette di aggiungere un cluster all'insieme dei cluster
     * @param c cluster da aggiungere
     */
    void add(Cluster c)
    {
        C.add(c);
    }

    /**
     * Restituisce una string composta dai centroidi di tutti i cluster in questo insieme.
     * Formato: "0: centroide0\n1: centroide1\n..."
     * @return rappresentazione testuale dei centroidi di tutti i cluster
     */
    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();

        int i = 1;
        for(Cluster c : C)
            str.append(i++).append(": ").append(c.toString()).append("\n");
        
        return str.toString();
    }

    /**
     * Restituisce una descrizione dettagliata di ciascun cluster, utilizzando i dati forniti.
     * Formato: "i: dettagli di ogni cluster\n"
     * @param data container {@link Data} da cui estrarre i valori delle tuple
     * @return rappresentazione testuale dello stato di tutti i cluster nell'insieme
     */
    public String toString(Data data)
    {
        StringBuilder str = new StringBuilder();
        
        int i = 1;
        for(Cluster c : C)
            str.append(i++).append(": ").append(c.toString(data)).append("\n");
        
        return str.toString();
    }

    @Override
    public Iterator<Cluster> iterator()
    {
        return C.iterator();
    }
}
