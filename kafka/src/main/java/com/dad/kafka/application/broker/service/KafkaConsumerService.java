package com.dad.kafka.application.broker.service;

import com.dad.kafka.application.domain.KafkaMessage;
import com.dad.kafka.application.service.MessageValidatorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

  private final MessageValidatorService validatorService;

//  @KafkaListener(topics = "dad-atividade-kafka")
  public void consume(KafkaMessage message) {
    if (validatorService.isValid(message)) {
      ObjectMapper objectMapper = new ObjectMapper();
      try {
        String jsonString = objectMapper.writeValueAsString(message);
        System.out.println("Valid message received: " + jsonString);
      } catch (Exception e) {
        System.out.println("Error converting message to JSON: " + e.getMessage());
      }

    } else {
      System.out.println("Invalid message: " + message);
    }
  }
}
