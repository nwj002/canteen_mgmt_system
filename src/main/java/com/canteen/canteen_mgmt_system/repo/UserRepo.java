package com.canteen.canteen_mgmt_system.repo;

import com.canteen.canteen_mgmt_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    @Query(value = "select * from users where email=?1", nativeQuery = true)
    Optional<User> findByEmail(String email);
}
