package org.camunda.bpm.listprocessing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JSONConverter {
    public static void main(String[] args) {

        // create an array called datasets
        JsonArray datasets = new JsonArray();

        File file = new File("src/main/java/org.camunda.bpm.listprocessing/input.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file)))  {
            String line;
            boolean flag = true; 
            List<String> columns = null; 
            while ((line = br.readLine()) != null) {
               if (flag) {
                   flag = false; 
                   //process header 
                   columns = Arrays.asList(line.split("~"));
               } else {
                   //to store the object temporarily
                   JsonObject obj = new JsonObject(); 
                   List<String> chunks = Arrays.asList(line.split("~"));

                   for(int i = 0; i < columns.size(); i++) {
                       obj.addProperty(columns.get(i), chunks.get(i));
                   }
                   datasets.add(obj); 
               } 
            }
        } catch(FileNotFoundException fnfe) {
            System.out.println("File not found.");
        } catch(IOException io) {
            System.out.println("Cannot read file.");
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
        System.out.println(gson.toJson(datasets));
    }
}
