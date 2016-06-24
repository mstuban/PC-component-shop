package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

/**
 * Predstavlja entitet računala, koji je sastavljen od matične ploče, procesora,
 * radne memorije i tvrdog diska (komponenata).
 * 
 * @author Marko
 *
 */
public class Racunalo extends DohvatKomponente {
	private MaticnaPloca maticnaPloca;
	private Procesor procesor;
	private RadnaMemorija radnaMemorija;
	private TvrdiDisk tvrdiDisk;
	private Integer brojMemorijskihModula;
	private Integer id;	

	/**
	 * Inicijalizira matičnu ploču, procesor, radnu memoriju i tvrdi disk.
	 * Dodaje 10 komponenti u polje komponenata u nadklasi.
	 * 
	 * @param maticnaPloca
	 *            matična ploča računala
	 * @param procesor
	 *            procesor računala
	 * @param radnaMemorija
	 *            radna memorija računala
	 * @param tvrdiDisk
	 *            tvrdi disk računala
	 */
	public Racunalo(MaticnaPloca maticnaPloca, Procesor procesor, RadnaMemorija radnaMemorija, TvrdiDisk tvrdiDisk,
			Integer brojMemorijskihModula, Integer id) {
		super(new Komponenta[10]);
		this.maticnaPloca = maticnaPloca;
		this.procesor = procesor;
		this.radnaMemorija = radnaMemorija;
		this.tvrdiDisk = tvrdiDisk;
		this.brojMemorijskihModula = brojMemorijskihModula;
		this.id = id;
	}

	/**
	 * Dohvaća matičnu ploču računala.
	 * 
	 * @return matičnu ploču računala
	 */
	public MaticnaPloca getMaticnaPloca() {
		return maticnaPloca;
	}

	/**
	 * Postavlja matičnu ploču računala.
	 * 
	 * @param maticnaPloca
	 *            matična ploča čije vrijednosti će biti postavljene
	 */
	public void setMaticnaPloca(MaticnaPloca maticnaPloca) {
		this.maticnaPloca = maticnaPloca;
	}

	/**
	 * Dohvaća procesor računala.
	 * 
	 * @return procesor računala
	 */
	public Procesor getProcesor() {
		return procesor;
	}

	/**
	 * Postavlja procesor računala.
	 * 
	 * @param procesor
	 *            čije vrijednosti će biti postavljene
	 */
	public void setProcesor(Procesor procesor) {
		this.procesor = procesor;
	}

	/**
	 * Dohvaća radnu memoriju računala.
	 * 
	 * @return radnu memoriju računala
	 */
	public RadnaMemorija getRadnaMemorija() {
		return radnaMemorija;
	}

	/**
	 * Postavlja radnu memoriju računala.
	 * 
	 * @param radnaMemorija
	 *            radna memorija koja će biti postavljena
	 */
	public void setRadnaMemorija(RadnaMemorija radnaMemorija) {
		this.radnaMemorija = radnaMemorija;
	}

	/**
	 * Dohvaća tvrdi disk računala.
	 * 
	 * @return tvrdi disk računala
	 */
	public TvrdiDisk getTvrdiDisk() {
		return tvrdiDisk;
	}

