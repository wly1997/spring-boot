package com.wuly.untils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {

    private static BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();

    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        //String pw="0411";//$2a$10$fn.DxVOt/9Qa56AGd7vBA.7MEpeR0NNm9ruEURGZ8OdPbBlBzDr0C
        //String pw ="0827";//$2a$10$nKmxjyCl0rsXUh./EPfhcOuW.U8OS4hB5U6Se39XvSSbJQZ4aTg1i
        String pw ="1234";//$2a$10$6DSs4wQmr3r9P1NGwbXi.OktDad/5592qwub9b..DcvPu22fZSxQq
        pw=encodePassword(pw);
        System.out.println(pw);
    }
}
