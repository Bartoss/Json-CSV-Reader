package service.impl;

import service.FireReader;

import java.util.HashMap;

public class FireReaderImpl implements FireReader {

    private final static String pathJson = "files/employees.json";
    private final static String pathCsv = "files/employees.csv";

    public void setup(String[] args) {
        ReaderCsvImpl readerCsvImpl = new ReaderCsvImpl();
        ReaderJsonImpl readerJsonImpl = new ReaderJsonImpl();
        CalculateSalaryImpl calculateSalaryImpl = new CalculateSalaryImpl();
        HashMap<String, Float> salaryMap;
        System.out.println("===Calculations from CSV file===");
        salaryMap = calculateSalaryImpl.calculations(readerCsvImpl.readCSV(pathCsv));
        printValues(salaryMap);
        System.out.println("===Calculations from JSON file===");
        salaryMap = calculateSalaryImpl.calculations(readerJsonImpl.readJSON(pathJson));
        printValues(salaryMap);
    }

    public void printValues(HashMap<String, Float> salaryMap) {
        salaryMap.forEach((k, v) -> {
            System.out.println(k + " - " + v);
        });
    }
}
