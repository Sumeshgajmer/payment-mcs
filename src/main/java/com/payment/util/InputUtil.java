package com.payment.util;

import com.payment.domain.exception.InvalidArgumentException;

import java.util.Scanner;

public class InputUtil {

    private static final String INVALID_INPUT_MESSAGE = "Sorry, you have given the invalid input";

    public static int inputIntValue(String inputMessage){
        try {
            System.out.println(inputMessage);
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        }catch (Exception e){
            throw new InvalidArgumentException(INVALID_INPUT_MESSAGE);
        }
    }

    public static double inputDoubleValue(String inputMessage){
        try {
            System.out.println(inputMessage);
            Scanner scanner = new Scanner(System.in);
            return scanner.nextDouble();
        }catch (Exception e){
            throw new InvalidArgumentException(INVALID_INPUT_MESSAGE);
        }
    }
}
