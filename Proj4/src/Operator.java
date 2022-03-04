/************************************************************************************************
* CLASS: Operator (Operator.java)
*
* DESCRIPTION
* Subclass of Token
* Abstract superclass of unary and binary operators.  
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
 * Operator is the superclass of all binary and unary operators.
 */
public abstract class Operator extends Token
{
  public Operator() {}

  public abstract boolean isBinaryOperator();

  public abstract int precedence();

  public abstract int stackPrecedence();
}
