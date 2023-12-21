package org.example;

import org.example.exeption.ExtensionExeption;
import org.example.helpers.*;

import java.util.*;

import static org.example.helpers.ParserType.*;

public class Manager {
    private final Scanner scanner = new Scanner(System.in);
    private Map<Address, Integer> uniqueAddressList;
    private Map<String, City> cityFloorList;

    public void readFile() {
        while (true) {
            printMenu();

            try {
                String command = scanner.next();

                switch (command) {
                    case "1":
                        System.out.println("Введите имя файла:");
                        String path = scanner.next();
                        ArrayList<Address> addressList;
                        addressList = choiceParseVariant(path);

                        if (!addressList.isEmpty()) {
                            getUniqueAddress(addressList);
                            printDuplicateAddress();

                            getCityFloorCount(uniqueAddressList);
                            printCityFloor();
                        } else {
                            throw new Exception("Ошибка чтения файла");
                        }
                        break;
                    case "0":
                        System.out.println("Выход");
                        return;
                    default:
                        System.out.println("Такой комманды нет!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
       }
    }

    public void printMenu() {
        System.out.println("Считывание файла - 1");
        System.out.println("Выход- 0");
    }

    public void printDuplicateAddress() {
        System.out.println("Дублирующиеся адреса:");
        boolean checkDuplicateAddress = false;

        if (!uniqueAddressList.isEmpty()) {
            for (Address address : uniqueAddressList.keySet()){
                if (uniqueAddressList.get(address) > 0) {
                    System.out.println(address + " - количество дублей " + uniqueAddressList.get(address));
                    checkDuplicateAddress = true;
                }
            }
        }

        if (!checkDuplicateAddress) {
            System.out.println("Нет");
        }
    }

    public void printCityFloor() {
        System.out.println("Этажность домов:");
        if (!cityFloorList.isEmpty()) {
            for (City city : cityFloorList.values()){
                System.out.println(city);
            }
        }
    }

    public void getUniqueAddress(ArrayList<Address> list) {
        Map<Address, Integer> addressUnique = new HashMap<>();
        Address address;

        for (int i = 1; i < list.size(); i++) {
            address = list.get(i);

            if (addressUnique.containsKey(address)) {
                Integer duplicateAddressCount = addressUnique.get(address) + 1;
                addressUnique.put(address, duplicateAddressCount);
            } else {
                addressUnique.put(address, 0);
            }
        }

        uniqueAddressList = addressUnique;
    }

    public void getCityFloorCount(Map<Address, Integer> addressList) {
        Map<String, City> cityList = new HashMap<>();

        for (Address address : addressList.keySet()) {
            City city;

            if (cityList.containsKey(address.getCity())) {
                city = cityList.get(address.getCity());
            } else {
                city = new City(address.getCity());
            }

            switch (address.getFloor()) {
                case 1:
                    city.setOneFloor();
                    break;
                case 2:
                    city.setTwoFloor();
                    break;
                case 3:
                    city.setThreeFloor();
                    break;
                case 4:
                    city.setFourFloor();
                    break;
                case 5:
                    city.setFiveFloor();
                    break;
            }

            cityList.put(city.getName(), city);
        }

        cityFloorList = cityList;
    }

    public ArrayList<Address> choiceParseVariant(String path) throws Exception {
        int sizeExtension = 5; // a.xml || b.csv || ...
        String extension;

        if (path.length() < sizeExtension) {
            throw new ExtensionExeption("Ошибка расширения файла");
        } else {
            extension = path.substring(path.length() - 3);
        }

        ParserFile parser = null;

        if (extension.equals("xml")) {
            parser = new ParserFactory().createParser(XML);
            return new ArrayList<>(parser.parse("address.xml"));
        } else if (extension.equals("csv")) {
            parser = new ParserFactory().createParser(CSV);
            return new ArrayList<>(parser.parse("address.csv"));
        } else {
            throw new ExtensionExeption("Ошибка расширения файла");
        }
    }
}
