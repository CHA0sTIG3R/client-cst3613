package edu.cuny.citytech.cst.retirement;


import edu.cuny.citytech.cst.retirement.fxml.RetirementPieChartLogicFX;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.Date;

public class RetirementView extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        PieChart pieChart = new PieChart();
        TilePane tPane = new TilePane();
        Label labelStatus = new Label("Status");
        CheckBox checkBoxShowPercentage = new CheckBox("Show Percentage");

        RetirementPieChartLogicFX pc = new RetirementPieChartLogicFX(pieChart, tPane, labelStatus, checkBoxShowPercentage);
        primaryStage.setTitle("Retirements/Clients [Olowu,Hamza] " + new Date());

        tPane.setPadding(new Insets(0,0,10,0));
        tPane.setAlignment(Pos.CENTER);

        checkBoxShowPercentage.setOnAction(pc::clickEvent);

        Label labelTitle = new Label("Retirement");


        labelTitle.setFont(new Font("Arial",40));


        pieChart.setMinWidth(750);
        pieChart.setMinHeight(750);
        pieChart.setLegendVisible(true);
        pieChart.setLegendSide(Side.LEFT);

        pc.loadPieChart(e -> true);
       // loadCheckBoxes();

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(checkBoxShowPercentage);
        vbox.getChildren().add(labelTitle);
        vbox.getChildren().add(pieChart);
        vbox.getChildren().add(tPane);
        vbox.getChildren().add(labelStatus);

        pc.loadCheckBoxes(tPane);

        Scene scene = new Scene(vbox, 890, 890);

        primaryStage.setScene(scene);
        primaryStage.setHeight(955);
        primaryStage.setWidth(900);

        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}