package pe.edu.upc.schoolblog.evaluation.api;

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
import pe.edu.upc.schoolblog.evaluation.resource.CreateEvaluationResource;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@WebAppConfiguration
class EvaluationControllerTest {
    private final static String BASE_URL = "evaluations";

    MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void save() throws Exception {
        String requestBody = "{ \"course_id\": 1, \"name\": \"EvaluationName\", \"description\": \"EvaluationDescription\", \"expirationDay\": \"2023-12-31\", \"initDay\": \"2023-09-01\" }";

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
        int evaluationId = 1;
        MvcResult mockMvcResult = mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL + "/" + evaluationId)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        assertEquals(200, mockMvcResult.getResponse().getStatus());
        assertNotNull(mockMvcResult.getResponse().getContentAsString());
    }

    @Test
    void fetchByCourseId() throws Exception {
        int courseId = 1;

        MvcResult mockMvcResult = mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL + "/courses/" + courseId)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        assertEquals(200, mockMvcResult.getResponse().getStatus());
        assertNotNull(mockMvcResult.getResponse().getContentAsString());
    }

    @Test
    void update() throws Exception {
        int evaluationId = 1;
        String requestBody = "{ \"id\": " + evaluationId + ", \"course_id\": 2, \"name\": \"UpdatedEvaluationName\", \"description\": \"UpdatedEvaluationDescription\", \"expirationDay\": \"2023-12-31\", \"initDay\": \"2023-09-01\" }";

        MvcResult mockMvcResult = mockMvc.perform(MockMvcRequestBuilders.put(BASE_URL + "/" + evaluationId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(200, mockMvcResult.getResponse().getStatus());
        assertNotNull(mockMvcResult.getResponse().getContentAsString());
    }

    @Test
    void delete() throws Exception {
        int evaluationId = 1;

        MvcResult mockMvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(BASE_URL + "/" + evaluationId)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        assertEquals(204, mockMvcResult.getResponse().getStatus());
    }
}
