package com.packagedelivery.consumer.package_delivery_consumer.dtos;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "tracking")
@Table(name = "package")
public class Package {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sender;
    private String receptor;
    private Boolean weight;
    private Double distance;
    private Double price;
    private LocalDateTime sendDate;

    @ManyToOne
    @JoinColumn(name = "tracking_id", nullable = false)
    private Tracking tracking;
}
