package com.canteen.canteen_mgmt_system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
public class Customer {

    @Id
    @SequenceGenerator(name = "customer_seq_gen", sequenceName = "customer_id_seq", allocationSize =1 )
    @GeneratedValue(generator = "customer_seq_gen", strategy = GenerationType.SEQUENCE)

    private Integer id;

    @Column(name="customer_id", nullable = false, length = 50)
    private Integer customerId;

    @Column(name="customer_name", nullable = false,length = 50)
    private String customerName;

    @Column(name = "customer_email", nullable = false,length = 50)
    private String customerEmail;

    @Column(name="customer_address", nullable = false,length = 50)
    private String customerAddress;

    @Column(name="customer_image", nullable = false,length = 50)
    private String customerImage;

//    @ManyToOne


}
