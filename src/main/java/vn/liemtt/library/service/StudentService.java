package vn.liemtt.library.service;

import vn.liemtt.library.domain.StudentDTO;

import java.util.List;

public interface StudentService {
    void addStudents(final List<StudentDTO> studentDTOList);
    StudentDTO findByStudentId(final String studentId);
    void updateStudent(final StudentDTO studentDTO);
}
