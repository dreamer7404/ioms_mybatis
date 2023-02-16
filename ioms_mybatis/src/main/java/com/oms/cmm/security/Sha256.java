package com.oms.cmm.security;

import java.security.MessageDigest;

/**
 * <pre>
 * Statements
 * </pre>
 *
 * @author sunny
 * @since 2023. 1. 19.
 * @see
 */

public class Sha256 {
    
    /*
     * sha-256 암호화
     * 
    */
    public static String encrypt(String msg){
        String SHA = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(msg.getBytes());
            byte[] mByte = md.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < mByte.length; i++) {
                sb.append(Integer.toString((mByte[i]&0xff)+0x100, 16)).substring(1);
            }
            SHA = sb.toString();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return SHA;
    }
    
}
