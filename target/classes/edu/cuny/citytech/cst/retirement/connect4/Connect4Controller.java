package edu.cuny.citytech.cst.retirement.connect4;

import edu.cuny.citytech.cst.retirement.model.Cell;
import edu.cuny.citytech.cst.retirement.service.GravityService;
import edu.cuny.citytech.cst.retirement.utility.AbstractController;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.IntStream;

public class Connect4Controller extends AbstractController {

    @FXML
    private FlowPane fpMoves;

    @FXML
    private Label lblURL;

    @FXML
    private ToggleGroup tgDisplayMode;

    private boolean isX = true;

    private Label labels[] = null;

    private String getMoves() {
        var moves = fpMoves.getChildren().stream()
                .map(e -> ((Cell) e.getUserData()).getValue())
                .toArray(String[]::new);
        return String.join("", moves);
    }

    private EventHandler<MouseEvent> clickedEvent = e -> {
        var label = (Label)e.getSource();

        boolean isCheating  = !label.getText().contains("N");

        if (isCheating){
            return;
        }

        String move = isX ? "X" : "O";

        var cells = fpMoves.getChildren().stream()
                .map(m -> (Cell)m.getUserData())
                .toArray(Cell[]::new);

        var currentPosition = ((Cell)((Label)e.getSource()).getUserData()).getPosition();
        var cell = new Cell(currentPosition, move, "?");

        var newCell = GravityService.getFreePosition(cell, cells);
        newCell.get().setValue(move);
        var freePosition = newCell.get().getPosition();
        var freeLabel = labels[freePosition];
        freeLabel.setText(move);
        freeLabel.getStyleClass().add("color-"+move);
        isX = !isX;

        var data = getMoves();
        lblURL.setText("data size: " + data.length() + " data: " + data);
    };

    public void reset(){
        fpMoves.getChildren().forEach(e -> {
            var label = (Label)e;
            Cell cell = (Cell) label.getUserData();
            cell.setValue("N");
            label.setText(cell.getDisplayValue());
            label.getStyleClass().removeAll("color-X","color-O");
        });

        lblURL.setText("");
    }

    private void populate(int i) {
        var label = new Label("N" + i);
        label.setUserData(new Cell(i));
        label.getStyleClass().add("moves");
        label.setOnMouseClicked(clickedEvent);
        fpMoves.getChildren().add(label);

    }


    @Override
    public void childInitialize(URL url, ResourceBundle resourceBundle) {
        IntStream.rangeClosed(0,41).forEach(this::populate);

        this.labels = fpMoves.getChildren().stream()
                .map(e -> (Label)e)
                .toArray(Label[]::new);

        tgDisplayMode.selectedToggleProperty().addListener(e -> {

            AnchorPane parent = (AnchorPane) fpMoves.getParent();

            Toggle rb = tgDisplayMode.getSelectedToggle();
            String whichCss = rb.getUserData().toString();
            var cssUrl = getClass().getResource("/css/" + whichCss)
                    .toExternalForm();

            parent.getStylesheets().clear();
            parent.getStylesheets().add(cssUrl);
        });

    }
}
