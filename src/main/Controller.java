package main;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class Controller  {

    @FXML
    private Pane player1_next_block_pane;

    @FXML
    private Label player1_name_bottom;

    @FXML
    private Label player2_name_bottom;

    @FXML
    private Pane player1_field;

    @FXML
    private Pane player2_field;

    @FXML
    private Label timer;

    public Label getTimer() {
        return timer;
    }

    public Pane getPlayer1_field() {
        return player1_field;
    }

    public Pane getPlayer2_field() {
        return player2_field;
    }

    public Label getPlayer1_name_bottom() {
        return player1_name_bottom;
    }

    public Label getPlayer2_name_bottom() {
        return player2_name_bottom;
    }

    public Pane getPlayer1_next_block_pane() {
        return player1_next_block_pane;
    }
}
