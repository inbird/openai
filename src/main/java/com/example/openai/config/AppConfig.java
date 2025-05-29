package com.example.openai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.messages.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder chatClientBuilder){
        return chatClientBuilder.build(); //일반적인 처리

        //chatPlace 사용할때 사용
//        return chatClientBuilder
//                .defaultSystem("당신은 {subject}에 특화된 교육자입니다. {tone} 톤으로 개념을 명확하고 간단하게 설명하세요.") // 시스템 메시지: 템플릿 변수 포함
//                .build();

        //Advisor 테스트
//        ChatMemory chatMemory = MessageWindowChatMemory.builder().build();
//        return chatClientBuilder.defaultAdvisors(
//                MessageChatMemoryAdvisor.builder(chatMemory).build()).build();
    }
}
