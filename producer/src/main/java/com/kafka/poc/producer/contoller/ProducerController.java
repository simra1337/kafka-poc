package com.kafka.poc.producer.contoller;

import com.kafka.poc.producer.entity.Order;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class ProducerController {

  @Autowired
  private KafkaTemplate<String, Order> kafkaTemplate;

  @Value("${kafka.topic}")
  private String kafkaTopic;

  @PostMapping
  public ResponseEntity<String> createOrder(@RequestBody Order order) {
    String id = String.valueOf(UUID.randomUUID());
    order.setId(id);
    kafkaTemplate.send(kafkaTopic, id, order);

    return ResponseEntity.ok("Order created and sent to Kafka");
  }
}
