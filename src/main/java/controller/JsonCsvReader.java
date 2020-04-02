package controller;

import model.Employee;
import service.ReaderCSV;
import service.ReaderJSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static service.CalculateSalary.calculations;

public class JsonCsvReader {

    public static void main(String[] args){
        ReaderCSV readerCSV = new ReaderCSV();
        ReaderJSON readerJSON = new ReaderJSON();
        System.out.println("===Calculations from CSV file===");
        calculations(readerCSV.readCSV("/Users/bartekMacBookPro/Downloads/Java-JSON-CSV-Reader/src/main/resources/employees.csv"));
        System.out.println("===Calculations from JSON file===");
        calculations(readerJSON.readJSON("/Users/bartekMacBookPro/Documents/Json-CSV-Reader/src/main/resources/employees.json"));
    }
}
