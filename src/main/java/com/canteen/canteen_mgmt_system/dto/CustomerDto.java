package com.canteen.canteen_mgmt_system.dto;

import com.canteen.canteen_mgmt_system.entity.Customer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class CustomerDto {
    private Integer id;

    @NotNull(message = "values should be filled")
    @NotBlank

    private Integer customerId;
    private String customerName;
    private String customerEmail;
    private String customerAddress;
    private String customerImage;

    public CustomerDto(Customer customer){
        this.id= customer.getId();
        this.customerId= customer.getCustomerId();
        this.customerName=customer.getCustomerName();
        this.customerEmail=customer.getCustomerEmail();
        this.customerAddress=customer.getCustomerAddress();
        this.customerImage=customer.getCustomerImage();
    }

}
