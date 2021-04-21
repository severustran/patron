package vn.liemtt.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.liemtt.library.config.ModelMapperConfig;
import vn.liemtt.library.domain.StudentDTO;
import vn.liemtt.library.repository.StudentRepository;
import vn.liemtt.library.repository.entity.StudentEntity;
import vn.liemtt.library.service.StudentService;

import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private ModelMapperConfig mapperConfig;

    public StudentServiceImpl(final StudentRepository studentRepository, final ModelMapperConfig mapperConfig) {
        this.studentRepository = studentRepository;
        this.mapperConfig = mapperConfig;
    }

    @Override
    public void addStudents(final List<StudentDTO> studentDTOList) {
        studentDTOList.forEach(studentDTO -> {
            StudentEntity studentEntity = mapperConfig.modelMapper().map(studentDTO, StudentEntity.class);
            this.studentRepository.save(studentEntity);
        });
    }

    @Override
    public StudentDTO findByStudentId(final String studentId) {
        final StudentEntity studentEntity = this.studentRepository.findStudentEntityByStudentId(studentId);
        if (Objects.isNull(studentEntity))
            return null;
        else {
            StudentDTO dto = mapperConfig.modelMapper().map(studentEntity, StudentDTO.class);
            return dto;
        }
    }

    @Override
    public void updateStudent(final StudentDTO studentDTO) {
        StudentEntity entity = mapperConfig.modelMapper().map(studentDTO, StudentEntity.class);
        this.studentRepository.save(entity);
    }
}
