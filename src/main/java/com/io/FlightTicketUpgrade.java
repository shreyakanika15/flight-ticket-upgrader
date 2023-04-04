package com.io;

import com.io.validator.IValidator;
import com.io.validator.ValidatorAggregator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.io.constant.Constants.COMMA;
import static com.io.constant.Constants.REJECT_RECORDS_FILE_NAME;
import static com.io.constant.Constants.SUCCESS_RECORDS_FILE_NAME;

//Read,Validate and Process the flight records
public class FlightTicketUpgrade {

    private static final String SUCCESSFUL_RECORDS_HEADER = "First_name, Last_name, PNR, Fare_class, Travel_date, Pax, Ticketing_date, Email, Mobile_phone, Booked_cabin,Discount_code";
    private static final String REJECT_RECORDS_HEADER = "First_name, Last_name, PNR, Fare_class, Travel_date, Pax, Ticketing_date, Email, Mobile_phone, Booked_cabin,Error";
    private static final int FARE_CLASS_INDEX = 3;

    public void upgradeFlight(final String fileName) throws IOException {
        final List<String> fileContents = readFlightRecords(fileName);
        validateFlightRecords(fileContents);
    }

    private void validateFlightRecords(List<String> fileContents) throws IOException {
        final List<String> successRecords = new ArrayList<>();
        final List<String> rejectedRecords = new ArrayList<>();

        for (int i = 1; i < fileContents.size(); i++) {
            String content = fileContents.get(i);
            String[] lineArray = content.split(COMMA);
            final List<String> errorMessages = validateRecord(lineArray);

            // if size is more than 0 that means there is/are problem with records/bookings.
            if (errorMessages.size() > 0) {
                rejectedRecords.add(content + COMMA + errorMessages.get(0));
            } else {
                successRecords.add(content + COMMA + CheckDiscountedCode.discountCode(lineArray[FARE_CLASS_INDEX]));
            }
        }

        processFlightRecords(successRecords, rejectedRecords);
    }

    private void processFlightRecords(List<String> successRecords, List<String> rejectedRecords) throws IOException {
        try {
            if (successRecords.size() > 0) {
                successRecords.add(0, SUCCESSFUL_RECORDS_HEADER);
                Path path_s = Paths.get(SUCCESS_RECORDS_FILE_NAME);
                Files.createFile(path_s);
                Files.write(path_s, successRecords);
            }

            if (rejectedRecords.size() > 0) {
                rejectedRecords.add(0, REJECT_RECORDS_HEADER);
                Path path_r = Paths.get(REJECT_RECORDS_FILE_NAME);
                Files.createFile(path_r);
                Files.write(path_r, rejectedRecords);
            }
        } catch (IOException e) {
            throw new IOException("Caught exception while writing the records to a file. . " + e);
        }
    }

    private List<String> readFlightRecords(String fileName) throws IOException {
        try {
            Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader().getResource(fileName)).toURI());
            return Files.readAllLines(path);
        } catch (Exception ex) {
            throw new IOException("Caught Error while reading the file. . " + ex);
        }
    }

    private List<String> validateRecord(final String[] lineArray) {
        List<String> messages = new ArrayList<>();
        for (IValidator validator : ValidatorAggregator.getValidators()) {
            if (!validator.validate(lineArray)) {
                messages.add(validator.errorMessage());
                break;
            }
        }
        return messages;
    }
}
