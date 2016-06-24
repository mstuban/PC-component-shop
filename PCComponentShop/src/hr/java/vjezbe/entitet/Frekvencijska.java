package hr.java.vjezbe.entitet;

import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 * Povećava brzinu za pola iznosa početne brzine.
 * 
 * @author Marko
 *
 */
public interface Frekvencijska {
	/**
	 * 
	 * @param brzina podatak o brzini procesora
	 * @return brzina uvećana za pola iznosa početne brzine
	 */
	default public BigDecimal overclock(BigDecimal brzina) {
		return brzina.add((brzina.divide(new BigDecimal(2), 8, RoundingMode.CEILING)));
	}
}
