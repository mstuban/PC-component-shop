package hr.java.vjezbe.iznimke;

public class NeispravanBrojMemorijskihModulaException extends Exception {

	/**
	 * Tip izminke koja se baca u slučaju kada uneseni broj memorijskih modula
	 * premašuje maksimalno dozvoljeni.
	 */
	private static final long serialVersionUID = -821866893252460780L;

	/**
	 * Inicijalizira vrijednost poruke o grešci pozivajući konstruktor nadklase.
	 * 
	 * @param message
	 *            poruka o grešci koja se zapisuje u log file-u
	 */
	public NeispravanBrojMemorijskihModulaException(String message) {
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
	public NeispravanBrojMemorijskihModulaException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Inicijalizira vrijednost uzroka greške pozivajući konstruktor nadklase.
	 * 
	 * @param cause
	 *            uzrok greške koja se dogodila
	 */
	public NeispravanBrojMemorijskihModulaException(Throwable cause) {
		super(cause);
	}
}
