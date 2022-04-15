package edu.cuny.citytech.cst.retirement.connect4;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.IntStream;

public class Connect4Controller implements Initializable {

    @FXML
    private FlowPane fpMoves;

    @FXML
    private Label lblURL;

    private boolean isX = true;

    private String getMoves() {
        var moves = fpMoves.getChildren().stream()
                .map(e -> ((Label) e).getText())
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
        label.setText(move);
        isX = !isX;

        lblURL.setText(getMoves());
    };

    public void reset(){
        fpMoves.getChildren().forEach(e -> {
            var label = (Label)e;
            label.setText("N");
        });
    }

    private void populate(int i) {
        var label = new Label("N" + i);
        label.getStyleClass().add("moves");
        label.setOnMouseClicked(clickedEvent);
        fpMoves.getChildren().add(label);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        IntStream.rangeClosed(0,41).forEach(this::populate);
    }
}
