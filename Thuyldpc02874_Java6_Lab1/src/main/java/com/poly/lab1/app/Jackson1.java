package com.poly.lab1.app;

import java.io.File;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poly.lab1.bean.*;

public class Jackson1 {
	public static void main(String[] args) throws Exception {
		// demo1();
		demo2();

	}

	private static void demo1() throws Exception {
		String path = "C:\\Users\\Thuy\\Downloads\\Thuyldpc02874_Java6_Lab1\\src\\main\\resources\\student.json";

		ObjectMapper mapper = new ObjectMapper();
		JsonNode student = mapper.readTree(new File(path));

		System.out.println(">>Name: " + student.get("name").asText());
		System.out.println(">>Marks: " + student.get("marks").asDouble());
		System.out.println(">>Gender: " + student.get("gender").asBoolean());
		System.out.println(">>Email: " + student.get("contact").get("email").asText());
		System.out.println(">>Phone: " + student.findValue("phone").asText());
		student.get("subjects").iterator().forEachRemaining(subjects -> {
			System.out.println(">>Subjects: " + subjects.asText());
		});

	}

	private static void demo2() throws Exception {
		String path = "C:\\Users\\Thuy\\Downloads\\Thuyldpc02874_Java6_Lab1\\src\\main\\resources\\students.json";
		ObjectMapper mapper = new ObjectMapper();
		JsonNode students = mapper.readTree(new File(path));
		students.iterator().forEachRemaining(student -> {
			System.out.println(">>Name: " + student.get("name").asText());
			System.out.println(">>Marks: " + student.get("marks").asDouble());
			System.out.println(">>Gender: " + student.get("gender").asBoolean());
			System.out.println(">>Email: " + student.get("contact").get("email").asText());
			System.out.println(">>Phone: " + student.findValue("phone").asText());
			student.get("subjects").iterator().forEachRemaining(subjects -> {
				System.out.println(">>Subjects: " + subjects.asText());
			});
			System.out.println("-------------------------------------");
		});

	}
}
