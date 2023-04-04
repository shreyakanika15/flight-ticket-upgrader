package com.io.validator.impl;

import com.io.util.Utility;
import com.io.validator.IValidator;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.time.LocalDate;

//Checks Ticket date is before travel date
public class TicketDateValidator implements IValidator {

    private final static Logger LOG = LoggerFactory.getLogger(TicketDateValidator.class);

    private final static int TICKET_DATE_INDEX = 6;
    private final static int TRAVEL_DATE_INDEX = 4;

    @Override
    public boolean validate(final String[] records) {
        try {
            String ticketDate_value = records[TICKET_DATE_INDEX];
            String travelDate_value = records[TRAVEL_DATE_INDEX];

            if (Utility.isStringEmptyOrNull(ticketDate_value) || Utility.isStringEmptyOrNull(travelDate_value)) {
                return false;
            }

            LocalDate ticketDate = LocalDate.parse(ticketDate_value.trim());
            LocalDate travelDate = LocalDate.parse(travelDate_value.trim());

            return ticketDate.isBefore(travelDate);
        } catch (Exception ex) {
            LOG.error(() -> "Error caught while validating the ticket and travel dates. . . " + ex);
            return false;
        }
    }

    @Override
    public String errorMessage() {
        return "Ticket Date and Travel Date are InValid";
    }
}
