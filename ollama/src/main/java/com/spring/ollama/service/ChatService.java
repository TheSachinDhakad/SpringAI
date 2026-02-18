package com.spring.ollama.service;

import com.spring.ollama.entity.Tut;

public interface ChatService {
    Tut chat(String query);
}
