package edu.cuny.citytech.cst.retirement.counter;

import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class CounterLogic {
    public Label lblTitle;
    public FlowPane fpNum;
    public TextField txtInput;
    public AnchorPane apContain;
    public Button btnCount;
    public Label lblMessage;
    public ToggleGroup tgRadio;
    public Label lblField;

    public CounterLogic(Label lblTitle, FlowPane fpNum, TextField txtInput, AnchorPane apContain, Button btnCount, Label lblMessage, ToggleGroup tgRadio, Label lblField) {
        this.lblTitle = lblTitle;
        this.fpNum = fpNum;
        this.txtInput = txtInput;
        this.apContain = apContain;
        this.btnCount = btnCount;
        this.lblMessage = lblMessage;
        this.tgRadio = tgRadio;
        this.lblField = lblField;
    }

    public static void loadScene(IntConsumer consumer, String inp){
        if (inp.equals("ABC")) {
            IntStream.rangeClosed('A', 'Z').forEach(consumer);
            IntStream.rangeClosed('a', 'z').forEach(consumer);
        }else {
            IntStream.rangeClosed(0, Integer.parseInt(inp)).forEach(consumer);
        }
    }

    public void loadRadio(){
        tgRadio.selectedToggleProperty().addListener(e -> {
            Toggle rBtn = tgRadio.getSelectedToggle();
            if (rBtn.getUserData().equals("none")){
                txtInput.setText("200");
                fpNum.getChildren().forEach(ch ->{
                    var lbl = (Label) ch;
                    lbl.getStyleClass().removeAll("selected");
                });
            } else if (rBtn.getUserData().equals("even")){
                oddOrEven(true);
            }else if (rBtn.getUserData().equals("odd")){
                oddOrEven(false);
            }else if (rBtn.getUserData().equals("fifth")){
                radioMethod(5);
            }else if (rBtn.getUserData().equals("sevens")){
                radioMethod(7);
            }else if (rBtn.getUserData().equals("tens")){
                radioMethod(10);
            }else if (rBtn.getUserData().equals("teen")){
                radioMethod(13);
            } else if (rBtn.getUserData().equals("ABC")) {
                loadABC();
            }
        });
    }

    private void oddOrEven(boolean bool) {
        txtInput.setText("200");
        if (bool)
            fpNum.getChildren().forEach(ch ->{
                var lbl = (Label) ch;
                lbl.getStyleClass().removeAll("selected");
                if (Integer.parseInt(lbl.getText())%2 == 0){
                    lbl.getStyleClass().add("selected");
                }
            });
        else
            fpNum.getChildren().forEach(ch ->{
                var lbl = (Label) ch;
                lbl.getStyleClass().removeAll("selected");
                if (Integer.parseInt(lbl.getText())%2 != 0){
                    lbl.getStyleClass().add("selected");
                }
            });
    }

    private void radioMethod(int x){
        txtInput.setText("200");
        fpNum.getChildren().forEach(ch ->{
            var lbl = (Label) ch;
            lbl.getStyleClass().removeAll("selected");
            if (Integer.parseInt(lbl.getText())%x == 0){
                lbl.getStyleClass().add("selected");
            }
        });
    }

    public void loadABC(){
        txtInput.setText("ABC");
    }

    public void loadNumbers(){

        CounterLogic.loadScene(this::populate, txtInput.getText());

        txtInput.textProperty().addListener(e ->{
                btnCount.setText("Count to: "+ txtInput.getText());
                lblTitle.setText("Count "+ txtInput.getText());
        });
    }

    public void count(){
        if (txtInput.getText().equals("ABC")){
            fpNum.getChildren().clear();
            CounterLogic.loadScene(this::populateABC, txtInput.getText());
            lblMessage.getStyleClass().removeAll("message");
            lblMessage.setText("");
        } else if (Integer.parseInt(txtInput.getText()) > 250) {
            lblMessage.setText("Invalid Entry, number is greater than 250.");
            lblMessage.getStyleClass().add("message");
        }
        else if (Integer.parseInt(txtInput.getText()) < 0) {
            lblMessage.setText("Invalid Entry, number is lesser than 250." );
            lblMessage.getStyleClass().add("message");
        }else {
            fpNum.getChildren().clear();
            CounterLogic.loadScene(this::populate, txtInput.getText());
            lblMessage.getStyleClass().removeAll("message");
            lblMessage.setText("");
        }
    }

    private void populate(int i) {
        var label = new Label(Integer.toString(i));
        label.setUserData(i);
        label.getStyleClass().add("num");
        fpNum.getChildren().add(label);
    }

    private void populateABC(int i) {
        var label = new Label(Character.toString(i));
        label.setUserData(i);
        label.getStyleClass().add("abc");
        fpNum.getChildren().add(label);
    }

}
