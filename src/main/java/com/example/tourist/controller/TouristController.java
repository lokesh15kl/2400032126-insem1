
package com.example.tourist.controller;

import com.example.tourist.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tourists")
public class TouristController {

    private final TouristService service;

    public TouristController(TouristService service) {
        this.service = service;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTourist(
            @PathVariable Long id,
            @RequestHeader(value = "Token",
                           required = false) String token) {

        if (!"valid-token-123".equals(token)) {
            return ResponseEntity.status(
                    HttpStatus.UNAUTHORIZED)
                    .body("Invalid or missing Token");
        }

        service.deleteTourist(id);

        return ResponseEntity.ok(
                "Tourist record deleted successfully");
    }
}
