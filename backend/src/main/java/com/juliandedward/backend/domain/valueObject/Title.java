package com.juliandedward.backend.domain.valueObject;

import com.julian.commerceshared.valueobject.AbstractValueObject;

public class Title extends AbstractValueObject<String> {
    public Title(String value) {
        super(value);
    }

    public static Title create(String value) {
        if(value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if(value.length() > 255) {
            throw new IllegalArgumentException("Title cannot be longer than 255 characters");
        }
        return new Title(value);
    }
}
