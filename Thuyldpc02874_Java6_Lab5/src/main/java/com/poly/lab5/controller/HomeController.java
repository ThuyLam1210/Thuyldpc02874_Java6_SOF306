package com.poly.lab5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poly.lab5.service.FileManagerService;

@Controller
public class HomeController {
   
    @RequestMapping("/rest")
    public String adminPage(Model model) {
        return "views/crud";
    }

    @RequestMapping("/rest/importExcel")
    public String importExcel(Model model) {
        return "views/excel";
    }

    @RequestMapping("/rest/file")
    public String importfile(Model model) {
        return "views/file";
    }

  
}
