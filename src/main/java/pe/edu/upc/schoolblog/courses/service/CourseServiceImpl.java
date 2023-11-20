package pe.edu.upc.schoolblog.courses.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.schoolblog.courses.domain.entity.Course;
import pe.edu.upc.schoolblog.courses.domain.entity.Level;
import pe.edu.upc.schoolblog.courses.domain.persistence.CourseRepository;
import pe.edu.upc.schoolblog.courses.domain.service.CourseService;
import pe.edu.upc.schoolblog.shared.Constant;
import pe.edu.upc.schoolblog.shared.exception.ResourceNotFoundException;
import pe.edu.upc.schoolblog.shared.exception.ResourceValidationException;
import pe.edu.upc.schoolblog.teachers.domain.model.entity.Teacher;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private Validator validator;

    @Transactional(readOnly = true)
    @Override
    public List<Course> fetchAll() {
        return courseRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Course> fetchByTeacherId(Teacher teacher){
        return courseRepository.findByTeacher(teacher);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Course> fetchById(Integer id) {
        if (courseRepository.existsById(id)) {
            return courseRepository.findById(id);
        } else {
            throw new ResourceNotFoundException(Constant.COURSE_ENTITY, id);
        }
    }

    @Override
    public Course save(Course course) {

        if (course.getLevel()!= Level.PRESCHOOL_LEVEL){
            if (course.getLevel()!= Level.ELEMENTARY_SCHOOL_LEVEL){
                if (course.getLevel() != Level.HIGH_SCHOOL_LEVEL){
                    throw new ResourceValidationException("Invalid level, only can be: (" +
                            Level.PRESCHOOL_LEVEL + ") or (" +
                            Level.ELEMENTARY_SCHOOL_LEVEL+ ") or ("
                            + Level.HIGH_SCHOOL_LEVEL + ").");
                }
            }
        }

        Optional<Course> existingCourse = courseRepository.findByNameAndLevelAndAndGradeAndAndSection(course.getName(), course.getLevel(), course.getGrade(), course.getSection());

        if (existingCourse != null){
            throw new ResourceValidationException("This course already exist in this section.");
        }

        Set<ConstraintViolation<Course>>
                violations = validator.validate(course);

        if (!violations.isEmpty()){
            throw new ResourceValidationException(violations);
        }

        return courseRepository.save(course);
    }

    @Transactional
    @Override
    public Course update(Course course) {
        return courseRepository.save(course);
    }

    @Transactional
    @Override
    public boolean deleteById(Integer id) {
        if(courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
