package com.io.validator;

import com.io.validator.impl.CabinValidator;
import com.io.validator.impl.EmailValidator;
import com.io.validator.impl.MobilePhoneValidator;
import com.io.validator.impl.PNRValidator;
import com.io.validator.impl.TicketDateValidator;

import java.util.ArrayList;
import java.util.List;

public final class ValidatorAggregator {

    private final static List<IValidator> VALIDATOR_LIST = new ArrayList<>() {
        {
            add(new EmailValidator());
            add(new MobilePhoneValidator());
            add(new TicketDateValidator());
            add(new PNRValidator());
            add(new CabinValidator());
        }
    };

    private ValidatorAggregator(){
    }

    public static List<IValidator> getValidators() {
        return VALIDATOR_LIST;
    }
}
