package rw.rca.devops.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import rw.rca.devops.dto.DoMathRequest;
import rw.rca.devops.utils.ApiResponse;
import rw.rca.devops.utils.InvalidOperationException;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntergrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testMath_operation_success() throws InvalidOperationException {
        DoMathRequest mathRequest = new DoMathRequest(12, 4, "/");

        ResponseEntity<ApiResponse> response = this.restTemplate.postForEntity(
                "/api/v1",
                mathRequest,
                ApiResponse.class
        );

        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(3.0, response.getBody().getData());
    }
}
