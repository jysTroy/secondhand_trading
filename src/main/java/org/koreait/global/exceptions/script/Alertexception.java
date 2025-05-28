package org.koreait.global.exceptions.script;

import org.koreait.global.exceptions.CommonException;
import org.springframework.http.HttpStatus;

public class Alertexception extends CommonException {
    public Alertexception(String message, HttpStatus status) {
        super(message, status);
    }
}
