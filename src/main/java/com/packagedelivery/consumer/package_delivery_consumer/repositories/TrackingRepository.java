package com.packagedelivery.consumer.package_delivery_consumer.repositories;

import com.packagedelivery.consumer.package_delivery_consumer.dtos.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackingRepository extends JpaRepository<Tracking, Long> {
}
