package exceptions;

/**
 * Eccezione personalizzata lanciata quando un dataset è vuoto.
 * 
 * Questa eccezione viene utilizzata per segnalare che il dataset fornito
 * non contiene alcun esempio e quindi non può essere utilizzato
 * per operazioni di clustering o altre elaborazioni.
 */
public class EmptyDatasetException extends Exception
{
    /**
     * Costruttore di default.
     */
    public EmptyDatasetException()
    {
        super("Il dataset e' vuoto.");
    }

    /**
     * Costruttore con messaggio personalizzato.
     * 
     * @param msg il messaggio di errore personalizzato
     */
    public EmptyDatasetException(String msg)
    {
        super(msg);
    }
}