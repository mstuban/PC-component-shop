package hr.java.vjezbe.entitet;

/**
 * Dohvaća komponente iz računala.
 * 
 * @author Marko
 *
 */
public abstract class DohvatKomponente {
	private Komponenta[] poljeKomponenata;

	/**
	 * Inicijalizira polje komponenata.
	 * 
	 * @param poljeKomponenata
	 *            polje u kojemu se nalaze komponente računala
	 */
	public DohvatKomponente(Komponenta[] poljeKomponenata) {
		super();
		this.poljeKomponenata = poljeKomponenata;
	}

	/**
	 * 
	 * @return polje komponenata
	 */
	public Komponenta[] getPoljeKomponenata() {
		return poljeKomponenata;
	}

	/**
	 * Postavlja polje komponenata.
	 * 
	 * @param poljeKomponenata polje čije se vrijednosti postavljaju u trenutno polje
	 */
	public void setPoljeKomponenata(Komponenta[] poljeKomponenata) {
		this.poljeKomponenata = poljeKomponenata;
	}

	/**
	 * Određuje tip komponente.
	 * 
	 * @param komponenta entitet koji je definiran nazivom proizvođača
	 *            
	 * @return tip komponente koja je poslana u funkciju
	 */
	public abstract Komponenta odrediKomponentu(Komponenta komponenta);

	/**
	 * Sprema komponentu u polje komponenata računala.
	 * @param komponenta komponenta koja će se spremiti u polje računala
	 */
	public abstract void spremiKomponentu(Komponenta komponenta);
}
