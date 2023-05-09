package com.canteen.canteen_mgmt_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name="role")
@NoArgsConstructor


public class Role {
    @Id
    @SequenceGenerator(name = "role_seq_gen", sequenceName = "role_id_seq",allocationSize = 1)
    @GeneratedValue(generator = "role_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

}
