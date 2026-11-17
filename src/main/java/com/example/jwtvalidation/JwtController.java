
package com.example.jwtvalidation;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class JwtController {

    private final JwtValidator validator;

    public JwtController(JwtValidator validator) {
        this.validator = validator;
    }

    @GetMapping("/validate")
    public String validate(@RequestParam String token) {

        if (validator.validateToken(token)) {
            return "JWT Token is Valid";
        }

        return "JWT Token is Invalid";
    }
}
