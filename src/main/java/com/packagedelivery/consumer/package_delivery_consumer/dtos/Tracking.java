package com.packagedelivery.consumer.package_delivery_consumer.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tracking")
public class Tracking {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String agency;
    private LocalDateTime arrivalTime;
    @Enumerated(EnumType.STRING)
    private TrackingStatus status;
    private String address;

    @OneToMany(mappedBy = "tracking", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Package> packages;

    private Double total;
}
