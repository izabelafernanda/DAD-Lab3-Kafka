package com.dad.kafka.application.service;

import com.dad.kafka.application.domain.KafkaMessage;
import org.springframework.stereotype.Service;

@Service
public class MessageValidatorService {

  public boolean isValid(KafkaMessage message) {
    return "Izabela Fernanda Silva".equals(message.getName()) &&
        "1331325@sga.pucminas.br".equals(message.getLogin_id()) &&
        "2".equals(message.getGroup());
  }
}
