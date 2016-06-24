package hr.vjezbe.tecajnica;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import hr.java.vjezbe.javafx.PocetniEkranController;

public class TecajnicaNit implements Runnable {

	private Thread nit;

	public TecajnicaNit(String nazivPrograma) {
		nit = new Thread(this, nazivPrograma);
	}

	public void start() {
		nit.start();
	}

	@Override
	public void run() {
		boolean flag = true;
		while (flag) {
			LocalDate localDate = PocetniEkranController.datum;
			String oznakaValute = PocetniEkranController.valuta;
			if(Tecajnica.dohvatiTecaj(oznakaValute, localDate) == null){
				break;
			}
			String formatiraniDatum = localDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
			System.out.print(formatiraniDatum + " ");
			System.out.print(nit.getName());
			System.out.print("za " + oznakaValute + " je: ");
			System.out.println(Tecajnica.dohvatiTecaj(oznakaValute, localDate));
			System.out.println();

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
