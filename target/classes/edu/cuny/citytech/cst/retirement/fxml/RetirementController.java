package edu.cuny.citytech.cst.retirement.fxml;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;

import java.net.URL;
import java.util.ResourceBundle;

public class RetirementController implements Initializable {

    @FXML
    private CheckBox checkBoxShowPercentage;

    @FXML
    private Label labelStatus;

    @FXML
    private Label labelTitle;

    @FXML
    private PieChart pieChart;

    @FXML
    private TilePane tPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        RetirementPieChartLogicFX guiLogic =
                new RetirementPieChartLogicFX(pieChart, tPane, labelStatus, checkBoxShowPercentage);

        checkBoxShowPercentage.setOnAction(guiLogic::clickEvent);
        guiLogic.loadPieChart(e -> true);
        guiLogic.loadCheckBoxes(tPane);
    }
}
