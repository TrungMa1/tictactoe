package com.example.tictactoever2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeModelTest {

    private TicTacToeModel model;

    @Before
    public void setupModel() {
        model = new TicTacToeModel();
    }

    @Test
    public void testVertical() {
        var board = model.getBoard();
        board[1] = 'X';
        board[4] = 'X';
        board[7] = 'X';
        model.declareWinner();
        assertTrue(model.isGameEnded());
        assertEquals("X", model.getWinner());
    }

    @Test
    public void testHorizontal() {
        var board = model.getBoard();
        board[3] = 'X';
        board[4] = 'X';
        board[5] = 'X';
        model.declareWinner();
        assertTrue(model.isGameEnded());
        assertEquals("X", model.getWinner());
    }

    @Test
    public void testDiagonal() {
        var board = model.getBoard();
        model.setCurrentPlayer('O');
        board[2] = 'O';
        board[4] = 'O';
        board[6] = 'O';
        model.declareWinner();
        assertTrue(model.isGameEnded());
        assertEquals("O", model.getWinner());
    }

    @Test
    public void testOtherDiagonal() {
        model.makeMove(2);
        model.makeMove(1);
        model.makeMove(4);
        model.makeMove(5);
        model.makeMove(6);
        assertTrue(model.isGameEnded());
        assertEquals("X", model.getWinner());
    }

    @Test
    public void testValidMovesX() {
        assertTrue(model.isValidMove(0));
        model.makeMove(0);
        assertEquals('X', model.getCurrentPlayer());
    }
}