package hr.java.vjezbe.javafx;

import java.awt.Desktop;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import hr.java.vjezbe.baza.podataka.BazaPodataka;
import hr.java.vjezbe.entitet.Komponenta;
import hr.java.vjezbe.entitet.MaticnaPloca;
import hr.java.vjezbe.entitet.Procesor;
import hr.java.vjezbe.entitet.RadnaMemorija;
import hr.java.vjezbe.entitet.TvrdiDisk;
import hr.vjezbe.tecajnica.SpremiMaticnuPlocuNit;
import hr.vjezbe.tecajnica.Tecajnica;
import hr.vjezbe.tecajnica.TecajnicaNit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PocetniEkranController implements Initializable {

	@FXML
	public ListView<Komponenta> lijeviListView = new ListView<>();
	@FXML
	private ListView<Komponenta> desniListView = new ListView<>();
	@FXML
	public static ObservableList<Komponenta> lijeviPodaci = null;
	@FXML
	private ObservableList<Komponenta> desniPodaci;
	@FXML
	private Integer odabranoUListi;
	@FXML
	public static List<Komponenta> lijevaListaKomponenata = new ArrayList<>();
	@FXML
	public static List<Komponenta> desnaListaKomponenata = new ArrayList<>();
	@FXML
	private MaticnaPloca maticnaPloca;
	@FXML
	private Procesor procesor;
	@FXML
	public static boolean postojiMaticna;
	@FXML
	public static boolean postojiProcesor;
	@FXML
	public static Integer brojacMaticnih = 0;
	@FXML
	public static Integer brojacMemorija = 0;
	@FXML
	public static Integer brojacDiskova = 0;
	@FXML
	private boolean prekoracenaMemorija = false;
	@FXML
	private ComboBox<String> valute = new ComboBox<>();
	@FXML
	private TextField ukupnaCijena;
	@FXML
	private TextField ukupnaCijenauEurima;
	private BigDecimal ukupno = new BigDecimal(0);
	@FXML
	private Button tooltipGumb;
	final Tooltip tooltip = new Tooltip();
	public static Integer brojRacunala = 0;
	@FXML
	private DatePicker tecaj = new DatePicker();
	public static LocalDate datum;
	@FXML
	private Text oznakaValute = new Text();
	public static String valuta;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		List<MaticnaPloca> maticnePloce;
		try {
			maticnePloce = BazaPodataka.dohvatiMaticnePloce();
			lijevaListaKomponenata.addAll(maticnePloce);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<RadnaMemorija> radneMemorije;
		try {
			radneMemorije = BazaPodataka.dohvatiRadneMemorije();
			lijevaListaKomponenata.addAll(radneMemorije);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Procesor> procesori;
		try {
			procesori = BazaPodataka.dohvatiProcesore();
			lijevaListaKomponenata.addAll(procesori);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<TvrdiDisk> tvrdiDiskovi;
		try {
			tvrdiDiskovi = BazaPodataka.dohvatiTvrdeDiskove();
			lijevaListaKomponenata.addAll(tvrdiDiskovi);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lijeviPodaci = FXCollections.observableArrayList(lijevaListaKomponenata);
		lijeviListView.setItems(lijeviPodaci);

		tooltip.setText("Kliknite za dodavanje komponente");
		tooltipGumb.setTooltip(tooltip);

		valute.getItems().addAll(Arrays.asList("AUD", "CAD", "CZK", "DKK", "HUF", "JPY", "NOK", "SEK", "CHF", "GBP",
				"USD", "EUR", "PLN"));

	}

	@FXML
	public void obrisiKomponentu() {
		odabranoUListi = desniListView.getSelectionModel().getSelectedIndex();
		if (odabranoUListi == -1) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Pogreška");
			alert.setHeaderText("Niste odabrali komponentu!");
			alert.setContentText("Prvo morate odabrati komponentu koju želite izbrisati");
			alert.showAndWait();
		}
		Komponenta komponenta = desnaListaKomponenata.get(odabranoUListi);

		desnaListaKomponenata.remove(desnaListaKomponenata.get(odabranoUListi));

		desniPodaci = FXCollections.observableArrayList(desnaListaKomponenata);
		desniListView.setItems(desniPodaci);

		if (komponenta instanceof MaticnaPloca) {
			postojiMaticna = false;
		}
		if (komponenta instanceof RadnaMemorija) {
			brojacMemorija--;
		}
		if (komponenta instanceof Procesor) {
			postojiProcesor = false;
		}
		if (komponenta instanceof TvrdiDisk) {
			brojacDiskova--;
		}

		ukupno = ukupno.subtract(komponenta.getCijena());
		ukupnaCijena.setText(ukupno.toString());
		LocalDate datum = (LocalDate) tecaj.getValue();
		PocetniEkranController.datum = datum;
		BigDecimal djelitelj = null;
		valuta = valute.getSelectionModel().getSelectedItem();
		try {
			djelitelj = Tecajnica.dohvatiTecaj(valuta, datum);
		} catch (Throwable e) {
			System.out.println("Greška! Tečaj za taj datum ne postoji!");
		}
		ukupnaCijenauEurima.setText(ukupno.divide(djelitelj, 6, RoundingMode.HALF_UP).toString());

	}

	@FXML
	public void dodajKomponentu() {

		valuta = valute.getSelectionModel().getSelectedItem();
		oznakaValute.setText(valuta);
		LocalDate date = (LocalDate) tecaj.getValue();
		if (date == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Pogreška kod unosa");
			alert.setHeaderText("Datum tečaja");
			alert.setContentText("Obvezan podatak");
			alert.showAndWait();
			return;
		}

		if (valuta == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Pogreška kod unosa");
			alert.setHeaderText("Valuta");
			alert.setContentText("Morate odabrati valutu!");
			alert.showAndWait();
			return;
		}

		if (Tecajnica.dohvatiTecaj("EUR", date) == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Pogreška kod unosa");
			alert.setHeaderText("Datum tečaja");
			alert.setContentText("Za taj datum ne postoji tečaj!");
			alert.showAndWait();
			return;
		}

		odabranoUListi = lijeviListView.getSelectionModel().getSelectedIndex();
		if (odabranoUListi == -1) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Pogreška");
			alert.setHeaderText("Niste odabrali komponentu!");
			alert.setContentText("Prvo morate odabrati komponentu koju želite dodati");
			alert.showAndWait();
		}
		Komponenta komponenta = lijevaListaKomponenata.get(odabranoUListi);

		if (!postojiMaticna && komponenta instanceof MaticnaPloca) {
			brojacMaticnih++;
			maticnaPloca = (MaticnaPloca) komponenta;
			desnaListaKomponenata.add(komponenta);
			desniPodaci = FXCollections.observableArrayList(desnaListaKomponenata);
			desniListView.setItems(desniPodaci);
			postojiMaticna = true;
			ukupno = ukupno.add(komponenta.getCijena());
		} else if (postojiMaticna && komponenta instanceof MaticnaPloca) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Pogreška");
			alert.setHeaderText("Matična ploča već postoji");
			alert.setContentText("Već ste odabrali matičnu ploču za ovu konfiguraciju!");
			alert.showAndWait();
		} else {
			//
		}

		if (!postojiProcesor && komponenta instanceof Procesor) {
			procesor = (Procesor) komponenta;

			if (postojiMaticna && maticnaPloca.getTipSucelja().equals(procesor.getTipSucelja())) {
				desnaListaKomponenata.add(komponenta);
				desniPodaci = FXCollections.observableArrayList(desnaListaKomponenata);
				desniListView.setItems(desniPodaci);
				postojiProcesor = true;
				ukupno = ukupno.add(komponenta.getCijena());
			} else if (!postojiMaticna) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Pogreška");
				alert.setHeaderText("Ne postoji matična ploča");
				alert.setContentText("Za dodavanje procesora prvo dodajte matičnu ploču!");
				alert.showAndWait();
			} else if (postojiMaticna && !maticnaPloca.getTipSucelja().equals(procesor.getTipSucelja())) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Pogreška");
				alert.setHeaderText("Nekompatibilna sučelja!");
				alert.setContentText("Unesite procesor ponovo");
				alert.showAndWait();
			} else {
				//
			}

		} else if (postojiProcesor && komponenta instanceof Procesor) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Pogreška");
			alert.setHeaderText("Procesor već postoji");
			alert.setContentText("Već ste odabrali procesor za ovu konfiguraciju!");
			alert.showAndWait();
		}

		Integer brojModula = 0;
		for (Komponenta component : desnaListaKomponenata) {
			if (component instanceof RadnaMemorija) {
				brojModula += ((RadnaMemorija) component).getBrojModula();
			}
		}

		if ((komponenta instanceof RadnaMemorija) && postojiMaticna) {

			if ((brojModula + ((RadnaMemorija) komponenta).getBrojModula()) <= maticnaPloca
					.getMaksimalanBrojMemorijskihModula()) {
				desnaListaKomponenata.add(komponenta);
				desniPodaci = FXCollections.observableArrayList(desnaListaKomponenata);
				desniListView.setItems(desniPodaci);
				brojacMemorija++;
				ukupno = ukupno.add(komponenta.getCijena());
			} else {
				prekoracenaMemorija = true;
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Pogreška");
				alert.setHeaderText("Prekoračili ste količinu radne memorije");
				alert.setContentText("Ne možete dodati više memorije jer matična ploča to ne dozvoljava!");
				alert.showAndWait();
			}
		} else if ((komponenta instanceof RadnaMemorija) && !postojiMaticna) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Pogreška");
			alert.setHeaderText("Matična ploča ne postoji");
			alert.setContentText("Ne možete dodati radnu memoriju bez matične ploče!");
			alert.showAndWait();
		}

		if (komponenta instanceof TvrdiDisk) {
			desnaListaKomponenata.add(komponenta);
			desniPodaci = FXCollections.observableArrayList(desnaListaKomponenata);
			desniListView.setItems(desniPodaci);
			brojacDiskova++;
			ukupno = ukupno.add(komponenta.getCijena());
		}

		ukupnaCijena.setText(ukupno.toString());
		BigDecimal djelitelj = null;
		try {
			djelitelj = Tecajnica.dohvatiTecaj(valuta, date);
		} catch (Throwable e) {
			System.out.println("Greška! Tečaj za taj datum ne postoji!");
		}
		PocetniEkranController.datum = date;

		ukupnaCijenauEurima.setText(ukupno.divide(djelitelj, 6, RoundingMode.HALF_UP).toString());

		TecajnicaNit nit = new TecajnicaNit("tečaj ");

		ExecutorService executorService = Executors.newFixedThreadPool(1);
		executorService.execute(nit);

		executorService.shutdown();
	}

	@FXML
	public void spremiKonfiguraciju() {
		try {
			BazaPodataka.spremiKonfiguraciju();
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void postojeLiSveKomponente() {
		postojiMaticna = false;
		for (Komponenta component : desnaListaKomponenata) {
			if (component instanceof MaticnaPloca) {
				postojiMaticna = true;
			}
		}

		if (!prekoracenaMemorija) {
			for (Komponenta component : desnaListaKomponenata) {
				if (component instanceof RadnaMemorija) {
					brojacMemorija++;
				}

			}
		}

		postojiProcesor = false;
		for (Komponenta component : desnaListaKomponenata) {
			if (component instanceof Procesor) {
				postojiProcesor = true;
			}
		}

		for (Komponenta component : desnaListaKomponenata) {
			if (component instanceof TvrdiDisk) {
				brojacDiskova++;
			}
		}

	}

	@FXML
	public void prikaziEkranZaNovuMaticnuPlocu() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("MaticnaPloca.fxml"));
		Scene scene = new Scene((Parent) loader.load());
		Stage stage = new Stage();
		stage.setTitle("Unos nove matične ploče");
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void prikaziEkranZaNoviProcesor() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Procesor.fxml"));
		Scene scene = new Scene((Parent) loader.load());
		Stage stage = new Stage();
		stage.setTitle("Unos novog procesora");
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void prikaziEkranZaNovuMemoriju() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("RadnaMemorija.fxml"));
		Scene scene = new Scene((Parent) loader.load());
		Stage stage = new Stage();
		stage.setTitle("Unos nove radne memorije");
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void prikaziEkranZaNoviDisk() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("TvrdiDisk.fxml"));
		Scene scene = new Scene((Parent) loader.load());
		Stage stage = new Stage();
		stage.setTitle("Unos novog diska");
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void posaljiUpit() throws IOException, URISyntaxException {

		List<Komponenta> komponente = PocetniEkranController.desnaListaKomponenata;
		List<String> stringovi = new ArrayList<>();

		if (desnaListaKomponenata.isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Pogreška");
			alert.setHeaderText("Greška!");
			alert.setContentText("Ne možete poslati upit bez komponenata!");
			alert.showAndWait();
			return;
		}

		for (Komponenta komponenta : komponente) {
			stringovi.add(komponenta.toString());
		}

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Poštovani, da li su dostupne sljedeće komponente u Vašem webshopu?\n");
		for (String string : stringovi) {
			stringBuilder.append(string);
			stringBuilder.append(" ");
		}

		String uriStr = String.format("mailto:%s?subject=%s&body=%s", "info@hgshop.hr", "Upit",
				stringBuilder.toString());
		uriStr = uriStr.replaceAll("\\s+", "%20");
		System.out.println(uriStr);

		Desktop desktop;
		if (Desktop.isDesktopSupported() && (desktop = Desktop.getDesktop()).isSupported(Desktop.Action.MAIL)) {
			URI mailto = new URI(uriStr);
			desktop.mail(mailto);
		} else {
			throw new RuntimeException("desktop doesn't support mailto; mail is dead anyway ;)");
		}

	}

	@FXML
	public void spremiMaticnu() {
		SpremiMaticnuPlocuNit nit = new SpremiMaticnuPlocuNit();

		ExecutorService executorService = Executors.newFixedThreadPool(1);
		executorService.execute(nit);

		executorService.shutdown();
	}

	public static void osvjeziListe() throws Exception {
		lijevaListaKomponenata.clear();
		try {
			lijevaListaKomponenata.addAll(BazaPodataka.dohvatiMaticnePloce());
			lijevaListaKomponenata.addAll(BazaPodataka.dohvatiProcesore());
			lijevaListaKomponenata.addAll(BazaPodataka.dohvatiRadneMemorije());
			lijevaListaKomponenata.addAll(BazaPodataka.dohvatiTvrdeDiskove());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		List<Komponenta> novaLista = lijevaListaKomponenata;
		lijeviPodaci.clear();
		lijeviPodaci.addAll(novaLista);
	}

}
