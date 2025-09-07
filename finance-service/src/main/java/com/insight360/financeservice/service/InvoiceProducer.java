
package com.insight360.financeservice.service;

import jakarta.jms.Queue;
import jakarta.jms.Topic;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class InvoiceProducer {

    private final JmsTemplate queueJmsTemplate;
    private final Queue invoiceQueue;
    private final JmsTemplate topicJmsTemplate;
    private final Topic notificationTopic;

    public InvoiceProducer(JmsTemplate queueJmsTemplate, Queue invoiceQueue, JmsTemplate topicJmsTemplate, Topic notificationTopic) {
        this.queueJmsTemplate = queueJmsTemplate;
        this.invoiceQueue = invoiceQueue;
        this.topicJmsTemplate = topicJmsTemplate;
        this.notificationTopic = notificationTopic;
    }

    public void createInvoice(Long clientId, Double amount) {
        String payload = clientId + ":" + amount;
        queueJmsTemplate.convertAndSend(invoiceQueue, payload);
        System.out.println("📤 Invoice queued: " + payload);
    }

    public void publishNotification(String msg) {
        topicJmsTemplate.convertAndSend(notificationTopic, msg);
        System.out.println("📣 Notification published: " + msg);
    }
}
