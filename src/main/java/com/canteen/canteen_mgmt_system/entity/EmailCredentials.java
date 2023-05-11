package com.canteen.canteen_mgmt_system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table
@Entity
public class EmailCredentials {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Email_Seq_GEN")
    @SequenceGenerator(name="Email_Seq_GEN", sequenceName = "Email_Seq", initialValue = 1, allocationSize = 1)

    private long id;
    @Column(unique = true)
    private String email;
    private String password;
    private String host;
    private String port;
    private Date date;
    private Boolean active;
    private String protocol;
}
