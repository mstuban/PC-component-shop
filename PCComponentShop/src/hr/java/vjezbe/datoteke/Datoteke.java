package hr.java.vjezbe.datoteke;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import hr.java.vjezbe.entitet.Komponenta;
import hr.java.vjezbe.entitet.MaticnaPloca;
import hr.java.vjezbe.entitet.Procesor;
import hr.java.vjezbe.entitet.RadnaMemorija;
import hr.java.vjezbe.entitet.TvrdiDisk;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Datoteke {

	public static <T extends Komponenta> void spremiKomponentu(T komponenta) {
		if (komponenta instanceof MaticnaPloca) {
			try (BufferedWriter out = new BufferedWriter(new FileWriter("dat/maticnePloce.txt", true))) {
				out.newLine();
				out.write(komponenta.getNazivProizvodjaca());
				out.newLine();
				out.write(((MaticnaPloca) komponenta).getTip());
				out.newLine();
				out.write(((MaticnaPloca) komponenta).getTipSucelja());
				out.newLine();
				out.write(((MaticnaPloca) komponenta).getMaksimalanBrojMemorijskihModula().toString());
				out.newLine();
				out.write(komponenta.getCijena().toString());

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Uspješno spremanje");
				alert.setHeaderText("Uspješno spremanje podataka u datoteku");
				alert.setContentText("Podaci o novoj matičnoj ploči uspješno su spremljeni u datoteku!");
				alert.showAndWait();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (komponenta instanceof Procesor) {
			try (BufferedWriter out = new BufferedWriter(new FileWriter("dat/procesori.txt", true))) {
				out.newLine();
				out.write(komponenta.getNazivProizvodjaca());
				out.newLine();
				out.write(((Procesor) komponenta).getTipSucelja());
				out.newLine();
				out.write(((Procesor) komponenta).getBrzina().toString());
				out.newLine();
				out.write(komponenta.getCijena().toString());

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Uspješno spremanje");
				alert.setHeaderText("Uspješno spremanje podataka u datoteku");
				alert.setContentText("Podaci o novom procesoru uspješno su spremljeni u datoteku!");
				alert.showAndWait();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (komponenta instanceof RadnaMemorija) {

			try (BufferedWriter out = new BufferedWriter(new FileWriter("dat/radneMemorije.txt", true))) {
				out.newLine();
				out.write(komponenta.getNazivProizvodjaca());
				out.newLine();
				out.write(((RadnaMemorija) komponenta).getTip());
				out.newLine();
				out.write(((RadnaMemorija) komponenta).getKapacitet().toString());
				out.newLine();
				out.write(((RadnaMemorija) komponenta).getBrojModula().toString());
				out.newLine();
				out.write(komponenta.getCijena().toString());

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Uspješno spremanje");
				alert.setHeaderText("Uspješno spremanje podataka u datoteku");
				alert.setContentText("Podaci o novoj radnoj memoriji uspješno su spremljeni u datoteku!");
				alert.showAndWait();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (komponenta instanceof TvrdiDisk) {

			try (BufferedWriter out = new BufferedWriter(new FileWriter("dat/tvrdiDiskovi.txt", true))) {
				out.newLine();
				out.write(komponenta.getNazivProizvodjaca());
				out.newLine();
				out.write(((TvrdiDisk) komponenta).getTip());
				out.newLine();
				out.write(((TvrdiDisk) komponenta).getKapacitet().toString());
				out.newLine();
				out.write(komponenta.getCijena().toString());

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Uspješno spremanje");
				alert.setHeaderText("Uspješno spremanje podataka u datoteku");
				alert.setContentText("Podaci o novom tvrdom disku uspješno su spremljeni u datoteku!");
				alert.showAndWait();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
