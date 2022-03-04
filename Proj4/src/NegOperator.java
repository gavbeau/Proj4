/************************************************************************************************
* CLASS: NegOperator (NegOperator.java)
*
* DESCRIPTION
* Subclass of BinaryOperator
* Performs the subtraction arithmetic operation 
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
 * Represents the negation operator which is a specific type of unary operator.
 */
public class NegOperator extends UnaryOperator     
{
   public NegOperator(){}
  //Implements the negation operator.
  @Override
   public Operand evaluate(Operand pOperand)
   {return new Operand(-pOperand.getValue());}
  //Returns the normal precedence level of this operator.
  @Override
   public int precedence() {return 4;}
  //Returns the precedence level of this operator when on it is on the operator stack.
  @Override
   public int stackPrecedence() {return 4;}
}