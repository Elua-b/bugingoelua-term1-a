package rw.rca.devops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rw.rca.devops.dto.DoMathRequest;
import rw.rca.devops.service.MathService;
import rw.rca.devops.utils.ApiResponse;
import rw.rca.devops.utils.InvalidOperationException;

@RestController
@RequestMapping("/api/v1")

public class MathController {
    @Autowired
    public static MathService mathService;

    public MathController(MathService mathService) {
        MathController.mathService = mathService;
    }

    @PostMapping("/doMath")
    public ResponseEntity<?> doMath(@RequestBody DoMathRequest body) throws InvalidOperationException {
        return ResponseEntity.ok(new ApiResponse(mathService.doMath(body.getOperand1(), body.getOperand2(), body.getOperation())));

    }
}
