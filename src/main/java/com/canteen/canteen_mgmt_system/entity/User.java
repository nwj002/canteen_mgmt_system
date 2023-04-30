package com.canteen.canteen_mgmt_system.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users", uniqueConstraints = {
        @UniqueConstraint(name="UNIQUE_user_email",
        columnNames = "email")
})
public class User {
    @Id
    @SequenceGenerator(name = "users_seq_gen",
            sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "users_seq_gen",
            strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "fullname", nullable = false)
    private String fullName;
    @Column(nullable = false)
    private String email;
    @Column(name = "mobile_no")
    private String mobileNo;
    @Column(name = "password", nullable = false)
    private String password;
}
