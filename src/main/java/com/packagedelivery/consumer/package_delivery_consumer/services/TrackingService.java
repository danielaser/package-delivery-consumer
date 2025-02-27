package com.packagedelivery.consumer.package_delivery_consumer.services;

import com.packagedelivery.consumer.package_delivery_consumer.dtos.Tracking;
import com.packagedelivery.consumer.package_delivery_consumer.repositories.TrackingRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class TrackingService {

    private final TrackingRepository trackingRepository;

    public TrackingService(TrackingRepository trackingRepository) {
        this.trackingRepository = trackingRepository;
    }

    @Transactional
    public void saveTracking(Tracking tracking) {
        if (tracking.getPackages() != null) {
            tracking.getPackages().forEach(aPackage -> {
                aPackage.setTracking(tracking);
                aPackage.setId(null);
            });
        }

        System.out.println("Saving tracking with packages: " + tracking.getPackages());
        trackingRepository.save(tracking);
        System.out.println("The tracking is been saved with the id: " + tracking.getId());
    }
}
