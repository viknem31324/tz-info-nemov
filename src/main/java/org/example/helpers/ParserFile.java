package org.example.helpers;

import org.example.Address;

import java.util.ArrayList;

public abstract class ParserFile {
    public abstract ArrayList<Address> parse(String path);
}
