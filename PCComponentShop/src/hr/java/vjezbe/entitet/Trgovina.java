package hr.java.vjezbe.entitet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import hr.java.vjezbe.entitet.Komponenta;

public class Trgovina<T extends Komponenta> {
	private List<T> listaKomponenata = new ArrayList<>();

	public Trgovina(List<T> listaKomponenata) {
		super();
		this.listaKomponenata = listaKomponenata;
	}

	public List<T> getListaKomponenata() {
		return listaKomponenata;
	}

	public void setListaKomponenata(List<T> listaKomponenata) {
		this.listaKomponenata = listaKomponenata;
	}

	public void dodajKomponentu(T komponenta) {
		listaKomponenata.add(komponenta);
	}

	public T najJeftinijaKomponenta() {
		Collections.sort(listaKomponenata, (k1, k2) -> k1.getCijena().compareTo(k2.getCijena()));
		return listaKomponenata.get(0);
	}

	public T najSkupljaKomponenta() {
		Collections.sort(listaKomponenata, (k1, k2) -> k1.getCijena().compareTo(k2.getCijena()));
		return listaKomponenata.get(listaKomponenata.size() - 1);
	}

}