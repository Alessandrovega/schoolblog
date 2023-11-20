package pe.edu.upc.schoolblog.courses.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upc.schoolblog.courses.domain.entity.Course;
import pe.edu.upc.schoolblog.courses.resource.CourseResource;
import pe.edu.upc.schoolblog.courses.resource.CreateCourseResource;
import pe.edu.upc.schoolblog.courses.resource.UpdateCourseResource;
import pe.edu.upc.schoolblog.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;


public class CourseMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;


    public Course toModel(CreateCourseResource resource) {
        return this.mapper.map(resource, Course.class);
    }
    public Course toModel(UpdateCourseResource resource) {
        return this.mapper.map(resource, Course.class);
    }
    public CourseResource toResource(Course course) {
        return this.mapper.map(course, CourseResource.class);
    }
}
