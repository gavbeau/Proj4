/************************************************************************************************
* CLASS: DivOperator (DivOperator.java)
*
* DESCRIPTION
* Subclass of BinaryOperator
* Performs the division arithmetic operation 
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
 * Represents the division operator which is a specific type of binary operator.
 */
public class DivOperator extends BinaryOperator
{
   public DivOperator(){}

  //Returns the division of the left-hand side operand and the right-hand side operand.
   @Override
   public Operand evaluate(Operand pLhsOperand, Operand pRhsOperand)
   {
      return new Operand(pLhsOperand.getValue() / pRhsOperand.getValue());
   }
  //Returns the normal precedence level of this operator.
   @Override
   public int precedence() 
   {
      return 3;      
   }
  //Returns the precedence level of this operator when on it is on the operator stack.
   @Override
   public int stackPrecedence()
   {
      return 3;     
   }
}