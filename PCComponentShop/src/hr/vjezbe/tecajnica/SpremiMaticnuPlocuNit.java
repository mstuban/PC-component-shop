package hr.vjezbe.tecajnica;

import java.util.List;

import hr.java.vjezbe.baza.podataka.BazaPodataka;
import hr.java.vjezbe.entitet.MaticnaPloca;

public class SpremiMaticnuPlocuNit implements Runnable {

	private Thread nit;

	public SpremiMaticnuPlocuNit() {
		nit = new Thread();
	}

	public void start() {
		nit.start();
	}

	@Override
	public void run() {
		try {
			List<MaticnaPloca> maticnePloce = BazaPodataka.dohvatiMaticnePloce();
			
			for (MaticnaPloca maticnaPloca : maticnePloce)
				BazaPodataka.spremiMaticnuPlocu(maticnaPloca);
	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
