package edu.cuny.citytech.cst.retirement.examples;

import edu.cuny.citytech.cst.retirement.service.RichClientService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class BarChartExampleController implements Initializable {

    @FXML
    private BarChart<String,Float> bar;

    @FXML
    private VBox root;

    @FXML
    private Label lblMessage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        //Configuring Series for XY chart
        XYChart.Series<String,Float> series = new XYChart.Series<>();

        var service = new RichClientService();
        var list = service.findAll();

        bar.setData(FXCollections.observableArrayList(series));

        var max = service.max();
        var min = service.min();
        for (var current: list) {
            var data = new XYChart.Data<String,Float>(current.getClientId(), current.getAmount());
            series.getData().add(data);
            data.getNode().setStyle("-fx-bar-fill: black;");

            if (max.getAmount() == current.getAmount()){
                data.getNode().setStyle("-fx-bar-fill: green;");
            }
            else if (current.getAmount() > service.getAverage()){
                data.getNode().setStyle("-fx-bar-fill: blue;");
            }
            else if (min.getAmount() == current.getAmount()){
                data.getNode().setStyle("-fx-bar-fill: red;");
            }

        }


        //Adding series to the barchart
        bar.setTitle("Barchart - (FXML) by Hamza Olowu");

        lblMessage.setText(service.max().toString());
    }
}
