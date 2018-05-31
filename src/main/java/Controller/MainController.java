package Controller;

import Model.DefaultLogic.DefaultTheory;
import Model.PropositionalLogic.Formula;
import Parser.FParser;
import Utility.Utility;
import View.NewAxiomView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class MainController {

    public void initialize() {
        Utility.mainController = this;
    }

    @FXML
    private ListView<String> axiomListView;
    @FXML
    private ListView<String> defaultListView;

    @FXML
    private void addAxiom() {
        new NewAxiomView();
    }

    public void addToAxiomList(String s) {
        axiomListView.getItems().add(s);
    }

    public void addToDefaultList(String s) {
        defaultListView.getItems().add(s);
    }

}