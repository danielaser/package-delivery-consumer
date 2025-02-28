package com.packagedelivery.consumer.package_delivery_consumer.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tracking")
public class Tracking {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private TrackingStatus status;
    private String agency;
    private LocalDateTime arrivalTime;
    private String address;

    @OneToMany(mappedBy = "tracking", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Package> packages;

}
