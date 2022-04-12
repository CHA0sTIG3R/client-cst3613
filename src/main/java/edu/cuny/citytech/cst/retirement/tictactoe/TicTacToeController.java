package edu.cuny.citytech.cst.retirement.tictactoe;

import com.jbbwebsolutions.http.utility.JSONGet;
import edu.cuny.citytech.cst.retirement.model.TicTacToeResults;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

public class TicTacToeController {

    @FXML
    private FlowPane fpMoves;

    @FXML
    private Label lblMessage;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblURL;

    @FXML
    void reset(ActionEvent event) {
        fpMoves.getChildren().forEach(e ->{
            Label label = ((Label) e);
            label.setText("N");
            label.getStyleClass().remove("winner");
        });

        lblMessage.setText("");
        lblURL.setText("");
    }

    @FXML
    void xOrO(MouseEvent event) {
        var source = (Label) event.getSource();

        if (!source.getText().equals("N")){
            lblMessage.setText("Invalid move was made!");
            return;
        }

        var letter = isX ? "X" : "O";
        source.setText(letter);
        isX = !isX;

        String url = "http://localhost:9215/tictactoe?position=" + getMoves();

        var results = JSONGet.submitGet(url, TicTacToeResults.class);

        lblURL.setText(url + " " + results);

        if (results.isStatus()){
            int p1 = results.getP1();
            int p2 = results.getP2();
            int p3 = results.getP3();

            var moves =fpMoves.getChildren().stream().map(e -> e)
                    .toList();

            moves.get(p1).getStyleClass().add("winner");
            moves.get(p2).getStyleClass().add("winner");
            moves.get(p3).getStyleClass().add("winner");

        }
    }

    private String getMoves() {
        var moves = fpMoves.getChildren().stream()
                .map(e -> ((Label) e).getText()).toArray(String[]::new);
        return String.join("", moves);
    }

    private boolean isX = true;

}
