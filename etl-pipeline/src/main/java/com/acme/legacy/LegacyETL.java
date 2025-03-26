package com.acme.legacy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class LegacyETL {

    public static List<JSONObject> fetchSalesData(String urlString) throws Exception {
        // Uses Java 7 style HTTP connection (HttpURLConnection)
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
            new InputStreamReader(conn.getInputStream())
        );
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JSONArray jsonArray = new JSONArray(response.toString());
        List<JSONObject> dataList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            dataList.add(jsonArray.getJSONObject(i));
        }
        return dataList;
    }

    public static List<JSONObject> processData(List<JSONObject> data) {
        // Outdated: no logging, minimal logic, no error handling
        System.out.println("Processing data...");
        List<JSONObject> cleanedData = new ArrayList<>();
        for (JSONObject record : data) {
            if (record.has("product_id")) {
                cleanedData.add(record);
                System.out.println("Record has product_id: " + record.get("product_id"));
            }
        }
        return cleanedData;
    }

    public static void storeData(List<JSONObject> data, String outputFilePath) throws Exception {
        // Writes data to a file in JSON format
        // No robust error handling
        JSONArray jsonArray = new JSONArray();
        for (JSONObject record : data) {
            jsonArray.put(record);
        }
        java.io.FileWriter writer = new java.io.FileWriter(outputFilePath);
        writer.write(jsonArray.toString());
        writer.close();
        System.out.println("Data stored locally in " + outputFilePath);
    }

    public static void main(String[] args) throws Exception {
        // Hardcoded values for demonstration
        String url = "http://example.com/api/v1/sales";
        String outputFilePath = "sales_output.json";

        List<JSONObject> salesData = fetchSalesData(url);
        List<JSONObject> cleanedData = processData(salesData);
        storeData(cleanedData, outputFilePath);
        Thread.sleep(2000);
        System.out.println("ETL process completed.");
    }
}
