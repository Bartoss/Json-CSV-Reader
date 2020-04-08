package controller;

import service.CalculateSalary;
import service.ReaderCSV;
import service.ReaderJSON;

import java.util.HashMap;

public class JsonCsvReader {

    private final static String pathJson = "/Users/bartekMacBookPro/Documents/Json-CSV-Reader/src/main/resources/files/employees.json";
    private final static String pathCsv = "/Users/bartekMacBookPro/Documents/Json-CSV-Reader/src/main/resources/files/employees.csv";

    public static void main(String[] args) {
        ReaderCSV readerCSV = new ReaderCSV();
        ReaderJSON readerJSON = new ReaderJSON();
        CalculateSalary calculateSalary = new CalculateSalary();
        HashMap<String, Float> salaryMap;

        System.out.println("===Calculations from CSV file===");
        salaryMap = calculateSalary.calculations(readerCSV.readCSV(pathCsv));
        printValues(salaryMap);
        salaryMap = null;
        System.out.println("===Calculations from JSON file===");
        salaryMap = calculateSalary.calculations(readerJSON.readJSON(pathJson));
        printValues(salaryMap);
    }

    public static void printValues(HashMap<String, Float> salaryMap){
        salaryMap.forEach((k,v) ->{
            System.out.println(k + " - " + v);
        });
    }
}
