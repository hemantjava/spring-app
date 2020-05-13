package com.hk.springapp;

import com.hk.springapp.controller.InvoiceController;
import com.hk.springapp.entity.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAppApplication implements ApplicationRunner {
	@Autowired
	private InvoiceController controller;


	public static void main(String[] args) {
		SpringApplication.run(SpringAppApplication.class, args);
	}


	@Override
	public void run (ApplicationArguments args) throws Exception {

		Invoice invoice = Invoice.builder()
				.billDropDate("20191207")
				.accountNumber("ABCDEF100234")
				.paymentAmount("000000000010000")
				.invoiceNumber("100000000000000")
				.dueDate("20200101")
				.build();
		controller.generateInvoice(invoice);

	}
}
