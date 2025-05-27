package com.example.openai.controller;


import com.example.openai.service.ChatService;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/chat")
    public String chat(@RequestParam("message") String message){
        return chatService.chat(message);
    }

    @GetMapping("/chatPlace")
    public String chatPlace(@RequestParam("subject") String subject,
            @RequestParam("tone") String tone,
            @RequestParam("message") String message){
        return chatService.chatPlace(subject, tone, message);
    }

    @GetMapping("/chatJson")
    public ChatResponse chatJson(@RequestParam("message") String message){
        return chatService.chatJson(message);
    }

}
