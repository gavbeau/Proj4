/*
* CLASS: Expression (Expression.java)
*
* DESCRIPTION
* Evaluates the expression entered in the calculator. 
* Utilizes linked lists to evaluate the expressions.
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
 * Represents an infix expression to be evaluated.
 */
public class Expression 
{
  private Queue<Token> mTokenQueue;

    /**
     * Expression(String)
     *
     * pExprStr is a string representing an infix expression. This ctor uses the
     * Tokenizer class to break the string into Token objects which are stored in the token queue instance variable.
     * -- Read the first token
     * -- Keep reading tokens until tokenizer.nextToken() returns null.
     */
  public Expression (String pExprStr)
  {
    Queue<Token> q = new Queue<Token>();
    setTokenQueue(q);
      
    Tokenizer tokenizer = new Tokenizer(pExprStr);
    Token prevToken = null;
    Token token = tokenizer.nextToken();
    while (token != null)
    {
      if (token instanceof SubOperator)
      {
        token = negationCheck(token, prevToken);
      }
         
      getTokenQueue().enqueue(token);
      prevToken = token;
      token = tokenizer.nextToken();
    }
  }

    /**
     * Evaluates the expression and returns the result as a Double.
     */
  public Double evaluate(Expression pExpr)
  {
    Stack<Operator> operatorStack = new Stack<Operator>();
    Stack<Operand> operandStack = new Stack<Operand>();

    while (!getTokenQueue().isEmpty())
    {
      Token token = getTokenQueue().dequeue();
      
      if (token instanceof Operand)
      {
        Operand number = (Operand) token;
        operandStack.push(number);  
      }
      
      else if (token instanceof LeftParen)
      {
        LeftParen paren = (LeftParen) token;
        operatorStack.push(paren); 
      }
      
      else if (token instanceof RightParen)
      {
        while (!(operatorStack.peek() instanceof LeftParen))
        {
          topEval(operatorStack, operandStack);
        }
        operatorStack.pop();
      }
      
      else
      {
        Operator operator = (Operator) token;
        
        while (keepEvaluating(operatorStack, operator) == true)
        {
          topEval(operatorStack, operandStack);
        }
        operatorStack.push(operator);
      }
    }
    
    while (!operatorStack.isEmpty())
    {
      topEval(operatorStack, operandStack); 
    }
      return operandStack.pop().getValue();
  }
  

    /**
     * Accessor method for mTokenQueue.
     */
  protected Queue<Token> getTokenQueue() 
  {
    return mTokenQueue;
  }

    /**
     * Returns true when we need to pop the operator on top of the operator stack and evaluate it. If the stack
     * is empty, returns false since there is no operator to pop. Otherwise, return true if the operator on top
     * of the operator stack has stack precedence greater than or equal to the normal precedence of pOperator.
     */
    private boolean keepEvaluating(Stack<Operator> pOperatorStack, Operator pOperator) 
    {
        if (pOperatorStack.isEmpty()) { return false; } 
        
        else 
        {
            return pOperatorStack.peek().stackPrecedence() >= pOperator.precedence();
        }
    }

    /**
     * This method determines if pToken is really a negation operator rather than a subtraction operator, and if
     * so, will return a negation operator pToken. If pToken represents subtraction, then we simply return pToken.
     */
    private Token negationCheck(Token pToken, Token pPrevToken) {
        if (pPrevToken == null || pPrevToken instanceof BinaryOperator || pPrevToken instanceof LeftParen) {
            pToken = new NegOperator();
        }
        return pToken;
    }

    /**
     * Mutator method for mTokenQueue.
     */
    protected void setTokenQueue(Queue<Token> pTokenQueue) {
        mTokenQueue = pTokenQueue;
    }

    /**
     * Evaluates the "top" of the stack. If the top operator on the operator stack is a unary operator, we pop
     * one operand from the operand stack, evaluate the result, and push the result onto the operand stack. If
     * the top operator on the operator stack is a binary operator, we pop two operands from the operand stack,
     * evaluate the result of the operation, and push the result onto the operand stack.
     */

    private void topEval(Stack<Operator> pOperatorStack, Stack<Operand> pOperandStack)
    {
      Operand right = pOperandStack.pop();
      Operator operator = pOperatorStack.pop();
      if (operator instanceof NegOperator == true)
      {
        pOperandStack.push(((NegOperator) operator).evaluate(right));
      }
      else
      {
        Operand left = pOperandStack.pop();
        if (operator instanceof AddOperator)
        {
          pOperandStack.push(((AddOperator) operator).evaluate(left, right));
        }
        else if (operator instanceof SubOperator)
        {
          pOperandStack.push(((SubOperator) operator).evaluate(left, right));
        }
        else if (operator instanceof MultOperator)
        {
          pOperandStack.push(((MultOperator) operator).evaluate(left, right));
        }
        else
        {
          pOperandStack.push(((DivOperator) operator).evaluate(left, right));
        }
      }
    }
}
