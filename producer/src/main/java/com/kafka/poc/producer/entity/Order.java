package com.kafka.poc.producer.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Order {

  private String id;

  private String itemName;

  private String price;

  private String quantity;

}
