package rw.rca.devops.service;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import rw.rca.devops.dto.DoMathRequest;
import rw.rca.devops.serviceImpls.MathOperatorImpl;
import rw.rca.devops.utils.ApiResponse;
import rw.rca.devops.utils.InvalidOperationException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import static org.junit.Assert.assertThrows;


public class MathControllerImplTest {
    private int operand1 = 10;
    private int operand2 = 3;

    @Test
    public void performMultiplication_success() throws InvalidOperationException {
        MathOperatorImpl mathOperator = new MathOperatorImpl();

        double actualResult = mathOperator.doMath(operand1, operand2, "*");
        double result = 30.0;

        Assertions.assertEquals(actualResult, result);
    }

    @Test
    public void performDivision_success() throws InvalidOperationException {
        MathOperatorImpl mathOperator = new MathOperatorImpl();

        double actualResult = mathOperator.doMath(operand1, operand2, "/");
        double result = 3.3333333333333335;

        Assertions.assertEquals(actualResult, result);
    }

    @Test
    public void performDivision_whenOperand2_IsZero() throws InvalidOperationException {
        MathOperatorImpl mathOperator = new MathOperatorImpl();


        assertThrows(InvalidOperationException.class, () -> {
            mathOperator.doMath(operand1, operand2, "/");
        });
    }

    @Test
    public void performAddition_success() throws InvalidOperationException {
        MathOperatorImpl mathOperator = new MathOperatorImpl();

        double actualResult = mathOperator.doMath(operand1, operand2, "+");
        double result = 13.0;

        Assertions.assertEquals(actualResult, result);
    }

    @Test
    public void performSubtraction_success() throws InvalidOperationException {
        MathOperatorImpl mathOperator = new MathOperatorImpl();

        double actualResult = mathOperator.doMath(operand1, operand2, "-");
        double result = 7.0;

        Assertions.assertEquals(actualResult, result);
    }

    @Test
    public void performPowering_success() throws InvalidOperationException {
        MathOperatorImpl mathOperator = new MathOperatorImpl();

        double actualResult = mathOperator.doMath(operand1, operand2, "**");
        double result = 1000.0;

        Assertions.assertEquals(actualResult, result);
    }

    @Test
    public void performLog_success() throws InvalidOperationException {
        MathOperatorImpl mathOperator = new MathOperatorImpl();

        double actualResult = mathOperator.doMath(operand1, operand2, "log");
        double result = 4.771212547196624;

        Assertions.assertEquals(actualResult, result);
    }

    @Test
    public void performLn_success() throws InvalidOperationException {
        MathOperatorImpl mathOperator = new MathOperatorImpl();

        double actualResult = mathOperator.doMath(operand1, operand2, "ln");
        double result = 10.986122886681098;

        Assertions.assertEquals(actualResult, result);
    }

}


