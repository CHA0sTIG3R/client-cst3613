package edu.cuny.citytech.cst.retirement.fxml;

import edu.cuny.citytech.cst.retirement.service.ClientService;
import edu.cuny.citytech.cst.retirement.utility.NumberUtility;
import edu.cuny.citytech.cst.retirement.utility.StringUtility;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;

import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class RetirementControllerBarChart implements Initializable {

    @FXML
    private BarChart barChart;

    @FXML
    private Label labelStats;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        var dataList = new ClientService().getPercentage(e -> true);

        XYChart.Series clientSeries = new XYChart.Series();

        float max = 0;

        float maxPercent = 0;
        String maxId = "";
        for (var data: dataList) {
            clientSeries.getData().add(new XYChart.Data(data.getClientId(),data.getAmount()));

            if (data.getAmount() > max){
                max = data.getAmount();
                maxPercent = data.getPercentage();
                maxId = data.getClientId();
            }

        }


        barChart.getData().add(clientSeries);
        barChart.lookupAll(".default-color0.chart-bar")
                .forEach(e -> e.setStyle("-fx-bar-fill: black;"));
        barChart.lookup(".data"+NumberUtility.getMax(dataList)+".chart-bar").setStyle("-fx-bar-fill: green;");
        barChart.lookup(".data"+NumberUtility.getMin(dataList)+".chart-bar").setStyle("-fx-bar-fill: red;");

        labelStats.setText("The max client is: clientId="+maxId+", amount="+ StringUtility.getMoneyFormat(max) +", percentage="+StringUtility.getPercentageFormat(maxPercent));
    }



}