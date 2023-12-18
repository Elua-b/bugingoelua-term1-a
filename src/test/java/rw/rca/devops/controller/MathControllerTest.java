package rw.rca.devops.controller;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import rw.rca.devops.service.MathService;

@RunWith(SpringRunner.class)
@WebMvcTest(MathService.class)
public class MathControllerTest {
    @MockBean
    private MathService mathServiceMock;

    @Autowired
    private MockMvc mockMvc;
}
