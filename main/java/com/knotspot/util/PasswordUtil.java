package com.knotspot.util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {
	
	/**
	 * hash the entered password into 10 
	 * @param typePassword the input password while register
	 * @return the hashed password
	 */
	public static String hashPassword(String typePassword) {
        String salt = BCrypt.gensalt(10);
        return BCrypt.hashpw(typePassword, salt);
    }

    /**
     * checks if the password entered while login matches 
     * @param typePassword the input password while login
     * @param hashedPassword the stored registered password
     * @return boolean if matches or not
     */
    public static boolean checkPassword(String typePassword, String hashedPassword) {
        return BCrypt.checkpw(typePassword, hashedPassword);
    }
}
