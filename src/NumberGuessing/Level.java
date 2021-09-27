package NumberGuessing;

import javax.swing.*;
import java.awt.event.*;
import MainClass.*;

public class Level extends JDialog {
    private JPanel contentPane;
    private JLabel lbllevel;
    private JButton btneasy;
    private JButton btnmedium;
    private JButton btnhard;
    private JPanel frmlevel;
    private JButton btnback;

    public Level() {
        setTitle("Number guessing - Level");
        setContentPane(contentPane);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);

        setModal(true);
   // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        btneasy.addActionListener(listener);
        btnmedium.addActionListener(listener);
        btnhard.addActionListener(listener);
        btnmedium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Medium m=new Medium();
                setVisible(false);
                m.setVisible(true);
            }
        });
        btnhard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            Hard h=new Hard();
            setVisible(false);
            h.setVisible(true);
            }
        });
        btneasy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Easy a=new Easy();
                setVisible(false);
                a.setVisible(true);
            }
        });
        btnback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainClass m=new MainClass();
                setVisible(false);
                m.setVisible(true);
            }
        });
    }
    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
