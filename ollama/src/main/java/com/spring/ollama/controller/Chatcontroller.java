package com.spring.ollama.controller;


import com.spring.ollama.entity.Tut;
import com.spring.ollama.service.ChatServiceImpl;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Chatcontroller {


    private final ChatServiceImpl chatService;

   private ChatClient chatClient;
   public Chatcontroller(ChatServiceImpl chatService, ChatClient.Builder builder ){
       this.chatService = chatService;
       this.chatClient = builder.build();
   }
    @GetMapping("chat")
    public ResponseEntity<Tut> chat(@RequestParam(value = "q") String query){
//      String response=  this.chatClient.prompt(query).call().content();
//        return ResponseEntity.ok(response);
       return ResponseEntity.ok(chatService.chat(query));


    }
}

