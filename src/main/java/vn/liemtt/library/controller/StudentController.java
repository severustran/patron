package vn.liemtt.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.liemtt.library.domain.StudentDTO;
import vn.liemtt.library.service.StudentService;

@Controller
public class StudentController {

    private static final String STUDENT_DETAIL = "student";

    private StudentService service;

    public StudentController(final StudentService service) {
        this.service = service;
    }

    @GetMapping("/student")
    public String findStudent(String studentId, Model model) {
        StudentDTO dto = service.findByStudentId("12345678");
        model.addAttribute("student", dto);
        return STUDENT_DETAIL;
    }

}
