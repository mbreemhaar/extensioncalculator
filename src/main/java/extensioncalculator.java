import Model.DefaultLogic.DefaultTheory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class extensioncalculator extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("calcinterface.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Default Logic Extension Calculator");
        new DefaultTheory();
        primaryStage.show();
    }
}
