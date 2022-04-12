package edu.cuny.citytech.cst.retirement.tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Date;

public class TicTacToeMain extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        String fileName = "/fxml/TicTacToeView.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(fileName));
        Scene scene = new Scene(root);
        primaryStage.setTitle("TicTacToe | Olowu, Hamza " + new Date());
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
}
