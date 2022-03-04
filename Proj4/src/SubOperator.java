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
 * Represents the subtraction operator which is a specific type of binary operator.
 */
public class SubOperator extends BinaryOperator
{
  public SubOperator() {}

  @Override
  public Operand evaluate(Operand pLhsOperand, Operand pRhsOperand)
  {
    return new Operand(pLhsOperand.getValue() - pRhsOperand.getValue());
  }

  @Override
  public int precedence() { return 2; }

  @Override
  public int stackPrecedence() { return 2; }
}