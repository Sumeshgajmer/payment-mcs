package com.payment.util;

import com.payment.domain.exception.InvalidArgumentException;

public class StringUtil {
    public static void checkNullOrEmpty(String fieldName, String tag){
        if(isNullOrEmpty(fieldName))
            throw new InvalidArgumentException( tag + " cannot be null or empty");
    }

    public static boolean isNullOrEmpty(String string){
        return string == null || string.isEmpty();
    }

}

