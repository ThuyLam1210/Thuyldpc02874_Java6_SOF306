/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.rest;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author Thuy
 */
public class Rest {

    private static ObjectMapper mapper = new ObjectMapper();

    public static JsonNode get(String path) {
        return request("GET", path, null);
    }

    public static JsonNode post(String path, Object data) {
        return request("POST", path, data);
    }

    public static JsonNode put(String path, Object data) {
        return request("PUT", path, data);
    }

    public static JsonNode delete(String path) {
        return request("DELETE", path, null);
    }

    private static JsonNode request(String method, String path, Object data) {
        try {
            //1. REQUEST
            String uri = "https://poly-java6-70fbd-default-rtdb.firebaseio.com" + path + ".json";
            URL url = new URL(uri);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Accept", "application/json");

            conn.setRequestMethod(method);

            // 11 DATA (POST & PUT only)
            if (method.equalsIgnoreCase("POST") || method.equalsIgnoreCase("PUT")) {

                conn.setDoOutput(true);
                mapper.writeValue(conn.getOutputStream(), data);

            }

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                return mapper.readTree(conn.getInputStream());
            }
            conn.disconnect();
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
