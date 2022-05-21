package edu.cuny.citytech.cst.retirement.counter;

import edu.cuny.citytech.cst.retirement.utility.AbstractController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ResourceBundle;

public class CounterController extends AbstractController {
    public Label lblTitle;
    public FlowPane fpNum;
    public TextField txtInput;
    public AnchorPane apContain;
    public Button btnCount;
    public Label lblMessage;
    public ToggleGroup tgRadio;
    public Label lblField;


    @Override
    public void childInitialize(URL url, ResourceBundle resourceBundle) {

        CounterLogic guiLogic = new CounterLogic(lblTitle, fpNum, txtInput, apContain, btnCount, lblMessage, tgRadio, lblField);
        guiLogic.loadNumbers();
        btnCount.setText("Count to: "+ txtInput.getText());
        btnCount.setOnAction(t -> guiLogic.count());
        guiLogic.loadRadio();

    }
}
