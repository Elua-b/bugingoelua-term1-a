package rw.rca.devops.service;

import org.springframework.stereotype.Service;
import rw.rca.devops.utils.InvalidOperationException;

@Service
public class MathService {
    public double doMath(double operand1, double operand2, String operation) throws InvalidOperationException {
        if ("/".equals(operation) && operand2 == (double) 0) {
            throw new InvalidOperationException("Cannot divide by 0");
        }
}
