package com.poly.lab2.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poly.lab2.bean.Student;

@Controller
public class HomeController {
	@RequestMapping("/index")
	public String index(Model model) throws StreamReadException, DatabindException, IOException {
		model.addAttribute("message", "Tôi nè Lâm Diễm Thúy");
		
		ObjectMapper mapper = new ObjectMapper();
		String path = "E:\\New folder\\Java 6\\NopLab\\Thuyldpc02874_Java6_Lab2\\src\\main\\resources\\static\\json\\student.json";
		Student students = mapper.readValue(new File(path), Student.class);
		model.addAttribute("sv", students);
		return "home/index";
	}
}
