package com.packagedelivery.consumer.package_delivery_consumer.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "tracking")
@Table(name = "package")
public class Package {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sender;
    private LocalDateTime sendDate;
    private String receptor;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "tracking_id", nullable = false)
    private Tracking tracking;
}
