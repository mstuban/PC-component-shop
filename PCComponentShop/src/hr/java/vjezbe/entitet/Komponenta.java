package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

/**
 * Predstavlja entitet komponente računala koja je definirana nazivom
 * proizvođača.
 * 
 * @author Marko
 *
 */
public abstract class Komponenta {
	private String nazivProizvodjaca;
	private BigDecimal cijena;
	private Integer id;

	/**
	 * Inicijalizira naziv proizvođača komponente i cijenu komponente.
	 * 
	 * @param nazivProizvodjaca
	 *            podatak o nazivu proizvođača komponente
	 * @param cijena podatak o cijeni komponente
	 */
	public Komponenta(String nazivProizvodjaca, BigDecimal cijena) {
		super();
		this.nazivProizvodjaca = nazivProizvodjaca;
		this.cijena = cijena;
	}

	/**
	 * Dohvaća naziv proizvođača komponente.
	 * 
	 * @return naziv proizvođača komponente
	 */
	public String getNazivProizvodjaca() {
		return nazivProizvodjaca;
	}

	/**
	 * Postavlja naziv proizvođača komponente.
	 * 
	 * @param nazivProizvodjaca
	 *            podatak o nazivu proizvođača komponente
	 */
	public void setNazivProizvodjaca(String nazivProizvodjaca) {
		this.nazivProizvodjaca = nazivProizvodjaca;
	}

	/**
	 * Dohvaća podatak o cijeni komponente.
	 * @return podatak o cijeni komponente
	 */
	public BigDecimal getCijena() {
		return cijena;
	}

	/**
	 * Postavlja podatak o cijeni komponente.
	 * @param cijena podatak o cijeni komponente
	 */
	public void setCijena(BigDecimal cijena) {
		this.cijena = cijena;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
/**
 * Služi za specifičan ispis podataka o pojedinoj komponenti.
 */
	public abstract void ispisPodataka();

}
