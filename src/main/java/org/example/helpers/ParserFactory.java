package org.example.helpers;

public class ParserFactory {
    public static ParserFile createParser(ParserType type){
        ParserFile parser = null;

        switch (type) {
            case XML:
                parser =  new ParserXml();
                break;
            case CSV:
                parser =  new ParserCsv();
                break;
        }

        return parser;
    }
}
