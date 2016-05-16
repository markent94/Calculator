import java.util.*;

public class Converter
{
    /** The possible operators */
    private static final String OPERATORS = "+-*/";
    /** Precedence of operators */
    private static final int[] PRECEDENCE = {1, 1, 2, 2};
    /** The final postfix String of the expression */
    private StringBuilder postfix;
    /** Stack to place operators in order */
    private Stack<Character> operator;
    
    /**
    *Converts a given infix expression into an ordered
    *postfix expression.
    *
    *@param infix The infix expression to be converted.
    *@return String postfix expression.
    *@throws SyntaxErrorException.
    */
    
    public String convert(String infix) throws SyntaxErrorException
    {
        operator = new Stack<Character>();
        postfix = new StringBuilder();
        String[] tokens = infix.split(" ");
        try
        {
            for (String nextToken : tokens)
            {
                String next = nextToken;
                if (isNumeric(next))
                {
                    postfix.append(next);
                    postfix.append(' ');
                }
                else if(isOperator(next.charAt(0)))
                {
                    processOperator(next.charAt(0));
                }
                else
                {
                    throw new SyntaxErrorException("Unexpected Character Encountered: " + next);
                }
            }
            while (!operator.empty())
            {
                char op = operator.pop();
                postfix.append(op);
                postfix.append(' ');
            }
        }
        catch (EmptyStackException ese)
        {
            throw new SyntaxErrorException("The stack is empty");
        }
        return postfix.toString();
    }
    
    /**
    *Returns if the given character is a possible operator.
    *
    *@param ch The char value to be checked.
    *@return True if the character is an operator, else false.
    */
    
    private boolean isOperator(char ch)
    {
        return OPERATORS.indexOf(ch) != -1;
    }
    
    /**
    *Determines the precedence of an operator.
    *
    *@param op The operator.
    *@return The order of precedence.
    */
    
    private int precedence(char op)
    {
        return PRECEDENCE[OPERATORS.indexOf(op)];
    }
    
    /**
    *Places the operator in the given postfix postition.
    *
    *@param op The operator.
    */
    
    private void processOperator(char op)
    {
        if (operator.empty())
        {
            operator.push(op);
        }
        else
        {
            char topOp = operator.peek();
            if (precedence(op) > precedence(topOp))
            {
                operator.push(op);
            }
            else
            {
                while (!operator.empty() && precedence(op) <= precedence(topOp))
                {
                    operator.pop();
                    postfix.append(topOp);
                    postfix.append(' ');
                    if (!operator.empty())
                    {
                        topOp = operator.peek();
                    }
                }
                operator.push(op);
            }
        }
    }
    
    /**
    *Determines if a String is a numerical value.
    *
    *@param str The String containing an integer.
    *@return True if the String is a number, else false.
    */
    
    public boolean isNumeric(String str)  
    {  
        try  
        {  
          double d = Double.parseDouble(str);  
        }  
        catch(NumberFormatException nfe)  
        {  
          return false;  
        }  
        return true;  
    }
}
class SyntaxErrorException extends Exception
{
    
    /**
    *Initializes a SyntaxErrorException.
    *
    *param message Message output upon exception.
    */
    
    public SyntaxErrorException(String message)
    {
        super(message);
    }
}
                    
        