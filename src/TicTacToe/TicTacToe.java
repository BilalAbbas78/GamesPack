package TicTacToe;

import MainClass.*;



import javax.swing.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class TicTacToe extends JDialog{
    private JPanel contentPane;
    private JButton btnMainMenu;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JLabel lblDescription;

    private boolean isCircleTurn;
    private int gameEnd;
    private ImageIcon circle = new ImageIcon("res/ticTacToeCircle.png");
    private ImageIcon cross = new ImageIcon("res/ticTacToeCross.png");

    public TicTacToe() {




        newGame();

        setTitle("Tic Tac Toe");
        setContentPane(contentPane);
        setModal(true);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);

        getRootPane().setDefaultButton(btnMainMenu);

        btnMainMenu.addActionListener(e -> showMainMenu());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        btn1.addActionListener(e -> {
            if (btn1.getIcon() != circle && btn1.getIcon() !=cross){
                if (isCircleTurn)
                    btn1.setIcon(circle);
                else
                    btn1.setIcon(cross);
                repeatedActions();
            }
        });
        btn2.addActionListener(e -> {
            if (btn2.getIcon() != circle && btn2.getIcon() !=cross){
                if (isCircleTurn)
                    btn2.setIcon(circle);
                else
                    btn2.setIcon(cross);
                repeatedActions();
            }
        });
        btn3.addActionListener(e -> {
            if (btn3.getIcon() != circle && btn3.getIcon() !=cross){
                if (isCircleTurn)
                    btn3.setIcon(circle);
                else
                    btn3.setIcon(cross);
                repeatedActions();
            }
        });
        btn4.addActionListener(e -> {
            if (btn4.getIcon() != circle && btn4.getIcon() !=cross){
                if (isCircleTurn)
                    btn4.setIcon(circle);
                else
                    btn4.setIcon(cross);
                repeatedActions();
            }
        });
        btn5.addActionListener(e -> {
            if (btn5.getIcon() != circle && btn5.getIcon() !=cross){
                if (isCircleTurn)
                    btn5.setIcon(circle);
                else
                    btn5.setIcon(cross);
                repeatedActions();
            }
        });
        btn6.addActionListener(e -> {
            if (btn6.getIcon() != circle && btn6.getIcon() !=cross){
                if (isCircleTurn)
                    btn6.setIcon(circle);
                else
                    btn6.setIcon(cross);
                repeatedActions();
            }
        });
        btn7.addActionListener(e -> {
            if (btn7.getIcon() != circle && btn7.getIcon() !=cross){
                if (isCircleTurn)
                    btn7.setIcon(circle);
                else
                    btn7.setIcon(cross);
                repeatedActions();
            }
        });
        btn8.addActionListener(e -> {
            if (btn8.getIcon() != circle && btn8.getIcon() !=cross){
                if (isCircleTurn)
                    btn8.setIcon(circle);
                else
                    btn8.setIcon(cross);
                repeatedActions();
            }
        });
        btn9.addActionListener(e -> {
            if (btn9.getIcon() != circle && btn9.getIcon() !=cross){
                if (isCircleTurn)
                    btn9.setIcon(circle);
                else
                    btn9.setIcon(cross);
                repeatedActions();
            }
        });
    }

    void newGame(){
        btn1.setIcon(null);
        btn2.setIcon(null);
        btn3.setIcon(null);
        btn4.setIcon(null);
        btn5.setIcon(null);
        btn6.setIcon(null);
        btn7.setIcon(null);
        btn8.setIcon(null);
        btn9.setIcon(null);

        lblDescription.setText("Player 1 turn");
        isCircleTurn = true;
        gameEnd = 0;
    }

    public void repeatedActions(){
        isCircleTurn = !isCircleTurn;
        lblDescription.setText("Player "+ (isCircleTurn ? 1 : 2) + " turn");

        gameEnd++;

        if (gameEnd == 9){
            lblDescription.setText("Game drawn");
            GlobalClassTicTacToe.winner = "Draw";
            showResults();
        }


        checkWin();

    }

    void checkWin() {
        if (isEqual(btn1, btn2, btn3)){
            announceWinner();
            disableButtons();
            blink(btn1, btn2, btn3);
            gameEnd();
        }
        else if (isEqual(btn4, btn5, btn6)){
            announceWinner();
            disableButtons();
            blink(btn4, btn5, btn6);
            gameEnd();
        }
        else if (isEqual(btn7, btn8, btn9)){
            announceWinner();
            disableButtons();
            blink(btn7, btn8, btn9);
            gameEnd();
        }
        else if (isEqual(btn1, btn4, btn7)){
            announceWinner();
            disableButtons();
            blink(btn1, btn4, btn7);
            gameEnd();
        }
        else if (isEqual(btn2, btn5, btn8)){
            announceWinner();
            disableButtons();
            blink(btn2, btn5, btn8);
            gameEnd();
        }
        else if (isEqual(btn3, btn6, btn9)){
            announceWinner();
            disableButtons();
            blink(btn3, btn6, btn9);
            gameEnd();
        }
        else if (isEqual(btn1, btn5, btn9)){
            announceWinner();
            disableButtons();
            blink(btn1, btn5, btn9);
            gameEnd();
        }
        else if (isEqual(btn3, btn5, btn7)){
            announceWinner();
            disableButtons();
            blink(btn3, btn5, btn7);
            gameEnd();
        }
    }

    void disableButtons(){
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);
        btnMainMenu.setEnabled(false);

    }

    void gameEnd() {
        TimerTask task = new TimerTask() {
            public void run() {
                btn1.setVisible(false);
                btn2.setVisible(false);
                btn3.setVisible(false);
                btn4.setVisible(false);
                btn5.setVisible(false);
                btn6.setVisible(false);
                btn7.setVisible(false);
                btn8.setVisible(false);
                btn9.setVisible(false);

                showResults();






            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 5000);



    }

    void showResults(){
        TicTacToeResults Results = new TicTacToeResults(lblDescription.getText());
        setVisible(false);
        Results.setVisible(true);
    }

    void announceWinner(){
        if (isCircleTurn){
            GlobalClassTicTacToe.winner = "cross";
            GlobalClassTicTacToe.player2Wins++;
            lblDescription.setText("Player 2 won");
        }
        else{
            GlobalClassTicTacToe.winner = "circle";
            GlobalClassTicTacToe.player1Wins++;
            lblDescription.setText("Player 1 won");
        }
    }

    void blink(JButton btnBlink1, JButton btnBlink2, JButton btnBlink3){
        TimerTask task1 = new TimerTask() {
            public void run() {
                btnBlink1.setEnabled(false);
                btnBlink2.setEnabled(false);
                btnBlink3.setEnabled(false);
            }
        };
        TimerTask task2 = new TimerTask() {
            public void run() {
                btnBlink1.setEnabled(true);
                btnBlink2.setEnabled(true);
                btnBlink3.setEnabled(true);
            }
        };
        Timer timer1 = new Timer("Timer");
        Timer timer2 = new Timer("Timer");


        timer1.scheduleAtFixedRate(task1, 100, 300);
        timer2.scheduleAtFixedRate(task2, 100, 300);
    }

    boolean isEqual(JButton a, JButton b, JButton c){
        return a.getIcon() == b.getIcon() && b.getIcon() == c.getIcon() && c.getIcon() != null;
    }



    void showMainMenu() {
        // add your code here
        MainClass Main = new MainClass();
        setVisible(false);
        Main.setVisible(true);


    }

    void onCancel() {
        // add your code here if necessary
        MainClass m1 = new MainClass();
        setVisible(false);
        m1.setVisible(true);
    }

    public static void main(String[] args) {
        TicTacToe dialog = new TicTacToe();
        dialog.pack();
        dialog.setVisible(true);


    }
}
