package MainClass;

import javax.swing.*;
import java.awt.event.*;

import Hangman.*;
import NumberGuessing.*;
import TicTacToe.*;

public class MainClass extends JDialog {
    private JPanel contentPane;
    private JButton btnNumberGuessing;
    private JButton btnHangman;
    private JButton btnExit;
    private JButton btnTicTacToe;
    private JLabel lblHeading;

    public MainClass() {

        setTitle("Main Menu");
        setContentPane(contentPane);
        setModal(true);


        pack();
        setLocationRelativeTo(null);
        setResizable(false);


        btnExit.addActionListener(e -> onCancel());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        btnTicTacToe.addActionListener(e -> {

            TicTacToe t1 = new TicTacToe();
            setVisible(false);
            t1.setVisible(true);

        });


        btnNumberGuessing.addActionListener(e -> {
            Level l1 = new Level();
            setVisible(false);
            l1.setVisible(true);
        });
        btnHangman.addActionListener(e -> {
            Hangman h1 = new Hangman();
            setVisible(false);
            h1.setVisible(true);
        });
    }



    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        MainClass dialog = new MainClass();

        dialog.pack();
        dialog.setVisible(true);


    }
}
