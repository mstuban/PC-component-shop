package hr.vjezbe.tecajnica;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Tecajnica {

	public static BigDecimal dohvatiTecaj(String oznakaValute, LocalDate datum){

		String formatiraniDatum = datum.format(DateTimeFormatter.ofPattern("ddMMyy"));
		String URL = "http://www.hnb.hr/tecajn/f" + formatiraniDatum + ".dat";

		URL url = null;
		try {
			url = new URL(URL);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Scanner in = null;

			try {
				in = new Scanner(url.openStream());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("Greška! Za taj datum ne postoji tečaj!");
				return null;
				
			}


		String line;

		try {
			while ((line = in.nextLine()) != null) {
				if (line.contains(oznakaValute)) {
					if(oznakaValute == "GBP"){
						String tecajString = line.substring(30, 39);
						tecajString = tecajString.substring(0, 2) + '.' + tecajString.substring(3, 9);
						BigDecimal tecaj = new BigDecimal(tecajString);
						in.close();
						return tecaj;
					}
					String tecajString = line.substring(31, 39);
					tecajString = tecajString.substring(0, 1) + '.' + tecajString.substring(2, 8);
					BigDecimal tecaj = new BigDecimal(tecajString);
					in.close();
					return tecaj;
				}
			}
		} catch (NoSuchElementException e) {

		}
		return new BigDecimal(0);
		
	}
}
