package com.oms.cmm.utils;


import java.security.MessageDigest;
import java.security.PrivateKey;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


/**
 * <pre>
 * Statements
 * </pre>
 *
 * @author Windows ≫c¿eAU
 * @since 2023. 2. 14.
 * @see
 */

public class AES128 {
    /*
     * encrypt 에서 리턴되는 바이트 수만큼 decrypt에 입력해야 한다.
    */
    
    public static byte[] encrypt(byte[] Byte, String key)throws Exception{
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(Byte);
        return encrypted;
    }
    
    public static byte[] decrypt(byte[] Byte, String key)throws Exception{
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] original = cipher.doFinal(Byte);
        return original;
    }
    
    /*
     * sha-256 암호화
     * 
    */
    public static String SHA256(String msg){
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
    public static String decryptRsa(PrivateKey privateKey, String securedValue) throws Exception {
//        Log.debug("will decrypt : " + securedValue);
        Cipher cipher = Cipher.getInstance("RSA");
        
        if (securedValue == null || securedValue.length() % 2 != 0) {
            return "";
        }

        byte[] bytes = new byte[securedValue.length() / 2];
        for (int i = 0; i < securedValue.length(); i += 2) {
            byte value = (byte)Integer.parseInt(securedValue.substring(i, i + 2), 16);
            bytes[(int) Math.floor(i / 2)] = value;
        }
        
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(bytes);
        String decryptedValue = new String(decryptedBytes, "utf-8"); // 문자 인코딩 주의.
        return decryptedValue;
    }
}
