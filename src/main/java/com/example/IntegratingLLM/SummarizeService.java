package com.example.IntegratingLLM;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class SummarizeService {

    private ChatClient chatclient;

    public SummarizeService(ChatClient.Builder builder){
        this.chatclient=builder.build();
    }

    public String summarize(String ticket) {
        String output = chatclient.prompt()
                .user("Summmarize this support ticket in 2 lines:\n\n" + ticket)
                .call()
                .content();
        return output;
    }
}
