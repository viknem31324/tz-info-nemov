package org.example.helpers;

import org.example.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.example.helpers.ParserType.*;

public class ParserCsvTest {
    Address address = new Address("Барнаул", "Дальняя улица", 56, 2);
    @Test
    void testParse() {
        String testPath = "src/test/resources/address.csv";

        try {
            ParserFile parser = ParserFactory.createParser(CSV);
            ArrayList<Address> addressList = new ArrayList<>(parser.parse(testPath));
            Assertions.assertEquals(address, addressList.get(0));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
