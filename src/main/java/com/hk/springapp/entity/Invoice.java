package com.hk.springapp.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

@ApiModel(description = "Details about the Invoice. ")
public class Invoice {

    @ApiModelProperty(notes = "BillDropDate of the Invoice",name="name",required=true)
    @NotNull(message = "is required")
    @Size(min = 8,message = "is required")
    private String billDropDate;

    @ApiModelProperty(notes = "InvoiceNumber of the Invoice",name="name",required=true)
    @NotNull(message = "is required")
    @Size(min = 15,message = "is required")
    private String invoiceNumber;

    @ApiModelProperty(notes = "AccountNumber of the Invoice",name="name",required=true)
    @NotNull(message = "is required")
    @Length(max = 12,min = 12 ,message ="is required")
    private String accountNumber;

    @ApiModelProperty(notes = "PaymentAmount of the Invoice",name="name",required=true)
    @NotNull(message = "is required")
    @Min(value = 15, message = "is required")
    private String paymentAmount;

    @ApiModelProperty(notes = "BillDueDate of the Invoice",name="name",required=true)
    @NotNull(message = "is required")
  //  @Size(min = 8,message = "is required")
    @Size(min = 8, message = "is required",max = 8)
    private String dueDate;
}
