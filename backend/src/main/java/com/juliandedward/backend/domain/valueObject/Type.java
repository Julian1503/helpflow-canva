package com.juliandedward.backend.domain.valueObject;

import com.julian.commerceshared.valueobject.AbstractValueObject;

public class Type extends AbstractValueObject<TypeEnum> {
    protected Type(TypeEnum value) {
        super(value);
    }

    public static Type create(TypeEnum value) {
        if(value == null) {
            throw new IllegalArgumentException("Type cannot be null");
        }
        return new Type(value);
    }
}
