package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NewAxiomView {
    public NewAxiomView() {
        Stage stage = new Stage();
        stage.setTitle("Add new axiom");
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/newaxiom.fxml"));
            stage.setScene(new Scene(root));

        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.show();
    }
}
