package com.canteen.canteen_mgmt_system.entity;
import jakarta.persistence.*;

@Table
@Entity

public class Order {
    @Id
    private Integer Id;

    @Column(name="customer_name", length = 50,nullable = false)
    private String customerName;

    @Column(name="customer_email", length = 50,nullable = false)
    private String customeremail;


}
