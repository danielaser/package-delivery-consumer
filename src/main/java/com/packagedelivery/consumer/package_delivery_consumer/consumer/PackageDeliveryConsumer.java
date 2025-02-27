package com.packagedelivery.consumer.package_delivery_consumer.consumer;

import com.packagedelivery.consumer.package_delivery_consumer.dtos.Tracking;
import com.packagedelivery.consumer.package_delivery_consumer.services.TrackingService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PackageDeliveryConsumer {

    private final TrackingService trackingService;

    public PackageDeliveryConsumer(TrackingService trackingService) {
        this.trackingService = trackingService;
    }

    @RabbitListener(queues = "package_delivery_queue")
    public void receiveMessage(Tracking tracking) {
        System.out.println("Received message " + tracking);
        trackingService.saveTracking(tracking);
    }
}
