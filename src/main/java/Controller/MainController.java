package Controller;

import Model.DefaultLogic.Default;
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

        final String os = System.getProperty("os.name");
        if (os != null && os.startsWith("Mac"))
            menuBar.useSystemMenuBarProperty().set(true);

    }

    @FXML
    private MenuBar menuBar;

    @FXML
    private Label detailsLabel;
    @FXML
    private TreeView<Extension> processTreeView;

    @FXML
    private ListView<Formula> axiomListView;
    @FXML
    private ListView<Default> defaultListView;

    @FXML
    private void addAxiom() {
        new NewAxiomView();
    }

    @FXML private void removeAxiom() {
        axiomListView.getItems().remove(axiomListView.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void addDefault() {
        new NewDefaultView();
    }

    @FXML private void removeDefault() {
        defaultListView.getItems().remove(defaultListView.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void recalculate() {
        Extension root = Utility.theory.buildProcessTree();
        TreeItem<Extension> viewRoot = buildTreeView(root,null);
        processTreeView.setRoot(viewRoot);
        processTreeView.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> {
            if (newValue != null) {
                detailsLabel.setText(newValue.getValue().getDetailsString());
            } else {
                detailsLabel.setText("");
            }
        } );

    }

    @FXML
    private void clear() {
        axiomListView.getItems().clear();
        defaultListView.getItems().clear();
        this.recalculate();
    }

    private TreeItem<Extension> buildTreeView(Extension extension, TreeItem<Extension> parent) {
        TreeItem<Extension> item = new TreeItem<Extension>(extension);
        item.setExpanded(true);

        for(Extension child : extension.getChildren()) {
            buildTreeView(child,item);
        }

        if (parent != null) {
            parent.getChildren().add(item);
        }

        return item;


    }

    public ObservableList<Formula> getAxiomList() {
        return axiomListView.getItems();
    }

    public ObservableList<Default> getDefaultList() {
        return defaultListView.getItems();
    }

}