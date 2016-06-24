package hr.java.vjezbe.glavna;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import hr.java.vjezbe.entitet.Memorijska;
import hr.java.vjezbe.entitet.Racunalo;
import hr.java.vjezbe.entitet.SuceljeProcesora;
import hr.java.vjezbe.iznimke.NeispravanBrojMemorijskihModulaException;
import hr.java.vjezbe.iznimke.NekompatibilnoSuceljeZaProcesorException;
import hr.java.vjezbe.sort.NajmanjaBrzinaProcesora;
import hr.java.vjezbe.sort.NajmanjiKapacitetRadneMemorije;

/**
 * Predstavlja glavnu funkciju.
 * 
 * @author Marko
 *
 */
public class Glavna {

	/**
	 * Predstavlja main funkciju.
	 * 
	 * @param args
	 *            sadrži podatke o argumentima komandne linije
	 * @throws IOException 
	 * @throws URISyntaxException 
	 * @throws NekompatibilnoSuceljeZaProcesorException
	 * @throws NeispravanBrojMemorijskihModulaException
	 */
	public static void main(String[] args) throws IOException, URISyntaxException {

		
		//
		// List<MaticnaPloca> maticnePloce = new ArrayList<>();
		// List<Procesor> procesori = new ArrayList<>();
		// List<TvrdiDisk> tvrdiDiskovi = new ArrayList<>();
		// List<RadnaMemorija> radneMemorije = new ArrayList<>();
		//
		// maticnePloce = GlavnaDatoteke.ucitajMaticnePloce();
		// procesori = GlavnaDatoteke.ucitajProcesore();
		// tvrdiDiskovi = GlavnaDatoteke.ucitajTvrdeDiskove();
		// radneMemorije = GlavnaDatoteke.ucitajRadneMemorije();

		// for (MaticnaPloca maticnaPloca : maticnePloce) {
		// try {
		// BazaPodataka.spremiMaticnuPlocu(maticnaPloca);
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		//
		// for (Procesor procesor : procesori) {
		// try {
		// BazaPodataka.spremiProcesor(procesor);
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		//
		// for (RadnaMemorija radnaMemorija : radneMemorije) {
		// try {
		// BazaPodataka.spremiRadnuMemoriju(radnaMemorija);
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		//
		// for (TvrdiDisk tvrdiDisk : tvrdiDiskovi) {
		// try {
		// BazaPodataka.spremiTvrdiDisk(tvrdiDisk);
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }

