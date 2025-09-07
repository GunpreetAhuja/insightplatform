
package com.insight360.financeservice.controller;

import com.insight360.financeservice.service.InvoiceProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/finance")
public class FinanceController {

    private final InvoiceProducer invoiceProducer;

    public FinanceController(InvoiceProducer invoiceProducer) {
        this.invoiceProducer = invoiceProducer;
    }

    @PostMapping("/invoice")
    public ResponseEntity<String> createInvoice(@RequestParam Long clientId, @RequestParam Double amount) {
        invoiceProducer.createInvoice(clientId, amount);
        return ResponseEntity.accepted().body("Invoice queued for client " + clientId);
    }

    @PostMapping("/notify")
    public ResponseEntity<String> notify(@RequestParam String msg) {
        invoiceProducer.publishNotification(msg);
        return ResponseEntity.ok("Notification published");
    }
}
