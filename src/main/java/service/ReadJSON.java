package service;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Example;

public class ReadJSON {

    public static void readDom() {
        try {
            //reader = new BufferedReader(new FileReader(file));
            Gson gson = new GsonBuilder().create();
            //Example employes = gson.fromJson(reader, Example.class);
            Example ourClass = null;
            ourClass = gson.fromJson(new FileReader("/Users/bartekMacBookPro/Downloads/Java-JSON-CSV-Reader/src/main/resources/employees.json"), Example.class);

            ourClass.getEmployees().forEach(employee -> {
                System.out.println(employee.getName());
                System.out.println(employee.getSurname());
            });


        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadJSON.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }
    }

    public static void main(String[] args){
        long ti, tf;

        ti = System.currentTimeMillis();
        System.out.println("Start reading in object mode: " + ti);
        ReadJSON.readDom();
        tf = System.currentTimeMillis();
        System.out.println("Finish. Total time: " + (tf - ti));

    }

}
