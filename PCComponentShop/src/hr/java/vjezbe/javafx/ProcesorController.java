package hr.java.vjezbe.javafx;

import java.math.BigDecimal;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import hr.java.vjezbe.baza.podataka.BazaPodataka;
import hr.java.vjezbe.entitet.Procesor;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ProcesorController implements Initializable {

	@FXML
	private ComboBox<String> tipSucelja;
	@FXML
	private TextField proizvodac;
	@FXML
	private TextField brzina;
	@FXML
	private TextField cijena;
	private boolean sveJeUneseno = true;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		tipSucelja.getItems()
				.addAll(Arrays.asList("SOCKET_AM2", "SOCKET_AM3", "SOCKET_AM2", "SOCKET_LGA_1151", "SOCKET_G3"));

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

		if (tipSucelja.getSelectionModel().getSelectedIndex() == -1) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Pogreška kod unosa");
			alert.setHeaderText("Tip sučelja");
			alert.setContentText("Obvezan podatak");
			alert.showAndWait();
			sveJeUneseno = false;
			return;
		}

		if (brzina.getText().equals("")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Pogreška kod unosa");
			alert.setHeaderText("Brzina");
			alert.setContentText("Obvezan podatak");
			alert.showAndWait();
			sveJeUneseno = false;
			return;
		}

		if (!brzina.getText().equals("")) {
			try {
				new BigDecimal(brzina.getText());
			} catch (NumberFormatException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Pogreška kod unosa");
				alert.setHeaderText("Brzina");
				alert.setContentText("Podatak mora biti BigDecimal tipa");
				alert.showAndWait();
			}
		}

		if (cijena.getText().equals("")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Pogreška kod unosa");
			alert.setHeaderText("Cijena");
			alert.setContentText("Obvezan podatak");
			alert.showAndWait();
			sveJeUneseno = false;
		}

		if (!cijena.getText().equals("")) {
			try {
				new BigDecimal(cijena.getText());
			} catch (NumberFormatException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Pogreška kod unosa");
				alert.setHeaderText("Cijena");
				alert.setContentText("Podatak mora biti BigDecimal tipa");
				alert.showAndWait();
			}
		}

		try {
			if (sveJeUneseno) {
				Procesor procesor = new Procesor(proizvodac.getText(), tipSucelja.getSelectionModel().getSelectedItem(),
						new BigDecimal(brzina.getText()), new BigDecimal(cijena.getText()));
				try {
					BazaPodataka.spremiProcesor(procesor);
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
