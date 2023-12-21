package org.example.helpers;

import org.example.Address;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ParserCsv extends ParserFile {
    @Override
    public ArrayList<Address> parse(String fileName){
        String path = "src/main/resources/" + fileName;
        ArrayList<String> lineList;
        ArrayList<Address> addressList = new ArrayList<>();

        try {
            lineList = new ArrayList<>(Files.readAllLines(Path.of(path)));

            for (int i = 1; i < lineList.size(); i++) {
                String[] lineContents = lineList.get(i).split(";");
                addressList.add(replaceAddress(lineContents));
            }

            return addressList;
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла");
            return new ArrayList<>();
        }
    }

    public Address replaceAddress(String[] lineContents) {
        String city = lineContents[0].replaceAll("\"","");
        String street = lineContents[1].replaceAll("\"","");
        int house = Integer.parseInt(lineContents[2]);
        int floor = Integer.parseInt(lineContents[3]);
        return new Address(city, street, house, floor);
    }

}