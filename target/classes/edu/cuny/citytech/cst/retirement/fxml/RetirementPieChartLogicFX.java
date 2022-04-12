package edu.cuny.citytech.cst.retirement.fxml;

import edu.cuny.citytech.cst.retirement.model.Client;
import edu.cuny.citytech.cst.retirement.model.IPie;
import edu.cuny.citytech.cst.retirement.service.ClientService;
import javafx.event.ActionEvent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;


import static edu.cuny.citytech.cst.retirement.utility.StringUtility.*;

public class RetirementPieChartLogicFX {
    private PieChart pieChart = new PieChart();
    private TilePane tPane = new TilePane();
    private Label labelStatus = new Label("Status");
    private CheckBox checkBoxShowPercentage = new CheckBox("Show Percentage");

    public RetirementPieChartLogicFX(PieChart pieChart, TilePane tPane, Label labelStatus, CheckBox checkBoxShowPercentage) {
        this.pieChart = pieChart;
        this.tPane = tPane;
        this.labelStatus = labelStatus;
        this.checkBoxShowPercentage = checkBoxShowPercentage;
    }

    public static <T extends IPie> void loadPieChart(List<T> list,
                                                     PieChart pieChart,
                                                     Supplier<Boolean> supplier,
                                                     Consumer<String> consumer){


        float summary = 0;
        for (var model: list) {
            String text = model.getId();

            if (supplier.get())
                text += " - " + getPercentageFormat(model.getPercent());
            else
                text += " - " + getMoneyFormat(model.getValue());
            PieChart.Data slice1 = new PieChart.Data(text, model.getValue().floatValue());
            pieChart.getData().add(slice1);
            summary += model.getValue().floatValue();
        }

        consumer.accept("The number of clients: " + list.size()
                + " the total of all clients: " +getMoneyFormat(summary)
                + " 3% fee: " + getMoneyFormat(summary * .03)
        );
    }

    public void loadCheckBoxes(Pane pane){

        IntStream.rangeClosed(1,17)
                .mapToObj(e -> "s" + String.format("%02d",e))
                .map(m -> new CheckBox(m))
                .forEach(cBox -> {
                    cBox.setSelected(true);
                    cBox.setOnAction(this::clickEvent);
                    pane.getChildren().add(cBox);
                });

    }

    public void clickEvent(ActionEvent actionEvent) {
        pieChart.getData().clear();

        var checkBoxes = tPane.getChildren().stream()
                .map(e -> (CheckBox) e)
                .filter(w -> w.isSelected())
                .map(e -> e.getText())
                .toList();

        Predicate<Client> predicate = e -> false;
        int total = 0;
        for (String cBox: checkBoxes) {
            predicate = predicate.or(e -> e.getClientId().equals(cBox));
            total = total + 1 ;
        }

        loadPieChart(predicate);

    }

    public void loadPieChart(Predicate<Client> predicate){
        List<Client> clientList = new ClientService().getPercentage(predicate);

        RetirementPieChartLogicFX.loadPieChart(clientList, pieChart, checkBoxShowPercentage::isSelected,labelStatus::setText);
    }

}
