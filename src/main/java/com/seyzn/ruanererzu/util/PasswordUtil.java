package com.seyzn.ruanererzu.util;

import org.apache.shiro.crypto.hash.Md5Hash;

public class PasswordUtil {
    public static String degistPwd(String pwd){
        return new Md5Hash(pwd, PrjConstant.PWD_SALT, PrjConstant.PWD_ITERATIONS).toBase64();
    }
}
