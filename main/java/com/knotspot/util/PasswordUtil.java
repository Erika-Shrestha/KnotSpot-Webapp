package com.knotspot.util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {
	public static String hashPassword(String typePassword) {
        String salt = BCrypt.gensalt(10);
        return BCrypt.hashpw(typePassword, salt);
    }

    
    public static boolean checkPassword(String typePassword, String hashedPassword) {
        return BCrypt.checkpw(typePassword, hashedPassword);
    }
}
