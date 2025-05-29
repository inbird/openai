package com.example.openai.controller;


import com.example.openai.entity.Answer;
import com.example.openai.service.ChatService;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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
        //chatPlace?subject=과일&tone=정중히&message=배에 대해 간략히 설명
        //chatPlace?subject=교통수단&tone=정중히&message=배에 대해 간략히 설명
    }

    @GetMapping("/chatJson")
    public ChatResponse chatJson(@RequestParam("message") String message){
        return chatService.chatJson(message);
    }

    @GetMapping("/chatEntity")
    public Answer chatEntity(@RequestParam("message") String message){
        return chatService.chatEntity(message);
        //chatClass?message=햄볶음밥 재료 1가지
    }

    @GetMapping("/chatList")
    public List<String> chatList(@RequestParam("message") String message){
        return chatService.chatList(message);
        //chatClass?message=미국 주요도시 5개
    }

    @GetMapping("/chatMap")
    public Map<String, String> chatMap(@RequestParam("message") String message){
        return chatService.chatMap(message);
        //chatClass?message=유명한 한국영화(key)와 감독(value)을 5개 만들어줘
    }

}
