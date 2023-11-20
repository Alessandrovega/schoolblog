package pe.edu.upc.schoolblog.student.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pe.edu.upc.schoolblog.student.resource.CreateStudentResource;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@WebAppConfiguration
class StudentControllerTest {
    private final static String BASE_URL = "students";

    MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void save() throws Exception {
        CreateStudentResource createStudentResource = new CreateStudentResource();
        createStudentResource.setLastName("Doe");
        createStudentResource.setFirstName("John");

        // Crear una fecha usando el formato adecuado
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = dateFormat.parse("2000-01-01");
        createStudentResource.setBirthday(birthday);
        createStudentResource.setEmail("johndoe@example.com");
        createStudentResource.setPhone("123456789");
        createStudentResource.setAge(21);
        createStudentResource.setTiu("123456789");
        createStudentResource.setAddress("123 Main St");

        MvcResult mockMvcResult = mockMvc.perform(MockMvcRequestBuilders.post(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createStudentResource.toString())
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
        int studentId = 1;
        MvcResult mockMvcResult = mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL + "/" + studentId)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        assertEquals(200, mockMvcResult.getResponse().getStatus());
        assertNotNull(mockMvcResult.getResponse().getContentAsString());
    }

    @Test
    void update() throws Exception {
        int studentId = 1;

        CreateStudentResource updateStudentResource = new CreateStudentResource();
        updateStudentResource.setLastName("UpdatedLastName");
        updateStudentResource.setFirstName("UpdatedFirstName");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = dateFormat.parse("2000-02-02");
        updateStudentResource.setBirthday(birthday);

        updateStudentResource.setEmail("updated@example.com");
        updateStudentResource.setPhone("987654321");
        updateStudentResource.setAge(22);
        updateStudentResource.setTiu("987654321");
        updateStudentResource.setAddress("456 Updated St");

        MvcResult mockMvcResult = mockMvc.perform(MockMvcRequestBuilders.put(BASE_URL + "/" + studentId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updateStudentResource.toString())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(200, mockMvcResult.getResponse().getStatus());
        assertNotNull(mockMvcResult.getResponse().getContentAsString());
    }

    @Test
    void delete() throws Exception {
        int studentId = 1;

        MvcResult mockMvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(BASE_URL + "/" + studentId)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        assertEquals(204, mockMvcResult.getResponse().getStatus());
    }
}
