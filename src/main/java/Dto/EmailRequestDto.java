package Dto;

import lombok.Data;

@Data // will generate getters, setters and constructors
public class EmailRequestDto {

    private String emailContent;
    private String tone;
}
