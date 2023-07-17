package com.poly.lab4.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.lab4.DAO.StudentDAO;
import com.poly.lab4.bean.Student;
import com.poly.lab4.bean.StudentMap;

@Controller
public class StudentsController2 {
    @Autowired
    StudentDAO dao;

    @RequestMapping("/student/index")
    public String index(Model model) {
        Student student = new Student("", "", 0.0, true, "");
        model.addAttribute("form", student);
        StudentMap map = dao.findAll();
        model.addAttribute("items", map);
        return "student/index";
    }

    @RequestMapping("/student/edit/{key}")
    public String edit(Model model, @PathVariable("key") String key) {
        model.addAttribute("key", key);
        Student student = dao.findByKey(key);
        model.addAttribute("form", student);
        StudentMap map = dao.findAll();
        model.addAttribute("items", map);
        return "student/index";
    }

    @RequestMapping("/student/create")
    public String create(Model model, @ModelAttribute("form") Student student) {
        try {
            dao.create(student);
            StudentMap map = dao.findAll();
            model.addAttribute("items", map);
            model.addAttribute("form", new Student());
            model.addAttribute("message", "Đã tạo thành công sinh viên mới");
        } catch (Exception e) {
            model.addAttribute("message", "Đã xảy ra lỗi khi tạo sinh viên mới");
        }
        return "student/index";
    }

    @RequestMapping("/student/update/{key}")
    public String update(Model model, @PathVariable("key") String key, @ModelAttribute("form") Student student) {
        try {
            model.addAttribute("key", key);
            dao.update(key, student);
            StudentMap map = dao.findAll();
            model.addAttribute("items", map);
            model.addAttribute("form", new Student());
            model.addAttribute("message", "Đã cập nhật thông tin sinh viên");
        } catch (Exception e) {
            model.addAttribute("message", "Đã xảy ra lỗi khi cập nhật sinh viên");
        }
        return "student/index";
    }

    @RequestMapping("/student/delete/{key}")
    public String delete(Model model, @PathVariable String key) {
        try {
            dao.delete(key);
            StudentMap map = dao.findAll();
            model.addAttribute("items", map);
            model.addAttribute("form", new Student());
            model.addAttribute("message", "Đã xóa sinh viên");
        } catch (Exception e) {
            model.addAttribute("message", "Đã xảy ra lỗi khi xóa sinh viên");
        }
        return "student/index";
    }
}
