package com.example.openai.service;

import com.example.openai.entity.Answer;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.converter.ListOutputConverter;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Service
public class ChatService {
    private final ChatClient chatClient;

    public ChatService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String chat(String message){
        return chatClient.prompt() //프롬프트
                .user(message) //사용자 메시지
                .call() //호출
                .content(); //ChatResonse -> 결과 문자 추출
    }

    public String chatPlace(String subject, String tone, String message) {
        return chatClient.prompt() //프롬프트
                .user(message) //사용자 메시지
                .system(sp->sp
                        .param("subject", subject)
                        .param("tone", tone)
                )
                .call() //호출
                .content();
    }

    public ChatResponse chatJson(String message){
        return chatClient.prompt() //프롬프트
                .user(message) //사용자 메시지
                .call() //호출
                .chatResponse();
    }

    public Answer chatEntity(String message){
        return chatClient.prompt() //프롬프트
                .user(message) //사용자 메시지
                .call() //호출
                .entity(Answer.class);
    }
    public List<String> chatList(String message){
        return chatClient.prompt() //프롬프트
                .user(message) //사용자 메시지
                .call() //호출
                .entity(new ListOutputConverter(new DefaultConversionService()));
    }

    public Map<String, String > chatMap(String message){
        return chatClient.prompt() //프롬프트
                .user(message) //사용자 메시지
                .call() //호출
                .entity(new ParameterizedTypeReference<Map<String, String>>() {
                });
    }

    //Advisor Chat
    public String getResponse(String message){
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }

    public void startChat(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Your Message");
        while (true) {
            String message = scanner.nextLine();
            if (message.equals("exit")) {
                System.out.println("Exiting Chat");
                break;
            }
            String response = getResponse(message);
            System.out.println("Bot: " + response);
        }
        scanner.close();
    }

}
