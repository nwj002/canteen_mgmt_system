package com.canteen.canteen_mgmt_system.Services;

import com.canteen.canteen_mgmt_system.dto.CustomerDto;
import com.canteen.canteen_mgmt_system.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    void saveData(CustomerDto customerDto);
    List<Customer>getData();
    Optional<Customer> getById(Integer id);
    Customer getByIdNoOps(Integer id);
    void deleteById(Integer id);
}
