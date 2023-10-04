/************************************************************************************************
* CLASS: View (View.java)
*
* DESCRIPTION
* Subclass of JFrame
* Implements ActionListener
* Implements the GUI
* Manages the display, input, and buttons 
*
* COURSE AND PROJECT INFORMATION
* CSE205 Object Oriented Programming and Data Structures, 
* Spring Term A 2022
* Project Number: project-4 
*
* AUTHOR: Gavin Beaudry, gbeaudry, gbeaudry@asu.edu
* AUTHOR: Chavon Kattner, ckattner, ckattner@asu.edu
************************************************************************************************/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class View extends JFrame implements ActionListener 
{

  //size of the GUI window
  public static final int FRAME_WIDTH  = 500;
  public static final int FRAME_HEIGHT = 180;

  /**
   * instance varriables
   * Buttons to clear, evaluate, or exit the program
   * JText field for input
   * JLabel for displaying results
  */
  private JButton         mClearButton;
  private JButton         mEvalButton;
  private JTextField      mInputText;
  private JButton         mExitButton;
  private Main            mMain;
  private JLabel          mResultLabel;

  //ctor takes a Main obj, makes the GUI visible
  public View(Main pMain) 
  {

    //saving reference of pVar to instance var
    mMain = pMain;

    //Results panel     
    JPanel panelLabel = new JPanel();
    mResultLabel = new JLabel("");
    panelLabel.add(mResultLabel);

    //input panel
    JPanel panelInput = new JPanel();
    mInputText = new JTextField(40);
    panelInput.add(mInputText);

    //Buttons: Clear, Evaluate, Exit
    JPanel panelButtons = new JPanel();
        
    mClearButton = new JButton("Clear");
    mClearButton.addActionListener(this);
    panelButtons.add(mClearButton);
        
    mEvalButton = new JButton("Evaluate");
    mEvalButton.addActionListener(this);
    panelButtons.add(mEvalButton);

    mExitButton = new JButton("Exit");
    mExitButton.addActionListener(this);  
    panelButtons.add(mExitButton);

    //Main panel, vertical box layout
    JPanel panelMain = new JPanel();
    panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
    panelMain.add(Box.createVerticalGlue());
    panelMain.add(panelLabel);
    panelMain.add(panelInput);
    panelMain.add(mClearButton);
    panelMain.add(mEvalButton);
    panelMain.add(mExitButton);

    setTitle("Kalkutron-9001");
    setSize(FRAME_WIDTH, FRAME_HEIGHT);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    add(panelMain);
    setVisible(true);
  }

  //Overridden action performed, calls private methods
  @Override
  public void actionPerformed(ActionEvent pEvent)
  {
    if (pEvent.getSource() == mClearButton) { clear(); }
    if (pEvent.getSource() == mEvalButton) { evaluate(); }
    if (pEvent.getSource() == mExitButton) { mMain.exit(); }
  }
    
  //Clear button sets InputText and ResultLabel to empty
  private void clear()
  {
    mInputText.setText("");
    mResultLabel.setText("");
  }

  /**evaluate takes input from InputText, 
  * converts to Expression obj
  * calls Expression.evaluate()
  * returns Double
  * sets ResultLabel to results
  */
  private void evaluate()
  {
    String in = mInputText.getText();
    Expression expr = new Expression(in);
    Double result = ((Expression) expr).evaluate(expr);
    mResultLabel.setText(result.toString()); 
  }

  
  public void messageBox(String pMessage) 
  {
    JOptionPane.showMessageDialog(this, pMessage, "Message", JOptionPane.PLAIN_MESSAGE);
  }
}//end View
