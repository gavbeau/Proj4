/************************************************************************************************
* CLASS: Operand (Operand.java)
*
* DESCRIPTION
* Subclass of Token
* Converts tokens to real number to be used in arithmetic operations. 
*
* COURSE AND PROJECT INFORMATION
* CSE205 Object Oriented Programming and Data Structures, 
* Spring Term A 2022
* Project Number: project-4 
*
* AUTHOR: Gavin Beaudry, gbeaudry, gbeaudry@asu.edu
* AUTHOR: Chavon Kattner, ckattner, ckattner@asu.edu
************************************************************************************************/

/**
 * An operand is a numeric value represented as a Double.
 */
public class Operand extends Token
{
  private Double mValue;

  public Operand(Double pValue) { mValue = pValue; }

  public Double getValue() { return mValue; }

  public void setValue(Double pValue) { mValue = pValue; }
}
