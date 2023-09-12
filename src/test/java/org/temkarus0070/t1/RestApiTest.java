package org.temkarus0070.t1;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.temkarus0070.t1.models.FrequencyDto;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@AutoConfigureMockMvc
public class RestApiTest {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSuccessReturningMap() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/")
                                              .content(objectMapper.writeValueAsString(new FrequencyDto("KEK KEK")))
                                              .contentType(MediaType.APPLICATION_JSON))
               .andExpect(result -> {
                   Map<String, Integer> actualResult = objectMapper.readValue(result.getResponse()
                                                                                    .getContentAsString(), HashMap.class);
                   Assertions.assertFalse(actualResult.isEmpty());
                   Map<String, Integer> expectedRes = Map.of("K", 4, "E", 2, " ", 1);
                   for (Map.Entry<String, Integer> expectedCharacterIntegerEntry : expectedRes.entrySet()) {
                       Assertions.assertEquals(actualResult.get(expectedCharacterIntegerEntry.getKey()),
                                               expectedCharacterIntegerEntry.getValue());
                   }
               });
    }

    @Test
    public void testErrorWhenWithoutRequestBody() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/")
                                              .content(" kjkj")
                                              .contentType(MediaType.APPLICATION_JSON))
               .andExpect(result -> {
                   Assertions.assertEquals(400,
                                           result.getResponse()
                                                 .getStatus());
               });
    }
}
