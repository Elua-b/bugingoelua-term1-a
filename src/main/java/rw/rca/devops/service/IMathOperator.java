package rw.rca.devops.service;

import org.springframework.stereotype.Service;
import rw.rca.devops.utils.InvalidOperationException;


public interface IMathOperator {
    double doMath(double operand1, double operand2, String operation) throws InvalidOperationException;
}
