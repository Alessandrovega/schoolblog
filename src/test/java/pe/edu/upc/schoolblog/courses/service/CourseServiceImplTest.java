package pe.edu.upc.schoolblog.Test.service;

import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pe.edu.upc.schoolblog.teachers.domain.model.entity.Teacher;
import pe.edu.upc.schoolblog.teachers.domain.persistence.TeacherRepository;
import pe.edu.upc.schoolblog.teachers.service.TeacherServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CourseServiceImplTest {

    @InjectMocks
    private TeacherServiceImpl teacherService;

    @Mock
    private TeacherRepository teacherRepository;

    @Mock
    private Validator validator;

    @Test
    public void testFetchAll() {
        // Arrange
        List<Teacher> expected = this.expectedListTeacher();
        Mockito.when(teacherRepository.findAll())
                .thenReturn(this.actualListTeacher());
        // Act
        List<Teacher> actual = teacherService.fetchAll();


        // Assert
        Assertions.assertEquals(expected.get(0).getId(), actual.get(0).getId());
        Assertions.assertEquals(expected.get(0).getLastName(), actual.get(0).getLastName());
        Assertions.assertEquals(expected.get(0).getFirstName(), actual.get(0).getFirstName());
    }

    @Test
    public void testFetchById() {
        // Arrange
        Integer idExpected = 15;
        Integer idActual = 15;
        Optional<Teacher> expected = this.expectedOptionalTeacher(idExpected);

        Mockito.when(teacherRepository.existsById(Mockito.anyInt()))
                .thenReturn(true);
        Mockito.when(teacherRepository.findById(Mockito.anyInt()))
                .thenReturn(actualOptionalTeacher(idActual));
        // Act
        Optional<Teacher> actual = teacherService.fetchById(idActual);
        // Assert
        Assertions.assertEquals(expected.get().getId(), actual.get().getId());
        Assertions.assertEquals(expected.get().getLastName(), actual.get().getLastName());
        Assertions.assertEquals(expected.get().getFirstName(), actual.get().getFirstName());

    }

    @Test
    public void saveTest() {

        Integer idExpected = 15;
        Integer idActual = 14;
        var teacher = createTeacher(idExpected);

        Mockito.when(teacherRepository.save(ArgumentMatchers.any())).thenReturn(teacher);

        Teacher actualTeacher= teacherService.save(teacher);

        Assertions.assertNotEquals(idActual, actualTeacher.getId());


    }

    @Test
    public void updateTest() {

        String expectedFirstName = " Valery";
        String expectedLastName = " Ayasta";

        Teacher teacher = new Teacher();

        teacher.setFirstName(" Marjorie");
        teacher.setLastName("Abanto");


        Mockito.when(teacherRepository.save(ArgumentMatchers.any())).thenReturn(teacher);

        Teacher actualTeacher = teacherService.save(teacher);

        Assertions.assertNotEquals(expectedFirstName, actualTeacher.getFirstName());
        Assertions.assertNotEquals(expectedLastName, actualTeacher.getLastName());

        Mockito.verify(teacherRepository, Mockito.times(1)).save(ArgumentMatchers.any());
    }


    @Test
    public void deleteTest() {
        Integer idExpected = 15;

        createTeacher(idExpected);

        Mockito.when(teacherRepository.existsById(Mockito.anyInt()))
                .thenReturn(true);
        Mockito.doNothing().when(teacherRepository).deleteById(Mockito.anyInt());

        boolean result = teacherService.deleteById(15);

        Assertions.assertTrue(result);

    }


    public List<Teacher> expectedListTeacher() {
        List<Teacher> expected = new ArrayList<>();


        Teacher teacher= new Teacher();
        teacher.setId(1);
        teacher.setLastName("Ayasta");
        teacher.setFirstName("Valery");


        expected.add(teacher);
        return expected;
    }

    public List<Teacher> actualListTeacher() {
        List<Teacher> expected = new ArrayList<>();


        Teacher teacher=new Teacher();
        teacher.setId(1);
        teacher.setLastName("Ayasta");
        teacher.setFirstName("Valery");

        expected.add(teacher);
        return expected;
    }

    public Optional<Teacher> expectedOptionalTeacher(Integer id) {
        return Optional.of(createTeacher(id));
    }

    public Optional<Teacher> actualOptionalTeacher(Integer id) {
        return Optional.of(createTeacher(id));
    }


    public Teacher createTeacher(Integer id) {

        Teacher teacher= new Teacher();
        teacher.setId(id);
        teacher.setLastName("Ayasta");
        teacher.setFirstName("Valery");

        return teacher;
    }

}

