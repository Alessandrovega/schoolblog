package pe.edu.upc.schoolblog.teachers.api;

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
import pe.edu.upc.schoolblog.teachers.resource.CreateTeacherResource;
import pe.edu.upc.schoolblog.teachers.resource.UpdateTeacherResource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@WebAppConfiguration
class TeacherControllerTest {

    private final static String BASE_URL = "/teachers";

    MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void save() throws Exception {
        String requestBody = "{ \"lastName\": \"Doe\", \"firstName\": \"John\", \"email\": \"johndoe@example.com\", \"phone\": \"123456789\", \"address\": \"123 Main St\", \"date\": \"2000-01-01\" }";

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
        int teacherId = 1;
        MvcResult mockMvcResult = mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL + "/" + teacherId)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        assertEquals(200, mockMvcResult.getResponse().getStatus());
        assertNotNull(mockMvcResult.getResponse().getContentAsString());
    }

    @Test
    void update() throws Exception {
        int teacherId = 1;
        String requestBody = "{ \"id\": " + teacherId + ", \"lastName\": \"UpdatedLastName\", \"firstName\": \"UpdatedFirstName\", \"email\": \"updatedemail@example.com\", \"phone\": \"987654321\", \"address\": \"456 Updated St\", \"date\": \"2001-02-02\" }";

        MvcResult mockMvcResult = mockMvc.perform(MockMvcRequestBuilders.put(BASE_URL + "/" + teacherId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(200, mockMvcResult.getResponse().getStatus());
        assertNotNull(mockMvcResult.getResponse().getContentAsString());
    }

    @Test
    void delete() throws Exception {
        int teacherId = 1;

        MvcResult mockMvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(BASE_URL + "/" + teacherId)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        assertEquals(200, mockMvcResult.getResponse().getStatus());
    }
}
