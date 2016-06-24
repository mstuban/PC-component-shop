package hr.java.vjezbe.entitet;

import java.math.BigDecimal;
/**
 * Predstavlja entitet tvrdog diska, a definiran je tipom, kapacitetom, i brojem okretaja.
 * @author Marko
 *
 */
public class TvrdiDisk extends Komponenta implements Memorijska {
	private String tip;
	private BigDecimal kapacitet;
	private Integer brojOkretaja;
/**
 * Inicijalizira vrijednosti naziva proizvođača, cijeni komponente, tipa, kapaciteta i broja okretaja tvrdog diska. Također postavlja naziv proizvođača komponente.
 * @param nazivProizvodjaca podatak o nazivu proizvođača tvrdog diska
 * @param tip podatak o tipu tvrdog diska
 * @param kapacitet podatak o kapacitetu tvrdog diska
 * @param brojOkretaja podatak o broju okretaja tvrdog diska
 * @param cijena podatak o cijeni komponente
 */
	public TvrdiDisk(String nazivProizvodjaca, String tip, BigDecimal kapacitet, Integer brojOkretaja, BigDecimal cijena) {
		super(nazivProizvodjaca, cijena);
		this.tip = tip;
		this.kapacitet = kapacitet;
		this.brojOkretaja = brojOkretaja;
	}
/**
 * Dohvaća podatak o tipu tvrdog diska.
 * @return tip tvrdog diska
 */
	public String getTip() {
		return tip;
	}
/**
 * Postavlja podatak o tip tvrdog diska.
 * @param tip tip tvrdog diska koji će biti postavljen
 */
	public void setTip(String tip) {
		this.tip = tip;
	}
/**
 * Dohvaća podatak o kapacitetu tvrdog diska.
 * @return kapacitet tvrdog diska
 */
	public BigDecimal getKapacitet() {
		return kapacitet;
	}
/**
 * Postavlja kapacitet tvrdog diska.
 * @param kapacitet kapacitet tvrdog diska koji će biti postavljen
 */
	public void setKapacitet(BigDecimal kapacitet) {
		this.kapacitet = kapacitet;
	}
/**
 * Dohvaća podatak o broju okretaja tvrdog diska.
 * @return broj okretaja tvrdog diska
 */
	public Integer getBrojOkretaja() {
		return brojOkretaja;
	}
/**
 * Postavlja broj okretaja tvrdog diska.
 * @param brojOkretaja broj okretaja tvrdog diska koji će biti postavljen
 */
	public void setBrojOkretaja(Integer brojOkretaja) {
		this.brojOkretaja = brojOkretaja;
	}

	@Override
	public void uvecajKapacitet(Integer broj) {
		BigDecimal big = new BigDecimal(broj);
		this.kapacitet = this.kapacitet.multiply(big);
	}
	
	@Override
	public void ispisPodataka() {
		System.out.println("Naziv proizvođača: " + super.getNazivProizvodjaca());
		System.out.println("Cijena: " + super.getCijena() + " kn");
		System.out.println("Tip: " + this.tip);
		System.out.println("Kapacitet: " + this.kapacitet + " GB");
		System.out.println("Broj okretaja: " + this.brojOkretaja);
	}
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		
		builder.append(super.getNazivProizvodjaca());
		builder.append(", ");
		builder.append(this.tip);
		builder.append(", Kapacitet: ");
		builder.append(this.kapacitet);
		builder.append(" GB");
		builder.append(", ");
		builder.append("Broj okretaja: ");
		builder.append(this.brojOkretaja);
		builder.append(", ");
		builder.append(super.getCijena());
		builder.append(" kn");
		
		return builder.toString();
	}


}
