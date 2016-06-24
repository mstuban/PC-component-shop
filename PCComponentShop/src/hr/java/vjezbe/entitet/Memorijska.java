package hr.java.vjezbe.entitet;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Uvećava kapacitet radne memorije i pretvara gigabajte u terabajte.
 * @author Marko
 *
 */
public interface Memorijska {
	/**
	 * Uvećava kapacitet radne memorije za zadani broj.
	 * @param broj broj za koji će se povećati kapacitet radne memorije računala (u gigabajtima)
	 */
	public void uvecajKapacitet(Integer broj);
	/**
	 * Pretvara podatak u gigabajtima u terabajte.
	 * @param broj broj čija se vrijednost treba pretvoriti iz gigabajta u terabajte
	 * @return podatak u terabajtima
	 */
	public static BigDecimal pretvoriUTB(BigDecimal broj)
	{
		return broj.divide(new BigDecimal(1024), 8, RoundingMode.CEILING);
	}
}
