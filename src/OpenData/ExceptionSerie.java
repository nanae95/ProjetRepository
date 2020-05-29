package OpenData;

public class ExceptionSerie extends Exception {

	public ExceptionSerie(Document doc) {
		System.out.println("Ne fait pas partie d'une série!!");
	}
}
