package com.dad.kafka.controller;

import com.dad.kafka.application.broker.service.KafkaProducerService;
import com.dad.kafka.application.domain.KafkaMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class KafkaController {

  private final KafkaProducerService producerService;

  @PostMapping("/publish")
  public ResponseEntity<String> publishMessage(@RequestBody KafkaMessage message) {
    producerService.sendMessage("dad-atividade-kafka", message);

    return ResponseEntity.ok("Message published successfully");
  }
}
