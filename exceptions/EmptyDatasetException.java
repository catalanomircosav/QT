package exceptions;

public class EmptyDatasetException extends Exception
{
    public EmptyDatasetException()
    {
        super("Il dataset e' vuoto.");
    }

    public EmptyDatasetException(String msg)
    {
        super(msg);
    }
}