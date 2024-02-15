package com.mjc.school.service;

import com.mjc.school.service.exception.LengthIsNotBetween3and15Exception;
import com.mjc.school.service.exception.LengthIsNotBetween5and255Exception;
import com.mjc.school.service.exception.LengthIsNotBetween5and30Exception;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Validator {


    public boolean lengthBetween5And255Symbols(String text) {
        try {
            if ((text.length() >= 5) && (text.length() <= 255)) return true;
            else throw new IOException();
        } catch (Exception e) {
            throw new LengthIsNotBetween5and255Exception(text);
        }
    }

    public boolean lengthBetween5And30Symbols(String text) {
        try {
            if ((text.length() >= 5) && (text.length() <= 30)) return true;
            else throw new IOException();
        } catch (Exception e) {
            throw new LengthIsNotBetween5and30Exception(text);
        }
    }

    public boolean lengthBetween3And15Symbols(String text) {
        try {
            if ((text.length() >= 3) && (text.length() <= 15)) return true;
            else throw new IOException();
        } catch (Exception e) {
            throw new LengthIsNotBetween3and15Exception(text);
        }
    }
}