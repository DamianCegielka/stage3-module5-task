package com.mjc.school.service.exception;

public class TagIsDoesNotExistException extends RuntimeException{

        public TagIsDoesNotExistException() {
            System.Logger.Level.valueOf("ERROR_CODE: 000212 ERROR_MESSAGE: Tag is does not exist. ");
        }
}

