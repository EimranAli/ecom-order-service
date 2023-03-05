package com.ecom.order.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;

    @Column(nullable = false)
    private float price;

    @Column(nullable = false)
    private long productId;

    @Column(nullable = false)
    private long customerId;
}
