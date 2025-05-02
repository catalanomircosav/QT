import data.Data;
import mining.QTMiner;
import keyboardinput.*;

public class MainTest {
	public static void main(String[] args) {

		double radius;
		char risposta;
		Data data =new Data();
		System.out.println(data);
		
		do
		{
			do
			{
				System.out.print("Insert radius (>0)=");
				radius =  Keyboard.readDouble();
				if(radius <= 0)
					System.out.println("Error! Radius must be greater than 0!");
			}while(radius <= 0);
			
			QTMiner qt = new QTMiner(radius);
			int numIter = qt.compute(data);
	
			System.out.println("Number of clusters:" + numIter);
			System.out.println(qt.getC().toString(data));

			do
			{
				System.out.print("New execution? (y/n): ");
				risposta =  Keyboard.readChar();
				if(risposta != 'n' && risposta != 'y')
					System.out.println("Error! Insert 'y' or 'n' !");
			}while(risposta != 'n' && risposta != 'y');
		}while(risposta != 'n');
	}
}
