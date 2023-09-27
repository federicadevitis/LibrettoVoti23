
package it.polito.tdp.libretto;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import it.polito.tdp.libretto.model.Libretto;
import it.polito.tdp.libretto.model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

	private Libretto model;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ComboBox<Integer> cmbPunti;

	@FXML
	private DatePicker seldata;

	@FXML
	private TextField txtCorso;

	@FXML
	private TextArea txtResult;

	@FXML
	void handleInserisci(ActionEvent event) {
		String nomeCorso = txtCorso.getText();
		Integer punti = cmbPunti.getValue(); 
		LocalDate data = seldata.getValue();
		
		Voto voto = new Voto(nomeCorso, punti, data);
		this.model.aggiungiVoto(voto);
		
		txtResult.setText(this.model.toString());

	}

	public void setModel(Libretto model) {
		this.model = model;
	}

	@FXML
	void initialize() {
		assert cmbPunti != null : "fx:id=\"cmbPunti\" was not injected: check your FXML file 'main.fxml'.";
		assert seldata != null : "fx:id=\"seldata\" was not injected: check your FXML file 'main.fxml'.";
		assert txtCorso != null : "fx:id=\"txtCorso\" was not injected: check your FXML file 'main.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'main.fxml'.";

		for(int i=18; i<=30; i++) {
		cmbPunti.getItems().add(i);
		}
	}

}
