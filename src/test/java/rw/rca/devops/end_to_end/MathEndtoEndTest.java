package rw.rca.devops.end_to_end;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import rw.rca.devops.dto.DoMathRequest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MathEndtoEndTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testMultiplication_success() throws Exception {
        DoMathRequest mathRequest = new DoMathRequest(12, 4, "*");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/math")
                        .contentType("application/json")
                        .content(toJSON(mathRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value(48.0));
    }

    private byte[] toJSON(DoMathRequest mathRequest) {
        return new byte[0];
    }


    @Test
    public void testDivision_success() throws Exception {
        DoMathRequest mathRequest = new DoMathRequest(12, 4, "/");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/math")
                        .contentType("application/json")
                        .content(toJSON(mathRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value(3.0));
}
}
