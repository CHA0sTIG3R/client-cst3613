package edu.cuny.citytech.cst.retirement.utility;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public abstract class AbstractController implements Initializable {

    @FXML
    private Menu menuScene;

    @FXML
    private AnchorPane anchorPane;

    public void changeScene(String fileName)  {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fileName));
            Parent ReportManager = loader.load();
            Scene ReportManagerScene = new Scene(ReportManager);

            Stage window = (Stage)anchorPane.getScene().getWindow();

            window.setScene(ReportManagerScene);

            window.show();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MenuItem menuTicTacToe = new MenuItem("TicTacToe");
        MenuItem menuConnect4 = new MenuItem("Connect 4");
        MenuItem menuCounter = new MenuItem("Counter");


        menuCounter.setOnAction( (ActionEvent event) -> {
            changeScene("/fxml/CounterView.fxml");
        });


        menuTicTacToe.setOnAction( (ActionEvent event) -> {
            changeScene("/fxml/TicTacToeView.fxml");
        });

        menuConnect4.setOnAction( (ActionEvent event) -> {
            changeScene("/fxml/Connect4View.fxml");
        });

        menuScene.getItems().addAll(menuTicTacToe, menuConnect4, menuCounter);

        childInitialize(url, resourceBundle);
    }

    public abstract void childInitialize(URL url, ResourceBundle resourceBundle) ;
}