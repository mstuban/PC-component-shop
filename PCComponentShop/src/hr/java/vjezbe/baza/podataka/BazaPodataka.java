package hr.java.vjezbe.baza.podataka;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import hr.java.vjezbe.entitet.Komponenta;
import hr.java.vjezbe.entitet.MaticnaPloca;
import hr.java.vjezbe.entitet.Procesor;
import hr.java.vjezbe.entitet.RadnaMemorija;
import hr.java.vjezbe.entitet.TvrdiDisk;
import hr.java.vjezbe.javafx.PocetniEkranController;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class BazaPodataka {

	private static final String DATABASE_FILE = "dat/bazaPodataka.properties";

	private static Connection spajanjeNaBazuPodataka() throws SQLException, IOException {

		Properties svojstva = new Properties();
		svojstva.load(new FileReader(DATABASE_FILE));
		String urlBazePodataka = svojstva.getProperty("bazaPodatakaUrl");
		String korisnickoIme = svojstva.getProperty("korisnickoIme");
		String lozinka = svojstva.getProperty("lozinka");
		Connection veza = DriverManager.getConnection(urlBazePodataka, korisnickoIme, lozinka);
		return veza;
	}

	private static void zatvaranjeVezeNaBazuPodataka(Connection veza) throws SQLException {

		try {
			veza.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public static void spremiMaticnuPlocu(MaticnaPloca maticnaPloca) throws Exception {
		Connection veza = spajanjeNaBazuPodataka();
		veza.setAutoCommit(false);
		try {
			PreparedStatement insertMaticnaKomponenta = veza
					.prepareStatement("INSERT INTO RACUNALA.KOMPONENTA (NAZIV_PROIZVODJACA, CIJENA) VALUES (?, ?)");
			insertMaticnaKomponenta.setString(1, maticnaPloca.getNazivProizvodjaca());
			insertMaticnaKomponenta.setBigDecimal(2, maticnaPloca.getCijena());
			insertMaticnaKomponenta.executeUpdate();
			ResultSet generatedKeys = insertMaticnaKomponenta.getGeneratedKeys();
			if (generatedKeys.next()) {
				maticnaPloca.setId(generatedKeys.getInt(1));
			}

			PreparedStatement insertMaticnaPloca = veza.prepareStatement(
					"INSERT INTO RACUNALA.MATICNA_PLOCA (ID, TIP, TIP_SUCELJA, MAX_MEMORIJSKIH_MODULA) VALUES (?, ?, ?, ?)");
			insertMaticnaPloca.setInt(1, maticnaPloca.getId());
			insertMaticnaPloca.setString(2, maticnaPloca.getTip());
			insertMaticnaPloca.setString(3, maticnaPloca.getTipSucelja());
			insertMaticnaPloca.setInt(4, maticnaPloca.getMaksimalanBrojMemorijskihModula());
			insertMaticnaPloca.executeUpdate();
			veza.commit();

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Uspješno spremanje");
			alert.setHeaderText("Uspješno spremanje podataka u bazu podataka");
			alert.setContentText("Podaci o novoj matičnoj ploči uspješno su spremljeni u bazu podataka!");
			alert.showAndWait();

		} catch (Throwable ex) {
			veza.rollback();
			throw ex;
		}
		zatvaranjeVezeNaBazuPodataka(veza);
	}

	public static void spremiProcesor(Procesor procesor) throws Exception {
		Connection veza = spajanjeNaBazuPodataka();
		veza.setAutoCommit(false);
		try {
			PreparedStatement insertProcesorKomponenta = veza
					.prepareStatement("INSERT INTO RACUNALA.KOMPONENTA (NAZIV_PROIZVODJACA, CIJENA) VALUES (?, ?)");
			insertProcesorKomponenta.setString(1, procesor.getNazivProizvodjaca());
			insertProcesorKomponenta.setBigDecimal(2, procesor.getCijena());
			insertProcesorKomponenta.executeUpdate();
			ResultSet generatedKeys = insertProcesorKomponenta.getGeneratedKeys();
			if (generatedKeys.next()) {
				procesor.setId(generatedKeys.getInt(1));
			}
			PreparedStatement insertProcesor = veza.prepareStatement(
					"INSERT INTO RACUNALA.PROCESOR (ID, TIP, TIP_SUCELJA, BRZINA) VALUES (?, ?, ?, ?)");
			insertProcesor.setInt(1, procesor.getId());
			insertProcesor.setString(2, procesor.getTipSucelja());
			insertProcesor.setString(3, procesor.getTipSucelja());
			insertProcesor.setBigDecimal(4, procesor.getBrzina());
			insertProcesor.executeUpdate();
			veza.commit();

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Uspješno spremanje");
			alert.setHeaderText("Uspješno spremanje podataka u bazu podataka");
			alert.setContentText("Podaci o novom procesoru uspješno su spremljeni u bazu podataka!");
			alert.showAndWait();

		} catch (Throwable ex) {
			veza.rollback();
			throw ex;
		}
		zatvaranjeVezeNaBazuPodataka(veza);
	}

	public static void spremiRadnuMemoriju(RadnaMemorija radnaMemorija) throws Exception {
		Connection veza = spajanjeNaBazuPodataka();
		veza.setAutoCommit(false);
		try {
			PreparedStatement insertMemorijaKomponenta = veza
					.prepareStatement("INSERT INTO RACUNALA.KOMPONENTA (NAZIV_PROIZVODJACA, CIJENA) VALUES (?, ?)");
			insertMemorijaKomponenta.setString(1, radnaMemorija.getNazivProizvodjaca());
			insertMemorijaKomponenta.setBigDecimal(2, radnaMemorija.getCijena());
			insertMemorijaKomponenta.executeUpdate();
			ResultSet generatedKeys = insertMemorijaKomponenta.getGeneratedKeys();
			if (generatedKeys.next()) {
				radnaMemorija.setId(generatedKeys.getInt(1));
			}
			PreparedStatement insertRadnaMemorija = veza.prepareStatement(
					"INSERT INTO RACUNALA.RADNA_MEMORIJA (ID, TIP, KAPACITET, BROJ_MODULA) VALUES (?, ?, ?, ?)");
			insertRadnaMemorija.setInt(1, radnaMemorija.getId());
			insertRadnaMemorija.setString(2, radnaMemorija.getTip());
			insertRadnaMemorija.setInt(3, radnaMemorija.getKapacitet());
			insertRadnaMemorija.setInt(4, radnaMemorija.getBrojModula());
			insertRadnaMemorija.executeUpdate();
			veza.commit();

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Uspješno spremanje");
			alert.setHeaderText("Uspješno spremanje podataka u bazu podataka");
			alert.setContentText("Podaci o novoj radnoj memoriji uspješno su spremljeni u bazu podataka!");
			alert.showAndWait();
		} catch (Throwable ex) {
			veza.rollback();
			throw ex;
		}
		zatvaranjeVezeNaBazuPodataka(veza);
	}

	public static void spremiTvrdiDisk(TvrdiDisk tvrdiDisk) throws Exception {
		Connection veza = spajanjeNaBazuPodataka();
		veza.setAutoCommit(false);
		try {
			PreparedStatement insertTvrdiDiskKomponenta = veza
					.prepareStatement("INSERT INTO RACUNALA.KOMPONENTA (NAZIV_PROIZVODJACA, CIJENA) VALUES (?, ?)");
			insertTvrdiDiskKomponenta.setString(1, tvrdiDisk.getNazivProizvodjaca());
			insertTvrdiDiskKomponenta.setBigDecimal(2, tvrdiDisk.getCijena());
			insertTvrdiDiskKomponenta.executeUpdate();
			ResultSet generatedKeys = insertTvrdiDiskKomponenta.getGeneratedKeys();
			if (generatedKeys.next()) {
				tvrdiDisk.setId(generatedKeys.getInt(1));
			}
			PreparedStatement insertTvrdiDisk = veza.prepareStatement(
					"INSERT INTO RACUNALA.TVRDI_DISK (ID, TIP, KAPACITET, BROJ_OKRETAJA) VALUES (?, ?, ?, ?)");
			insertTvrdiDisk.setInt(1, tvrdiDisk.getId());
			insertTvrdiDisk.setString(2, tvrdiDisk.getTip());
			insertTvrdiDisk.setBigDecimal(3, tvrdiDisk.getKapacitet());
			insertTvrdiDisk.setInt(4, tvrdiDisk.getBrojOkretaja());
			insertTvrdiDisk.executeUpdate();
			veza.commit();

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Uspješno spremanje");
			alert.setHeaderText("Uspješno spremanje podataka u bazu podataka");
			alert.setContentText("Podaci o novom tvrdom disku uspješno su spremljeni u bazu podataka!");
			alert.showAndWait();

		} catch (Throwable ex) {
			veza.rollback();
			throw ex;
		}
		zatvaranjeVezeNaBazuPodataka(veza);
	}

	public static List<MaticnaPloca> dohvatiMaticnePloce() throws Exception {
		Connection veza = spajanjeNaBazuPodataka();
		Statement statementKomponenta = veza.createStatement();
		ResultSet resultSetKomponenta = statementKomponenta.executeQuery("SELECT * FROM RACUNALA.KOMPONENTA");
		PreparedStatement statementMaticnaPloca = veza
				.prepareStatement("SELECT * FROM RACUNALA.MATICNA_PLOCA WHERE ID = ?");
		List<MaticnaPloca> listaMaticnihPloca = new ArrayList<>();
		while (resultSetKomponenta.next()) {
			Integer id = resultSetKomponenta.getInt("ID");
			String nazivProizvodjaca = resultSetKomponenta.getString("NAZIV_PROIZVODJACA");
			BigDecimal cijena = resultSetKomponenta.getBigDecimal("CIJENA");
			statementMaticnaPloca.setInt(1, id);
			ResultSet resultSetMaticnaPloca = statementMaticnaPloca.executeQuery();
			while (resultSetMaticnaPloca.next()) {
				String tip = resultSetMaticnaPloca.getString("TIP");
				String tipSucelja = resultSetMaticnaPloca.getString("TIP_SUCELJA");
				Integer maxModula = resultSetMaticnaPloca.getInt("MAX_MEMORIJSKIH_MODULA");
				MaticnaPloca maticnaPloca = new MaticnaPloca(nazivProizvodjaca, tipSucelja, maxModula, cijena, tip);
				maticnaPloca.setId(id);
				listaMaticnihPloca.add(maticnaPloca);
			}
		}
		zatvaranjeVezeNaBazuPodataka(veza);
		return listaMaticnihPloca;
	}

	public static List<Procesor> dohvatiProcesore() throws Exception {
		Connection veza = spajanjeNaBazuPodataka();
		Statement statementKomponenta = veza.createStatement();
		ResultSet resultSetKomponenta = statementKomponenta.executeQuery("SELECT * FROM RACUNALA.KOMPONENTA");
		PreparedStatement statementProcesor = veza.prepareStatement("SELECT * FROM RACUNALA.PROCESOR WHERE ID = ?");
		List<Procesor> listaProcesora = new ArrayList<>();
		while (resultSetKomponenta.next()) {
			Integer id = resultSetKomponenta.getInt("ID");
			String nazivProizvodjaca = resultSetKomponenta.getString("NAZIV_PROIZVODJACA");
			BigDecimal cijena = resultSetKomponenta.getBigDecimal("CIJENA");
			statementProcesor.setInt(1, id);
			ResultSet resultSetProcesor = statementProcesor.executeQuery();
			while (resultSetProcesor.next()) {
				String tipSucelja = resultSetProcesor.getString("TIP_SUCELJA");
				BigDecimal brzina = resultSetProcesor.getBigDecimal("BRZINA");
				Procesor procesor = new Procesor(nazivProizvodjaca, tipSucelja, brzina, cijena);
				procesor.setId(id);
				listaProcesora.add(procesor);
			}
		}
		zatvaranjeVezeNaBazuPodataka(veza);
		return listaProcesora;
	}

	public static List<RadnaMemorija> dohvatiRadneMemorije() throws Exception {
		Connection veza = spajanjeNaBazuPodataka();
		Statement statementKomponenta = veza.createStatement();
		ResultSet resultSetKomponenta = statementKomponenta.executeQuery("SELECT * FROM RACUNALA.KOMPONENTA");
		PreparedStatement statementMemorija = veza
				.prepareStatement("SELECT * FROM RACUNALA.RADNA_MEMORIJA WHERE ID = ?");
		List<RadnaMemorija> listaMemorija = new ArrayList<>();
		while (resultSetKomponenta.next()) {
			Integer id = resultSetKomponenta.getInt("ID");
			String nazivProizvodjaca = resultSetKomponenta.getString("NAZIV_PROIZVODJACA");
			BigDecimal cijena = resultSetKomponenta.getBigDecimal("CIJENA");
			statementMemorija.setInt(1, id);
			ResultSet resultSetMemorija = statementMemorija.executeQuery();
			while (resultSetMemorija.next()) {
				String tipSucelja = resultSetMemorija.getString("TIP");
				Integer kapacitet = resultSetMemorija.getInt("KAPACITET");
				Integer brojModula = resultSetMemorija.getInt("BROJ_MODULA");
				RadnaMemorija radnaMemorija = new RadnaMemorija(nazivProizvodjaca, tipSucelja, kapacitet, brojModula,
						cijena);
				radnaMemorija.setId(id);
				listaMemorija.add(radnaMemorija);
			}
		}
		zatvaranjeVezeNaBazuPodataka(veza);
		return listaMemorija;
	}

	public static List<TvrdiDisk> dohvatiTvrdeDiskove() throws Exception {
		Connection veza = spajanjeNaBazuPodataka();
		Statement statementKomponenta = veza.createStatement();
		ResultSet resultSetKomponenta = statementKomponenta.executeQuery("SELECT * FROM RACUNALA.KOMPONENTA");
		PreparedStatement statementDisk = veza.prepareStatement("SELECT * FROM RACUNALA.TVRDI_DISK WHERE ID = ?");
		List<TvrdiDisk> listaDiskova = new ArrayList<>();
		while (resultSetKomponenta.next()) {
			Integer id = resultSetKomponenta.getInt("ID");
			String nazivProizvodjaca = resultSetKomponenta.getString("NAZIV_PROIZVODJACA");
			BigDecimal cijena = resultSetKomponenta.getBigDecimal("CIJENA");
			statementDisk.setInt(1, id);
			ResultSet resultSetDisk = statementDisk.executeQuery();
			while (resultSetDisk.next()) {
				String tipSucelja = resultSetDisk.getString("TIP");
				BigDecimal kapacitet = resultSetDisk.getBigDecimal("KAPACITET");
				Integer brojOkretaja = resultSetDisk.getInt("BROJ_OKRETAJA");
				TvrdiDisk tvrdiDisk = new TvrdiDisk(nazivProizvodjaca, tipSucelja, kapacitet, brojOkretaja, cijena);
				tvrdiDisk.setId(id);
				listaDiskova.add(tvrdiDisk);
			}
		}
		zatvaranjeVezeNaBazuPodataka(veza);
		return listaDiskova;
	}

	public static void spremiKonfiguraciju() throws SQLException, IOException {
		if (PocetniEkranController.postojiMaticna && PocetniEkranController.brojacDiskova > 0
				&& PocetniEkranController.brojacMemorija > 0 && PocetniEkranController.postojiProcesor) {

			Integer maticnaPlocaId = 0;
			Integer tvrdiDiskId = 0;
			Integer radnaMemorijaId = 0;
			Integer procesorId = 0;
			Integer brojModula = 0;

			(PocetniEkranController.brojRacunala)++;

			for (Komponenta komponenta : PocetniEkranController.desnaListaKomponenata) {

				if (komponenta instanceof MaticnaPloca) {
					maticnaPlocaId = komponenta.getId();
					brojModula = ((MaticnaPloca) komponenta).getMaksimalanBrojMemorijskihModula();
				}
				if (komponenta instanceof Procesor) {
					procesorId = komponenta.getId();
				}
				if (komponenta instanceof TvrdiDisk) {
					tvrdiDiskId = komponenta.getId();
				}
				if (komponenta instanceof RadnaMemorija) {
					radnaMemorijaId = komponenta.getId();
				}

			}

			Connection veza = spajanjeNaBazuPodataka();
			veza.setAutoCommit(false);

			PreparedStatement insertRacunalo;

			insertRacunalo = veza.prepareStatement(
					"INSERT INTO RACUNALA.RACUNALO (ID, MATICNA_PLOCA_ID, PROCESOR_ID, RADNA_MEMORIJA_ID, BROJ_MODULA_RADNE_MEMORIJE, TVRDI_DISK_ID) VALUES (?, ?, ?, ?, ?, ?)");

			insertRacunalo.setInt(1, PocetniEkranController.brojRacunala);
			insertRacunalo.setInt(2, maticnaPlocaId);
			insertRacunalo.setInt(3, procesorId);
			insertRacunalo.setInt(4, radnaMemorijaId);
			insertRacunalo.setInt(5, brojModula);
			insertRacunalo.setInt(6, tvrdiDiskId);
			insertRacunalo.executeUpdate();
			veza.commit();

			zatvaranjeVezeNaBazuPodataka(veza);

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Čestitamo!");
			alert.setHeaderText("Uspješno ste spremili konfiguraciju računala!");
			alert.showAndWait();

		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Pogreška");
			alert.setHeaderText("Morate prvo unijeti sve komponente!");
			alert.showAndWait();
		}
	}

	public static void obrisiKomponentu(Komponenta komponenta) throws IOException {

		try {
			Connection veza = spajanjeNaBazuPodataka();
			veza.setAutoCommit(false);
			try {
				String sql = null;
				if (komponenta instanceof MaticnaPloca)
					sql = "DELETE FROM RACUNALA.MATICNA_PLOCA WHERE ID = ?";
				if (komponenta instanceof Procesor)
					sql = "DELETE FROM RACUNALA.PROCESOR WHERE ID = ?";
				if (komponenta instanceof RadnaMemorija)
					sql = "DELETE FROM RACUNALA.RADNA_MEMORIJA WHERE ID = ?";
				if (komponenta instanceof TvrdiDisk)
					sql = "DELETE FROM RACUNALA.TVRDI_DISK WHERE ID = ?";

				PreparedStatement obrisiKomponentu1 = veza.prepareStatement(sql);
				obrisiKomponentu1.setInt(1, komponenta.getId());
				obrisiKomponentu1.executeUpdate();

				String query = "DELETE FROM RACUNALA.KOMPONENTA WHERE ID = ?";
				PreparedStatement obrisiKomponentu2 = veza.prepareStatement(query);
				obrisiKomponentu2.setInt(1, komponenta.getId());
				obrisiKomponentu2.executeUpdate();

				veza.commit();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
