package org.ourspring.trend.exceptions;

import org.ourspring.global.exceptions.NotFoundException;

public class TrendNotFoundException extends NotFoundException {
    public TrendNotFoundException() {
        super("NotFound.trend");
    }
}
