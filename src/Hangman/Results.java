package Hangman;

import MainClass.MainClass;

import javax.swing.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.awt.event.KeyAdapter;

public class Results extends JDialog {
    private JPanel contentPane;
    private JButton btnplayAgain;
    private JButton btnMainMenu3;
    private JPanel btnPlayAgain;
    private JLabel lblWinLoseDisplay;
    private JLabel lblCorrectWord;
    private JButton btnExit;


    boolean isWin;

    void playAgain() {

        Hangman playAgain=new Hangman();
        this.setVisible(false);
        playAgain.setVisible(true);



    }



    public Results(boolean isWin, String correctWord) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnplayAgain);
        setTitle("Hangman - Results");


        this.isWin = isWin;
        if (isWin == true)
            lblWinLoseDisplay.setText("You Won");
        else
            lblWinLoseDisplay.setText("You Lose");

        lblCorrectWord.setText("Correct word was "+ correctWord);

        pack();
        setResizable(false);
        setLocationRelativeTo(null);


        btnplayAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playAgain();
            }
        });
        btnMainMenu3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainClass m1 = new MainClass();
                setVisible(false);
                m1.setVisible(true);
            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

}
