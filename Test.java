import java.util.*;

public class Test
{
    
    /**
    *Tests the Calculator class with given user input.
    */
    
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an expression: ");
        String expression = in.nextLine();    
        System.out.println(Calculator.calculate(expression));
    }
}
    