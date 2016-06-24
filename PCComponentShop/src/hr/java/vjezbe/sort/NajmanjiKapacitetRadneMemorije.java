package hr.java.vjezbe.sort;

import java.util.Comparator;

import hr.java.vjezbe.entitet.Racunalo;

public class NajmanjiKapacitetRadneMemorije implements Comparator<Racunalo> {

	@Override
	public int compare(Racunalo o1, Racunalo o2) {
		if (o1.getRadnaMemorija().getKapacitet() > o2.getRadnaMemorija().getKapacitet()) {
			return 1;
		} else if (o1.getRadnaMemorija().getKapacitet() < o2.getRadnaMemorija().getKapacitet()) {
			return -1;
		} else {
			return 0;
		}
	}

}
