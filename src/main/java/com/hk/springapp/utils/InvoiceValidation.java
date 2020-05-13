package com.hk.springapp.utils;


import com.hk.springapp.entity.Invoice;

public class InvoiceValidation {

    public static  boolean validate (Invoice invoice) {
        boolean flag = true;
        if (invoice.getAccountNumber().length() != 12)
            flag = false;
        else if (invoice.getPaymentAmount().length() != 15)
            flag = false;
        else if (invoice.getInvoiceNumber().length() != 15)
            flag = false;
        else if (invoice.getBillDropDate().length() != 8)
            flag = false;
        else if (invoice.getDueDate().length() != 8)
            flag = false;
        return flag;
    }
}
