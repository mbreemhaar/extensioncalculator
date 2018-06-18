package Controller;

import Model.DefaultLogic.Default;
import Model.PropositionalLogic.Formula;
import Parser.FParser;
import Utility.Utility;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewDefaultController {
    @FXML
    private TextField prereqTextField;
    @FXML
    private TextField justTextField;
    @FXML
    private TextField consTextField;

    @FXML
    private Button cancelButton;

    @FXML
    private void add() {
        Formula prereq = FParser.parse(prereqTextField.getText());
        Formula just = FParser.parse(justTextField.getText());
        Formula cons = FParser.parse(consTextField.getText());

        if (prereq != null && prereq.isValid() && just != null && just.isValid() && cons != null && cons.isValid()) {
            Default d = new Default(prereq,just,cons);
            Utility.theory.add(d);
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
