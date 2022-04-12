package edu.cuny.citytech.cst.retirement.examples;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Date;

public class BarChartExampleMain extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        String fileName = "/fxml/BarChartExampleView.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(fileName));
        Scene scene = new Scene(root);
        primaryStage.setTitle("BarChart [Olowu,Hamza] " + new Date());
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
}
