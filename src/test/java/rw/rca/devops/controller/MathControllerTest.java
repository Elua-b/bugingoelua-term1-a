package rw.rca.devops.controller;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import rw.rca.devops.service.MathService;

@RunWith(SpringRunner.class)
@WebMvcTest(MathService.class)
public class MathControllerTest {

}
