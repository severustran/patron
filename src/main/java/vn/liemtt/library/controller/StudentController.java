package vn.liemtt.library.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.liemtt.library.domain.StudentDTO;
import vn.liemtt.library.service.StudentService;

import java.util.Objects;

@Controller
@RequestMapping("/api/student/")
public class StudentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
    private static final String STUDENT_DETAIL = "student";
    private static final String ERROR = "error";
    private static final String SEARCH = "search";
    private static final String ADD = "add";
    private static final String STUDENT_EDIT = "student-edit";

    private StudentService service;

    public StudentController(final StudentService service) {
        this.service = service;
    }

    @GetMapping("student-detail")
    public String findStudent(@RequestParam(value = "studentId") String studentId, Model model) {
        StudentDTO dto = service.findByStudentId(studentId);
        if(Objects.isNull(dto)) {
            model.addAttribute("student", studentId);
            return ERROR;
        } else {
            model.addAttribute("student", dto);
            return STUDENT_DETAIL;
        }
    }

    @PostMapping("student-detail1")
    public String editStudent(@ModelAttribute("student") StudentDTO studentDTO, Model model) {
        LOGGER.info(studentDTO.toString());
        model.addAttribute("student", studentDTO);
        return STUDENT_EDIT;
    }

    @RequestMapping(value = "search")
    public String showSearch() {
        return SEARCH;
    }

    @RequestMapping(value = "add")
    public String showAdd() {
        return ADD;
    }

}
