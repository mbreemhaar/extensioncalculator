package Controller;

import Model.PropositionalLogic.Formula;
import Parser.FParser;
import Utility.Utility;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewAxiomController {

    @FXML
    private TextField textField;

    @FXML
    private Button cancelButton;

    @FXML
    private void add() {
        String s = textField.getText();
        Formula f = FParser.parse(s);

        if (f != null) {
            Utility.theory.add(f);
            this.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid formula");
            alert.setHeaderText(null);
            alert.setContentText("The formula you entered is invalid");

            alert.showAndWait();
        }
    }

    @FXML
    private void close() {
        Stage s = (Stage) cancelButton.getScene().getWindow();
        s.close();
    }

}
