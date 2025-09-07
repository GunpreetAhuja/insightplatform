
package com.insight360.notificationservice.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationSubscriber {

    @JmsListener(destination = "notification.topic", containerFactory = "topicListenerFactory")
    public void onNotification(String msg) {
        System.out.println("🔔 Notification received: " + msg);
    }
}
