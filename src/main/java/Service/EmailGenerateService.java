package Service;

import Dto.EmailRequestDto;
import org.springframework.stereotype.Service;

@Service
public class EmailGenerateService {

    // generate email reply
    public String generateEmailReply(EmailRequestDto emailRequest) {
        // build the prompt
        String prompt = buildPrompt(emailRequest);
        //craft a request
        //do request and get response
        //return response

        return null;
    }

    private String buildPrompt(EmailRequestDto emailRequest) {
        StringBuilder prompt = new StringBuilder();
        prompt.append("Generate a professional email reply for the following email content. Please don't generate a subject line.");
        if (emailRequest.getTone() != null && emailRequest.getTone().isEmpty()) {
            prompt.append("Use a").append(emailRequest.getTone()).append("tone");
        }
        prompt.append("\nOriginal email: \n").append(emailRequest.getEmailContent());
        return prompt.toString();
    }
}
