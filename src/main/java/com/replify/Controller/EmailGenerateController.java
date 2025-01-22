package com.replify.Controller;

import com.replify.Dto.EmailRequestDto;
import com.replify.Service.EmailGenerateService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class EmailGenerateController {

    private final EmailGenerateService emailGenerateService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateEmail(@RequestBody EmailRequestDto emailRequestDto) {
        System.out.println("Received request: " + emailRequestDto);
        String response = emailGenerateService.generateEmailReply(emailRequestDto);
        return ResponseEntity.ok(response);
    }

}
