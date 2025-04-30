/**
 * La classe {@link ClusterSet} rappresenta un insieme di cluster.
 * 
 * @see Cluster
 */
public class ClusterSet {

    /**
     * Array di cluster
     */
    private Cluster[] C;

    /**
     * Costruttore che inizializza l'array dei cluster come vuoto.
     */
    public ClusterSet()
    {
        C = new Cluster[0];
    }

    /**
     * Metodo che permette di aggiungere un cluster all'insieme dei cluster
     * @param c cluster da aggiungere
     */
    void add(Cluster c)
    {
        Cluster temp[] = new Cluster[C.length + 1];

        for(int i = 0; i < C.length; i++)
            temp[i] = C[i];
        
        temp[C.length] = c;
        C = temp;
    }
    
    /**
     * Metodo che permette di ottenere un cluster all'indice specificato. 
     * @param i indice del cluster da restituire
     * @return il cluster all'indice {@code i}
     */
    Cluster get(int i)
    {
        return C[i];
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

        for(int i = 0; i < C.length; i++)
            if(C[i] != null)
                str.append(i).append(C[i].toString()).append("\n");
        
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

        for(int i = 0; i < C.length; i++)
            if(C[i] != null)
                str.append(i).append(": ").append(toString(data)).append("\n");
        
        return str.toString();
    }
}
