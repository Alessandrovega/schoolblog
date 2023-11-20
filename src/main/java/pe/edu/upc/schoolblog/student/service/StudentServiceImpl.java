package pe.edu.upc.schoolblog.student.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.schoolblog.shared.Constant;
import pe.edu.upc.schoolblog.shared.exception.ResourceNotFoundException;
import pe.edu.upc.schoolblog.shared.exception.ResourceValidationException;
import pe.edu.upc.schoolblog.student.domain.model.entity.Student;
import pe.edu.upc.schoolblog.student.domain.persistence.StudentRepository;
import pe.edu.upc.schoolblog.student.domain.service.StudentService;
import pe.edu.upc.schoolblog.student.resource.StudentResource;


import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private Validator validator;

    @Transactional(readOnly = true)
    @Override
    public List<Student> fetchAll() {
        return studentRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Student> fetchById(Integer id) {
        if(studentRepository.existsById(id))
            return studentRepository.findById(id);
        else throw new ResourceNotFoundException(Constant.STUDENT_ENTITY, id);
    }


    @Transactional
    @Override
    public Student save(Student student) {
        Set<ConstraintViolation<Student>> violations
                = validator.validate(student);
        if (!violations.isEmpty()){
            throw new ResourceValidationException(violations);
        }
        return studentRepository.save(student);
    }

    @Transactional
    @Override
    public Student update(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    @Override
    public boolean deleteById(Integer id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
