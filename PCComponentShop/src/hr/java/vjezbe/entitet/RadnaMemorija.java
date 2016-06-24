package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

/**
 * Predstavlja entitet radne memorije koju definira tip, kapacitet i broj
 * modula.
 * 
 * @author Marko
 *
 */

public class RadnaMemorija extends Komponenta implements Memorijska {
	private String tip;
	private Integer kapacitet;
	private Integer brojModula;

	/**
	 * 
	 * @param nazivProizvodjaca
	 *            podatak o nazivu proizvođača radne memorije
	 * @param tip
	 *            podatak o tipu radne memorije
	 * @param kapacitet
	 *            podatak o kapacitetu radne memorije
	 * @param brojModula
	 *            podatak o broju modula radne memorije
	 */
	/**
	 * Inicijalizira vrijednosti naziva proizvođača, cijeni komponente, tipa,
	 * kapaciteta i broja modula radne memorije računala. Također postavlja
	 * naziv proizvođača komponente.
	 * 
	 * @param nazivProizvodjaca
	 *            podatak o nazivu proizvođača radne memorije
	 * @param tip
	 *            podatak o tipu radne memorije
	 * @param kapacitet
	 *            podatak o kapacitetu radne memorije
	 * @param brojModula
	 *            podatak o broju modula radne memorije
	 * @param cijena
	 *            podatak o cijeni komponente
	 */
	public RadnaMemorija(String nazivProizvodjaca, String tip, Integer kapacitet, Integer brojModula,
			BigDecimal cijena) {
		super(nazivProizvodjaca, cijena);
		this.tip = tip;
		this.kapacitet = kapacitet;
		this.brojModula = brojModula;
	}

	/**
	 * Dohvaća tip radne memorije.
	 * 
	 * @return podatak o tipu radne memorije
	 */
	public String getTip() {
		return tip;
	}

	/**
	 * Postavlja tip radne memorije računala.
	 * 
	 * @param tip
	 *            radne memorije koji će biti postavljen
	 */
	public void setTip(String tip) {
		this.tip = tip;
	}

	/**
	 * Dohvaća kapacitet radne memorije.
	 * 
	 * @return kapacitet radne memorije
	 */
	public Integer getKapacitet() {
		return kapacitet;
	}

	/**
	 * Postavlja kapacitet radne memorije.
	 * 
	 * @param kapacitet
	 *            radne memorije koji će biti postavljen
	 */
	public void setKapacitet(Integer kapacitet) {
		this.kapacitet = kapacitet;
	}

	/**
	 * Dohvaća broj modula radne memorije.
	 * 
	 * @return broj modula radne memorije
	 */
	public Integer getBrojModula() {
		return brojModula;
	}

	/**
	 * Postavlja broj modula radne memorije.
	 * 
	 * @param brojModula
	 *            broj modula radne memorije koji će biti postavljen
	 */
	public void setBrojModula(Integer brojModula) {
		this.brojModula = brojModula;
	}
/**
 * Služi za ispis podataka o radnoj memoriji.
 */
	@Override
	public void ispisPodataka() {
		System.out.println("Naziv proizvođača: " + super.getNazivProizvodjaca());
		System.out.println("Cijena: " + super.getCijena() + " kn");
		System.out.println("Tip: " + this.tip);
		System.out.println("Kapacitet: " + this.kapacitet + " GB");
		System.out.println("Broj modula: " + this.brojModula);
	}

	@Override
	public void uvecajKapacitet(Integer broj) {
		this.kapacitet *= broj;
	}

	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		
		builder.append(this.getNazivProizvodjaca());
		builder.append(", ");
		builder.append(this.tip);
		builder.append(", Kapacitet: ");
		builder.append(this.kapacitet);
		builder.append(" GB");
		builder.append(", ");
		builder.append("Broj modula: ");
		builder.append(this.brojModula);
		builder.append(", ");
		builder.append(super.getCijena());
		builder.append(" kn");
		
		return builder.toString();
	}

}
