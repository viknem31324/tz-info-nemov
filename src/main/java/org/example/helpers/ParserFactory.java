package org.example.helpers;

public class ParserFactory {
    public ParserFile createParser(ParserType type) throws Exception {
        ParserFile parser = null;

        switch (type) {
            case XML:
                parser =  new ParserXml();
                break;
            case CSV:
                parser =  new ParserCsv();
                break;
        }

        if (parser == null) {
            throw new Exception("Ошибка типа парсера");
        }

        return parser;
    }
}
