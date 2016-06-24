package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

/**
 * Predstavlja entitet procesora, koji je definiran tipom sučelja i brzinom.
 * 
 * @author Marko
 *
 */
public class Procesor extends Komponenta implements Frekvencijska {

	private String tipSucelja;
	private BigDecimal brzina;

	/**
	 * Inicijalizira vrijednosti naziva proizvođača procesora, cijeni
	 * komponente, tipa sučelja procesora, i brzine procesora. Također postavlja
	 * naziv proizvođača komponente
	 * 
	 * @param nazivProizvodjaca
	 *            podatak o nazivu proizvođača procesora
	 * @param tipSucelja
	 *            podatak o tipu sučelja procesora
	 * @param brzina
	 *            brzina procesora (u gigahercima)
	 * @param cijena
	 *            podatak o cijeni komponente
	 */
	public Procesor(String nazivProizvodjaca, String tipSucelja, BigDecimal brzina, BigDecimal cijena) {
		super(nazivProizvodjaca, cijena);
		this.tipSucelja = tipSucelja;
		this.brzina = brzina;
	}

	/**
	 * Dohvaća podatak o tipu sučelja procesora.
	 * 
	 * @return tip sučelja procesora
	 */
	public String getTipSucelja() {
		return tipSucelja;
	}

	/**
	 * Postavlja podatak o tipu sučelja procesora.
	 * 
	 * @param tipSucelja
	 *            podatak o tipu sučelja procesora koji se treba postaviti
	 */
	public void setTipSucelja(String tipSucelja) {
		this.tipSucelja = tipSucelja;
	}

	/**
	 * Dohvaća podatak o brzini procesora.
	 * 
	 * @return podatak o brzini procesora
	 */
	public BigDecimal getBrzina() {
		return brzina;
	}

	/**
	 * Postavlja brzinu procesora na određenu vrijednost.
	 * 
	 * @param brzina
	 *            broj na koji će se postaviti trenutna brzina procesora
	 */
	public void setBrzina(BigDecimal brzina) {
		this.brzina = brzina;
	}

	/**
	 * Služi za ispis podataka o procesoru.
	 */
	@Override
	public void ispisPodataka() {
		System.out.println("Naziv proizvođača: " + super.getNazivProizvodjaca());
		System.out.println("Cijena: " + super.getCijena() + " kn");
		System.out.println("Tip sučelja: " + this.tipSucelja);
		System.out.println("Brzina: " + this.brzina + " GHz");

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append(super.getNazivProizvodjaca());
		builder.append(", ");
		builder.append(this.tipSucelja);
		builder.append(", Brzina: ");
		builder.append(this.brzina);
		builder.append(" GHz");
		builder.append(", ");
		builder.append(super.getCijena());
		builder.append(" kn");

		return builder.toString();
	}

}
