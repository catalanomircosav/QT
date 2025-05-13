import data.Data;
import mining.QTMiner;
import keyboardinput.*;
import exceptions.*;

public class MainTest {
    public static void main(String[] args) {
        double radius;
        char risposta = ' ';
        Data data = new Data();

        try {
            // Controllo iniziale: verifica se il dataset è vuoto
            if (data.getNumberOfExamples() == 0) {
                throw new EmptyDatasetException("Il dataset è vuoto. Impossibile procedere.");
            }

            System.out.println(data);

            do {
                do {
                    System.out.print("Insert radius (>0): ");
                    radius = Keyboard.readDouble();
                    if (radius <= 0)
                        System.out.println("Error! Radius must be greater than 0!");
                } while (radius <= 0);

                QTMiner qt = new QTMiner(radius);
                
                try {
                    int numIter = qt.compute(data);
                    System.out.println("Number of clusters: " + numIter);
                    System.out.println(qt.getC().toString(data));

                } catch (EmptyDatasetException | ClusteringRadiusException e) {

                    System.err.println("Errore durante il clustering: " + e.getMessage());
                    continue;
                }

                do {
                    System.out.print("New execution? (y/n): ");
                    risposta = Keyboard.readChar();
                    if (risposta != 'n' && risposta != 'y')
                        System.out.println("Error! Insert 'y' or 'n'!");
                } while (risposta != 'n' && risposta != 'y');
            } while (risposta != 'n');

        } catch (EmptyDatasetException e) {
            System.err.println("Errore iniziale: " + e.getMessage());
        }
    }
}