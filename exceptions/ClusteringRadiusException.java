package exceptions;

/**
 * La classe {@link ClusteringRadiusException} estende la classe Exception e rappresenta l'eccezione che riguarda un unico cluster
 */
public class ClusteringRadiusException extends Exception 
{
    /**
     * Costruttore che invoca il costruttore della classe madre {@code Exception}
     */
    public ClusteringRadiusException(String message) 
    {
        super(message);
    }
}