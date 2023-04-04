package com.io;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static com.io.constant.Constants.REJECT_RECORDS_FILE_NAME;
import static com.io.constant.Constants.SUCCESS_RECORDS_FILE_NAME;

public class FlightTicketUpgradeTest {

    @AfterEach
    public void tearDown() throws Exception {
        Path path_s = Paths.get(SUCCESS_RECORDS_FILE_NAME);
        Path path_r = Paths.get(REJECT_RECORDS_FILE_NAME);
        Files.deleteIfExists(path_r);
        Files.deleteIfExists(path_s);
    }

    @Test
    public void upgradeFlight_Records() throws Exception {

        String fileName = "test.csv";

        FlightTicketUpgrade flightTicketUpgrade = new FlightTicketUpgrade();

        flightTicketUpgrade.upgradeFlight(fileName);

        Assertions.assertTrue(Files.exists(Paths.get(SUCCESS_RECORDS_FILE_NAME)));
        Assertions.assertTrue(Files.exists(Paths.get(REJECT_RECORDS_FILE_NAME)));

        List<String> rejectedLines = Files.readAllLines(Paths.get(REJECT_RECORDS_FILE_NAME));
        List<String> successLines = Files.readAllLines(Paths.get(REJECT_RECORDS_FILE_NAME));

        Assertions.assertEquals(4, rejectedLines.size());
        Assertions.assertEquals(4, successLines.size());
    }

    @Test
    public void upgradeFlight_throws_Exception() {

        String fileName = "test1.csv";

        FlightTicketUpgrade flightTicketUpgrade = new FlightTicketUpgrade();

        Assertions.assertThrows(IOException.class, () -> flightTicketUpgrade.upgradeFlight(fileName));
    }
}
