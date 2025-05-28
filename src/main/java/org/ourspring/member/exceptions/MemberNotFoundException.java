package org.ourspring.member.exceptions;

import org.ourspring.global.exceptions.NotFoundException;

public class MemberNotFoundException extends NotFoundException {
    public MemberNotFoundException() {
        super("NotFound.member");
        setErrorCode(true);
    }
}
