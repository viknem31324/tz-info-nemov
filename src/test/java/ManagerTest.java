import org.example.Address;
import org.example.City;
import org.example.Manager;
import org.example.helpers.ParserFactory;
import org.example.helpers.ParserFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.example.helpers.ParserType.CSV;

public class ManagerTest {
    private String testPath = "src/test/resources/address.csv";
    private Manager manager = new Manager();
    private ParserFile parser = ParserFactory.createParser(CSV);
    ArrayList<Address> addressList = new ArrayList<>(parser.parse(testPath));

    @Test
    void testUniqueAddress() {
        Address address = new Address("Барнаул", "Дальняя улица", 56, 2);
        Map<Address, Integer> uniqueList = manager.getUniqueAddress(addressList);
        Assertions.assertEquals(3, uniqueList.get(address));
    }

    @Test
    void testCityFloor() {
        City city = new City("Барнаул", 2, 1, 1, 1, 1);

        Map<Address, Integer> uniqueList = manager.getUniqueAddress(addressList);
        Map<String, City> cityFloorList = manager.getCityFloorCount(uniqueList);
        Assertions.assertEquals(city, cityFloorList.get(city.getName()));
    }
}
