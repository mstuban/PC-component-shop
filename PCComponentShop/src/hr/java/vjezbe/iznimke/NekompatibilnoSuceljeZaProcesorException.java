package hr.java.vjezbe.iznimke;

public class NekompatibilnoSuceljeZaProcesorException extends Exception {

	/**
	 *  Predstavlja tip iznimke koji se baca u slučaju ako sučelja procesora i matične ploče
	 * nisu jednaka.
	 */
	private static final long serialVersionUID = 6160306746455324715L;

	/**
	 * Inicijalizira vrijednost poruke o grešci pozivajući konstruktor nadklase.
	 * 
	 * @param message
	 *            poruka o grešci koja se zapisuje u log file-u
	 */
	public NekompatibilnoSuceljeZaProcesorException(String message) {
		super(message);
	}

	/**
	 * Inicijalizira vrijednost poruke o grešci i uzroku greške pozivajući
	 * konstruktor nadklase.
	 * 
	 * @param message
	 *            poruka o grešci koja se zapisuje u log file-u
	 * @param cause
	 *            uzrok greške koja se dogodila
	 */
	public NekompatibilnoSuceljeZaProcesorException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Inicijalizira vrijednost uzroka greške pozivajući konstruktor nadklase.
	 * 
	 * @param cause
	 *            uzrok greške koja se dogodila
	 */
	public NekompatibilnoSuceljeZaProcesorException(Throwable cause) {
		super(cause);
	}
}
