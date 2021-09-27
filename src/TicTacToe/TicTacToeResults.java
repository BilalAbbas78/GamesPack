package TicTacToe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import MainClass.*;


public class TicTacToeResults extends JDialog {
    private JPanel contentPane;
    private JButton btnResetScore;
    private JButton btnExit;
    private JButton btnPlayAgain;
    private JButton btnMainMenu;
    private JLabel lblPlayer1Wins;
    private JLabel lblPlayer2Wins;
    private JLabel lblWinner;

    public TicTacToeResults(String playerWon) {
        setContentPane(contentPane);
        setTitle("Results");
        setModal(true);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);


        displayWinner();
        displayWins();

        btnMainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenu();
            }
        });
        btnPlayAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playAgain();
            }
        });
        btnResetScore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetScore();
            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });
    }

    void displayWinner(){
        if (GlobalClassTicTacToe.winner.equals("circle"))
            lblWinner.setText("Player 1 Won");
        else if (GlobalClassTicTacToe.winner.equals("cross"))
            lblWinner.setText("Player 2 Won");
        else
            lblWinner.setText("Game Drawn");
    }

    void displayWins(){
        lblPlayer1Wins.setText(String.valueOf(GlobalClassTicTacToe.player1Wins));
        lblPlayer2Wins.setText(String.valueOf(GlobalClassTicTacToe.player2Wins));
        pack();
    }

    void resetScore(){
        GlobalClassTicTacToe.player1Wins = 0;
        GlobalClassTicTacToe.player2Wins = 0;
        lblPlayer1Wins.setText(String.valueOf(GlobalClassTicTacToe.player1Wins));
        lblPlayer2Wins.setText(String.valueOf(GlobalClassTicTacToe.player2Wins));
    }
    void playAgain(){
        TicTacToe Game = new TicTacToe();
        setVisible(false);
        Game.setVisible(true);
    }
    void exit(){
        System.exit(0);
    }
    void mainMenu(){
        MainClass Main = new MainClass();
        setVisible(false);
        Main.setVisible(true);
    }
}
