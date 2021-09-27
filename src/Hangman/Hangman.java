package Hangman;

import MainClass.MainClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Hangman extends JDialog implements KeyListener {
    private JPanel contentPane;
    private JButton btnMain;
    private JButton btnPlayAgain;
    private JLabel lblGuess;
    private JLabel lblRightWrong;
    private JLabel lblHint;
    private JLabel lblLivesRemaining;
    private JLabel lblPicHangman;
    private JButton btnBack;

    char keyIn;
    int lives;
    static String[] words={"AIRCONDITIONER","TEAMS","MANGO","RAPUNZEL", "APPLE","OOP","CRISTIANORONALDO","KARACHI","CHAIR","YOUTUBE"};
    static String[] hints={"Artificial Air Breeze","Online Classes App","King of Fruits","Fairy Tale","Red and Green Fruit","Classes of Hierarchy","GOAT (Footballer)","City of Lights","Four Wooden Legs","World of Vidoes"};
    ImageIcon[] images = {new ImageIcon("res/Hangman5.jpg"), new ImageIcon("res/Hangman4.jpg"), new ImageIcon("res/Hangman3.jpg"), new ImageIcon("res/Hangman2.jpg"), new ImageIcon("res/Hangman1.jpg")};
    int indexOfWord=0;//for storing random numbr value
    String tempToBeGuessed;
    String str = "";

    ArrayList<Character> toBeGuessed = new ArrayList<Character>();//size not specified .it can be extended

    void random(){
        int min = 0;
        int max = 9;
        indexOfWord = (int)(Math.random()*(max-min+1)+min);
        setResizable(false);

    }
   void hintCalling()
   {
       lblHint.setText("Hint: "+hints[indexOfWord]);

   }



    void spacing ()
    {

        for(int i=0;i<words[indexOfWord].length();i++)
        {
//             toBeGuessed[i]= '?';
             toBeGuessed.add('?');



        }

        displayGuessedLetters();


    }

    void displayGuessedLetters(){
        tempToBeGuessed = toBeGuessed.toString()// charc array changed into string in order to display it on label
                .substring(1, 3*toBeGuessed.size()-1)
                .replaceAll(", ", " "); //to replace[?,?,?,?,?] with space and remove the brackets

        lblGuess.setText(tempToBeGuessed); //guess2 changed into string and stored in the label ???
    }

    public void keyPressed(KeyEvent e) {
//        System.out.println("keyPressed");
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){



           case KeyEvent.VK_A:
                 keyIn='A';
                 A(keyIn);

                break;
           case KeyEvent.VK_B:
                 keyIn='B';
               A(keyIn);
                break;
           case KeyEvent.VK_C:
                 keyIn='C';
               A(keyIn);
                 break;
           case KeyEvent.VK_D:
                 keyIn='D';
               A(keyIn);
                 break;

           case KeyEvent.VK_E:
                 keyIn='E';
               A(keyIn);
                 break;
           case KeyEvent.VK_F:
                 keyIn='F';
               A(keyIn);
                 break;
           case KeyEvent.VK_G:
                 keyIn='G';
               A(keyIn);
                 break;
           case KeyEvent.VK_H:
                 keyIn='H';
               A(keyIn);
                 break;
           case KeyEvent.VK_I:
                 keyIn='I';
               A(keyIn);
                 break;
           case KeyEvent.VK_J:
                 keyIn='J';
               A(keyIn);
                 break;
           case KeyEvent.VK_K:
                 keyIn='K';
               A(keyIn);
                 break;
           case KeyEvent.VK_L:
                 keyIn='L';
               A(keyIn);
                 break;
           case KeyEvent.VK_M:
                 keyIn='M';
               A(keyIn);
                 break;
           case KeyEvent.VK_N:
                 keyIn='N';
               A(keyIn);
                 break;
           case KeyEvent.VK_O:
                 keyIn='O';
               A(keyIn);
                 break;
           case KeyEvent.VK_P:
                 keyIn='P';
               A(keyIn);
                 break;
           case KeyEvent.VK_Q:
                 keyIn='Q';
               A(keyIn);
                 break;
           case KeyEvent.VK_R:
                 keyIn='R';
               A(keyIn);
                 break;
           case KeyEvent.VK_S:
                 keyIn='S';
               A(keyIn);
                 break;
           case KeyEvent.VK_T:
                 keyIn='T';
               A(keyIn);
                 break;
           case KeyEvent.VK_U:
                 keyIn='U';
               A(keyIn);
                 break;
           case KeyEvent.VK_V:
                 keyIn='V';
               A(keyIn);
                 break;
           case KeyEvent.VK_W:
                 keyIn='W';
               A(keyIn);
                 break;
           case KeyEvent.VK_X:
                 keyIn='X';
               A(keyIn);
                 break;
           case KeyEvent.VK_Y:
                 keyIn='Y';
               A(keyIn);
                 break;
           case KeyEvent.VK_Z:
                 keyIn='Z';
               A(keyIn);
                 break;
           

        }




    }
    public void keyTyped(KeyEvent e) {
//        System.out.println("keyTyped");
    }

    public Hangman() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnMain);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        setTitle("Hangman");




        lblPicHangman.setIcon(images[4]);

        lives = 5;


        newGame();
        spacing();
        hintCalling();
        lblLivesRemaining.setText("Remaining lives = "+lives);

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
        pack();
        setLocationRelativeTo(null);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainClass m1 = new MainClass();
                setVisible(false);
                m1.setVisible(true);
            }
        });
    }

    void showResults(boolean isWin)//variable for either wining or lsoing and then acccordingly it will display the compliment on screen whether he has won or lost
    {
        Results R1=new Results(isWin, words[indexOfWord]);//passing the value of isWin in the constructor of the next form result
        this.setVisible(false);//hangman form will be invisible
        R1.setVisible(true);//result form will be vR
    }
    private void A(char keyIn){

        boolean isValid=false; //checking answer is wrong or right
        char[] ch = words[indexOfWord].toCharArray(); //g is string array in which word to be guessed is stored
        for(int i=0; i<words[indexOfWord].length(); i++) //now changed into char we r checking chr by char
        {

            if (ch[i] == keyIn){ //the word entered by user is either same as the word to be guessed or not
                toBeGuessed.set(i, keyIn); //words guessed by user stored in char array guess2
                isValid= true;//??marks replaced with letters entered by user

            }


        }
        if(isValid==false)//check if wrong then display
        {
            lblRightWrong.setText("WRONG GUESS!");
            lblRightWrong.setForeground(Color.RED);
            lives--;


            lblLivesRemaining.setText("Remaining lives = "+lives);

        }
        else {
            lblRightWrong.setText("RIGHT GUESS!");
            lblRightWrong.setForeground(Color.GREEN);
        }

        displayGuessedLetters();


        String tempToBeGuessed2 = tempToBeGuessed.replaceAll(" ", "");//spaces removed from temptobeguessed so that it cann b easily compared with the original word


        if(tempToBeGuessed2.equals(words[indexOfWord]))//when equal
        {
            //it will set the value to the true when all the letters are being matched (when the )
            showResults(true);

        }
        if(lives==0) {
            showResults(false);//set value to false when user guesses the answers wrong and accordingly value to the next form will be passed
        }
        if (lives>0)
            lblPicHangman.setIcon(images[lives-1]);

        pack();

    }

    void newGame(){
        random();
    }



    private void onCancel() {
        // add your code here if necessary
        dispose();
    }


    public static void main(String[] args) {
        Hangman dialog = new Hangman();
        dialog.pack();
        dialog.setVisible(true);

    }
}
