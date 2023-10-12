package com.dad.kafka.application.domain;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class KafkaMessage {
  private String name;
  private String login_id;
  private String group;
}
