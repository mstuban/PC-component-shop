package hr.java.vjezbe.javafx;

import java.math.BigDecimal;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import hr.java.vjezbe.baza.podataka.BazaPodataka;
import hr.java.vjezbe.entitet.MaticnaPloca;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class MaticnaPlocaController implements Initializable {

	@FXML
	private ComboBox<String> tipSucelja;
	@FXML
	private ComboBox<Integer> maksimalanBrojModula;
	@FXML
	private TextField cijena;
	@FXML
	private TextField proizvodac;
	@FXML
	private TextField tipMaticnePloce;
	@FXML
	private MaticnaPloca maticnaPloca;
	private boolean sveJeUneseno = true;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tipSucelja.getItems().addAll(Arrays.asList("SOCKET_AM2", "SOCKET_AM3", "SOCKET_LGA_1151", "SOCKET_G3"));
		maksimalanBrojModula.getItems().addAll(1, 2, 3, 4);
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

		if (tipMaticnePloce.getText().equals("")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Pogreška kod unosa");
			alert.setHeaderText("Tip matične ploče");
			alert.setContentText("Obvezan podatak");
			alert.showAndWait();
			sveJeUneseno = false;
			return;
		}

		if (tipSucelja.getSelectionModel().getSelectedIndex() == -1) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Pogreška kod unosa");
			alert.setHeaderText("Tip sučelja na procesoru");
			alert.setContentText("Obvezan podatak");
			alert.showAndWait();
			sveJeUneseno = false;
			return;
		}

		if (maksimalanBrojModula.getSelectionModel().getSelectedIndex() == -1) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Pogreška kod unosa");
			alert.setHeaderText("Maksimalan broj modula");
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
				alert.setContentText("Podatak mora biti BigDecimal tipa");
				alert.showAndWait();
			}
		}

		try {
			if (sveJeUneseno) {
				MaticnaPloca maticnaPloca = new MaticnaPloca(proizvodac.getText(),
						tipSucelja.getSelectionModel().getSelectedItem(),
						maksimalanBrojModula.getSelectionModel().getSelectedItem(), new BigDecimal(cijena.getText()),
						tipMaticnePloce.getText());

				try {
					BazaPodataka.spremiMaticnuPlocu(maticnaPloca);
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
