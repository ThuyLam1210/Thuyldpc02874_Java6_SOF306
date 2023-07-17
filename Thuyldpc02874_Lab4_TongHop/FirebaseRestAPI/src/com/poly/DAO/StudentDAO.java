/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.DAO;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poly.bean.Student;
import com.poly.rest.Rest;

/**
 *
 * @author Thuy
 */
public class StudentDAO {

    ObjectMapper mapper = new ObjectMapper();

    public StudentMap findAll() {

        JsonNode resp = Rest.get("/student");
        return mapper.convertValue(resp, StudentMap.class);
    }

    public Student findByKey(String key) {
        JsonNode resp = Rest.get("/student/" + key);
        return mapper.convertValue(resp, Student.class);
    }

    public String create(Student data) {
        JsonNode resp = Rest.post("/student", data);
        return resp.get("name").asText(); // Assuming the response contains the name of the created student

    }

    public Student update(String key, Student data) {
        JsonNode resp = Rest.put("/student/" + key, data);
        return mapper.convertValue(resp, Student.class);
    }

    public void delete(String key) {
        Rest.delete("/student/" + key);
    }
}
