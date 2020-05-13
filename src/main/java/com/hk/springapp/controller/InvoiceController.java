package com.hk.springapp.controller;


import com.hk.springapp.entity.Invoice;
import com.hk.springapp.exception.InvalidInputException;
import com.hk.springapp.service.InvoiceService;
import com.hk.springapp.utils.InvoiceValidation;
import io.swagger.annotations.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value="InvoiceController", description="Operation gathering the input data and generating Invoice using luhn algorithm")
@RestController
@RequestMapping("/invoice")
@Log4j2
public class InvoiceController {

    @Autowired
    private InvoiceService service;

    /**
     * localhost:9191/invoice/generate
     *
     * @return valid Invoice data
     * @param invoice
     */
    @ApiOperation(value = "Generating Invoice Number ", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 411, message = "The field required valid size")
    })
    @PostMapping("/generate")
    public ResponseEntity<String> generateInvoice (@ApiParam(value = "This input values for Invoice generation ", required = true) @RequestBody Invoice invoice) {
        String generatedValue = null;
           if(!InvoiceValidation.validate(invoice))
               throw new InvalidInputException("Given input data not valid plz check.");
            generatedValue  = service.generateInvoice(invoice);
            log.info(generatedValue);
        return ResponseEntity.ok(generatedValue);

    }
}
