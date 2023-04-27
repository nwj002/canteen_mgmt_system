package com.canteen.canteen_mgmt_system.repo;

import com.canteen.canteen_mgmt_system.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends
    JpaRepository<Customer, Integer>{
}
