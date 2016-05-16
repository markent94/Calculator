import java.util.*;

public class Calculator
{
    
    /**
    *Calculates a given Infix expression and returns the resultant outcome.
    *The infix expression is first converted to a postfix expression from which
    *it is placed into a stack to be calculated in the postfix method.
    *
    *@param expression The infix expression to be calculated.
    *@return The double value after calculations.
    */
    
    public static double calculate(String expression)
    {
        Stack<String> stack = new Stack<>();
        Converter toPostFix = new Converter();
        double right;
        double left;
        try
        {   
            String postfixString = toPostFix.convert(expression);  
            String[] tokens = postfixString.split(" ");   
            for (String nextToken : tokens)
            {
                String next = nextToken;
                if (!isNumeric(next))
                {
                    char operator = next.charAt(0);
                    right = Double.parseDouble(stack.pop().toString());
                    left = Double.parseDouble(stack.pop().toString());
                    if (operator == '+')
                    {
                        Double num = left + right;
                        stack.push(num.toString());
                    }
                    else if (operator == '-')
                    {
                        Double num = left - right;
                        stack.push(num.toString());
                    }
                    else if (operator == '*')
                    {
                        Double num = left * right;
                        stack.push(num.toString());
                    }
                    else if (operator == '/')
                    {
                        Double num = left / right;
                        stack.push(num.toString());
                    }
                }
                else
                {
                    stack.push(next);
                }
            }
        }
        catch (SyntaxErrorException see)
        {
            System.out.println("Input is incorrect");
            System.exit(0);
        }
        catch (Exception e)
        {
            System.out.println("Input is incorrect");
            System.exit(0);
        }
        return Double.parseDouble(stack.pop()); 
    }
    
    /**
    *Determines if the String value is numeric or not.
    *
    *@param str The String value needed to be checked.
    *@return True if the String is a number, else false.
    */
    
    public static boolean isNumeric(String str)  
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