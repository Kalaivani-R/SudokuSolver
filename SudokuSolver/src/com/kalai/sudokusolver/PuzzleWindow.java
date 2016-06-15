package com.kalai.sudokusolver;


import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Kalai
 */
public class PuzzleWindow {

    public PuzzleWindow(){
        //Initialization of the Window
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setLayout(new BorderLayout());
        window.setBounds(20, 20, 300, 300);
        window.setResizable(false);
    }

    public void addLabelPanel(){
        //Addition the Welcome and Difficulty Level Labels
        labelPanel.setLayout(new GridLayout(2,1,5,10));
        labelPanel.add(welcomeLabel);
        labelPanel.add(difficultyLabel);
        window.add(labelPanel,BorderLayout.NORTH);
    }
    
    public void addMatrixPanel()
    {
        //Addition of the Matrix Panel
        matrixPanel.setLayout(new GridLayout(PUZZLE_SIZE,PUZZLE_SIZE));
        GridBagConstraints c = new GridBagConstraints();
        for(int i=0;i<PUZZLE_SIZE;i++)
            for(int j=0;j<PUZZLE_SIZE;j++){
                submatrixPanel[i][j]= new JPanel();
                submatrixPanel[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                c.gridx = j;
                c.gridy = i;
                addSubMatrixPanel(i,j);
                matrixPanel.add(submatrixPanel[i][j],c);                             
           }
       window.add(matrixPanel,BorderLayout.CENTER);
    }

    public void addSubMatrixPanel(int a,int b){
        //Addition of the Sub Matrix Panel
        GridBagConstraints c = new GridBagConstraints();
        submatrixPanel[a][b].setLayout(new GridLayout(PUZZLE_SIZE,PUZZLE_SIZE));
        for(int i=0;i<PUZZLE_SIZE;i++){
            for(int j=0;j<PUZZLE_SIZE;j++)
            {
                textbox[i][j]= new JTextField(3);
                c.gridy = j;
                c.gridx = i;
                submatrixPanel[a][b].add(textbox[i][j],c);              
            }
         }
    }

    public void addButtonPanel(){
        //Addition of the Button Panel
        buttonPanel.setLayout(new GridLayout(1,2,75,5));
        buttonPanel.add(goButton);
        buttonPanel.add(resetButton);
        window.add(buttonPanel,BorderLayout.SOUTH);
    }

    public void launchApplication(){
        //Code to launch the Application
        addLabelPanel();
        addMatrixPanel();
        addButtonPanel();
    }

public JFrame window = new JFrame("SuDoKu Solver");

//Components in Label Panel
public JPanel labelPanel= new JPanel();
public JLabel welcomeLabel= new JLabel("Welcome!",SwingConstants.CENTER);
public JLabel difficultyLabel= new JLabel("Difficulty Level:",SwingConstants.CENTER);

//Components in Button Panel
public JPanel buttonPanel=new JPanel();
public JButton goButton=new JButton("Go!");
public JButton resetButton=new JButton("Reset");

//Components in Matrix Panel
public JPanel matrixPanel=new JPanel();
public JPanel submatrixPanel[][]=new JPanel[PUZZLE_SIZE][PUZZLE_SIZE];
public JTextField textbox[][]= new JTextField[PUZZLE_SIZE][PUZZLE_SIZE];

//Puzzle Size
public static final int PUZZLE_SIZE=2;
}
