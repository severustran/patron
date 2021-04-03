package vn.liemtt.library.service.impl;

import org.springframework.stereotype.Service;
import vn.liemtt.library.domain.StudentDTO;
import vn.liemtt.library.repository.StudentRepository;
import vn.liemtt.library.repository.entity.StudentEntity;
import vn.liemtt.library.service.StudentService;

import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(final StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void addStudents(final List<StudentDTO> studentDTOList) {
        studentDTOList.forEach(studentDTO -> {
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setStudentId(studentDTO.getStudentId());
            studentEntity.setStudentType(studentDTO.getStudentType());
            studentEntity.setFullName(studentDTO.getFullName());
            studentEntity.setFaculty(studentDTO.getFaculty());
            studentEntity.setTakenLO(studentDTO.getTakenLO());
            studentEntity.setGraduated(studentDTO.getGraduated());
            studentEntity.setDateStart(studentDTO.getDateStart());
            studentEntity.setDateEnd(studentDTO.getDateEnd());
            this.studentRepository.save(studentEntity);
        });
    }

    @Override
    public StudentDTO findByStudentId(final String studentId) {
        final StudentEntity studentEntity = this.studentRepository.findStudentEntityByStudentId(studentId);
        if (Objects.isNull(studentEntity))
            return null;
        else {
            StudentDTO dto = new StudentDTO();
            dto.setStudentId(studentEntity.getStudentId());
            dto.setStudentType(studentEntity.getStudentType());
            dto.setFullName(studentEntity.getFullName());
            dto.setFaculty(studentEntity.getFaculty());
            dto.setTakenLO(studentEntity.getTakenLO());
            dto.setGraduated(studentEntity.getGraduated());
            dto.setViolated(studentEntity.getViolated());
            dto.setDateStart(studentEntity.getDateStart());
            dto.setDateEnd(studentEntity.getDateEnd());
            return dto;
        }
    }
}
