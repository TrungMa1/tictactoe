package com.example.tictactoever2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import java.util.Arrays;
import java.util.List;

public class TicTacToeController {

    private static final TicTacToeModel model = new TicTacToeModel();

    @FXML
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9;
    @FXML
    private List<Button> buttons;
    @FXML
    private Button newRoundButton;
    @FXML
    private Button resetScoreButton;
    @FXML
    private Text playerXPointsText;
    @FXML
    private Text playerOPointsText;

    public void initialize() {
        buttons = Arrays.asList(
                button1, button2, button3,
                button4, button5, button6,
                button7, button8, button9
        );
    }

    @FXML
    private void newRoundButtonDo() {
        updateView();
        model.resetBoard();
        model.setCurrentPlayer('X');
        model.setGameEnded(false);
    }

    @FXML
    private void resetScoreButtonDo() {
        updateView();
        model.resetBoard();
        model.clearPoints();
        model.setCurrentPlayer('X');
        model.setGameEnded(false);
    }

    @FXML
    private void handleButtonClick(ActionEvent actionEvent) {
        Button clickedButton = (Button) actionEvent.getSource();
        int position = buttons.indexOf(clickedButton);

        if (model.isValidMove(position)) {
            model.makeMove(position);
            updateView();
        }
        if (!model.isGameEnded() && model.getCurrentPlayer() == 'O') {
            model.makeComputerMove();
            updateView();
        }
    }

    private void updateView() {
        for (int i = 0; i < model.getBoard().length; i++) {
            Button button = buttons.get(i);
            int cellValue = model.getBoard()[i];

            if (cellValue == 1) {
                button.setText("X");
            } else if (cellValue == 2) {
                button.setText("O");
            } else {
                button.setText("");
            }
            button.setDisable(model.isGameEnded() || cellValue != 0);
        }
        playerXPointsText.setText("Player X Points: " + model.getPlayerXPoints());
        playerOPointsText.setText("Player O Points: " + model.getPlayerOPoints());
    }
}