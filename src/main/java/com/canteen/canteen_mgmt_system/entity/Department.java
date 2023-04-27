package com.canteen.canteen_mgmt_system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
// @data to add getter and se
public class Department {

    @Id
    @SequenceGenerator(name = "department_seq_gen", sequenceName = "department_id_seq", allocationSize =1 )
    @GeneratedValue(generator = "department_seq_gen", strategy = GenerationType.SEQUENCE)

    private Integer id;

    @Column(length = 50)
    private String departmentName;


}