	/**
	 * Postavlja tvrdi disk računala.
	 * 
	 * @param tvrdiDisk
	 *            tvrdi disk čije vrijednosti će biti postavljene
	 */
	public void setTvrdiDisk(TvrdiDisk tvrdiDisk) {
		this.tvrdiDisk = tvrdiDisk;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBrojMemorijskihModula() {
		return brojMemorijskihModula;
	}

	public void setBrojMemorijskihModula(Integer brojMemorijskihModula) {
		this.brojMemorijskihModula = brojMemorijskihModula;
	}

	public BigDecimal izracunajCijenuRacunala() {
		BigDecimal cijenaRacunala = new BigDecimal(0);
		cijenaRacunala = cijenaRacunala.add(this.maticnaPloca.getCijena());
		cijenaRacunala = cijenaRacunala.add(this.procesor.getCijena());
		cijenaRacunala = cijenaRacunala.add(this.radnaMemorija.getCijena().multiply(new BigDecimal(this.brojMemorijskihModula)));
		cijenaRacunala = cijenaRacunala.add(this.tvrdiDisk.getCijena());
		return cijenaRacunala;
	}

	@Override
	public Komponenta odrediKomponentu(Komponenta komponenta) {
		if (komponenta instanceof MaticnaPloca) {
			System.out.println("Ispitana komponenta je matična ploča.");
			return komponenta;
		}
		if (komponenta instanceof TvrdiDisk) {
			System.out.println("Ispitana komponenta je procesor.");
			return komponenta;
		}
		if (komponenta instanceof Procesor) {
			System.out.println("Ispitana komponenta je procesor.");
			return komponenta;
		}
		if (komponenta instanceof RadnaMemorija) {
			System.out.println("Ispitana komponenta je radna memorija.");
			return komponenta;
		}
		return null;
	}

	@Override
	public void spremiKomponentu(Komponenta komponenta) {
	}

	@Override
	public String toString() {

		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("\nProizvođač matične ploče:\n");
		stringBuilder.append(this.getMaticnaPloca().getNazivProizvodjaca());
		stringBuilder.append("\nTip sučelja matične ploče:\n");
		stringBuilder.append(this.getMaticnaPloca().getTipSucelja());
		stringBuilder.append("\nProizvođač procesora:\n");
		stringBuilder.append(this.getProcesor().getNazivProizvodjaca());
		stringBuilder.append("\nTip sučelja procesora:\n");
		stringBuilder.append(this.getProcesor().getTipSucelja());
		stringBuilder.append("\nBrzina procesora:\n");
		stringBuilder.append(this.getProcesor().getBrzina());
		stringBuilder.append(" GHz");
		stringBuilder.append("\nProizvođač radne memorije:\n");
		stringBuilder.append(this.getRadnaMemorija().getNazivProizvodjaca());
		stringBuilder.append("\nTip radne memorije:\n");
		stringBuilder.append(this.getRadnaMemorija().getTip());
		stringBuilder.append("\nKapacitet radne memorije:\n");
		stringBuilder.append(Memorijska.pretvoriUTB(new BigDecimal(this.getRadnaMemorija().getKapacitet())));
		stringBuilder.append(" TB");
		stringBuilder.append("\nBroj modula radne memorije:\n");
		stringBuilder.append(this.getRadnaMemorija().getBrojModula());
		stringBuilder.append("\nProizvođač tvrdog diska:\n");
		stringBuilder.append(this.getTvrdiDisk().getNazivProizvodjaca());
		stringBuilder.append("\nTip tvrdog diska:\n");
		stringBuilder.append(this.getTvrdiDisk().getTip());
		stringBuilder.append("\nKapacitet tvrdog diska:\n");
		stringBuilder.append(this.getTvrdiDisk().getKapacitet());
		stringBuilder.append(" TB");
		stringBuilder.append("\nCijena matične ploče:\n");
		stringBuilder.append(this.getMaticnaPloca().getCijena());
		stringBuilder.append(" kn");
		stringBuilder.append("\nCijena procesora:\n");
		stringBuilder.append(this.getProcesor().getCijena());
		stringBuilder.append(" kn");
		stringBuilder.append("\nCijena radne memorije:\n");
		stringBuilder.append(this.getRadnaMemorija().getCijena());
		stringBuilder.append(" kn");
		stringBuilder.append("\nCijena tvrdog diska:\n");
		stringBuilder.append(this.getTvrdiDisk().getCijena());
		stringBuilder.append(" kn\n");

		return stringBuilder.toString();

		// return "Proizvođač matične ploče:\n" +
		// this.getMaticnaPloca().getNazivProizvodjaca()
		// + "\nTip sučelja matične ploče:\n" +
		// this.getMaticnaPloca().getTipSucelja()
		// + "\nProizvođač procesora:\n" +
		// this.getProcesor().getNazivProizvodjaca() + "\nTip sučelja
		// procesora:\n"
		// + this.getProcesor().getTipSucelja() + "\nBrzina procesora:\n" +
		// this.getProcesor().getBrzina() + " GHz"
		// + "\nProizvođač radne memorije:\n" +
		// this.getRadnaMemorija().getNazivProizvodjaca()
		// + "\nTip radne memorije:\n" + this.getRadnaMemorija().getTip() +
		//
		// new BigDecimal(this.getRadnaMemorija().getKapacitet()) +
		//
		// "\nKapacitet radne memorije:\n" + Memorijska.pretvoriUTB(new
		// BigDecimal(this.getRadnaMemorija().getKapacitet()))
		// + " TB" + "Broj modula radne memorije: " +
		// this.getRadnaMemorija().getBrojModula()
		// + "\nProizvođač tvrdog diska:\n" +
		// this.getTvrdiDisk().getNazivProizvodjaca() + "\nTip tvrdog diska:\n"
		// + this.getTvrdiDisk().getTip() + "\nBroj okretaja tvrdog diska:\n"
		// + this.getTvrdiDisk().getBrojOkretaja() + "\nKapacitet tvrdog
		// diska:\n"
		// + this.getTvrdiDisk().getKapacitet() + " TB" +
		//
		// "\nCijena matične ploče:\n" + this.getMaticnaPloca().getCijena() + "
		// kn" +
		//
		// "\nCijena procesora:\n" + this.getProcesor().getCijena() + " kn" +
		//
		// "\nCijena radne memorije:\n" + this.getRadnaMemorija().getCijena() +
		// " kn" +
		//
		// "\nCijena tvrdog diska:\n" + this.getTvrdiDisk().getCijena() + " kn";
	}

}
