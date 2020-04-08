package controller;

import service.FireReader;
import service.impl.FireReaderImpl;

public class JsonCsvReader {

    public static void main(String[] args) {
        FireReader fireReader = new FireReaderImpl();
        fireReader.setup(args);
    }

}
