package NumberGuessing;
import MainClass.MainClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Medium extends JDialog {
    private  int b;
    private  int rand;
    private  int score = 200;
    private  int attempts = 8;
    private JPanel contentPane;
    private JTextField textField1;
    private JButton btnguess;
    private JLabel lblleft;
    private JLabel lblsc;
    private JLabel lblvalid;
    private JLabel lblgame;
    private JLabel lblscore;
    private JLabel lblattemps;
    private JButton btnback;
    JFrame frame=new JFrame();
    public Medium() {
        setContentPane(contentPane);
        setTitle("Number guessing - Medium");
        pack();
        setLocationRelativeTo(null);
        setResizable(false);

        Rand();
        setModal(true);
        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.getText();
            }
        });
        btnguess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            if (test(textField1.getText())==true)
            {
                if(b>=1&&b<=100){
                    lblvalid.setText("");
                    Guess();
                }
                else{
                    lblvalid.setText("Enter your guess between 1 and 100");
                    lblvalid.setForeground(Color.RED);
                    pack();}
            }
            else {
                lblvalid.setText("Enter valid number.");
                lblvalid.setForeground(Color.RED);
                pack();
            }
            }
        });
        btnback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnback.getText().equals("Main Menu")){
                    MainClass m1 = new MainClass();
                    setVisible(false);
                    m1.setVisible(true);
                }
                else{
                    Level l=new Level();
                    setVisible(false);
                    l.setVisible(true);
                }

                pack();
            }
        });
    }
    private boolean test(String text) {
        try {
            b=Integer.parseInt(textField1.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private void Rand(){
        rand=(int)(Math.random()*99)+1;

    }
    void Guess() {
        lblsc.setText("Your score:");
        lblattemps.setText("Number of attempts left:");
       if (attempts>0){
            if (rand == b) {
                attempts--;
                lblsc.setText(Integer.toString(score));
                lblleft.setText(Integer.toString(attempts));
                JOptionPane.showMessageDialog(frame,"Congratulations,YOU WIN.","GAME END",JOptionPane.PLAIN_MESSAGE);
                lblvalid.setVisible(false);
                btnback.setText("Main Menu");
                setTitle("Score Card");
                btnguess.setVisible(false);
                textField1.setVisible(false);
                pack();

            } else {
                if (b>rand){
                    lblvalid.setText("TRY A LOWER NUMBER.");
                    lblvalid.setForeground(Color.RED);
                    pack();
                }
                else {
                    lblvalid.setText("TRY A HIGHER NUMBER.");
                    lblvalid.setForeground(Color.RED);
                    pack();
                }
                score = score - 25;
                attempts--;
                lblleft.setText(Integer.toString(attempts));
                lblsc.setText(Integer.toString(score));
            }
            if (b!=rand&&attempts==0){
                JOptionPane.showMessageDialog(frame,"Game over","You lose",JOptionPane.PLAIN_MESSAGE);
                lblvalid.setVisible(false);
                textField1.setVisible(false);
                btnguess.setVisible(false);
                btnback.setText("Main Menu");
                setTitle("Number guessing - Score Card");
                btnback.setVisible(true);
                pack();
            }
        }
  }
}