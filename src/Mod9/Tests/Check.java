package Mod9.Tests;

import java.util.Scanner;

public class Check {public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        System.out.print("Please enter a social insurance number with digits only: ");
        String sin = kb.next();

        // Ask for the user to enter again if entry is not valid
        while (!isValid(sin)) {
            System.out.print("Enter a valid social insurance number with digits only: ");
            sin = kb.next();
        }

        // Move on
    }

    // Check for validity seperately
    public static boolean isValid(String input)
    {
        // Does it have nine characters
        if(input.length() != 9)
            return false;

        // Is it a number ?
        try
        {
            Integer i = Integer.parseInt(input);
        }
        catch(NumberFormatException e)
        {
            return false;
        }

        // Passed all checks must be valid
        return true;
    }

}
