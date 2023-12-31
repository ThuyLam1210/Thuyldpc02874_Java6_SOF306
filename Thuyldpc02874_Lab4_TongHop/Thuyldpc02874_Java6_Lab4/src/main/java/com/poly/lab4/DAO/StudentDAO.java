package com.poly.lab4.DAO;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.poly.lab4.bean.Student;
import com.poly.lab4.bean.StudentMap;

@Repository
public class StudentDAO {
    RestTemplate rest = new RestTemplate();

    String url = "https://poly-java6-70fbd-default-rtdb.firebaseio.com/student.json";

    private String getUrl(String key) {
        return url.replace(".json", "/" + key + ".json");
    }

    public StudentMap findAll() {
        return rest.getForObject(url, StudentMap.class);
    }

    public Student findByKey(String key) {
        return rest.getForObject(getUrl(key), Student.class);
    }

    public String create(Student data) {
        HttpEntity<Student> entity = new HttpEntity<>(data);
        JsonNode resp = rest.postForObject(url, entity, JsonNode.class);
        return resp.get("name").asText();
    }

    public Student update(String key, Student data) {
        HttpEntity<Student> entity = new HttpEntity<>(data);
        rest.put(getUrl(key), entity);
        return data;
    }
    
    public void delete(String key) {
        String deleteUrl = getUrl(key);
        rest.delete(deleteUrl);
    }
    
}
