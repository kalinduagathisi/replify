package Controller;

import Dto.EmailRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailGenerateController {

    public ResponseEntity<String> generateEmail(@RequestBody EmailRequestDto emailRequestDto) {
        return ResponseEntity.ok("");
    }

}
