package rw.rca.devops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rw.rca.devops.dto.DoMathRequest;
import rw.rca.devops.service.IMathOperator;
import rw.rca.devops.serviceImpls.MathOperatorImpl;
import rw.rca.devops.utils.ApiResponse;
import rw.rca.devops.utils.InvalidOperationException;

@RestController
@RequestMapping("/api/v1")

public class MathController {
    @Autowired
    private final MathOperatorImpl mathOperatorImpl;

    public MathController(MathOperatorImpl mathOperatorImpl) {
        this.mathOperatorImpl = mathOperatorImpl;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> create(@RequestBody DoMathRequest dto) throws InvalidOperationException {
        return ResponseEntity.ok(ApiResponse.success(mathOperatorImpl.doMath(dto.getOperand1(), dto.getOperand2(), dto.getOperation())));
    }
}