		// Integer brojRacunala;
		// Integer brojMemorijskihModula;
		// System.out.println("Koliko konfiguracija računala želite unijeti?");
		// brojRacunala = unos.nextInt();
		// unos.nextLine();
		//
		// List<Racunalo> racunala = new ArrayList<>();s
		// MaticnaPloca maticnaPloca;
		// TvrdiDisk tvrdiDisk;
		// RadnaMemorija radnaMemorija;
		// Procesor procesor;
		//
		// int odabir = 1;
		// int odabirMaticnePloce = 1;
		// int odabirProcesora = 1;
		// for (int i = 0; i < brojRacunala; i++) {
		//
		// System.out.println("UNOS PODATAKA " + (i + 1) + ". RAČUNALA: ");
		//
		// do {
		// System.out.println("Odaberi matičnu ploču: ");
		// for (int j = 0; j < 3; j++) {
		// System.out.print(j + 1 + ". ");
		// System.out.println(maticnePloce.get(j).toString());
		// }
		// odabirMaticnePloce = unos.nextInt();
		// if (odabirMaticnePloce <= 0 || odabirMaticnePloce > 3)
		// System.out.println("Odabir mora biti od 1 do 3!");
		// } while (odabirMaticnePloce <= 0 || odabirMaticnePloce > 3);
		// maticnaPloca = maticnePloce.get(odabirMaticnePloce - 1);
		//
		// do {
		// System.out.println("Odaberi tvrdi disk: ");
		// for (int j = 0; j < 3; j++) {
		// System.out.print(j + 1 + ". ");
		// System.out.println(tvrdiDiskovi.get(j).toString());
		// }
		// odabir = unos.nextInt();
		// if (odabir <= 0 || odabir > 3)
		// System.out.println("Odabir mora biti od 1 do 3!");
		// } while (odabir <= 0 || odabir > 3);
		// tvrdiDisk = tvrdiDiskovi.get(odabir - 1);
		//
		// boolean provjera = false;
		// do {
		// do {
		// System.out.println("Odaberi procesor: ");
		// for (int j = 0; j < 3; j++) {
		// System.out.print(j + 1 + ". ");
		// System.out.println(procesori.get(j).toString());
		// }
		// odabirProcesora = unos.nextInt();
		// if (odabirProcesora <= 0 || odabirProcesora > 3)
		// System.out.println("Odabir mora biti od 1 do 3!");
		// } while (odabirProcesora <= 0 || odabirProcesora > 3);
		// procesor = procesori.get(odabirProcesora - 1);
		// try {
		// provjera =
		// provjeraKompatibilnostiSucelja(maticnaPloca.getTipSucelja(),
		// procesor.getTipSucelja());
		//
		// } catch (NekompatibilnoSuceljeZaProcesorException ex) {
		// System.out.println(ex.getMessage());
		// }
		// } while (provjera == false);
		//
		// do {
		// System.out.println("Odaberi radnu memoriju: ");
		// for (int j = 0; j < 3; j++) {
		// System.out.print(j + 1 + ". ");
		// System.out.println(radneMemorije.get(j).toString());
		// }
		// odabir = unos.nextInt();
		// if (odabir <= 0 || odabir > 3)
		// System.out.println("Odabir mora biti od 1 do 3!");
		// } while (odabir <= 0 || odabir > 3);
		// radnaMemorija = radneMemorije.get(odabir - 1);
		//
		// boolean provjeraModula = false;
		// do {
		// System.out.println("Upiši broj memorijskih modula: ");
		// brojMemorijskihModula = unos.nextInt();
		// try {
		// provjeraModula = provjeraKompatibilnostiModula(brojMemorijskihModula,
		// 4);
		// } catch (NeispravanBrojMemorijskihModulaException ex) {
		// System.out.println(ex.getMessage());
		// }
		// } while (provjeraModula == false);
		//
		// unos.nextLine();
		//
		// racunala.add(i, new Racunalo(maticnaPloca, procesor, radnaMemorija,
		// tvrdiDisk, brojMemorijskihModula));
		// }
		//
		// if (brojRacunala > 1) {
		// Racunalo najskupljeRacunalo =
		// racunala.stream().max(Comparator.comparing(Racunalo::izracunajCijenuRacunala))
		// .get();
		// Racunalo najJeftinijeRacunalo = racunala.stream()
		// .min(Comparator.comparing(Racunalo::izracunajCijenuRacunala)).get();
		//
		// System.out.println("Najskuplje računalo: ");
		// System.out.println(najskupljeRacunalo);
		// System.out.println("Cijena: " +
		// najskupljeRacunalo.izracunajCijenuRacunala() + " kn");
		//
		// try (PrintWriter out = new PrintWriter(new FileWriter(new
		// File("dat/najskuplja.txt")))) {
		//
		// out.println(najskupljeRacunalo);
		//
		// } catch (IOException e) {
		// System.err.println(e);
		// }
		//
		// System.out.println("Najjeftinije računalo: ");
		// System.out.println(najJeftinijeRacunalo);
		// System.out.println("Cijena: " +
		// najJeftinijeRacunalo.izracunajCijenuRacunala() + " kn");
		//
		// try (PrintWriter out = new PrintWriter(new FileWriter(new
		// File("dat/najjeftinija.txt")))) {
		//
		// out.println(najJeftinijeRacunalo);
		//
		// } catch (IOException e) {
		// System.err.println(e);
		// }
		//
		// }



	}

	/**
	 * Služi za ispis podataka o računalu.
	 * 
	 * @param racunalo
	 *            računalo čiji će se podaci ispisati
	 */
	public static void ispisPodataka(Racunalo racunalo) {

		System.out.println("Proizvođač matične ploče:");
		System.out.println(racunalo.getMaticnaPloca().getNazivProizvodjaca());
		System.out.println("Tip sučelja matične ploče");
		System.out.println(racunalo.getMaticnaPloca().getTipSucelja());
		System.out.println("Proizvođač procesora:");
		System.out.println(racunalo.getProcesor().getNazivProizvodjaca());
		System.out.println("Tip sučelja procesora:");
		System.out.println(racunalo.getProcesor().getTipSucelja());
		System.out.println("Brzina procesora:");
		System.out.println(racunalo.getProcesor().getBrzina() + " GHz");
		System.out.println("Proizvođač radne memorije:");
		System.out.println(racunalo.getRadnaMemorija().getNazivProizvodjaca());
		System.out.println("Tip radne memorije:");
		System.out.println(racunalo.getRadnaMemorija().getTip());

		BigDecimal bigD = new BigDecimal(racunalo.getRadnaMemorija().getKapacitet());

		System.out.println("Kapacitet radne memorije:");
		System.out.println(Memorijska.pretvoriUTB(bigD) + " TB");
		System.out.println("Broj modula radne memorije:");
		System.out.println(racunalo.getRadnaMemorija().getBrojModula());
		System.out.println("Maksimalan broj modula radne memorije");
		System.out.println(racunalo.getRadnaMemorija().getBrojModula());
		System.out.println("Proizvođač tvrdog diska:");
		System.out.println(racunalo.getTvrdiDisk().getNazivProizvodjaca());
		System.out.println("Tip tvrdog diska:");
		System.out.println(racunalo.getTvrdiDisk().getTip());
		System.out.println("Broj okretaja tvrdog diska:");
		System.out.println(racunalo.getTvrdiDisk().getBrojOkretaja());
		System.out.println("Kapacitet tvrdog diska:");
		System.out.println(racunalo.getTvrdiDisk().getKapacitet() + " TB");

		System.out.println("Cijena matične ploče:");
		System.out.println(racunalo.getMaticnaPloca().getCijena() + " kn");

		System.out.println("Cijena procesora:");
		System.out.println(racunalo.getProcesor().getCijena() + " kn");

		System.out.println("Cijena radne memorije:");
		System.out.println(racunalo.getRadnaMemorija().getCijena() + " kn");

		System.out.println("Cijena tvrdog diska:");
		System.out.println(racunalo.getTvrdiDisk().getCijena() + " kn");

		if (racunalo.getMaticnaPloca().brojPrikljucenihKomponenti() == 0) {
			System.out.println("Na matičnu nisu priključene komponente.");
		} else if (racunalo.getMaticnaPloca().brojPrikljucenihKomponenti() == 1) {
			System.out.println("Na matičnu ploču je priključena jedna komponenta.");
		} else {
			System.out.println("Na matičnu ploču je priključeno "
					+ racunalo.getMaticnaPloca().brojPrikljucenihKomponenti() + " komponente.");
		}

	}

	/**
	 * Unosi podatke o pojedinom računalu.
	 * 
	 * @param unos
	 *            tip podataka koji služi za unos podataka iz konzole(Scanner)
	 * @return računalo u koje su unešeni podaci
	 */
	// public static Racunalo unosPodataka(Scanner unos)
	// throws NekompatibilnoSuceljeZaProcesorException,
	// NeispravanBrojMemorijskihModulaException {
	//
	// String proizvodjacMaticnePloce;
	// String tipMaticnePloce;
	// String tipSuceljaMaticnePloce = null;
	// String proizvodjacProcesora;
	// String tipSuceljaProcesora = null;
	// BigDecimal brzinaProcesora;
	// String proizvodjacRadneMemorije;
	// String tipRadneMemorije;
	// Integer kapacitetRadneMemorije;
	// Integer brojModulaRadneMemorije;
	// String proizvodjacTvrdogDiska;
	// String tipTvrdogDiska;
	// BigDecimal kapacitetTvrdogDiska;
	// Integer brojOkretajaTvrdogDiska;
	// Integer maksimalanBrojMemorijskihModula;
	// BigDecimal cijenaMaticnePloce;
	// BigDecimal cijenaProcesora;
	// BigDecimal cijenaRadneMemorije;
	// BigDecimal cijenaTvrdogDiska;
	// Integer brojMemorijskihModula;
	//
	// Racunalo racunalo;
	// System.out.println("\nUnesite proizvođača matične ploče računala:\n");
	// proizvodjacMaticnePloce = unos.nextLine();
	//
	// System.out.println("Unesite tip matične ploče:\n");
	// tipMaticnePloce = unos.nextLine();
	// System.out.println("Unesite tip sučelja matične ploče računala(odaberite
	// broj ispred željenog sučelja):\n ");
	//
	// tipSuceljaMaticnePloce = unosTipaSucelja(tipSuceljaMaticnePloce, unos);
	//
	// System.out.println("Unesite proizvođača procesora računala:\n");
	// proizvodjacProcesora = unos.nextLine();
	//
	// System.out.println("Unesite tip sučelja procesora računala(odaberite broj
	// ispred željenog sučelja):\n ");
	//
	// tipSuceljaProcesora = unosTipaSucelja(tipSuceljaProcesora, unos);
	//
	// boolean vecSeIspisaloUpozorenje = false;
	// if (!tipSuceljaMaticnePloce.equals(tipSuceljaProcesora)) {
	// System.out.println("Unešena je neispravna konfiguracija.");
	// System.out.println("Sučelje matične ploče " + tipSuceljaMaticnePloce + "
	// nije jednako sučelju procesora "
	// + tipSuceljaProcesora + "!");
	// vecSeIspisaloUpozorenje = true;
	// }
	//
	// boolean nastaviPetlju = false;
	// do {
	// try {
	// nastaviPetlju = provjeraKompatibilnostiSucelja(tipSuceljaMaticnePloce,
	// tipSuceljaProcesora);
	// }
	//
	// finally {
	// if (!tipSuceljaMaticnePloce.equals(tipSuceljaProcesora) &&
	// !vecSeIspisaloUpozorenje) {
	// System.out.println("Unešena je neispravna konfiguracija.");
	// System.out.println("Sučelje matične ploče " + tipSuceljaMaticnePloce
	// + " nije jednako sučelju procesora " + tipSuceljaProcesora + "!");
	// }
	// }
	//
	// } while (nastaviPetlju == false);
	//
	// logger.info("Uspješno uneseno sučelje procesora i matične ploče.");
	//
	// do
	//
	// {
	// System.out.println("Unesite brzinu procesora računala (u GHz):");
	// brzinaProcesora = unos.nextBigDecimal();
	//
	// unos.nextLine();
	//
	// if (brzinaProcesora.compareTo(new BigDecimal(5.5)) > 0)
	// System.out.println("Prekoračili ste maksimalnu brzinu procesora!");
	//
	// } while (brzinaProcesora.compareTo(new BigDecimal(5.5)) > 0);
	//
	// logger.info("Uspješno unesena brzina procesora.");
	//
	// System.out.println("Unesite proizvođača radne memorije računala:\n");
	// proizvodjacRadneMemorije = unos.nextLine();
	//
	// System.out.println("Unesite tip radne memorije računala:\n");
	// tipRadneMemorije = unos.nextLine();
	//
	// System.out.println("Unesite maksimalan broj modula radne memorije:\n");
	// maksimalanBrojMemorijskihModula = unos.nextInt();
	//
	// System.out.println("Unesite broj modula radne memorije:\n");
	// brojModulaRadneMemorije = unos.nextInt();
	//
	// unos.nextLine();
	//
	// nastaviPetlju = false;
	//
	// do
	//
	// {
	// try {
	// nastaviPetlju = provjeraKompatibilnostiModula(brojModulaRadneMemorije,
	// maksimalanBrojMemorijskihModula);
	// } finally {
	// if (brojModulaRadneMemorije > maksimalanBrojMemorijskihModula) {
	// System.out.println("Unešena je neispravna konfiguracija.");
	// System.out.println("Broj modula radne memorije " +
	// brojModulaRadneMemorije
	// + " je veći od maksimalnog dopuštenog broja modula " +
	// maksimalanBrojMemorijskihModula
	// + "!");
	// }
	// }
	// } while (nastaviPetlju == false);
	//
	// logger.info("Uspješno unesen broj modula radne memorije.");
	//
	// do
	//
	// {
	// System.out.println("Unesite kapacitet radne memorije računala: (u
	// GB)\n");
	// kapacitetRadneMemorije = unos.nextInt();
	//
	// if (kapacitetRadneMemorije > 10240) {
	// System.out.println("Prekoračili ste maksimalan kapacitet radne
	// memorije!");
	// }
	//
	// } while (kapacitetRadneMemorije > 10240);
	//
	// logger.info("Uspješno unesen kapacitet radne memorije.");
	//
	// unos.nextLine();
	//
	// System.out.println("Unesite proizvođača tvrdog diska računala:\n");
	// proizvodjacTvrdogDiska = unos.nextLine();
	//
	// System.out.println("Unesite tip tvrdog diska računala:\n");
	// tipTvrdogDiska = unos.nextLine();
	//
	// System.out.println("Unesite broj okretaja tvrdog diska računala:\n");
	// brojOkretajaTvrdogDiska = unos.nextInt();
	//
	// try {
	// System.out.println("Unesite kapacitet tvrdog diska računala (u TB):\n");
	// kapacitetTvrdogDiska = unos.nextBigDecimal();
	// unos.nextLine();
	// } catch (RuntimeException ex) {
	// System.out.println(ex.getMessage());
	// System.out.println("Niste unjeli broj. Unesite ponovo!");
	// kapacitetTvrdogDiska = unos.nextBigDecimal();
	// }
	//
	// System.out.println("Unesite cijenu matične ploče:\n");
	// cijenaMaticnePloce = unos.nextBigDecimal();
	//
	// System.out.println("Unesite cijenu procesora:\n");
	// cijenaProcesora = unos.nextBigDecimal();
	//
	// System.out.println("Unesite cijenu radne memorije:\n");
	// cijenaRadneMemorije = unos.nextBigDecimal();
	//
	// System.out.println("Unesite cijenu tvrdog diska:\n");
	// cijenaTvrdogDiska = unos.nextBigDecimal();
	//
	// System.out.println("Unesi broj memorijskih modula računala: ");
	// brojMemorijskihModula = unos.nextInt();
	//
	// unos.nextLine();
	//
	// MaticnaPloca maticnaPloca = new MaticnaPloca(proizvodjacMaticnePloce,
	// tipSuceljaMaticnePloce,
	// maksimalanBrojMemorijskihModula, cijenaMaticnePloce, tipMaticnePloce);
	//
	// Procesor procesor = new Procesor(proizvodjacProcesora,
	// tipSuceljaProcesora, brzinaProcesora, cijenaProcesora);
	// maticnaPloca.prikljuci();
	//
	// RadnaMemorija radnaMemorija = new RadnaMemorija(proizvodjacRadneMemorije,
	// tipRadneMemorije,
	// kapacitetRadneMemorije, brojModulaRadneMemorije, cijenaRadneMemorije);
	// maticnaPloca.prikljuci();
	//
	// TvrdiDisk tvrdiDisk = new TvrdiDisk(proizvodjacTvrdogDiska,
	// tipTvrdogDiska, kapacitetTvrdogDiska,
	// brojOkretajaTvrdogDiska, cijenaTvrdogDiska);
	// maticnaPloca.prikljuci();
	//
	// //racunalo = new Racunalo(maticnaPloca, procesor, radnaMemorija,
	// tvrdiDisk, brojMemorijskihModula);
	//
	// logger.info(
	// "Uspješno je kreiran objekt racunalo. Dodane su mu komponente matična
	// ploča, procesor, radna memorija i tvrdi disk.");
	//
	// //return racunalo;
	//
	// }

	/**
	 * Služi za unos tipa sučelja matične ploče i procesora.
	 * 
	 * @param tipSucelja
	 *            podatak o tipu sučelja matične ploče ili procesora.
	 * @param unos
	 *            tip podataka koji služi za unos podataka iz konzole(Scanner)
	 * @return tip sučelja koji je odabran za pojedinu komponentu
	 */
	public static String unosTipaSucelja(String tipSucelja, Scanner unos) {
		String tip = new String();

		System.out.println("1) SOCKET_AM2");
		System.out.println("2) SOCKET_AM3");
		System.out.println("3) SOCKET_LGA_1151");
		System.out.println("4) SOCKET_G3");

		Integer odabir = unos.nextInt();

		do {
			switch (odabir) {
			case 1:
				tip = SuceljeProcesora.SUCELJE_1.getOpis();
				break;
			case 2:
				tip = SuceljeProcesora.SUCELJE_2.getOpis();
				break;
			case 3:
				tip = SuceljeProcesora.SUCELJE_3.getOpis();
				break;
			case 4:
				tip = SuceljeProcesora.SUCELJE_4.getOpis();
				break;

			default:
				System.out.println("Pogreška kod odabira, molimo pokušajte ponovno!");
				System.out.println("Unesite tip sučelja (odaberite broj ispred željenog sučelja): ");
				System.out.println("1) SOCKET_AM2");
				System.out.println("2) SOCKET_AM3");
				System.out.println("3) SOCKET_LGA_1151");
				System.out.println("4) SOCKET_G3");
				odabir = unos.nextInt();
				break;

			}
		} while (odabir <= 0 || odabir > 4);

		unos.nextLine();

		return tip;
	}

	/**
	 * Uspoređuje dva tipa sučelja matične ploče i procesora.
	 * 
	 * @param prviTipSucelja
	 *            prvi tip sučelja koji se treba usporediti
	 * @param drugiTipSucelja
	 *            drugi tip sučelja koji se treba usporediti
	 * @return true ili false ovisno o tome da li su sučelja jednaka ili ne
	 * @throws NekompatibilnoSuceljeZaProcesorException
	 *             baca iznimku u slučaju ako sučelja nisu jednaka
	 */
	public static boolean provjeraKompatibilnostiSucelja(String prviTipSucelja, String drugiTipSucelja)
			throws NekompatibilnoSuceljeZaProcesorException {
		if (!prviTipSucelja.equals(drugiTipSucelja)) {
			throw new NekompatibilnoSuceljeZaProcesorException("SUČELJA NISU KOMPATIBILNA!");
		}
		return prviTipSucelja.equals(drugiTipSucelja);
	}

	/**
	 * Uspoređuje da li broj modula radne memorije premašuje maksimalan broj
	 * modula radne memorije.
	 * 
	 * @param brojModulaRadneMemorije
	 *            podatak o broju modula radne memorije koji će se uspoređivati
	 * @param maksimalanBrojMemorijskihModula
	 *            podatak o maksimalnom broju memorijskih modula koji se ne
	 *            smije premašiti
	 * @return true ili false ovisno o tome da li broj modula radne memorije
	 *         prekoračuje maksimalan broj modula radne memorije
	 * @throws NeispravanBrojMemorijskihModulaException
	 *             baca iznimku u slučaju ako broj modula radne memorije
	 *             prekoračuje maksimalan broj modula radne memorije
	 */
	public static boolean provjeraKompatibilnostiModula(Integer brojModulaRadneMemorije,
			Integer maksimalanBrojMemorijskihModula) throws NeispravanBrojMemorijskihModulaException {
		if (brojModulaRadneMemorije > maksimalanBrojMemorijskihModula || brojModulaRadneMemorije <= 0) {
			throw (new NeispravanBrojMemorijskihModulaException("PREMAŠILI STE MAKSIMALAN BROJ MEMORIJSKIH MODULA!"));
		}
		return (brojModulaRadneMemorije <= maksimalanBrojMemorijskihModula && brojModulaRadneMemorije > 0);

	}

	/**
	 * Služi za ispis i sortiranje konfiguracija računala koristeći komparatore.
	 * Također povećava brzinu najmanjeg procesora za 50% i kapacitet najmanje
	 * radne memorije za dva puta.
	 * 
	 * @param racunala
	 *            lista računala koja će se ispisati i sortirati
	 */
	public static void sortIspisKonfiguracija(List<Racunalo> racunala) {

		List<BigDecimal> listaBrzina = new ArrayList<>();

		for (Racunalo racunalo : racunala) {
			listaBrzina.add(racunalo.getProcesor().getBrzina());
		}

		Collections.sort(racunala, new NajmanjaBrzinaProcesora());
		racunala.get(0).getProcesor()
				.setBrzina(racunala.get(0).getProcesor().overclock(racunala.get(0).getProcesor().getBrzina()));

		Collections.sort(racunala, new NajmanjiKapacitetRadneMemorije());
		racunala.get(0).getRadnaMemorija().uvecajKapacitet(2);

		for (Racunalo racunalo : racunala) {
			ispisPodataka(racunalo);
		}
	}

	/**
	 * Služi za ispis i sortiranje konfiguracija računala koristeći lambda
	 * funkcije. Također povećava brzinu najmanjeg procesora za 50% i kapacitet
	 * najmanje radne memorije za dva puta.
	 * 
	 * @param racunala
	 *            lista računala koja će se ispisati i sortirati
	 */
	public static void sortIspisKonfiguracijaLambda(List<Racunalo> racunala) {

		List<Racunalo> listaRacunala = racunala.stream().sorted(new NajmanjaBrzinaProcesora())
				.collect(Collectors.toList());

		Optional<List<Racunalo>> optionalList = Optional.of(listaRacunala);

		if (optionalList.isPresent())
			System.out.println("Lista računala je uspješnoo sortirana i popunjena.");
		else
			System.out.println("Lista računala nije sortirana.");

		listaRacunala.get(0).getProcesor().setBrzina(
				listaRacunala.get(0).getProcesor().overclock(listaRacunala.get(0).getProcesor().getBrzina()));

		Racunalo racunaloSNajmanjimKapacitetom = racunala.stream().min(new NajmanjiKapacitetRadneMemorije()).get();

		racunaloSNajmanjimKapacitetom.getRadnaMemorija().uvecajKapacitet(2);

		for (Racunalo racunalo : listaRacunala) {
			ispisPodataka(racunalo);
		}

	}

}
