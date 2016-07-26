package com.kalai.sudokusolver;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

public class Controller extends KeyAdapter implements ActionListener{
	 public void actionPerformed(ActionEvent ae)
	    {
		   if(ae.getActionCommand()=="Go!")
	       {
	    	   PuzzleWindow.goClicked();
	    	}
	       if(ae.getActionCommand()=="Reset")
	       {
	    	   PuzzleWindow.resetClicked();
	    	}
	    }
	 
	 	 
	 /** Handle the key typed event from the text field. */
	    public void keyTyped(KeyEvent e) {
	    	
	    	for (int i=0;i<PuzzleWindow.PUZZLE_SIZE*PuzzleWindow.PUZZLE_SIZE;i++)
	  		   for(int j=0;j<PuzzleWindow.PUZZLE_SIZE*PuzzleWindow.PUZZLE_SIZE;j++)
	  		   {
	  			 if(e.getSource().equals(PuzzleWindow.textbox[i][j]))
	  			 {
	  				if(((int)e.getKeyChar()<49 || (int)e.getKeyChar()>57) || (PuzzleWindow.textbox[i][j].getText().length()>=1))
	  				{
	  					PuzzleWindow.textbox[i][j].setBackground(Color.RED);
	  					PuzzleWindow.textbox[i][j].setText(null);
	  					break;
	  				 }
	  				else
	  				{
	  					PuzzleWindow.textbox[i][j].setBackground(Color.WHITE);
	  					break;
	  				}
	  			 }
	  		   }
	    	 }
	    
	   /* public void keyPressed(KeyEvent e){
	    	if(e.getSource().equals(KeyEvent.VK_BACK_SPACE))
	    	{
	    		System.out.println("H");
	    	}
	    }*/
    }
