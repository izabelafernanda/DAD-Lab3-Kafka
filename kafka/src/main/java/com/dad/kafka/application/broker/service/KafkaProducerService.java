package com.dad.kafka.application.broker.service;

import com.dad.kafka.application.domain.KafkaMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

  private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;

  public void sendMessage(String topic, KafkaMessage message) {

    var msg = String.format("Message send to kafka topic %s: ", topic);

    System.out.println(msg + message);

    kafkaTemplate.send(topic, message);
  }
}
