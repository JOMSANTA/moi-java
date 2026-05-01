package com.moi.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtil {

    private  static  final  PasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String hash(String plainPassword) {
        return encoder.encode(plainPassword);
    }

    public static boolean matches(String plainPassword, String hashPassword){
        return  encoder.matches(plainPassword, hashPassword);
    }



}
