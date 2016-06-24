package hr.java.vjezbe.glavna;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import hr.java.vjezbe.entitet.MaticnaPloca;
import hr.java.vjezbe.entitet.Procesor;
import hr.java.vjezbe.entitet.RadnaMemorija;
import hr.java.vjezbe.entitet.TvrdiDisk;

public class GlavnaDatoteke {

	public static List<MaticnaPloca> ucitajMaticnePloce() throws FileNotFoundException {

		List<MaticnaPloca> listaMaticnihPloca = new ArrayList<>();
		String line;
		String nazivProizvodjaca = new String();
		String tipMaticnePloce = new String();
		String tipSucelja = new String();

		try (BufferedReader in = new BufferedReader(new FileReader("dat/maticnePloce.txt"))) {
			while ((line = in.readLine()) != null) {
				nazivProizvodjaca = line;
				tipMaticnePloce = in.readLine();
				tipSucelja = in.readLine();
				Integer brojModula = Integer.parseInt(in.readLine());
				BigDecimal cijena = new BigDecimal(in.readLine());
				MaticnaPloca maticnaPloca = new MaticnaPloca(nazivProizvodjaca, tipSucelja, brojModula, cijena,
						tipMaticnePloce);
				listaMaticnihPloca.add(maticnaPloca);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return listaMaticnihPloca;
	}

	public static List<TvrdiDisk> ucitajTvrdeDiskove() throws FileNotFoundException {

		List<TvrdiDisk> listaTvrdihDiskova = new ArrayList<>();
		String line;
		String nazivProizvodjaca = new String();
		String tip = new String();
		BigDecimal kapacitetTvrdogDiska;
		Integer brojOkretaja;
		BigDecimal cijena;

		try (BufferedReader in = new BufferedReader(new FileReader("dat/tvrdiDiskovi.txt"))) {
			while ((line = in.readLine()) != null) {
				nazivProizvodjaca = line;
				tip = in.readLine();
				kapacitetTvrdogDiska = new BigDecimal(in.readLine());
				brojOkretaja = Integer.parseInt(in.readLine());
				cijena = new BigDecimal(in.readLine());
				TvrdiDisk tvrdiDisk = new TvrdiDisk(nazivProizvodjaca, tip, kapacitetTvrdogDiska, brojOkretaja, cijena);
				listaTvrdihDiskova.add(tvrdiDisk);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return listaTvrdihDiskova;
	}

	public static List<Procesor> ucitajProcesore() throws FileNotFoundException {

		List<Procesor> listaProcesora = new ArrayList<>();
		String line;
		String nazivProizvodjaca = new String();
		String tipSucelja = new String();
		BigDecimal brzina;
		BigDecimal cijena;

		try (BufferedReader in = new BufferedReader(new FileReader("dat/procesori.txt"))) {
			while ((line = in.readLine()) != null) {
				nazivProizvodjaca = line;
				tipSucelja = in.readLine();
				brzina = new BigDecimal(in.readLine());
				cijena = new BigDecimal(in.readLine());
				Procesor procesor = new Procesor(nazivProizvodjaca, tipSucelja, brzina, cijena);
				listaProcesora.add(procesor);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return listaProcesora;
	}
	
	public static List<RadnaMemorija> ucitajRadneMemorije() throws FileNotFoundException {

		List<RadnaMemorija> listaRadnihMemorija = new ArrayList<>();
		String line;
		String nazivProizvodjaca = new String();
		String tip = new String();
		Integer kapacitet;
		Integer brojModula;
		BigDecimal cijena;

		try (BufferedReader in = new BufferedReader(new FileReader("dat/radneMemorije.txt"))) {
			while ((line = in.readLine()) != null) {
				nazivProizvodjaca = line;
				tip = in.readLine();
				kapacitet = Integer.parseInt(in.readLine());
				brojModula = Integer.parseInt(in.readLine());
				cijena = new BigDecimal(in.readLine());
				RadnaMemorija radnaMemorija = new RadnaMemorija(nazivProizvodjaca, tip, kapacitet, brojModula, cijena);
				listaRadnihMemorija.add(radnaMemorija);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return listaRadnihMemorija;
	}
}
