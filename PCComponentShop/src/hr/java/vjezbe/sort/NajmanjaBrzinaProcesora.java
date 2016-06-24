package hr.java.vjezbe.sort;

import java.util.Comparator;

import hr.java.vjezbe.entitet.Racunalo;

public class NajmanjaBrzinaProcesora implements Comparator<Racunalo> {

	@Override
	public int compare(Racunalo o1, Racunalo o2) {
		if (o1.getProcesor().getBrzina().compareTo(o2.getProcesor().getBrzina()) > 0) {
			return 1;
		} else if (o1.getProcesor().getBrzina().compareTo(o2.getProcesor().getBrzina()) < 0) {
			return -1;
		} else {
			return 0;
		}
	}

}
