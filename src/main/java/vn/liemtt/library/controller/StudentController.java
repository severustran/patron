package vn.liemtt.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.liemtt.library.domain.StudentDTO;
import vn.liemtt.library.service.StudentService;

import java.util.Objects;

@Controller
@RequestMapping("/api/student/")
public class StudentController {

    private static final String STUDENT_DETAIL = "student";
    private static final String ERROR = "error";
    private static final String SEARCH = "search";
    private static final String ADD = "add";
    private static final String STUDENT_EDIT = "student-edit";
    private static final String STUDENT_EDITED = "student-edited";

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

    @PostMapping ("student-detail")
    public String editStudent(@RequestParam( value = "studentId") String studentId, Model model) {
        StudentDTO dto = service.findByStudentId(studentId);
        model.addAttribute("student", dto);
        model.addAttribute("status", false);
        return STUDENT_EDIT;
    }

    @PostMapping("temp")
    public String udpateStudent(@ModelAttribute("student") StudentDTO dto, Model model) {
        service.updateStudent(dto);
        model.addAttribute("student", dto);
        model.addAttribute("status", true);
//        return STUDENT_EDITED + "?studentId=" + dto.getStudentId();
        return STUDENT_DETAIL;
    }

    //TESING
    @GetMapping("testing-bootstrap")
    public String testing(@RequestParam(value = "studentId") String studentId, Model model) {
        StudentDTO dto = service.findByStudentId(studentId);
        if(Objects.isNull(dto)) {
            model.addAttribute("student", studentId);
            return ERROR;
        } else {
            model.addAttribute("student", dto);
            return STUDENT_EDITED;
        }
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
