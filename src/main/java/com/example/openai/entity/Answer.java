package com.example.openai.entity;

public class Answer {
    private String answer;

    public Answer() {
        // Required by Jackson
    }

    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
