package hr.java.vjezbe.javafx;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

import hr.java.vjezbe.baza.podataka.BazaPodataka;
import hr.java.vjezbe.entitet.TvrdiDisk;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class TvrdiDiskController implements Initializable {

	@FXML
	private TextField proizvodac;
	@FXML
	private TextField tip;
	@FXML
	private TextField kapacitet;
	@FXML
	private TextField cijena;
	@FXML
	private TextField brojOkretaja;
	boolean sveJeUneseno = true;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
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
			alert.setHeaderText("Tip");
			alert.setContentText("Obvezan podatak");
			alert.showAndWait();
			sveJeUneseno = false;
			return;
		}

		if (kapacitet.getText().equals("")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Pogreška kod unosa");
			alert.setHeaderText("Kapacitet");
			alert.setContentText("Obvezan podatak");
			alert.showAndWait();
			sveJeUneseno = false;
			return;
		}
		
		if (!kapacitet.getText().equals("")) {
			try {
				new BigDecimal(kapacitet.getText());
			} catch (NumberFormatException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Pogreška kod unosa");
				alert.setHeaderText("Kapacitet");
				alert.setContentText("Kapacitet mora biti tipa BigDecimal");
				alert.showAndWait();
				return;
			}
		}

		if (brojOkretaja.getText().equals("")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Pogreška kod unosa");
			alert.setHeaderText("Broj okretaja");
			alert.setContentText("Obvezan podatak");
			alert.showAndWait();
			sveJeUneseno = false;
			return;
		}
		

		if (!brojOkretaja.getText().equals("")) {
			try {
				new Integer(brojOkretaja.getText());
			} catch (NumberFormatException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Pogreška kod unosa");
				alert.setHeaderText("Broj okretaja");
				alert.setContentText("Broj okretaja mora biti tipa Integer");
				alert.showAndWait();
				return;
			}
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
				return;
			}
		}

		try {
			if (sveJeUneseno) {
				TvrdiDisk tvrdiDisk = new TvrdiDisk(proizvodac.getText(), tip.getText(),
						new BigDecimal(kapacitet.getText()), new Integer(brojOkretaja.getText()),
						new BigDecimal(cijena.getText()));
				
				try {
					BazaPodataka.spremiTvrdiDisk(tvrdiDisk);
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
