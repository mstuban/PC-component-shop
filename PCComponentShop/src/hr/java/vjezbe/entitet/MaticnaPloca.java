package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

/**
 * Predstavlja entitet matične ploče koja je definirana tipom sučelja, brojem
 * komponenti i maksimalnim brojem memorijskih modula.
 * 
 * @author Marko
 *
 */
public class MaticnaPloca extends Komponenta implements Prikljucna {
	private String tipSucelja;
	private String tip;

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	private Integer maksimalanBrojMemorijskihModula;
	private Integer brojKomponenti = 0;

	/**
	 * 
	 * Inicijalizira tip sučelja, cijene komponente, naziv proizvođača te
	 * maksimalan broj memorijskih modula matične ploče.
	 * 
	 * @param nazivProizvodjaca
	 *            podatak o nazivu proizvođača matične ploče
	 * @param tipSucelja
	 *            podatak o tipu sučelja matične ploče
	 * @param maksimalanBrojMemorijskihModula
	 *            maksimalan broj memorijskih modula matične ploče
	 * @param cijena
	 *            podatak o cijeni komponente
	 */
	public MaticnaPloca(String nazivProizvodjaca, String tipSucelja, Integer maksimalanBrojMemorijskihModula,
			BigDecimal cijena, String tip) {
		super(nazivProizvodjaca, cijena);
		this.tip = tip;
		this.tipSucelja = tipSucelja;
		this.maksimalanBrojMemorijskihModula = maksimalanBrojMemorijskihModula;
	}

	/**
	 * Dohvaća podatak o tipu sučelja matične ploče.
	 * 
	 * @return podatak o tipu sučelja matične ploče
	 */
	public String getTipSucelja() {
		return tipSucelja;
	}

	/**
	 * Postavlja podatak o tipu sučelja matične ploče.
	 * 
	 * @param tipSucelja
	 *            tip sučelja matične koji će se postaviti
	 */
	public void setTipSucelja(String tipSucelja) {
		this.tipSucelja = tipSucelja;
	}

	/**
	 * Dohvaća podatak o maksimalnom broju modula na matičnoj ploči.
	 * 
	 * @return maksimalan broj memorijskih modula matične ploče
	 */
	public Integer getMaksimalanBrojMemorijskihModula() {
		return maksimalanBrojMemorijskihModula;
	}

	/**
	 * Postavlja maksimalan broj memorijskih modula matične ploče;
	 * 
	 * @param maksimalanBrojMemorijskihModula
	 *            maksimalan broj memorijskih modula matične ploče koji će biti
	 *            postavljen
	 */
	public void setMaksimalanBrojMemorijskihModula(Integer maksimalanBrojMemorijskihModula) {
		this.maksimalanBrojMemorijskihModula = maksimalanBrojMemorijskihModula;
	}

	/**
	 * Dohvaća broj komponenta koje su trenutno priključene na matičnu ploču.
	 * 
	 * @return broj komponenta koje su trenutno priključene na matičnu ploču
	 */
	public Integer getBrojKomponenti() {
		return brojKomponenti;
	}

	/**
	 * Postavlja broj komponenti koje su trenutno priključene na matičnu ploču.
	 * 
	 * @param brojKomponenti
	 *            broj komponenta koje su trenutno priključene na matičnu ploču
	 */
	public void setBrojKomponenti(Integer brojKomponenti) {
		this.brojKomponenti = brojKomponenti;
	}

	/**
	 * Povećava broj komponenti koje su trenutno priključene na matičnu ploču za
	 * 1.
	 */
	@Override
	public void prikljuci() {
		brojKomponenti++;
	}

	/**
	 * Dohvaća broj komponenti koje su trenutno priključene na matičnu ploču.
	 */
	@Override
	public Integer brojPrikljucenihKomponenti() {
		return brojKomponenti;
	}

	/**
	 * Služi za ispis podataka o matičnoj ploči.
	 */
	@Override
	public void ispisPodataka() {
		System.out.println("Naziv proizvođača: " + super.getNazivProizvodjaca());
		System.out.println("Cijena: " + super.getCijena() + " kn");
		System.out.println("Tip sučelja: " + this.tipSucelja);
		System.out.println("Maksimalan broj memorijskih modula: " + this.maksimalanBrojMemorijskihModula);
		System.out.println("Broj komponenti: " + this.brojKomponenti);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append(super.getNazivProizvodjaca());
		builder.append(", ");
		builder.append(this.tip);
		builder.append(", ");
		builder.append(this.tipSucelja);
		builder.append(", ");
		builder.append("Maksimalan broj memorijskih modula: ");
		builder.append(this.maksimalanBrojMemorijskihModula);
		builder.append(", ");
		builder.append(super.getCijena());
		builder.append(" kn");

		return builder.toString();
	}

}
