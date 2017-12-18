/*
 * Created on Dec 17, 2017
 */
package mum.edu.utils;

import java.security.SecureRandom;
import java.util.Random;

public class StringUtils {

    private static final Random RANDOM = new SecureRandom();
    
    public static final int PASSWORD_LENGTH = 6;
    
    public static final String ROLE_USER = "ROLE_USER";
    
    public static final String ROLE_ADVISOR = "ROLE_ADVISOR";
    
    public static String generateRandomPassword()
    {
        String letters = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789+@";

        String pw = "";
        
        for (int i=0; i<PASSWORD_LENGTH; i++)
        {
            int index = (int)(RANDOM.nextDouble()*letters.length());
            pw += letters.substring(index, index+1);
        }
        return pw;
    }
}
