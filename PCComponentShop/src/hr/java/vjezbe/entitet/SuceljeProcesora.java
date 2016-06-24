package hr.java.vjezbe.entitet;
/**
 * Sadrži niz konstanti koje daju podatak o sučeljima procesora.
 * @author Marko
 *
 */
public enum SuceljeProcesora {

	SUCELJE_1(1, "SOCKET_AM2"), SUCELJE_2(2, "SOCKET_AM3"), SUCELJE_3(3, "LGA_1151"), SUCELJE_4(4, "SOCKET_G3");
	
	private Integer kod;
	private String opis;

	/**
	 * Inicijalizira vrijednosti koda sučelja procesora i opisa sučelja procesora.
	 * @param kod kod sučelja procesora
	 * @param opis opis sučelja procesora
	 */
	private SuceljeProcesora(Integer kod, String opis) {
		this.kod = kod;
		this.opis = opis;
	}

	/**
	 * Dohvaća podatak o kodu sučelja;
	 * @return podatak o kodu sučelja
	 */
	public Integer getKod() {
		return kod;
	}
/**
 * Postavlja podatak o kodu sučelja.
 * @param kod podatak o kodu sučelja
 */
	public void setKod(Integer kod) {
		this.kod = kod;
	}
/**
 * Dohvaća podatak o opisu sučelja.
 * @return podatak o opisu sučelja
 */
	public String getOpis() {
		return opis;
	}
/**
 * Postavlja podatak o opisu sučelja.
 * @param opis podatak o opisu sučelja
 */
	public void setOpis(String opis) {
		this.opis = opis;
	}

}
