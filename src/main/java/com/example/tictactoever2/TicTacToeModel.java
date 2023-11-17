package com.example.tictactoever2;

import java.util.Random;

public class TicTacToeModel {

    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    private int[] board;
    private char currentPlayer;
    private String winner;
    private boolean gameEnded;
    private int playerXPoints;
    private int playerOPoints;

    public TicTacToeModel() {
        initializeBoard();
        currentPlayer = PLAYER_X;
        gameEnded = false;
    }

    private void initializeBoard() {
        board = new int[9];
        for (int i = 0; i < 9; i++) {
            board[i] = 0;
        }
    }

    private void switchPlayer() {
        if (currentPlayer == PLAYER_X) {
            currentPlayer = PLAYER_O;
        } else {
            currentPlayer = PLAYER_X;
        }
    }

    private void handleDraw() {
        System.out.println("It's a draw!");
        gameEnded = true;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 9; i++) {
            if (board[i] == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean checkWinner() {
        for (int i = 0; i < 9; i += 3) {
            if (board[i] != 0 && board[i] == board[i + 1] && board[i] == board[i + 2]) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[i] != 0 && board[i] == board[i + 3] && board[i] == board[i + 6]) {
                return true;
            }
        }
        if (board[0] != 0 && board[0] == board[4] && board[0] == board[8]) {
            return true;
        }
        return board[2] != 0 && board[2] == board[4] && board[2] == board[6];
    }

    public void declareWinner() {
        if (checkWinner()) {
            winner = String.valueOf(currentPlayer);
            System.out.println("Player " + currentPlayer + " wins!");
            givePoints();
            gameEnded = true;
        } else if (!isBoardFull()) {
            switchPlayer();
        } else {
            handleDraw();
        }
    }

    public boolean isValidMove(int position) {
        return position >= 0 && position < 9 && board[position] == 0 && !gameEnded;
    }

    public void makeMove(int position) {
        if (!gameEnded && isValidMove(position)) {
            board[position] = (currentPlayer == PLAYER_X) ? 1 : 2;
            declareWinner();
        }
    }

    public void makeComputerMove() {
        if (!gameEnded) {
            Random random = new Random();
            int position;
            do {
                position = random.nextInt(9);
            } while (board[position] != 0);
            makeMove(position);
        }
    }

    private void givePoints() {
        if (currentPlayer == 'X') {
            playerXPoints++;
        } else {
            playerOPoints++;
        }
    }

    public void clearPoints() {
        setPlayerXPoints(0);
        setPlayerOPoints(0);
    }

    public void resetBoard() {
        initializeBoard();
        gameEnded = false;
    }

    public void setPlayerOPoints(int playerOPoints) {
        this.playerOPoints = playerOPoints;
    }

    public String getPlayerXPoints() {
        return String.valueOf(playerXPoints);
    }

    public void setPlayerXPoints(int playerXPoints) {
        this.playerXPoints = playerXPoints;
    }

    public String getPlayerOPoints() {
        return String.valueOf(playerOPoints);
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isGameEnded() {
        return gameEnded;
    }

    public int[] getBoard() {
        return board;
    }

    public String getWinner() {
        return winner;
    }

    public void setCurrentPlayer(char currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setGameEnded(boolean gameEnded) {
        this.gameEnded = gameEnded;
    }
}