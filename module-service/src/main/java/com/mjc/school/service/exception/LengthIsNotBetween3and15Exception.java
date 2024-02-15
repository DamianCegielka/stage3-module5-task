package com.mjc.school.service.exception;

public class LengthIsNotBetween3and15Exception extends RuntimeException {
    public LengthIsNotBetween3and15Exception(String text) {
        System.Logger.Level.valueOf("ERROR_CODE: 000015 ERROR_MESSAGE: News title can not be less than 3 and more than 15 symbols. News title is " + text);
    }
}