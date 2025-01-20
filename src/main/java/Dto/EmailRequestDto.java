package Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder// will generate getters, setters and constructors
public class EmailRequestDto {

    private String emailContent;
    private String tone;
}
