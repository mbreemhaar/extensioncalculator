package utility;

import controller.MainController;
import model.dlogic.DefaultTheory;
import javafx.scene.control.Alert;

public class Utility {
    public static DefaultTheory theory;
    public static MainController mainController;

    private Utility(){}

    public static void invalidFormulaAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid formula");
        alert.setHeaderText(null);
        alert.setContentText("The formula you entered is invalid");

        alert.showAndWait();
    }
}