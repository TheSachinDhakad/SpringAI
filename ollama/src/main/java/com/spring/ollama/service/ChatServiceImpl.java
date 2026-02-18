package com.spring.ollama.service;

import com.spring.ollama.entity.Tut;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService{
    private ChatClient chatClient;

    public ChatServiceImpl(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    @Override
    public Tut chat(String query) {
        Prompt p = new Prompt(query);

//        var response = this.chatClient.prompt(p).
//                call().chatResponse().getResult().getOutput().getText();
//        System.out.println(response);

        // use entity
        Tut t = this.chatClient.prompt(p).call().entity(Tut.class);


        return t;
    }
}
