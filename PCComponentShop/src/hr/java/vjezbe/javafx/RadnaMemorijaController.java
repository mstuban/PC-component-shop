package hr.java.vjezbe.javafx;

import java.math.BigDecimal;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import hr.java.vjezbe.baza.podataka.BazaPodataka;
import hr.java.vjezbe.entitet.RadnaMemorija;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class RadnaMemorijaController implements Initializable {

	@FXML
	private ComboBox<Integer> kapacitet;
	@FXML
	private ComboBox<Integer> brojModula;
	@FXML
	private TextField proizvodac;
	@FXML
	private TextField cijena;
	@FXML
	private TextField tip;
	boolean sveJeUneseno = true;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		kapacitet.getItems().addAll(Arrays.asList(1, 2, 4, 8));
		brojModula.getItems().addAll(Arrays.asList(1, 2, 3, 4));

	}

	@FXML
	public void provjera() {

		sveJeUneseno = true;

		if (proizvodac.getText().equals("")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Pogreška kod unosa");
			alert.setHeaderText("Proizvođač");
			alert.setContentText("Obvezan podatak");
			alert.showAndWait();
			sveJeUneseno = false;
			return;
		}

		if (tip.getText().equals("")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Pogreška kod unosa");
			alert.setHeaderText("Tip radne memorije");
			alert.setContentText("Obvezan podatak");
			alert.showAndWait();
			sveJeUneseno = false;
			return;
		}

		if (kapacitet.getSelectionModel().getSelectedIndex() == -1) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Pogreška kod unosa");
			alert.setHeaderText("Kapacitet");
			alert.setContentText("Obvezan podatak");
			alert.showAndWait();
			sveJeUneseno = false;
			return;
		}

		if (brojModula.getSelectionModel().getSelectedIndex() == -1) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Pogreška kod unosa");
			alert.setHeaderText("Broj modula");
			alert.setContentText("Obvezan podatak");
			alert.showAndWait();
			sveJeUneseno = false;
			return;
		}

		if (cijena.getText().equals("")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Pogreška kod unosa");
			alert.setHeaderText("Cijena");
			alert.setContentText("Obvezan podatak");
			alert.showAndWait();
			sveJeUneseno = false;
			return;
		}

		if (!cijena.getText().equals("")) {
			try {
				new BigDecimal(cijena.getText());
			} catch (NumberFormatException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Pogreška kod unosa");
				alert.setHeaderText("Cijena");
				alert.setContentText("Cijena mora biti tipa BigDecimal");
				alert.showAndWait();
			}
		}

		try {
			if (sveJeUneseno) {
				RadnaMemorija radnaMemorija = new RadnaMemorija(proizvodac.getText(), tip.getText(),
						kapacitet.getSelectionModel().getSelectedItem(),
						brojModula.getSelectionModel().getSelectedItem(), new BigDecimal(cijena.getText()));
				try {
					BazaPodataka.spremiRadnuMemoriju(radnaMemorija);
					PocetniEkranController.osvjeziListe();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (NumberFormatException e) {
			e.getMessage();
		}

	}

}
