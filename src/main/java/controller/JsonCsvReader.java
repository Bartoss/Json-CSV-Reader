package controller;

import service.ReaderCSV;

public class JsonCsvReader {

    public static void main(String[] args){
        ReaderCSV readerCSV = new ReaderCSV();
        readerCSV.readCSV().forEach(employee -> {
            System.out.println(employee.getJob());
        });
    }
}
