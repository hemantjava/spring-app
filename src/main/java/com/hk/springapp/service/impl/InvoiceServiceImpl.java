package com.hk.springapp.service.impl;

import com.hk.springapp.entity.Invoice;
import com.hk.springapp.service.InvoiceService;
import com.hk.springapp.utils.LuhnAlgo;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Override
    public String generateInvoice (Invoice invoice) {
         String value = StringConversion(invoice).toString();
        return LuhnAlgo.checkLuhn(value);
    }

    private StringBuilder StringConversion(Invoice invoice){
        StringBuilder builder = new StringBuilder();
        builder.append(invoice.getBillDropDate());
        builder.append(invoice.getInvoiceNumber());
        builder.append(invoice.getAccountNumber());
        builder.append(invoice.getPaymentAmount());
        builder.append(invoice.getDueDate());
        return builder;
    }
}
