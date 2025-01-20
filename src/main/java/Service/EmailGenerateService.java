package Service;

import Dto.EmailRequestDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class EmailGenerateService {
    private final WebClient webClient;

    @Value("${gemini.api.url}")
    private String geminiApiUrl;
    @Value("${gemini.api.key}")
    private String geminiApiKey;
    public EmailGenerateService(WebClient webClient) {
        this.webClient = webClient;
    }

    // generate email reply
    public String generateEmailReply(EmailRequestDto emailRequest) {
        // build the prompt
        String prompt = buildPrompt(emailRequest);

        //craft a request
        Map<String, Object> requestBody = Map.of(
          "contents", new Object[] {
                  Map.of(
                          "parts", new Object[] {
                                  Map.of("text", prompt)
                          }
                  )
                }
        );

        //do request and get response
        String response = webClient.post()
                .uri(geminiApiUrl + geminiApiKey)
                .header("Content-Type", "application/json")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        //return response
        return extractResponseContent(response);

        return null;
    }

    private String extractResponseContent(String response) {
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
