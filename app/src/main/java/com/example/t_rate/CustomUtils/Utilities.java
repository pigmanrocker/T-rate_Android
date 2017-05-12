package com.example.t_rate.CustomUtils;

/**
 * Created by pigmanrocker on 5/10/17.
 */

public class Utilities {

    public static int getNumberDigits(String inString){
        int numDigits= 0;
        int length= inString.length();
        for (int i = 0; i < length; i++) {
            if (Character.isDigit(inString.charAt(i))) {
                numDigits++;
            }
        }
        return numDigits;
    }

}
