
package com.insight360.financeservice.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class InvoiceConsumer {

    @JmsListener(destination = "invoice.queue", containerFactory = "queueListenerFactory")
    public void processInvoice(String payload) {
        System.out.println("📥 Processing invoice: " + payload);
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("✅ Invoice processed: " + payload);
    }
}
