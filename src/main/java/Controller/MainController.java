package Controller;

import Model.DefaultLogic.DefaultTheory;
import Model.DefaultLogic.Extension;
import Model.PropositionalLogic.Formula;
import Parser.FParser;
import Utility.Utility;
import View.NewAxiomView;
import View.NewDefaultView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Optional;

public class MainController {

    public void initialize() {
        Utility.mainController = this;
    }

    @FXML
    private TreeView<Extension> processTreeView;

    @FXML
    private ListView<String> axiomListView;
    @FXML
    private ListView<String> defaultListView;

    @FXML
    private void addAxiom() {
        new NewAxiomView();
    }

    @FXML
    private void addDefault() {
        new NewDefaultView();
    }

    @FXML
    private void recalculate() {
        Extension root = Utility.theory.buildProcessTree();
        TreeItem<Extension> viewRoot = buildTreeView(root,null);
        processTreeView.setRoot(viewRoot);
    }

    private TreeItem<Extension> buildTreeView(Extension extension, TreeItem<Extension> parent) {
        TreeItem<Extension> item = new TreeItem<Extension>(extension);

        for(Extension child : extension.getChildren()) {
            buildTreeView(child,item);
        }

        if (parent != null) {
            parent.getChildren().add(item);
        }

        return item;


    }

    public void addToAxiomList(String s) {
        axiomListView.getItems().add(s);
    }

    public void addToDefaultList(String s) {
        defaultListView.getItems().add(s);
    }

}