package pe.edu.upc.schoolblog.courses.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pe.edu.upc.schoolblog.courses.resource.CreateCourseResource;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@WebAppConfiguration
class CoursesControllerTest {
    private final static String BASE_URL = "courses";

    MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;


    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void save() throws Exception {
        String requestBody = "{ \"name\": \"CourseName\", \"description\": \"CourseDescription\", \"level\": \"High School\", \"grade\": \"Grade 10\", \"section\": \"A\", \"teacher_id\": 1 }";

        MvcResult mockMvcResult = mockMvc.perform(MockMvcRequestBuilders.post(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(201, mockMvcResult.getResponse().getStatus());
        assertNotNull(mockMvcResult.getResponse().getContentAsString());
    }

    @Test
    void fetchAll() throws Exception {
        MvcResult mockMvcResult = mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        assertEquals(200, mockMvcResult.getResponse().getStatus());

        String content = mockMvcResult.getResponse().getContentAsString();
        assertNotNull(content);
    }


    @Test
    void fetchId() throws Exception {
        int courseId = 1;
        MvcResult mockMvcResult = mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL + "/" + courseId)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        assertEquals(200, mockMvcResult.getResponse().getStatus());
        assertNotNull(mockMvcResult.getResponse().getContentAsString());
    }

    @Test
    void fetchByTeacherId() throws Exception {
        int teacherId = 1;

        MvcResult mockMvcResult = mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL + "/teacher/" + teacherId)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        assertEquals(200, mockMvcResult.getResponse().getStatus());
        assertNotNull(mockMvcResult.getResponse().getContentAsString());
    }

    @Test
    void update() throws Exception {
        int courseId = 1;
        String requestBody = "{ \"id\": " + courseId + ", \"name\": \"UpdatedCourseName\", \"description\": \"UpdatedCourseDescription\", \"level\": \"High School\", \"grade\": \"Grade 11\", \"section\": \"B\", \"teacher_id\": 2 }";

        MvcResult mockMvcResult = mockMvc.perform(MockMvcRequestBuilders.put(BASE_URL + "/" + courseId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(200, mockMvcResult.getResponse().getStatus());
        assertNotNull(mockMvcResult.getResponse().getContentAsString());
    }

    @Test
    void delete() throws Exception {
        int courseId = 1;

        MvcResult mockMvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(BASE_URL + "/" + courseId)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        assertEquals(204, mockMvcResult.getResponse().getStatus());
    }

}