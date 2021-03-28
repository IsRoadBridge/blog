package com.zxq;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;

public class DESUtil {
        private static final String ALGORITHM = "PBEWithMD5AndDES";

        private static final char[] PRIVATE_KEY_PWD = "62968980#Bocloud".toCharArray();
        private static final Key PRIVATE_KEY = getPBEKey();

        private static final byte[] SALT_BYTES = "20122018".getBytes(StandardCharsets.UTF_8);
        private static final int ITERATION_COUNT = 1000;

        private final static char[] HEX_ARRAY = "0123456789abcdef".toCharArray();
        private final static int BYTE_ARRAY_MAX_LEN = Integer.MAX_VALUE >> 1;


        /**
         * 根据PBE密码生成一把密钥
         */
        private static Key getPBEKey() {
            SecretKeyFactory keyFactory;
            SecretKey secretKey;

            try {
                keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
                PBEKeySpec keySpec = new PBEKeySpec(PRIVATE_KEY_PWD);
                secretKey = keyFactory.generateSecret(keySpec);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }

            return secretKey;
        }

        /**
         * 加密
         * @param plaintext 待加密的明文字符串
         * @return 加密后的密文字符串
         */
        public static String encrypt(String plaintext) {
            byte[] encipheredData = null;
            PBEParameterSpec parameterSpec = new PBEParameterSpec(SALT_BYTES, ITERATION_COUNT);
            try {
                Cipher cipher = Cipher.getInstance(ALGORITHM);

                cipher.init(Cipher.ENCRYPT_MODE, PRIVATE_KEY, parameterSpec);

                encipheredData = cipher.doFinal(plaintext.getBytes());
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
            return bytesToHexString(encipheredData);
        }

        /**
         * 解密密文字符串
         *
         * @param ciphertext 待解密的密文字符串
         * @return 解密后的明文字符串
         */
        public static String decrypt(String ciphertext) {
            byte[] passDec = null;

            PBEParameterSpec parameterSpec = new PBEParameterSpec(SALT_BYTES, ITERATION_COUNT);
            try {
                Cipher cipher = Cipher.getInstance(ALGORITHM);

                cipher.init(Cipher.DECRYPT_MODE, PRIVATE_KEY, parameterSpec);

                passDec = cipher.doFinal(hexStringToBytes(ciphertext));
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
            return new String(passDec);
        }

        /**
         * 将字节数组转换为十六进制字符串
         */
        public static String bytesToHexString(byte[] bytes) {
            return toHexString(bytes);
        }

        /**
         * 将十六进制字符串转换为字节数组
         */
        public static byte[] hexStringToBytes(String hexString) {
            hexString = hexString.toUpperCase();
            int length = hexString.length() / 2;
            char[] hexChars = hexString.toCharArray();
            byte[] d = new byte[length];
            for (int i = 0; i < length; i++) {
                int pos = i * 2;
                d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
            }
            return d;
        }

        private static byte charToByte(char c) {
            return (byte) "0123456789ABCDEF".indexOf(c);
        }


        public static String toHexString(byte[] bytes) {
            int len = bytes.length;
            if (len > BYTE_ARRAY_MAX_LEN) {
                throw new RuntimeException("字节数组的长度不能超过" + BYTE_ARRAY_MAX_LEN);
            }

            int newLen = len << 1;// len * 2
            char[] hexChars = new char[newLen];

            int v, index;

            for (int i = 0; i < len; i++) {
                v = bytes[i] & 0xFF; // 保留低8位，高24位置0
                index = i << 1;// index * 2
                hexChars[index] = HEX_ARRAY[v >>> 4];
                hexChars[index + 1] = HEX_ARRAY[v & 0x0F];
            }

            return new String(hexChars);
        }

}
