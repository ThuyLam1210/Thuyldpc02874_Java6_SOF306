package com.poly.lab1.app;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.poly.lab1.bean.*;

public class Jackson2 {
	public static void main(String[] args) throws Exception {
		// demo1();
		// demo2();
		// demo3();
		// demo4();
		// demo5();
		// demo6();
		demo7();

	}

	private static void demo1() throws Exception {
		String path = "C:\\Users\\Thuy\\Downloads\\Thuyldpc02874_Java6_Lab1\\src\\main\\resources\\student.json";

		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> student = mapper.readValue(new File(path), Map.class);

		System.out.println(">>Name: " + student.get("name"));
		System.out.println(">>Marks: " + student.get("marks"));
		System.out.println(">>Gender: " + student.get("gender"));
		Map<String, Object> contact = (Map<String, Object>) student.get("contact");
		System.out.println(">>Email: " + contact.get("email"));
		System.out.println(">>Phone: " + contact.get("phone"));
		List<String> subjects = (List<String>) student.get("subjects");
		subjects.forEach(subject -> {
			System.out.println(">>Subject: " + subject);
		});
	}

	private static void demo2() throws Exception {
		String path = "C:\\Users\\Thuy\\Downloads\\Thuyldpc02874_Java6_Lab1\\src\\main\\resources\\students.json";

		ObjectMapper mapper = new ObjectMapper();
		List<Map<String, Object>> students = mapper.readValue(new File(path), List.class);
		students.forEach(student -> {
			System.out.println(">>Name: " + student.get("name"));
		});
	}

	private static void demo3() throws Exception {
		String path = "C:\\Users\\Thuy\\Downloads\\Thuyldpc02874_Java6_Lab1\\src\\main\\resources\\student.json";
		ObjectMapper mapper = new ObjectMapper();
		Student2 student = mapper.readValue(new File(path), Student2.class);

		System.out.println(">>Name: " + student.getName());
		System.out.println(">>Marks: " + student.getMarks());
		System.out.println(">>Gender: " + student.getGender());
		Contact contact = student.getContact();
		System.out.println(">>Email: " + contact.getEmail());
		System.out.println(">>Phone: " + contact.getPhone());
		System.out.println(">>Address: " + contact.getAddress());
		List<String> subjects = student.getSubjects();
		subjects.forEach(subject -> {
			System.out.println(">>Subject: " + subject);
		});
	}

	private static void demo4() throws Exception {
		String path = "C:\\Users\\Thuy\\Downloads\\Thuyldpc02874_Java6_Lab1\\src\\main\\resources\\students.json";
		TypeReference<List<Student2>> type = new TypeReference<List<Student2>>() {
		};
		ObjectMapper mapper = new ObjectMapper();
		List<Student2> students = mapper.readValue(new File(path), type);
		students.forEach(student -> {
			System.out.println(">>Name: " + student.getName());
		});
	}

	private static void demo5() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode student = mapper.createObjectNode();
		student.put("name", "Lâm Diễm Thúy");
		student.put("marks", 7.5);
		student.put("gender", false);
		ObjectNode contact = student.putObject("contact");
		contact.put("email", "thuyldpc02874@fpt.edu.vn");
		contact.put("phone", "0887271981");
		ArrayNode subjects = student.putArray("subjects");
		subjects.add("SOF306");

		// Write to String
		String json = mapper.writeValueAsString(student);
		// Write to Output
		mapper.writeValue(System.out, student);
		// Write to file
		mapper.writeValue(new File(
				"C:\\Users\\Thuy\\Downloads\\Thuyldpc02874_Java6_Lab1\\src\\main\\resources\\jsondemo\\student.json"),
				student);
	}

	private static void demo6() throws Exception {
		Map<String, Object> contact = new HashMap<String, Object>();
		contact.put("email", "thuyldpc02874@fpt.edu.vn");
		contact.put("phone", "0887271981");

		List<String> subjects = Arrays.asList("WEB205", "SOF306");

		Map<String, Object> student = new HashMap<String, Object>();
		student.put("name", "Lâm Diễm Thúy");
		student.put("marks", 10);
		student.put("gender", false);
		student.put("contact", contact);
		student.put("subjects", subjects);

		ObjectMapper mapper = new ObjectMapper();

		// Write to String
		String json = mapper.writeValueAsString(student);
		System.out.println(json);
		// Write to Output
		mapper.writeValue(System.out, student);
		// Write to file
		mapper.writeValue(new File(
				"C:\\Users\\Thuy\\Downloads\\Thuyldpc02874_Java6_Lab1\\src\\main\\resources\\jsondemo\\student.json"),
				student);
	}

	private static void demo7() throws Exception {
		Contact contact = new Contact("thuyldpc02874@fpt.edu.vn", "0337845364", null);
		List<String> subjects = Arrays.asList("WEB205", "SOF306");
		Student2 student = new Student2("Thúy Lina", false, 7.5, contact, subjects);

		ObjectMapper mapper = new ObjectMapper();
		// Write to String
		String json = mapper.writeValueAsString(student);
		// Write to Output
		mapper.writerWithDefaultPrettyPrinter().writeValue(System.out, student);
		// Write to file
		mapper.writeValue(new File(
				"C:\\Users\\Thuy\\Downloads\\Thuyldpc02874_Java6_Lab1\\src\\main\\resources\\jsondemo\\student.json"),
				student);
	}
}
