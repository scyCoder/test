package com.scy.test;

public class Hello {
    /**
     * @param sourceString
     * @param password
     * @return 密文
     */
    public static String encrypt(String sourceString, String password) {
        char[] p = password.toCharArray(); // 字符串转字符数组
        int n = p.length; // 密码长度
        char[] c = sourceString.toCharArray();
        int m = c.length; // 字符串长度
        for (int k = 0; k < m; k++) {
            int mima = c[k] - p[k / n]; // 加密
            c[k] = (char) mima;
        }
        return new String(c);
    }

    /**
     * @param sourceString
     * @param password
     * @return 明文
     */
    public static String decrypt(String sourceString, String password) {
        char[] p = password.toCharArray(); // 字符串转字符数组
        int n = p.length; // 密码长度
        char[] c = sourceString.toCharArray();
        int m = c.length; // 字符串长度
        for (int k = 0; k < m; k++) {
            int mima = c[k] + p[k / n]; // 解密
            c[k] = (char) mima;
        }
        return new String(c);
    }

    /*
     * 使用例子
     */
    public static void main(String arg[]) {
        String wen = "zxyh-ICKmock-0607";
        String pass = "123456789";
        System.out.println(encrypt(wen, pass));
        System.out.println(decrypt(encrypt(wen, pass), pass));
    }

}